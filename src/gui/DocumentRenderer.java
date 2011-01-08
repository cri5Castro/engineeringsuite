package gui;

/* Copyright 2002
 Kei G. Gauthier
 Suite 301
 77 Winsor Street
 Ludlow, MA 01056
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JEditorPane;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.text.View;
import javax.swing.text.html.HTMLDocument;

/*
 *Print Documents Easily in Java
 This DocumentRenderer object handles print tasks so you don't have to.
 by Kei G. Gauthier and Stephen E. Sugermeyer

 Posted December 10, 2002

 Typical discussions of document printing in Java describe a difficult
 process that requires measuring fonts, parsing text, and drawing the result
 on a Graphics object. This seems unnecessarily difficult and at odds with
 the advanced programming methods available for the video display of
 documents. If you wanted to expend a great deal of effort to accomplish
 tasks, you wouldn't program in Java in the first place.

 Instead of measuring, parsing, and drawing on your own, you would probably
 prefer simply to send a document to an object that does all the work for
 you. This article describes such an object, DocumentRenderer, which accepts
 a document as an argument in a method and handles the tasks required to
 print the text. For example, using this class to render an HTML document on
 paper consists of only two steps: constructing an instance of
 DocumentRenderer and sending an HTML document as an argument to the
 print(HTMLDocument) method. The DocumentRenderer class handles the overhead
 required to print the document, including displaying a print dialog box and
 formatting the text. Download the source code for this class
 (DocumentRenderer.java).

 We designed the DocumentRenderer class to take advantage of the advanced
 text capabilities already available in Java. Following the principles of
 reusable and extensible classes, we employed existing objects that the Java
 Swing Text Package uses to format screen output so it can handle the work of
 rendering printed documents onto paper. Designing DocumentRenderer in this
 way allowed us to create the class in somewhat less than 200 lines of code
 prior to commenting.

 In addition to keeping the code short, employing existing objects in the
 implementation of DocumentRenderer provided the added benefit of making the
 class more generic. In the initial design of the class, we had only intended
 to print HTML documents. Adding the ability to print other types of
 documents was a total afterthought. We included this functionality at the
 end of the project when we looked at the code for our HTML printing class
 and realized that it would take only about six lines of additional code to
 print a Rich Text Format document.

 Render Documents
 DocumentRenderer prints the types of documents that can be contained within
 a JEditorPane. We tested this printer class with the three types that
 JEditorPane knows by default: HTMLDocuments, PlainDocuments, and Rich Text
 Format documents. With only minor modification, the class should be able to
 print other document types that can be contained within a JEditorPane.

 Our DocumentRenderer class separates the printing of a document from its
 video display. This allows you to format text specifically targeted for
 printed output without affecting its screen display. DocumentRenderer uses
 the size of practically any printable page to lay out the text and calculate
 line breaks. When the width of a document cannot be formatted to equal the
 width of a printable page or less, the class allows for scaling.

 DocumentRenderer is pretty smart. Page breaks won't unnecessarily split a
 single line of text between two pages. Characters also won't be chopped in
 half, as when browser output commonly prints the upper part of a sentence at
 the bottom of one page and the lower part of the same sentence at the top of
 the next page. The class handles various fonts, colors, and small icons.
 Columnar text presents no problem either. If a JEditorPane can display a
 text feature, DocumentRenderer usually renders the feature on paper.

 You can integrate DocumentRenderer into your programs with as few as two
 lines of code. A constructor with no arguments creates an instance of this
 class, and a call to the appropriate print method handles the rest. For
 instance, this code would print htmlDocument, a valid instance of the
 HTMLDocument class:

 DocumentRenderer DocumentRenderer = new
 DocumentRenderer();
 DocumentRenderer.print(htmlDocument);

 This presents users with a print dialog box, which allows them to choose the
 printer, number of copies, and so on-as well as the option to cancel the
 print job.

 PlainDocuments are printed in the same manner as HTMLDocuments by using the
 print(PlainDocument) method. Because Java does not provide direct access to
 a Rich Text Format document, you must send text of this type to
 DocumentRenderer by enclosing it in a JEditorPane, like this:

 DocumentRenderer.print(jeditorPane);

 Here jeditorPane, a valid instance of JEditorPane, contains a Rich Text
 Format document.

 As a convenience, calls to the pageDialog method of DocumentRenderer display
 a page dialog box so users can adjust the page size, margin settings, and
 paper orientation. DocumentRenderer also includes a method that allows
 developers to choose whether to scale documents that cannot fit within the
 width of a printable page. We think scaling would ordinarily be the
 preferred choice, because it prevents text from being clipped on the right
 margin, but it seemed appropriate to offer users the choice. This method,
 called setScaleWidthToFit(boolean), sets the scaling option. Be sure to call
 the scaling and pageDialog methods before the print method.

 Understand DocumentRenderer
 DocumentRenderer performs the tasks of displaying a print dialog box and
 initiating the print operation through standard tools available in the Java
 Swing Printing API. Because a complete understanding of this API is not
 necessary to use the DocumentRenderer class, and because the API has been
 thoroughly described in many other places (see Resources), we will not
 explain it here. The source code for the DocumentRenderer class also
 contains thorough documentation of the printing logic.

 We probably should explain, however, the process that DocumentRenderer uses
 to locate text on individual printed pages. To understand the improvements
 made available by this class, it helps to review the logic that Java
 printing procedures commonly follow to render text.

 Documents are usually printed in an unsophisticated manner. At first, the
 document is put into a JEditorPane. Think of the printing process as placing
 a rectangle, equal in size to the printable area of a page, on top of this
 JEditorPane and painting on paper whatever happens to lie beneath the
 rectangle.

 The rectangle is placed with its upper horizon along the top of the
 JEditorPane, and the area under the bounds of the rectangle gets painted. If
 the lower horizon of the rectangle cuts through text, so be it; the
 characters get clipped at the bottom of the printed page. To print the
 second page, the upper horizon of the rectangle is moved down to the line
 previously occupied by the lower horizon, and the process is repeated.
 Because this second page starts exactly where the first one ended, the
 bottom half of the characters that got clipped on page 1 show up on the top
 of page 2. Repeating this process prints subsequent pages.

 To avoid clipping lines, DocumentRenderer examines text carefully to
 determine if an individual piece of text fits neatly onto a page. This is
 better than merely dropping a rectangle onto the JEditorPane and painting
 whatever it happens to cover.

 Paint the View
 If you think of a JEditorPane as containing one document, you will not be
 able to determine the location or size of any piece of text. A document is
 just too large a structure to help with this task. The document either fits
 onto a single page or it does not. To accomplish the goal of neatly placing
 text on paper, you have to divide the document into smaller pieces and
 examine the location of each part.

 Fortunately, the Java Swing Text Package provides the View classes, which
 allow you to break documents into their individual, paintable parts. Think
 of a JEditorPane as being made up of a series of views; now you will be able
 to print the document neatly based on the size and location of these smaller
 chunks.

 Subclasses of View handle the tasks of laying out and painting text within
 visual components. What many programmers working with printed text do not
 realize, however, is that views can provide these same functions when
 rendering on paper. Although a complete discussion of views is beyond the
 scope of this article, a basic understanding is necessary to our discussion
 of document printing.

 In Swing, views serve as containers that handle text display. Multiple views
 branch from a root view within a tree structure. At the end of these
 branches appear leaf views that represent actual pieces of text.

 Think of the tree structure of views as starting with a single, large view
 that contains the entire document. This document view branches into several
 paragraph views, which, in turn, branch into individual lines. Although the
 actual workings of views are richer and more complex than this simple
 description, this example shows how you can use views to break a document
 down into small pieces that fit neatly onto printed pages. By looking at
 each line, you can determine whether it fits completely onto a page without
 being clipped at the bottom. If the line fits, print it; if it doesn't,
 record its location so it can be printed on the next page.

 Views within a JEditorPane operate in a manner similar to the way components
 behave within a JPanel. One big difference is that views do not require
 layout managers to handle their placement; they participate in their own
 layout. In this way, views within a JEditorPane operate like a visual
 component and layout manager. A view knows how to look, how to paint itself,
 and where its children should appear.

 Views are not created directly. Rather, they are produced by factories that
 are subclasses of ViewFactory. A ViewFactory takes a document and breaks it
 down into a root view and any necessary branch and leaf views. Along the
 way, the factory handles the tedious work of parsing the text and
 calculating the layout.

 You rarely work with these factories directly. For the most part they are
 called automatically. Setting the document in a JEditorPane and calling the
 JEditorPane.validate() method sends the document to the applicable factory,
 which returns the necessary views. These views are then used to lay out the
 component.

 Print the View
 The DocumentRenderer class places the document to be printed into
 jeditorPane, an instance of JEditorPane. The width of jeditorPane determines
 the size of a printable page and the validate method is called to perform
 the layout. DocumentRenderer does not display this JEditorPane, so screen
 output is not affected. The root view needed to print is obtained through a
 somewhat convoluted call to the user interface of jeditorPane:

 View rootView =
 jeditorPane.getUI().getRootView(jeditorPane);

 This rootView and its children can be queried for the information needed to
 lay out the document for printing. These views provide the coordinates and
 size within a graphical context of each piece of text. With this
 information, it's easy to determine whether a piece fits neatly onto a
 printed page. If it does, DocumentRenderer prints it; if not, the class
 determines a page break that will print the piece of text without clipping
 it.

 Because views know how to paint themselves, you needn't concern yourself
 with setting fonts or colors. DocumentRenderer handles styled text with
 varied fonts and colors through a simple call to the view's paint method.

 The tree structure of the views does present one problem, however. You
 cannot be sure how many times the views will branch from the root view
 before ending in a leaf view that represents a piece of printable text. You
 can address this concern easily by using a simple recursive method in the
 DocumentRenderer class.

 The printView method iterates through the branching structure of views in
 search of paintable leaf views. This method takes a view as one of its
 arguments. Starting with the root view, it examines each view to determine
 whether it has any child views associated with it. If it does, printView
 makes calls to itself using each of these children in turn as its view
 argument. In this way, the method eventually works through the entire tree
 structure. When the method finds a leaf view that has no children, it
 examines its placement within the graphical context used for printing. The
 method paints only those leaf views that fit completely on the printable
 clip of this context. When a leaf view straddles the bottom of a page, the
 method records the location of the top horizon of this leaf so that the next
 page can begin at this location. Therefore, page breaks don't chop lines of
 text.

 If you wish to pursue a further discussion of the use of views in printing,
 check out the source code of DocumentRenderer. We commented the heck out of
 it. With fewer than 200 lines of code, we had lots of time to write
 comments.

 Limitations of the Class
 DocumentRenderer has been tested with the Java SDK 1.3 and 1.4, although it
 should work with any version of Java that implements Swing. DocumentRenderer
 does its work through standard Java techniques. For that reason, it paints
 text no better and no worse than Java itself. Characteristics that do not
 get rendered in a JEditorPane do not show up on paper.

 Java has a slight problem measuring printed text in a Windows environment.
 Because text is not measured perfectly, some placement might appear slightly
 off. This is usually not a big problem because the errors are small, but
 they do become troublesome when text is right-justified. For this reason,
 avoid right-justified text. The DocumentRenderer class did not create this
 problem. This problem does not seem to occur in Linux environments.

 Lastly, large icons do not print. Java simply refuses to render them on the
 page. Small icons work quite well, however.

 No longer does printing in Java have to be so complicated. Simply use the
 DocumentRenderer class to add advanced text-printing capabilities to your
 applications with as few as two lines of code.
 */
