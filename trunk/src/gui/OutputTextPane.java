package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.StringTokenizer;

import net.sourceforge.jeuclid.swing.JMathComponent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * <<This java archive has been taken from symja project>> JTextPane with
 * special support for Images Modified by Pablo Salinas
 */
public class OutputTextPane extends JTextPane implements MouseListener {
	protected StyledDocument jOutputDoc;

	/* To implement line spacing */
	final float LineSpacing = (float) 0.8;
	SimpleAttributeSet Spacing = new SimpleAttributeSet();

	private final static String BRACKET_CHARACTERS = "[](){}";

	private final static String OPERATOR_CHARACTERS = "~+*;,.#'-:<>|&/=!^@";

	private final static String NUMERIC_BREAK_CHARCTERS = OPERATOR_CHARACTERS
			+ BRACKET_CHARACTERS;

	public final static String NAMED_IMAGE_STYLE = "NamedImage";

	public final static String NAMED_COMPONENT_STYLE = "NamedComponent";

	private final static SimpleAttributeSet OUTPUT_ATTR, ERROR_ATTR,
			OUTPUT_OPERATOR_ATTR, OUTPUT_STRING_ATTR, OUTPUT_NUM_ATTR,
			OUTPUT_NUM2_ATTR, OUTPUT_BRACKET_ATTR, OUTPUT_COMMENT_ATTR;

	private final static Color cColor[]; /* selected color */
	/* default colors */
	private final static Color cColorDefault[] = { Color.BLUE, Color.BLACK,
			new Color(100, 100, 255), Color.GRAY, new Color(255, 100, 0),
			new Color(100, 0, 50), new Color(50, 150, 0), Color.RED };

	private class Colors {
		final static int OUTPUT = 0;

		final static int NUM1 = 1;

		final static int NUM2 = 2;

		final static int COMMENT = 3;

		final static int OPERATOR = 4;

		final static int BRACKET = 5;

		final static int STRING = 6;

		final static int ERROR = 7;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6324491080121702039L;

	static {
		cColor = new Color[8];
		cColor[Colors.OUTPUT] = new Color(cColorDefault[Colors.OUTPUT].getRGB());
		cColor[Colors.ERROR] = new Color(cColorDefault[Colors.ERROR].getRGB());
		cColor[Colors.OPERATOR] = new Color(cColorDefault[Colors.OPERATOR]
				.getRGB());
		cColor[Colors.STRING] = new Color(cColorDefault[Colors.STRING].getRGB());
		cColor[Colors.NUM1] = new Color(cColorDefault[Colors.NUM1].getRGB());
		cColor[Colors.NUM2] = new Color(cColorDefault[Colors.NUM2].getRGB());
		cColor[Colors.BRACKET] = new Color(cColorDefault[Colors.BRACKET]
				.getRGB());
		cColor[Colors.COMMENT] = new Color(cColorDefault[Colors.COMMENT]
				.getRGB());
		// error
		ERROR_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(ERROR_ATTR, cColor[Colors.ERROR]);
		// normal output
		OUTPUT_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(OUTPUT_ATTR, cColor[Colors.OUTPUT]);
		// operator output
		OUTPUT_OPERATOR_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(OUTPUT_OPERATOR_ATTR,
				cColor[Colors.OPERATOR]);
		// string output
		OUTPUT_STRING_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(OUTPUT_STRING_ATTR, cColor[Colors.STRING]);
		// number 1 output
		OUTPUT_NUM_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(OUTPUT_NUM_ATTR, cColor[Colors.NUM1]);
		// number 2 output
		OUTPUT_NUM2_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(OUTPUT_NUM2_ATTR, cColor[Colors.NUM2]);
		// bracket output
		OUTPUT_BRACKET_ATTR = new SimpleAttributeSet();
		StyleConstants.setForeground(OUTPUT_BRACKET_ATTR,
				cColor[Colors.BRACKET]);
		// comment output
		OUTPUT_COMMENT_ATTR = new SimpleAttributeSet();
		StyleConstants
				.setForeground(OUTPUT_COMMENT_ATTR, cColor[Colors.STRING]);

	}

