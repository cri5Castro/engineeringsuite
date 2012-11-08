package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import evaluation.DiffAndEvaluator;

/**
 * GUI of the mathematics section
 * 
 * @author Pablo Salinas
 * 
 */
public class MathPane {

	static char com = (int) 34;// "

	private JButton NumericalButton;
	protected OutputTextPane Consola;

	private JButton SymbolicButton;
	public eTextField jCommandInput;
	private JLabel CommandLabel;

	private JButton PlotButton;
	private JCheckBox jCheckBox1;

	private JScrollPane jScrollPane2;

	private JPanel jPanel0;

	// This int is to control the history of the Symbolic Evaluator
	protected static int history = -1;

	public static boolean RenderPrint;// True=RenderPrint

	private JCheckBox getJCheckBox1() {
		if (jCheckBox1 == null) {
			jCheckBox1 = new JCheckBox();
			jCheckBox1.setFont(Principal.Times);
			jCheckBox1.setText(Translation.Language.get(50));
			jCheckBox1.setSelected(true);
			RenderPrint = true;
			jCheckBox1.addItemListener(new ItemListener() {

				public void itemStateChanged(ItemEvent event) {
					jCheckBox1ItemItemStateChanged(event);
				}
			});
		}
		return jCheckBox1;
	}

	private JButton getPlotButton() {
		if (PlotButton == null) {
			PlotButton = new JButton();
			PlotButton.setText(Translation.Language.get(51));
			PlotButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/plot 16.png"));
			PlotButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					PlotButtonMouseMouseClicked(event);
				}
			});
			PlotButton.addKeyListener(new KeyAdapter() {

			});
		}
		return PlotButton;
	}

	private JLabel getCommandLabel() {
		if (CommandLabel == null) {
			CommandLabel = new JLabel();
			CommandLabel.setFont(Principal.TimesBold);
			CommandLabel.setText(Translation.Language.get(52));
		}
		return CommandLabel;
	}

	private eTextField getJCommandInput() {
		if (jCommandInput == null) {
			jCommandInput = new eTextField();
			jCommandInput.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
			// AutoCompleteDecorator.decorate(jCommandInput,
			// Commands.CommandList(),false);
			jCommandInput.addKeyListener(new KeyAdapter() {

				public void keyReleased(KeyEvent event) {
					jCommandInputKeyKeyReleased(event);
				}
			});
		}
		return jCommandInput;
	}

	private JButton getSymbolicButton() {
		if (SymbolicButton == null) {
			SymbolicButton = new JButton();
			SymbolicButton.setText(Translation.Language.get(53));
			SymbolicButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					SymbolicButtonMouseMouseClicked(event);
				}
			});
		}
		return SymbolicButton;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getConsola());
		}
		return jScrollPane2;
	}

	protected JPanel getMathematicsPane() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null,
					"MathConsole", TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, Principal.TimesBold, new Color(51,
							51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getSymbolicButton(), new Constraints(new Trailing(8,
					88, 6, 6), new Trailing(38, 43, 337)));
			jPanel0.add(getNumericalButton(), new Constraints(new Trailing(6,
					138, 119), new Trailing(10, 43, 337)));
			jPanel0.add(getJScrollPane2(), new Constraints(new Bilateral(14, 8,
					25), new Bilateral(6, 82, 25)));
			jPanel0.add(getJCommandInput(), new Constraints(new Bilateral(121,
					108, 594), new Trailing(38, 113, 126)));
			jPanel0.add(getCommandLabel(), new Constraints(new Leading(14, 126,
					126), new Trailing(44, 113, 126)));
			jPanel0.add(getJCheckBox1(), new Constraints(new Leading(123, 180,
					10, 10), new Trailing(6, 113, 243)));
			jPanel0.add(getPlotButton(), new Constraints(new Leading(14, 97,
					108, 108), new Trailing(2, 30, 113, 269)));
		}
		return jPanel0;
	}

	private OutputTextPane getConsola() {
		if (Consola == null) {
			Consola = new OutputTextPane();
			Consola.setFont(Principal.Mono);
			Consola.setEditable(false);
			Consola.setBorder(BorderFactory.createBevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
			Consola.printOutColored(Translation.Language.get(54));
			// Ans must have a initial value, if not and the user insert ans,
			// the program crash
			DiffAndEvaluator.SymbolicEvaluator("ANS=0");
		}
		return Consola;
	}

	private JButton getNumericalButton() {
		if (NumericalButton == null) {
			NumericalButton = new JButton();
			NumericalButton.setText(Translation.Language.get(55));
			NumericalButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					NumericalButtonMouseMouseClicked(event);
				}
			});
		}
		return NumericalButton;
	}

	/* Checkbox to select rendered print output or not */
	private void jCheckBox1ItemItemStateChanged(ItemEvent event) {
		RenderPrint = event.getStateChange() == ItemEvent.SELECTED;
	}

	// Symbolic button
	private void SymbolicButtonMouseMouseClicked(MouseEvent event) {
		MathematicsGUI M = new MathematicsGUI();
		M.SymbolicCalc(false, Consola, jCommandInput);

	}

	// Numerical Button
	private void NumericalButtonMouseMouseClicked(MouseEvent event) {
		MathematicsGUI M = new MathematicsGUI();
		M.SymbolicCalc(true, Consola, jCommandInput);
	}

	/**
	 * Add events to up, down, which navigates trough history, and enter that
	 * calls MathEclipse
	 * 
	 * @param event
	 */
	private void jCommandInputKeyKeyReleased(KeyEvent event) {
		int n = event.getKeyCode();
		MathematicsGUI M = new MathematicsGUI();
		if (n == KeyEvent.VK_ENTER) {
			if (event.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK) {

				M.SymbolicCalc(true, Consola, jCommandInput);
			} else
				M.SymbolicCalc(false, Consola, jCommandInput);
		}

		if (n == KeyEvent.VK_UP) {
			if (history < symbolicEvaluator.History.GetSize() - 1)
				history++;
			jCommandInput.setText(symbolicEvaluator.History.GetText(history));
		}
		if (n == KeyEvent.VK_DOWN) {// Down
			if (history > 0)
				history--;
			jCommandInput.setText(symbolicEvaluator.History.GetText(history));
		}
	}

	/**
	 * Creates a new window to plot equations
	 */
	private void PlotButtonMouseMouseClicked(MouseEvent event) {
		MathematicsGUI n = new MathematicsGUI();
		n.PlotButton();

	}

}