package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Class to link with iText.
 * 
 * @author Pablo Salinas
 */
public class eSuite2Pdf {

	/**
	 * 
	 * @param TextArea
	 * @param Result
	 */
	public void Export() {
		String archivo;
		// At first we ask for the file directory
		JFileChooser fc = new JFileChooser();
		fc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"PDF - Portable Document File (.pdf)", "pdf");
		fc.addChoosableFileFilter(filter);
		fc.setFileFilter(filter);

		try {
			fc.showSaveDialog(fc);
			File file = fc.getSelectedFile();
			archivo = file.getAbsolutePath();
		} catch (Exception e) {
			System.out.println("No file selected" + Config.JumpLine);
			archivo = null;
		}

		try {
			if (!archivo.substring(archivo.length() - 4, archivo.length())
					.equals(".pdf"))
				archivo += ".pdf";

			String icono = Config.AbsolutePath + "icons/help-browser.png";
			String[] preguntas = new String[] {
					Translation.Language.get(3),
					Translation.Language.get(3) + " & "
							+ Translation.Language.get(4),
					Translation.Language.get(376) };
			int n = JOptionPane.showOptionDialog(null, Translation.Language
					.get(375), Translation.Language.get(46),
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, new ImageIcon(icono),
					preguntas, null);

			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			// First i read the TextArea(the equations)
			String s = new String("");
			StringReader J = new StringReader(Principal.TextArea.TextArea
					.getText());
			BufferedReader BufJ = new BufferedReader(J);

			PdfWriter.getInstance(document, new FileOutputStream(archivo));
			document.open();

			/*
			 * Paragraph paragraph; paragraph = new Paragraph("Roses");
			 * paragraph.add(new Chunk("india", FontFactory.getFont
			 * (FontFactory.HELVETICA, Font.DEFAULTSIZE, Font.BOLD)));
			 */

			Chunk chunk = new Chunk(Translation.Language.get(3), FontFactory
					.getFont(FontFactory.HELVETICA_BOLD, 20));
			// chunk.setUnderline(0.2f, -2f);

			document.add(chunk);
			document.add(new Paragraph("   "));
			document.add(new Paragraph("  "));
			Paragraph auxP;
			for (int i = 0; i < Principal.TextArea.TextArea.getLineCount(); i++) {
				s = BufJ.readLine();
				auxP = new Paragraph(s, FontFactory.getFont(
						FontFactory.COURIER, 12));
				// auxP.setFont(FontFactory.getFont(FontFactory.COURIER, 14));
				if (s != null)
					document.add(auxP);
			}
			document.add(new Paragraph("   "));
			document.add(new Paragraph("  "));
			if (n >= 1) {
				// Secondly the results
				J = new StringReader(Principal.ResultArea.TextArea.getText());
				BufJ = new BufferedReader(J);

				chunk = new Chunk(Translation.Language.get(4), FontFactory
						.getFont(FontFactory.HELVETICA_BOLD, 20));
				// chunk.setUnderline(0.2f, -2f);
				document.add(chunk);
				document.add(new Paragraph("   "));
				document.add(new Paragraph("  "));

				for (int i = 0; i < Principal.ResultArea.TextArea
						.getLineCount(); i++) {
					s = BufJ.readLine();
					if (s != null) {
						s = s.replace(" ", "");
						String[] auxS = s.split(">>");

						for (String S : auxS) {
							auxP = new Paragraph(S, FontFactory.getFont(
									FontFactory.COURIER, 12));
							document.add(auxP);
						}

					}
				}
			}
			if (n >= 2) {
				// thirdly the Log
				J = new StringReader(Principal.LogArea.TextArea.getText());
				BufJ = new BufferedReader(J);

				chunk = new Chunk(Translation.Language.get(5), FontFactory
						.getFont(FontFactory.HELVETICA_BOLD, 20));
				// chunk.setUnderline(0.2f, -2f);
				document.add(chunk);
				document.add(new Paragraph("   "));
				document.add(new Paragraph("  "));

				for (int i = 0; i < Principal.LogArea.TextArea.getLineCount(); i++) {
					s = BufJ.readLine();
					boolean bol = false;
					if (s != null) {
						if (i > Principal.LogArea.TextArea.getLineCount() / 2)
							bol = true;
						if (bol)
							s = s.replace(".....", ".");
						auxP = new Paragraph(s, FontFactory.getFont(
								FontFactory.COURIER, 12));
						document.add(auxP);
					}
				}

			}
			// AQUI SE SIGUEN AÑADIENDO COSAS AL EXPORTADOR DE PDF

			/*
			 * //con el codigo de abajo se pueden hacer imagenes de un
			 * OutputTextPane, una opcion es //hacer un OutputTextPane cada x
			 * ecuaciones y de ahi sacar una foto e imprimirla //a pdf. Pero
			 * habria que volver a hacer render print, pero para cada x
			 * ecuaciones //un outputtext distinto Dimension size =
			 * Principal.Rendered.getSize(); BufferedImage myImage = new
			 * BufferedImage(size.width, size.height,
			 * BufferedImage.TYPE_INT_RGB); Graphics2D g2 =
			 * myImage.createGraphics(); g2.setBackground(Color.WHITE);
			 * g2.setColor(Color.BLACK); Principal.Rendered.paint(g2); try {
			 * 
			 * OutputStream out = new FileOutputStream("Miau.jpg");
			 * 
			 * JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			 * 
			 * encoder.encode(myImage); ImageIO.write(myImage, "png", out);
			 * out.close();
			 * 
			 * } catch (Exception e) {
			 * 
			 * System.out.println(e.toString());
			 * 
			 * } Image im = Image.getInstance("Miau.jpg");
			 * 
			 * document.add(im);
			 */

			document.close();

		} catch (FileNotFoundException e) {
			System.out.println("Not file selected");
		} catch (DocumentException e) {

			System.out.println("Not file selected");
		} catch (Exception e) {
			System.out.println("Not file selected");
		}

	}
}