public class DocumentRenderer implements Printable {
	/*
	 * DocumentRenderer prints objects of type Document. Text attributes,
	 * including fonts, color, and small icons, will be rendered to a printed
	 * page. DocumentRenderer computes line breaks, paginates, and performs
	 * other formatting.
	 * 
	 * An HTMLDocument is printed by sending it as an argument to the
	 * print(HTMLDocument) method. A PlainDocument is printed the same way.
	 * Other types of documents must be sent in a JEditorPane as an argument to
	 * the print(JEditorPane) method. Printing Documents in this way will
	 * automatically display a print dialog.
	 * 
	 * As objects which implement the Printable Interface, instances of the
	 * DocumentRenderer class can also be used as the argument in the
	 * setPrintable method of the PrinterJob class. Instead of using the print()
	 * methods detailed above, a programmer may gain access to the formatting
	 * capabilities of this class without using its print dialog by creating an
	 * instance of DocumentRenderer and setting the document to be printed with
	 * the setDocument() or setJEditorPane(). The Document may then be printed
	 * by setting the instance of DocumentRenderer in any PrinterJob.
	 */
	protected int currentPage = -1; // Used to keep track of when
	// the page to print changes.

	/* Modified by Pablo Salinas to allow this to work with OutputTextPane */
	protected/* JEditorPane */OutputTextPane jeditorPane; // Container to hold
															// the
	// Document. This object will
	// be used to lay out the
	// Document for printing.

