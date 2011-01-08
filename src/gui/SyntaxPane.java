package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchEngine;

import evaluation.DiffAndEvaluator;

import String2ME.CheckString;

/**
 * This class implements a RSyntaxTextArea with icons, eSuite syntaxes, search
 * bar, etc.
 * 
 * @author pablo Salinas
 * 
 */
public class SyntaxPane {
	private JButton PlayButton;
	private JButton SaveButton;
	private JButton SaveAsButton;
	private JButton OpenButton;
	private JButton NewButton;
	private JButton PdfButton;
	private JButton NextButton;
	private JButton PreviousButton;

	protected eTextField jSearch;

	private JLabel SearchLabel;

	public RSyntaxTextArea TextArea;

	private RTextScrollPane TextScroll;

	private JToolBar jToolBar0;

	private JPanel jPanel1;

	public SyntaxPane ResultArea;

	public SyntaxPane(SyntaxPane Resultados) {
		this.ResultArea = Resultados;
	}

	public SyntaxPane() {

	}

	protected JPanel getSyntaxPane(boolean Editable) {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font(
							"Serif", Font.PLAIN, 14), new Color(59, 59, 59)));

			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJToolBar0(Editable), new Constraints(new Leading(5,
					0, 0), new Leading(0, 0, 0)));
			jPanel1.add(getTextScroll(Editable), new Constraints(new Bilateral(
					0, 0, 0), new Bilateral(34, 0, 0)));
		}
		return jPanel1;
	}

	/**
	 * This is the panel that has numbers in the left side
	 * 
	 * @return RTextScrollPane
	 */
	private RTextScrollPane getTextScroll(boolean editable) {
		if (TextScroll == null) {
			TextArea = new RSyntaxTextArea();

			TextArea.setMargin(new Insets(0, 20, 0, 0));

			if (!editable) {
				TextArea.setEditable(false);
				TextArea.setCurrentLineHighlightColor(Color.white);
			} else {
				TextArea.setMarginLinePosition(0);
				TextArea.setMarginLineEnabled(true);
			}
			SolverGUI S = new SolverGUI();
			S.PrepareSyntaxText(TextArea, Config.CurrentFont, editable);
			TextScroll = new RTextScrollPane(TextArea);
			TextScroll.setLineNumbersEnabled(editable);
		}
		return TextScroll;
	}

	private JToolBar getJToolBar0(boolean editable) {
		if (jToolBar0 == null) {
			jToolBar0 = new JToolBar();
			jToolBar0.setFloatable(false);

			if (editable)
				jToolBar0.setPreferredSize(new Dimension(1000, 35));
			else
				jToolBar0.setPreferredSize(new Dimension(440, 35));

			jToolBar0.setOpaque(false);
			jToolBar0.addSeparator();

			if (editable) {
				jToolBar0.add(getNewButton());
				jToolBar0.add(getOpenButton());
				jToolBar0.add(getSaveButton());
				jToolBar0.add(getSaveAsButton());
				jToolBar0.addSeparator();
				jToolBar0.add(getPdfButton());
				jToolBar0.addSeparator();
				jToolBar0.add(getPlayButton());

				jToolBar0.addSeparator();
			}

			jToolBar0.add(getSearchLabel());
			jToolBar0.add(getJSearch());
			jToolBar0.add(getPreviousButton());
			jToolBar0.add(getNextButton());
		}
		return jToolBar0;
	}

	private JLabel getSearchLabel() {
		if (SearchLabel == null) {
			SearchLabel = new JLabel();
			SearchLabel.setFont(Principal.TimesBold);
			SearchLabel.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/system-search.png"));
			SearchLabel.setText(Translation.Language.get(134));
		}
		return SearchLabel;
	}

	private JTextField getJSearch() {
		if (jSearch == null) {
			jSearch = new /* JTextField(10) */eTextField(10);
			// jSearch.setColumns(10);
			jSearch.setFont(new Font("Dialog", Font.PLAIN, 14));
			jSearch.addKeyListener(new KeyAdapter() {

				public void keyPressed(KeyEvent event) {
					jSearchKeyKeyPressed(event);
				}
			});
		}
		return jSearch;
	}

	/*--------------Buttons-----------------------------*/
	private JButton getPlayButton() {
		if (PlayButton == null) {
			PlayButton = new JButton();

			PlayButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/media-playback-start.png"));
			PlayButton.setText(Translation.Language.get(135));
			PlayButton
					.setBorder(BorderFactory.createCompoundBorder(null, null));
			PlayButton.setToolTipText(Translation.Language.get(136));
			PlayButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					PlayButtonMouseMouseClicked(/* event */);
				}
			});
		}
		return PlayButton;
	}

	private JButton getOpenButton() {
		if (OpenButton == null) {
			OpenButton = new JButton();
			OpenButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/document-open.png"));
			OpenButton.setText(Translation.Language.get(137));
			OpenButton.setToolTipText(Translation.Language.get(138));
			OpenButton
					.setBorder(BorderFactory.createCompoundBorder(null, null));
			OpenButton.setDefaultCapable(false);
			OpenButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					OpenButtonMouseMouseClicked(event);
				}
			});

		}
		return OpenButton;
	}

	private JButton getSaveButton() {
		if (SaveButton == null) {
			SaveButton = new JButton();

			SaveButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/document-save.png"));
			SaveButton.setText(Translation.Language.get(139));
			SaveButton.setToolTipText(Translation.Language.get(140));
			SaveButton
					.setBorder(BorderFactory.createCompoundBorder(null, null));
			SaveButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					SaveButtonMouseMouseClicked(event);
				}
			});

		}
		return SaveButton;
	}

	private JButton getSaveAsButton() {
		if (SaveAsButton == null) {
			SaveAsButton = new JButton();

			SaveAsButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/document-save-as.png"));
			SaveAsButton.setText(Translation.Language.get(141));
			SaveAsButton.setToolTipText(Translation.Language.get(140));
			SaveAsButton.setBorder(BorderFactory.createCompoundBorder(null,
					null));
			SaveAsButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					SaveAsButtonMouseMouseClicked(event);
				}
			});

		}
		return SaveAsButton;
	}

	private JButton getNewButton() {
		if (NewButton == null) {
			NewButton = new JButton();

			NewButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/document-new.png"));
			NewButton.setText(Translation.Language.get(143));
			NewButton.setToolTipText(Translation.Language.get(144));
			NewButton.setBorder(BorderFactory.createCompoundBorder(null, null));
			NewButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					NewButtonMouseMouseClicked(event);
				}
			});

		}
		return NewButton;
	}

	private JButton getPdfButton() {
		if (PdfButton == null) {
			PdfButton = new JButton();

			PdfButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/pdf.png"));
			PdfButton.setText(Translation.Language.get(145));
			PdfButton.setToolTipText(Translation.Language.get(146));
			PdfButton.setBorder(BorderFactory.createCompoundBorder(null, null));
			PdfButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					PdfButtonMouseMouseClicked(event);
				}
			});

		}
		return PdfButton;
	}

	private JButton getPreviousButton() {
		if (PreviousButton == null) {
			PreviousButton = new JButton();
			PreviousButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/media-seek-backward.png"));
			PreviousButton.setText(Translation.Language.get(147));
			PreviousButton.setToolTipText(Translation.Language.get(148));
			PreviousButton.setBorder(BorderFactory.createCompoundBorder(null,
					null));
			PreviousButton.setDefaultCapable(false);
			PreviousButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					PreviousButtonMouseMouseClicked(event);
				}
			});
		}
		return PreviousButton;
	}

	private JButton getNextButton() {
		if (NextButton == null) {
			NextButton = new JButton();
			NextButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/media-seek-forward.png"));
			NextButton.setText(Translation.Language.get(149));
			NextButton.setToolTipText(Translation.Language.get(150));
			NextButton
					.setBorder(BorderFactory.createCompoundBorder(null, null));
			NextButton.setDefaultCapable(false);
			NextButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					NextButtonMouseMouseClicked(event);
				}
			});

		}
		return NextButton;
	}

	/*----------------------BUTTONS EVENTS-----------------*/

	/* Search the word in jSearch in the TextArea (forward) */
	private void NextButtonMouseMouseClicked(MouseEvent event) {
		SearchEngine.find(TextArea, jSearch.getText(), true, false, false,
				false);
	}

	/* Search the word in jSearch in the TextArea (forward) */
	private void jSearchKeyKeyPressed(KeyEvent event) {
		int n = event.getKeyCode();
		if (n == KeyEvent.VK_ENTER) {
			SearchEngine.find(TextArea, jSearch.getText(), true, false, false,
					false);
		}
	}

	/* Search the word in jSearch in the TextArea (backward) */
	private void PreviousButtonMouseMouseClicked(MouseEvent event) {
		SearchEngine.find(TextArea, jSearch.getText(), false, false, false,
				false);
	}

	/**
	 * Open dialog
	 * 
	 * @param event
	 */
	protected void OpenButtonMouseMouseClicked(MouseEvent event) {
		SaveLoad L = new SaveLoad();
		L.Open(TextArea);
	}

	/**
	 * Save dialog
	 * 
	 * @param event
	 */
	protected void SaveButtonMouseMouseClicked(MouseEvent event) {
		SaveLoad S = new SaveLoad();
		S.Save(TextArea, false);

	}

	/**
	 * Save dialog
	 * 
	 * @param event
	 */
	protected void SaveAsButtonMouseMouseClicked(MouseEvent event) {
		SaveLoad S = new SaveLoad();
		S.Save(TextArea, true);

	}

	/**
	 * Erase current document
	 * 
	 * @param event
	 */
	protected void NewButtonMouseMouseClicked(MouseEvent event) {

		SaveLoad n = new SaveLoad();
		n.NewFile();

	}

	/**
	 * Calls the execute method that solves the system equation
	 * 
	 * @param event
	 */
	protected void PlayButtonMouseMouseClicked(/* MouseEvent event */) {
		try {

			// Sets the cursor to busy
			Config C = new Config();
			C.setAllWaitCursor();

			// Restart everything
			CheckString.PurgeAll();
			evaluation.DiffAndEvaluator.StringErrorEvaluating = null;
			evaluation.DiffAndEvaluator.IrrealEvaluation = false;
			// Starts the method
			SolverGUI n = new SolverGUI();
			n.Execute();

		} catch (RuntimeException RE) {
			Config.ErrorFound = true;
			RE.printStackTrace();
		} catch (Exception E) {
			Config.ErrorFound = true;
			E.printStackTrace();
		} finally {
			// Sets the cursor to default
			Config C = new Config();
			C.setInitialCursor();

			SolverGUI G = new SolverGUI();

			try {
				// printLog. Orders and print the variables and the times they
				// appear
				CheckString.Var.Variables.addAll(CheckString.OneEquationVar);
				CheckString.OneEquationVar.clear();
				Collections.sort(CheckString.Var.Variables);
				G.printLog();

				if (!Config.ErrorFound) {
					// Print results in result area
					G.printResults();

					// Print residuals in log
					G.printResiduals();

					// Select the result window
					Principal.SolverTabbedPane.setSelectedIndex(3);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (DiffAndEvaluator.TimeLimitExceeded)
				SolverGUI.PopUpWarning(Translation.Language.get(151)
						+ Config.JumpLine + Translation.Language.get(152));

			if (SolverGUI.ResidualsHigh & !DiffAndEvaluator.TimeLimitExceeded
					& !Config.ErrorFound)
				SolverGUI.PopUpWarning(Translation.Language.get(153)
						+ Config.JumpLine + Translation.Language.get(154));

			if (Config.ErrorFound & !DiffAndEvaluator.TimeLimitExceeded
					& DiffAndEvaluator.StringErrorEvaluating != null) {
				CheckString.PurgeAll();
				String[] auxC = DiffAndEvaluator
						.getVariables(DiffAndEvaluator.StringErrorEvaluating);
				String auxS = new String("");
				for (String S : auxC) {
					auxS += S + " ";
				}

				if (!DiffAndEvaluator.IrrealEvaluation)
					SolverGUI.PopUpError(Translation.Language.get(155)
							+ Config.JumpLine + Translation.Language.get(156)
							+ Config.JumpLine + "<" + auxS + ">"
							+ Config.JumpLine + Translation.Language.get(157));
				else
					SolverGUI.PopUpError(Translation.Language.get(382)
							+ Config.JumpLine + "<" + auxS + ">"
							+ Config.JumpLine + Translation.Language.get(383));

				DiffAndEvaluator.StringErrorEvaluating = new String("");
			}

			// Show the text from the beginning
			Principal.LogArea.TextArea.setCaretPosition(0);
			Principal.ResultArea.TextArea.setCaretPosition(0);

			// Restart everything
			CheckString.PurgeAll();
			evaluation.DiffAndEvaluator.StringErrorEvaluating = null;
			evaluation.DiffAndEvaluator.IrrealEvaluation = false;
			// This is the way to call the garbage collector
			System.gc();
			System.runFinalization();

			// Real ram memory usage
			// long used = Runtime.getRuntime().totalMemory() -
			// Runtime.getRuntime().freeMemory();
			// System.out.println("Memoria Ram en uso: "+used);

		}
	}

	/**
	 * Calls to the eSUite2Pdf.export method
	 * 
	 * @param event
	 */
	protected void PdfButtonMouseMouseClicked(MouseEvent event) {
		eSuite2Pdf aux = new eSuite2Pdf();
		aux.Export();
	}

	/**
	 * Calls to the repaint method
	 */
	protected void Refresh() {
		TextArea.repaint();
	}

	/* Search the word in jSearch in the TextArea (forward) */
	/**
	 * Search the String. True == found
	 */
	public boolean Search(String s) {
		return SearchEngine.find(TextArea, s, true, false, false, false);

	}

}