	public OutputTextPane(StyledDocument doc) {
		super(doc);
		jOutputDoc = doc;
		jOutputDoc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
	}

	public OutputTextPane() {
		this(new DefaultStyledDocument());
		Spacing.addAttribute(
				javax.swing.text.StyleConstants.FontConstants.Family,
				Font.MONOSPACED);
		Spacing.addAttribute(
				javax.swing.text.StyleConstants.FontConstants.FontSize,
				new Integer(13));
		Spacing.addAttribute(javax.swing.text.StyleConstants.LineSpacing,
				LineSpacing);
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

	}

	public void addImage(Image image) {
		try {
			StyledDocument doc = (StyledDocument) this.getDocument();
			Style style = doc.addStyle(NAMED_IMAGE_STYLE, null);
			StyleConstants.setIcon(style, new ImageIcon(image));
			doc.insertString(doc.getLength(), " ", style);
		} catch (BadLocationException ex) {
		}
	}

	public void addImage(Image image, boolean addNewLine) {
		StyledDocument doc = (StyledDocument) this.getDocument();
		this.addImage(image, doc.getLength(), addNewLine);
	}

	public void addImage(Image image, int location) {
		addImage(image, location, true);
	}

	public void addImage(Image image, int location, boolean addNewline) {
		try {
			StyledDocument doc = (StyledDocument) this.getDocument();
			Style style = doc.addStyle(NAMED_IMAGE_STYLE, null);
			StyleConstants.setIcon(style, new ImageIcon(image));
			doc.insertString(location, " ", style);
			if (addNewline)
				doc.insertString(location + 1, /* "\n" */System
						.getProperty("line.separator"), style);
		} catch (BadLocationException ex) {
		}
	}

	public void addComponent(JComponent component) {
		try {
			StyledDocument doc = (StyledDocument) this.getDocument();
			Style style = doc.addStyle(NAMED_COMPONENT_STYLE, null);
			StyleConstants.setComponent(style, component);
			doc.insertString(doc.getLength(), " ", style);
		} catch (BadLocationException ex) {
		}
	}

	public void addComponent(JComponent component, int location,
			boolean addNewline) {
		try {
			StyledDocument doc = (StyledDocument) this.getDocument();
			Style style = doc.addStyle(NAMED_COMPONENT_STYLE, null);
			StyleConstants.setComponent(style, component);
			doc.insertString(location, " ", style);
			if (addNewline) {
				doc.insertString(location + 1, /* "\n\n" */
				Config.JumpLine + Config.JumpLine, style);
			}
		} catch (BadLocationException ex) {
		}
	}

	public void addImage0(Image image, boolean addNewline) {
		addImage(image, 0, true);
	}

	/**
	 * Checks is a character is a valid (starting) character for a number
	 * 
	 * @param c
	 *            the char to be checked
	 * @return true (is numeric) or false (is not numeric)
	 */
	private boolean isNumeric(final char c) {
		return ("0123456789.".indexOf(c) != -1);
	}