	protected double pageEndY = 0; // Location of the current page
	// end.

	protected double pageStartY = 0; // Location of the current page
	// start.

	protected boolean scaleWidthToFit = true; // boolean to allow control over
	// whether pages too wide to fit
	// on a page will be scaled.

	/*
	 * The DocumentRenderer class uses pFormat and pJob in its methods. Note
	 * that pFormat is not the variable name used by the print method of the
	 * DocumentRenderer. Although it would always be expected to reference the
	 * pFormat object, the print method gets its PageFormat as an argument.
	 */
	protected PageFormat pFormat;
	protected PrinterJob pJob;

	/*
	 * The constructor initializes the pFormat and PJob variables.
	 */
	public DocumentRenderer() {
		pFormat = new PageFormat();
		pJob = PrinterJob.getPrinterJob();
	}

	/*
	 * Method to get the current Document
	 */
	public Document getDocument() {
		if (jeditorPane != null)
			return jeditorPane.getDocument();
		else
			return null;
	}

	/*
	 * Method to get the current choice the width scaling option.
	 */
	public boolean getScaleWidthToFit() {
		return scaleWidthToFit;
	}

	/*
	 * pageDialog() displays a page setup dialog.
	 */
	public void pageDialog() {
		pFormat = pJob.pageDialog(pFormat);
	}

