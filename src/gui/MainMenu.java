package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.border.EtchedBorder;

import org.fife.ui.rtextarea.RTextArea;

import String2ME.CheckString;

/**
 * Creates the toolBar.
 * 
 * @author Pablo Salinas
 * 
 */
class MainMenu implements ActionListener {

	protected JMenuBar jMenuBar0;
	private JMenuItem jExit, jOpen, jSaveAs, jSave, jNew, jPrint, jPDF;
	protected JMenu jFile, jEdit, jHelp;
	private JMenuItem jPreferences, jInitialValue, jPlay, jRefresh, jMaterial;
	protected JMenuItem jUndo, jRedo, jCut, jCopy, jPaste;
	private JMenuItem jAbout, jHelpF1;

	// private SyntaxPane TextArea;

	/*
	 * MainMenu(SyntaxPane TextArea){ this.TextArea=TextArea; }
	 */

	protected JMenuBar getJMenuBar0() {
		if (jMenuBar0 == null) {
			jMenuBar0 = new JMenuBar();
			jMenuBar0.setBorder(BorderFactory.createEtchedBorder(
					EtchedBorder.LOWERED, null, null));
			jMenuBar0.add(getJFile());
			jMenuBar0.add(getJEdit());
			jMenuBar0.add(getJHelp());
			jHelpF1.addActionListener(this);
			jPlay.addActionListener(this);
			jRefresh.addActionListener(this);
			jMaterial.addActionListener(this);
		}
		return jMenuBar0;
	}

	/* First menus */
	private JMenu getJEdit() {
		if (jEdit == null) {
			jEdit = new JMenu(Translation.Language.get(27));
			jEdit.add(getJUndo());
			jEdit.add(getJRedo());
			jEdit.addSeparator();
			jEdit.add(getJCut());
			jEdit.add(getJCopy());
			jEdit.add(getJPaste());
			jEdit.addSeparator();
			jEdit.add(getJPlay());
			jEdit.add(getJRefresh());
			jEdit.addSeparator();
			jEdit.add(getJMaterial());
			jEdit.add(getJInitialValue());
			jEdit.add(getJPreferences());

		}
		return jEdit;
	}

	private JMenu getJHelp() {
		if (jHelp == null) {
			jHelp = new JMenu(Translation.Language.get(28));
			jHelp.add(getjHelpF1());
			jHelp.add(getJAbout());
		}
		return jHelp;
	}

	private JMenu getJFile() {
		if (jFile == null) {
			jFile = new JMenu();
			jFile.setText(Translation.Language.get(29));

			jFile.add(getJNew());
			jFile.add(getJOpen());
			jFile.addSeparator();
			jFile.add(getJSave());
			jFile.add(getJSaveAs());
			jFile.addSeparator();
			jFile.add(getJPrint());
			jFile.add(getJPDF());
			jFile.addSeparator();
			jFile.add(getJExit());
		}
		return jFile;
	}

	/* Submenu */