	/**
	 * Color text in output pane depending on the contents of the inserted
	 * string
	 * 
	 * @param s
	 *            String that was inserted into the output pane
	 * @param offset
	 *            Start offset where string was inserted
	 */
	private void colorOutput(final String s, final int offset) {
		int startIdx = 0;
		char c;
		for (int idx = 0; idx < s.length(); idx++) {
			c = s.charAt(idx);
			startIdx = idx;
			// check for line comments
			if ((c == '/') && (idx < s.length() - 1)
					&& (s.charAt(idx + 1) == '/')) {
				startIdx = idx;
				idx++;
				while ((++idx < s.length()) && ((c = s.charAt(idx)) != '\n')) {
					;
				}
				jOutputDoc.setCharacterAttributes(offset + startIdx, idx
						- startIdx, OUTPUT_COMMENT_ATTR, true);
			}
			// check for operators
			startIdx = idx;

			while ((OPERATOR_CHARACTERS.indexOf(c) != -1)
					&& (++idx < s.length())) {
				c = s.charAt(idx);
			}

			if (idx != startIdx) {
				jOutputDoc.setCharacterAttributes(offset + startIdx, idx
						- startIdx, OUTPUT_OPERATOR_ATTR, true);
			}
			// check for brackets (no own state, since there's usually only one
			// bracket in a row)
			if (BRACKET_CHARACTERS.indexOf(c) != -1) {
				jOutputDoc.setCharacterAttributes(offset + idx, 1,
						OUTPUT_BRACKET_ATTR, true);
				continue;
			}
			// check for strings
			if (c == '"') {
				startIdx = idx;
				while ((++idx < s.length()) && ((c = s.charAt(idx)) != '"')) {
					;
				}
				jOutputDoc.setCharacterAttributes(offset + startIdx, idx
						- startIdx + 1, OUTPUT_STRING_ATTR, true);
			}
			// check for numbers
			if (isNumeric(c)) {
				int len, step, point = -1;
				boolean color1 = true;
				startIdx = idx;
				// search for break character
				while ((++idx < s.length())
						&& (NUMERIC_BREAK_CHARCTERS.indexOf(c = s.charAt(idx)) == -1)) {
					if (c == '.') {
						point = idx - startIdx; // position of point inside
												// number
					}
				}
				if (idx != s.length()) {
					idx--; // idx on last numeric character
				}
				len = idx - startIdx + 1;
				step = 3;
				// check kind of number
				if (len > 1) {
					if (s.charAt(startIdx) == '0') {
						// special cases: octal, binary, hexadecimal
						switch (s.charAt(startIdx + 1)) {
						case 'x':
							step = 2;
							startIdx += 2;
							len -= 2;
							break; // octal
						case 'b':
							step = 4;
							startIdx += 2;
							len -= 2;
							break; // octal
						case '.':
							step = 3;
							break; // decimal
						default:
							step = 2;
							break; // octal
						}
					}
				}

				if (point != -1) {
					int step2 = step;
					// special case: decimal point
					// first color characters after the point from left to right
					for (int pos = point + 1; pos < len; pos += step2) {
						if (pos + step2 >= len) {
							step2 = len - pos; // don't color outside number
						}
						jOutputDoc.setCharacterAttributes(offset + startIdx
								+ pos, step2, color1 ? OUTPUT_NUM_ATTR
								: OUTPUT_NUM2_ATTR, true);
						color1 = !color1; // toggle
					}
					// then color characters before the point from right to left
					len = point;
					color1 = true;
				}
				for (int pos = len; pos > 0; pos -= step) {
					if (pos - step < 0) {
						step = pos;
					}
					jOutputDoc.setCharacterAttributes(offset + startIdx + pos
							- step, step, color1 ? OUTPUT_NUM_ATTR
							: OUTPUT_NUM2_ATTR, true);
					color1 = !color1; // toggle
				}

			}
		}
	}

	/**
	 * Print text to output pane with syntax coloring
	 * 
	 * @param s
	 *            text to print
	 */
	public void printOutColored(final String s) {
		try {
			jOutputDoc.insertString(jOutputDoc.getLength(), s, OUTPUT_ATTR);
			jOutputDoc.setParagraphAttributes(jOutputDoc.getLength(),
					jOutputDoc.getLength() + s.length(), Spacing, true);
			// now start the coloring
			colorOutput(s, jOutputDoc.getLength() - s.length());
			setCaretPosition(jOutputDoc.getLength());// jOutputDoc.getLength());
		} catch (final BadLocationException ble) {
			System.out.println("Couldn't write to Output Pane");
		}
	}

	/**
	 * Print text to output pane
	 * 
	 * @param s
	 *            text to print
	 */
	public void printOut(final String s) {
		try {

			jOutputDoc.insertString(jOutputDoc.getLength(), s, /* OUTPUT_ATTR */
					OUTPUT_NUM_ATTR);
			jOutputDoc.setParagraphAttributes(jOutputDoc.getLength(),
					jOutputDoc.getLength() + s.length(), Spacing, true);
			setCaretPosition(jOutputDoc.getLength());// jOutputDoc.getLength());
		} catch (final BadLocationException ble) {
			System.out.println("Couldn't write to Output Pane");
		}
	}