	/*
	 * The print method implements the Printable interface. Although Printables
	 * may be called to render a page more than once, each page is painted in
	 * order. We may, therefore, keep track of changes in the page being
	 * rendered by setting the currentPage variable to equal the pageIndex, and
	 * then comparing these variables on subsequent calls to this method. When
	 * the two variables match, it means that the page is being rendered for the
	 * second or third time. When the currentPage differs from the pageIndex, a
	 * new page is being requested.
	 * 
	 * The highlights of the process used print a page are as follows:
	 * 
	 * I. The Graphics object is cast to a Graphics2D object to allow for
	 * scaling. II. The JEditorPane is laid out using the width of a printable
	 * page. This will handle line breaks. If the JEditorPane cannot be sized at
	 * the width of the graphics clip, scaling will be allowed. III. The root
	 * view of the JEditorPane is obtained. By examining this root view and all
	 * of its children, printView will be able to determine the location of each
	 * printable element of the document. IV. If the scaleWidthToFit option is
	 * chosen, a scaling ratio is determined, and the graphics2D object is
	 * scaled. V. The Graphics2D object is clipped to the size of the printable
	 * page. VI. currentPage is checked to see if this is a new page to render.
	 * If so, pageStartY and pageEndY are reset. VII. To match the coordinates
	 * of the printable clip of graphics2D and the allocation rectangle which
	 * will be used to lay out the views, graphics2D is translated to begin at
	 * the printable X and Y coordinates of the graphics clip. VIII. An
	 * allocation Rectangle is created to represent the layout of the Views.
	 * 
	 * The Printable Interface always prints the area indexed by reference to
	 * the Graphics object. For instance, with a standard 8.5 x 11 inch page
	 * with 1 inch margins the rectangle X = 72, Y = 72, Width = 468, and Height
	 * = 648, the area 72, 72, 468, 648 will be painted regardless of which page
	 * is actually being printed.
	 * 
	 * To align the allocation Rectangle with the graphics2D object two things
	 * are done. The first step is to translate the X and Y coordinates of the
	 * graphics2D object to begin at the X and Y coordinates of the printable
	 * clip, see step VII. Next, when printing other than the first page, the
	 * allocation rectangle must start laying out in coordinates represented by
	 * negative numbers. After page one, the beginning of the allocation is
	 * started at minus the page end of the prior page. This moves the part
	 * which has already been rendered to before the printable clip of the
	 * graphics2D object.
	 * 
	 * X. The printView method is called to paint the page. Its return value
	 * will indicate if a page has been rendered.
	 * 
	 * Although public, print should not ordinarily be called by programs other
	 * than PrinterJob.
	 */
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
		double scale = 1.0;
		Graphics2D graphics2D;
		View rootView;
		// I
		graphics2D = (Graphics2D) graphics;
		// II
		jeditorPane.setSize((int) pageFormat.getImageableWidth(),
				Integer.MAX_VALUE);
		jeditorPane.validate();
		// III
		rootView = jeditorPane.getUI().getRootView(jeditorPane);
		// IV
		if ((scaleWidthToFit)
				&& (jeditorPane.getMinimumSize().getWidth() > pageFormat
						.getImageableWidth())) {
			scale = pageFormat.getImageableWidth()
					/ jeditorPane.getMinimumSize().getWidth();
			graphics2D.scale(scale, scale);
		}
		// V
		graphics2D.setClip((int) (pageFormat.getImageableX() / scale),
				(int) (pageFormat.getImageableY() / scale), (int) (pageFormat
						.getImageableWidth() / scale), (int) (pageFormat
						.getImageableHeight() / scale));
		// VI
		if (pageIndex > currentPage) {
			currentPage = pageIndex;
			pageStartY += pageEndY;
			pageEndY = graphics2D.getClipBounds().getHeight();
		}
		// VII
		graphics2D.translate(graphics2D.getClipBounds().getX(), graphics2D
				.getClipBounds().getY());
		// VIII
		Rectangle allocation = new Rectangle(0, (int) -pageStartY,
				(int) (jeditorPane.getMinimumSize().getWidth()),
				(int) (jeditorPane.getPreferredSize().getHeight()));
		// X
		if (printView(graphics2D, allocation, rootView)) {
			return Printable.PAGE_EXISTS;
		} else {
			pageStartY = 0;
			pageEndY = 0;
			currentPage = -1;
			return Printable.NO_SUCH_PAGE;
		}
	}

	/*
	 * print(HTMLDocument) is called to set an HTMLDocument for printing.
	 */
	public void print(HTMLDocument htmlDocument) {
		setDocument(htmlDocument);
		printDialog();
	}

	/*
	 * print(JEditorPane) prints a Document contained within a JEDitorPane.
	 */
	public void print(JEditorPane jedPane) {
		setDocument(jedPane);
		printDialog();
	}

	/*
	 * print(PlainDocument) is called to set a PlainDocument for printing.
	 */
	public void print(PlainDocument plainDocument) {
		setDocument(plainDocument);
		printDialog();
	}

	/*
	 * A protected method, printDialog(), displays the print dialog and
	 * initiates printing in response to user input.
	 */
	protected void printDialog() {
		if (pJob.printDialog()) {
			pJob.setPrintable(this, pFormat);
			try {
				pJob.print();
			} catch (PrinterException printerException) {
				pageStartY = 0;
				pageEndY = 0;
				currentPage = -1;
				System.out.println("Error Printing Document");
			}
		}
	}

	/*
	 * printView is a recursive method which iterates through the tree structure
	 * of the view sent to it. If the view sent to printView is a branch view,
	 * that is one with children, the method calls itself on each of these
	 * children. If the view is a leaf view, that is a view without children
	 * which represents an actual piece of text to be painted, printView
	 * attempts to render the view to the Graphics2D object.
	 * 
	 * I. When any view starts after the beginning of the current printable
	 * page, this means that there are pages to print and the method sets
	 * pageExists to true. II. When a leaf view is taller than the printable
	 * area of a page, it cannot, of course, be broken down to fit a single
	 * page. Such a View will be printed whenever it intersects with the
	 * Graphics2D clip. III. If a leaf view intersects the printable area of the
	 * graphics clip and fits vertically within the printable area, it will be
	 * rendered. IV. If a leaf view does not exceed the printable area of a page
	 * but does not fit vertically within the Graphics2D clip of the current
	 * page, the method records that this page should end at the start of the
	 * view. This information is stored in pageEndY.
	 */
	protected boolean printView(Graphics2D graphics2D, Shape allocation,
			View view) {
		boolean pageExists = false;
		Rectangle clipRectangle = graphics2D.getClipBounds();
		Shape childAllocation;
		View childView;

		if (view.getViewCount() > 0) {
			for (int i = 0; i < view.getViewCount(); i++) {
				childAllocation = view.getChildAllocation(i, allocation);
				if (childAllocation != null) {
					childView = view.getView(i);
					if (printView(graphics2D, childAllocation, childView)) {
						pageExists = true;
					}
				}
			}
		} else {
			// I
			if (allocation.getBounds().getMaxY() >= clipRectangle.getY()) {
				pageExists = true;
				// II
				if ((allocation.getBounds().getHeight() > clipRectangle
						.getHeight())
						&& (allocation.intersects(clipRectangle))) {
					view.paint(graphics2D, allocation);
				} else {
					// III
					if (allocation.getBounds().getY() >= clipRectangle.getY()) {
						if (allocation.getBounds().getMaxY() <= clipRectangle
								.getMaxY()) {
							view.paint(graphics2D, allocation);
						} else {
							// IV
							if (allocation.getBounds().getY() < pageEndY) {
								pageEndY = allocation.getBounds().getY();
							}
						}
					}
				}
			}
		}
		return pageExists;
	}

	/*
	 * Method to set the content type the JEditorPane.
	 */
	protected void setContentType(String type) {
		jeditorPane.setContentType(type);
	}

	/*
	 * Method to set an HTMLDocument as the Document to print.
	 */
	public void setDocument(HTMLDocument htmlDocument) {
		// jeditorPane = new JEditorPane();
		jeditorPane = new OutputTextPane();/* Modified by Pablo Salinas */
		setDocument("text/html", htmlDocument);
	}

	/*
	 * Method to set the Document to print as the one contained in a
	 * JEditorPane. This method is useful when Java does not provide direct
	 * access to a particular Document type, such as a Rich Text Format
	 * document. With this method such a document can be sent to the
	 * DocumentRenderer class enclosed in a JEditorPane.
	 */
	public void setDocument(JEditorPane jedPane) {
		// jeditorPane = new JEditorPane();
		jeditorPane = new OutputTextPane();/* Modified by Pablo Salinas */
		setDocument(jedPane.getContentType(), jedPane.getDocument());
	}

	/*
	 * Method to set a PlainDocument as the Document to print.
	 */
	public void setDocument(PlainDocument plainDocument) {
		// jeditorPane = new JEditorPane();
		jeditorPane = new OutputTextPane();/* Modified by Pablo Salinas */
		setDocument("text/plain", plainDocument);
	}

	/*
	 * Method to set the content type and document of the JEditorPane.
	 */
	protected void setDocument(String type, Document document) {
		setContentType(type);
		jeditorPane.setDocument(document);
	}

	/*
	 * Method to set the current choice of the width scaling option.
	 */
	public void setScaleWidthToFit(boolean scaleWidth) {
		scaleWidthToFit = scaleWidth;
	}
}