	private JMenuItem getJAbout() {
		if (jAbout == null) {

			jAbout = new JMenuItem(Translation.Language.get(30), new ImageIcon(
					Config.AbsolutePath + "icons/dialog-information-small.png"));
			jAbout.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jMenuItem0MouseMouseReleased(event);
				}

				private void jMenuItem0MouseMouseReleased(MouseEvent event) {
					JOptionPane.showMessageDialog(null, Config.JumpLine
							+ Translation.Language.get(31) + Config.JumpLine
							+ Translation.Language.get(32) + Config.JumpLine
							+ Translation.Language.get(33) + Principal.VERSION
							+ Config.JumpLine + Translation.Language.get(34)
							+ Config.JumpLine + Translation.Language.get(35),
							Translation.Language.get(36),
							JOptionPane.OK_OPTION, new ImageIcon(
									Config.AbsolutePath
											+ "icons/help-browser.png"));

				}
			});
		}
		return jAbout;
	}

	private JMenuItem getjHelpF1() {
		if (jHelpF1 == null) {

			jHelpF1 = new JMenuItem(Translation.Language.get(28),
					new ImageIcon(Config.AbsolutePath
							+ "icons/help-browser-small.png"));
			jHelpF1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent
					.getKeyText(KeyEvent.VK_F1)));
			// jHelpF1.addActionListener(this);
			jHelpF1.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jMenuItem0MouseMouseReleased(event);
				}

				private void jMenuItem0MouseMouseReleased(MouseEvent event) {
					HelpGUI.jHelp();

				}
			});
		}
		return jHelpF1;
	}

	private JMenuItem getJPreferences() {
		if (jPreferences == null) {
			jPreferences = new JMenuItem(Translation.Language.get(37),
					new ImageIcon(Config.AbsolutePath
							+ "icons/preferences-system.png"));
			jPreferences.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jPreferencesMouseMouseReleased(event);
				}

				private void jPreferencesMouseMouseReleased(MouseEvent event) {
					Preferences.jPreferences();

				}
			});
		}
		return jPreferences;
	}

	private JMenuItem getJInitialValue() {
		if (jInitialValue == null) {
			jInitialValue = new JMenuItem(Translation.Language.get(20),
					new ImageIcon(Config.AbsolutePath
							+ "icons/mail-send-receive.png"));
			jInitialValue.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent event) {
					jInitialValueMouseMouseReleased(event);
				}

				private void jInitialValueMouseMouseReleased(MouseEvent event) {
					SolverGUI s = new SolverGUI();
					s.readVariables();
					InitialValuesGUI.jValues();
				}
			});
		}
		return jInitialValue;
	}

	private JMenuItem getJMaterial() {
		if (jMaterial == null) {
			jMaterial = new JMenuItem(Translation.Language.get(364),
					new ImageIcon(Config.AbsolutePath
							+ "icons/address-book-new.png"));
			jMaterial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent
					.getKeyText(KeyEvent.VK_F5)));
			jMaterial.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jInitialValueMouseMouseReleased(event);
				}

				private void jInitialValueMouseMouseReleased(MouseEvent event) {
					MaterialGUI.Material();
				}
			});
		}
		return jMaterial;
	}

	@SuppressWarnings("static-access")
	private JMenuItem getJUndo() {
		jUndo = new JMenuItem(Principal.TextArea.TextArea
				.getAction(RTextArea.UNDO_ACTION));
		return jUndo;
	}

	@SuppressWarnings("static-access")
	private JMenuItem getJRedo() {
		jRedo = new JMenuItem(Principal.TextArea.TextArea
				.getAction(RTextArea.REDO_ACTION));
		return jRedo;
	}

	private JMenuItem getJCut() {
		if (jCut == null) {
			jCut = new JMenuItem(Translation.Language.get(0), new ImageIcon(
					Config.AbsolutePath + "icons/cut.png"));
			jCut.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jPlayValueMouseMouseReleased(event);
				}

				private void jPlayValueMouseMouseReleased(MouseEvent event) {

					switch (SolverGUI.LastWindowFocused) {
					case 1:
						Principal.TextArea.TextArea.cut();
						break;
					case 5:
						Principal.mathPane.jCommandInput.cut();
						break;
					case 7:
						Principal.TextArea.jSearch.cut();
						break;
					case 8:
						Principal.LogArea.jSearch.cut();
						break;
					case 9:
						Principal.ResultArea.jSearch.cut();
						break;
					}

				}
			});
		}
		return jCut;
	}

	private JMenuItem getJCopy() {
		if (jCopy == null) {
			jCopy = new JMenuItem(Translation.Language.get(1), new ImageIcon(
					Config.AbsolutePath + "icons/copy.png"));
			jCopy.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jPlayValueMouseMouseReleased(event);
				}

				private void jPlayValueMouseMouseReleased(MouseEvent event) {
					switch (SolverGUI.LastWindowFocused) {
					case 1:
						Principal.TextArea.TextArea.copy();
						break;
					case 3:
						Principal.LogArea.TextArea.copy();
						break;
					case 4:
						Principal.ResultArea.TextArea.copy();
						break;
					case 5:
						Principal.mathPane.jCommandInput.copy();
						break;
					case 6:
						Principal.mathPane.Consola.copy();
						break;
					case 7:
						Principal.TextArea.jSearch.copy();
						break;
					case 8:
						Principal.LogArea.jSearch.copy();
						break;
					case 9:
						Principal.ResultArea.jSearch.copy();
						break;
					}

				}
			});
		}
		return jCopy;
	}

	private JMenuItem getJPaste() {
		if (jPaste == null) {
			jPaste = new JMenuItem(Translation.Language.get(2), new ImageIcon(
					Config.AbsolutePath + "icons/paste.png"));
			jPaste.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jPlayValueMouseMouseReleased(event);
				}

				private void jPlayValueMouseMouseReleased(MouseEvent event) {

					switch (SolverGUI.LastWindowFocused) {
					case 1:
						Principal.TextArea.TextArea.paste();
						break;
					case 5:
						Principal.mathPane.jCommandInput.paste();
						break;
					case 7:
						Principal.TextArea.jSearch.paste();
						break;
					case 8:
						Principal.LogArea.jSearch.paste();
						break;
					case 9:
						Principal.ResultArea.jSearch.paste();
						break;
					}

				}
			});
		}
		return jPaste;
	}

	private JMenuItem getJPlay() {
		if (jPlay == null) {
			jPlay = new JMenuItem(Translation.Language.get(38), new ImageIcon(
					Config.AbsolutePath
							+ "icons/media-playback-start-small.png"));
			jPlay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent
					.getKeyText(KeyEvent.VK_F3)));
			// jPlay.addActionListener(this);
			jPlay.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					jPlayValueMouseMouseReleased(event);
				}

				private void jPlayValueMouseMouseReleased(MouseEvent event) {
					Principal.TextArea
							.PlayButtonMouseMouseClicked(/* event */);

				}
			});
		}
		return jPlay;
	}

	private JMenuItem getJRefresh() {
		if (jRefresh == null) {
			jRefresh = new JMenuItem(Translation.Language.get(39),
					new ImageIcon(Config.AbsolutePath
							+ "icons/view-refresh-small.png"));
			jRefresh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent
					.getKeyText(KeyEvent.VK_F4)));
			jRefresh.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					jRefreshMouseMouseReleased();
				}

			});
		}
		return jRefresh;
	}

	private JMenuItem getJExit() {
		if (jExit == null) {
			jExit = new JMenuItem(Translation.Language.get(40), new ImageIcon(
					Config.AbsolutePath + "icons/system-log-out.png"));
			jExit.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jExitMouseMouseReleased(event);
				}

				private void jExitMouseMouseReleased(MouseEvent event) {
					SaveLoad.Salir();

				}
			});
		}
		return jExit;
	}

	private JMenuItem getJNew() {
		if (jNew == null) {
			jNew = new JMenuItem(Translation.Language.get(41), new ImageIcon(
					Config.AbsolutePath + "icons/document-new-small.png"));
			jNew.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jMenuItem0MouseMouseReleased(event);
				}

				private void jMenuItem0MouseMouseReleased(MouseEvent event) {
					Principal.TextArea.NewButtonMouseMouseClicked(event);

				}
			});
		}
		return jNew;
	}

	private JMenuItem getJOpen() {
		if (jOpen == null) {
			jOpen = new JMenuItem(Translation.Language.get(42), new ImageIcon(
					Config.AbsolutePath + "icons/document-open-small.png"));
			jOpen.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jMenuItem0MouseMouseReleased(event);
				}

				private void jMenuItem0MouseMouseReleased(MouseEvent event) {
					Principal.TextArea.OpenButtonMouseMouseClicked(event);

				}
			});
		}
		return jOpen;
	}

	private JMenuItem getJSave() {
		if (jSave == null) {
			jSave = new JMenuItem(Translation.Language.get(43), new ImageIcon(
					Config.AbsolutePath + "icons/document-save-small.png"));
			jSave.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jMenuItem0MouseMouseReleased(event);
				}

				private void jMenuItem0MouseMouseReleased(MouseEvent event) {
					Principal.TextArea.SaveButtonMouseMouseClicked(event);

				}
			});
		}
		return jSave;
	}

	private JMenuItem getJSaveAs() {
		if (jSaveAs == null) {
			jSaveAs = new JMenuItem(Translation.Language.get(44),
					new ImageIcon(Config.AbsolutePath
							+ "icons/document-save-as-small.png"));
			jSaveAs.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jMenuItem0MouseMouseReleased(event);
				}

				private void jMenuItem0MouseMouseReleased(MouseEvent event) {
					Principal.TextArea.SaveAsButtonMouseMouseClicked(event);

				}
			});
		}
		return jSaveAs;
	}

	private JMenuItem getJPDF() {
		if (jPDF == null) {
			jPDF = new JMenuItem(Translation.Language.get(45), new ImageIcon(
					Config.AbsolutePath + "icons/adobe-reader-small.png"));
			jPDF.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					jPDFItem0MouseMouseReleased(event);
				}

				private void jPDFItem0MouseMouseReleased(MouseEvent event) {
					Principal.TextArea.PdfButtonMouseMouseClicked(event);

				}
			});
		}
		return jPDF;
	}

	private JMenuItem getJPrint() {
		if (jPrint == null) {
			jPrint = new JMenuItem(Translation.Language.get(46), new ImageIcon(
					Config.AbsolutePath + "icons/document-print.png"));
			jPrint.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent event) {
					JPrintMouseMouseReleased();
				}

			});
		}
		return jPrint;
	}

	/**
	 * Calls the render Print method at gui.SolverGUI and prints the equations
	 * in the render area
	 */
	public static void jRefreshMouseMouseReleased() {
		try {
			// Sets the cursor to busy
			Config C = new Config();
			C.setAllWaitCursor();

			// Restart everything
			CheckString.PurgeAll();

			SolverGUI aux = new SolverGUI();
			aux
					.RenderEquations(Principal.Rendered,
							Principal.TextArea.TextArea);
		} finally {
			// Sets the cursor to default
			Config C = new Config();
			C.setInitialCursor();

			Principal.Rendered.setCaretPosition(0);

			// Restart everything
			CheckString.PurgeAll();
			// This is the way to call the garbage collector
			System.gc();
			System.runFinalization();
			// Set the render window
			Principal.SolverTabbedPane.setSelectedIndex(1);
		}

	}

	/**
	 * Calls the printer. To print the information.
	 */
	private void JPrintMouseMouseReleased() {
		String icono = Config.AbsolutePath + "icons/help-browser.png";
		String[] preguntas = new String[] {
				Translation.Language.get(3),
				Translation.Language.get(3) + " & "
						+ Translation.Language.get(4),
				Translation.Language.get(376) };
		int n = JOptionPane.showOptionDialog(null, Translation.Language
				.get(375), Translation.Language.get(46),
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				new ImageIcon(icono), preguntas, null);

		OutputTextPane output = new OutputTextPane();
		if (n >= 0) {
			output.PrintComplex(Translation.Language.get(3) + "\n\n\n", 20,
					true);
			output.printWithComments(Principal.TextArea.TextArea.getText()
					+ "\n\n\n");
		}
		if (n >= 1) {
			output.PrintComplex(Translation.Language.get(4) + "\n\n\n", 20,
					true);
			String S = Principal.ResultArea.TextArea.getText();
			S = S.replace(" ", "");
			String[] Saux = S.split(">>");
			String m = new String("");
			for (String s : Saux)
				m += (s + Config.JumpLine);
			output.PrintText(m);
		}
		if (n >= 2) {
			output.PrintComplex("Log\n\n\n", 20, true);
			output.PrintText(Principal.LogArea.TextArea.getText().replace(
					"...", ".").replace(Translation.Language.get(47),
					Translation.Language.get(48))
					+ "\n\n\n");

		}

		if (n >= 0) {
			DocumentRenderer DR = new DocumentRenderer();
			DR.print(output);
		}
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(Translation.Language.get(38)))
			Principal.TextArea.PlayButtonMouseMouseClicked();

		if (e.getActionCommand().equals(Translation.Language.get(39)))
			jRefreshMouseMouseReleased();

		if (e.getActionCommand().equals(Translation.Language.get(28)))
			HelpGUI.jHelp();

		if (e.getActionCommand().equals(Translation.Language.get(364)))
			MaterialGUI.Material();

	}
}