	/**
	 * Print text to error pane
	 * 
	 * @param s
	 *            text to print
	 */
	public void printErr(final String s) {
		if (s == null) {
			return;
		}
		try {
			jOutputDoc.insertString(jOutputDoc.getLength(),
					s + Config.JumpLine, ERROR_ATTR);
			jOutputDoc.setParagraphAttributes(jOutputDoc.getLength(),
					jOutputDoc.getLength() + s.length(), Spacing, true);
			setCaretPosition(jOutputDoc.getLength());
		} catch (final BadLocationException ble) {
			System.out.println("Couldn't write to Output Pane");
		}
	}

	/**
	 * Adds the equation rendered to the output panel
	 * 
	 * @param mathML
	 */
	public void RenderPrint(String mathML) {

		JMathComponent component = new JMathComponent();
		component.setBackground(Color.WHITE);
		component.setFontSize(25);
		component.setContent(mathML);
		this.addComponent(component, jOutputDoc.getLength(), false);

	}

	public void addOutputTextPane(OutputTextPane component) {
		component.setBackground(Color.WHITE);
		this.addComponent(component, jOutputDoc.getLength(), false);
	}

	private final int printer = 14;

	/**
	 * Prints in the component with the specified values with the Serif Font
	 * 
	 * @param input
	 * @param Size
	 * @param Bold
	 */
	public void PrintComplex(String input, int Size, boolean Bold) {
		SimpleAttributeSet attrs = new SimpleAttributeSet();
		StyleConstants.setBold(attrs, Bold);
		StyleConstants.setFontFamily(attrs, Font.SERIF);
		StyleConstants.setFontSize(attrs, Size);
		try {
			jOutputDoc.insertString(jOutputDoc.getLength(), input, attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the input text with Serif, no bold, and font size = 12
	 * 
	 * @param input
	 */
	public void PrintText(String input) {
		this.PrintComplex(input, printer, false);
	}

	/**
	 * This will write something like this: (enumeration in bold) + input: 1-
	 * input
	 * 
	 * @param enumeration
	 * @param input
	 */
	public void printEnumeration(String enumeration, String input) {
		this.PrintComplex(enumeration, printer, true);
		this.PrintComplex(input, printer, false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.ContextMenuMouseListener n = new gui.ContextMenuMouseListener();
		n.mouseClicked(e);

	}

	/**
	 * The purpose of this method is to be able to use OutputTextPane to print
	 * the code of equations in the printer with the comments colored
	 * 
	 * @param input
	 */
	public void printWithComments(String input) {
		boolean comments = false;

		// This boolean is to include the slash from /* into the colored print
		// text
		boolean slash = false;

		String s, ps = new String("");
		StringTokenizer lector = new StringTokenizer(input, "*/", true);
		while (lector.hasMoreTokens()) {
			s = lector.nextToken();

			if (s.equals("*") & (ps.equals("/")))
				comments = true;

			if (slash)
				s = ps + s;
			// We only will activate the slash situation when the slash belongs
			// to this /* not to */
			if (s.equals("/") & !ps.equals("*"))
				slash = true;
			else
				slash = false;

			// If slash then the string will be save the next iteration
			if (!slash)
				if (!comments)
					PrintText(s);
				else {
					SimpleAttributeSet attrs = new SimpleAttributeSet();
					StyleConstants.setBold(attrs, false);
					StyleConstants.setFontFamily(attrs, Font.SERIF);
					StyleConstants.setFontSize(attrs, printer);
					Color aux = new Color(0, 128, 0);
					StyleConstants.setForeground(attrs, aux);
					try {

						jOutputDoc.insertString(jOutputDoc.getLength(), s,
								attrs);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}

			if (s.equals("/") & (ps.equals("*")))
				comments = false;
			ps = s;
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}