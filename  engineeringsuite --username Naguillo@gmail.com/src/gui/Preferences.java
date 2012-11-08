package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import String2ME.CheckString;

//VS4E -- DO NOT REMOVE THIS LINE!
//No longer Works with VS4E
/**
 * Creates the Preferences window
 * 
 * @author Pablo Salinas
 */
public class Preferences extends JDialog {

	/* Intermediate variables */
	private boolean Degrees = CheckString.Radianes;
	private String theme = new String(Config.Theme);
	private String lang = new String(Config.Language);
	private String fontname = new String(Config.CurrentFontName);
	private int fontsize = Config.CurrentFontSize;
	private int Iteraciones = Config.MaxNumberOfIteration;
	private double accuracy = Config.Precision;
	private double defaultvalue = Config.DefaultInitialValue;
	private double gradientprecision = Config.GradientPrecision;
	private byte onevariablemethod = Config.SingleVariableMethod;
	private byte multivariablemethod = Config.MultiVariableMethod;
	private int operationcalctime = Config.MaxOperationsTime;
	private double maxjump = Config.MaxJump;
	private int antiminimum = Config.IterationAntiMinimum;
	@SuppressWarnings("unused")
	private double value = Config.DefaultInitialValue;
	private int maxcalculatetime = Config.MaxCalculateTime;
	private double maxpositiveplot = Config.MaxPositivePlot;
	private double maxnegativeplot = Config.MaxNegativePlot;
	private double trustregionradius = Config.TrustRegionRadius;
	/* End of intermediate variables */
	private JPanel GlobalPane;
	private JTabbedPane WindowTabbed;
	private JButton CloseButton;
	private JPanel GeneralPane;
	private JPanel jPanel2;
	private JLabel trigonometryLabel;
	private JLabel UnitsLabel;
	private JRadioButton SIButtonRadio;
	private JRadioButton DegreeButtonRadio;
	private JRadioButton RadianButtonRadio;
	@SuppressWarnings("unused")
	private ButtonGroup jButtonGroup;
	private JPanel jPanel3;
	private JComboBox FontComboBox;
	private JLabel SizeLabel;
	private JComboBox jComboBox1;
	private JPanel jPanel4;
	private JLabel LanguageLabel;
	private JPanel jPanel5;
	private JLabel ThemeLabel;
	private JComboBox ThemeComboBox;
	private static final long serialVersionUID = 1L;
	private JPanel jPanel6;
	private JButton ApplyButton;
	private JComboBox LanguageComboBox;
	private JPanel EquationsPane;
	private JLabel PrecisionLabel;
	private JLabel MaxIterationLabel;
	private eTextField PrecisionTextField;
	private eTextField MaxIterationTextField;
	private JPanel jPanel9;
	private JPanel GeneralPane0;
	private JLabel MaxCalcTimeLabel;
	private eTextField MaxCalculateTimeTextField;
	private JPanel GeneralPane1;
	private JLabel MaxPositiveLabel;
	private JLabel MaxNegativeLabel;
	private eTextField MaxPositivePlotTextField;
	private eTextField MaxNegativePlotTextField;
	private JLabel MaxCalculationTimeLabel;
	private JLabel OneVariableMethodLabel;
	private JLabel GeneralMethodLabel;
	private JLabel MaxJumpLabel;
	private JLabel GradientPrecisionLabel;
	private JLabel AntiMinimumLabel;
	private JLabel TrustRegionLabel;
	private eTextField MaxOperationsTimeTextField;
	private JComboBox SingleVariableMethodTextField;
	private JComboBox MultiVariableMethodTextField;
	private eTextField MaximumJumpTextField;
	private eTextField GradientPrecisionTextField;
	private eTextField AntiMinimumTextField;
	private eTextField TrustRegionTextField;
	@SuppressWarnings("unused")
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public Preferences() {
		initComponents();
	}

	public Preferences(Frame parent) {
		super(parent);
		initComponents();
	}

	public Preferences(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public Preferences(Frame parent, String title) {
		super(parent, title);
		initComponents();
	}

	public Preferences(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public Preferences(Frame parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public Preferences(Dialog parent) {
		super(parent);
		initComponents();
	}

	public Preferences(Dialog parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public Preferences(Dialog parent, String title) {
		super(parent, title);
		initComponents();
	}

	public Preferences(Dialog parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public Preferences(Dialog parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public Preferences(Window parent) {
		super(parent);
		initComponents();
	}

	public Preferences(Window parent, ModalityType modalityType) {
		super(parent, modalityType);
		initComponents();
	}

	public Preferences(Window parent, String title) {
		super(parent, title);
		initComponents();
	}

	public Preferences(Window parent, String title, ModalityType modalityType) {
		super(parent, title, modalityType);
		initComponents();
	}

	public Preferences(Window parent, String title, ModalityType modalityType,
			GraphicsConfiguration arg) {
		super(parent, title, modalityType, arg);
		initComponents();
	}

	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getGlobalPane(), new Constraints(new Bilateral(0, 0, 0),
				new Bilateral(0, 0, 0)));
		setSize(550, 500);
	}

	private eTextField getAntiMinimumTextField() {
		if (AntiMinimumTextField == null) {
			AntiMinimumTextField = new eTextField();
			AntiMinimumTextField.setText(Integer
					.toString(Config.IterationAntiMinimum));
			AntiMinimumTextField.setToolTipText(Translation.Language.get(56));
			AntiMinimumTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					AntiMinimumTextFieldFocusFocusLost(event);
				}
			});
		}
		return AntiMinimumTextField;
	}

	private eTextField getTrustRegionTextField() {
		if (TrustRegionTextField == null) {
			TrustRegionTextField = new eTextField();
			TrustRegionTextField.setText(Double
					.toString(Config.TrustRegionRadius));
			TrustRegionTextField.setToolTipText(Translation.Language.get(57));
			TrustRegionTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					TrustRegionTextFieldFocusFocusLost(event);
				}
			});
		}
		return TrustRegionTextField;
	}

	private eTextField getGradientPrecisionTextField() {
		NumberFormat Number = new DecimalFormat("0.#####E0");
		if (GradientPrecisionTextField == null) {
			GradientPrecisionTextField = new eTextField();
			GradientPrecisionTextField.setText(Number
					.format(this.gradientprecision));
			GradientPrecisionTextField.setToolTipText(Translation.Language
					.get(58));
			GradientPrecisionTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					GradientPrecisionTextFieldFocusFocusLost(event);
				}
			});
		}
		return GradientPrecisionTextField;
	}

	private eTextField getMaximumJumpTextField() {
		if (MaximumJumpTextField == null) {
			MaximumJumpTextField = new eTextField();
			MaximumJumpTextField.setText(Double.toString(this.maxjump));
			MaximumJumpTextField.setToolTipText(Translation.Language.get(59));
			MaximumJumpTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					MaximumJumpTextFieldFocusFocusLost(event);
				}
			});
		}
		return MaximumJumpTextField;
	}

	private JComboBox getMultiVariableMethodTextField() {
		if (MultiVariableMethodTextField == null) {
			MultiVariableMethodTextField = new JComboBox();
			MultiVariableMethodTextField.setModel(new DefaultComboBoxModel(
					new String[] { "Line-Search", "Double Dogleg",
							"Hebden-More", "Levenberg-Marquardt" }));
			MultiVariableMethodTextField
					.setSelectedIndex(Config.MultiVariableMethod - 1);
			MultiVariableMethodTextField.setToolTipText(Translation.Language
					.get(60));
			MultiVariableMethodTextField
					.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent event) {
							MultiVariableMethodTextFieldActionActionPerformed(event);
						}
					});
		}

		return MultiVariableMethodTextField;
	}

	private JComboBox getSingleVariableMethodTextField() {
		if (SingleVariableMethodTextField == null) {
			SingleVariableMethodTextField = new JComboBox();
			SingleVariableMethodTextField.setModel(new DefaultComboBoxModel(
					new String[] { "Line-Search", "Double Dogleg",
							"Hebden-More", "Levenberg-Marquardt" }));
			SingleVariableMethodTextField
					.setSelectedIndex(Config.SingleVariableMethod - 1);
			SingleVariableMethodTextField.setToolTipText(Translation.Language
					.get(61));
			SingleVariableMethodTextField
					.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent event) {
							SingleVariableMethodTextFieldActionActionPerformed(event);
						}
					});
		}

		return SingleVariableMethodTextField;
	}

	private eTextField getMaxOperationsTimeTextField() {
		if (MaxOperationsTimeTextField == null) {
			MaxOperationsTimeTextField = new eTextField();
			MaxOperationsTimeTextField.setText(Integer
					.toString(Config.MaxOperationsTime));
			MaxOperationsTimeTextField.setToolTipText(Translation.Language
					.get(62));
			MaxOperationsTimeTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					MaxOperationsTimeTextFieldFocusFocusLost(event);
				}
			});
		}
		return MaxOperationsTimeTextField;
	}

	private JLabel getTrustRegionLabel() {
		if (TrustRegionLabel == null) {
			TrustRegionLabel = new JLabel();
			TrustRegionLabel.setFont(Principal.TimesBold);
			TrustRegionLabel.setText(Translation.Language.get(63));
		}
		return TrustRegionLabel;
	}

	private JLabel getAntiMinimumLabel() {
		if (AntiMinimumLabel == null) {
			AntiMinimumLabel = new JLabel();
			AntiMinimumLabel.setFont(Principal.TimesBold);
			AntiMinimumLabel.setText(Translation.Language.get(64));
			AntiMinimumLabel.setToolTipText(Translation.Language.get(65));
		}
		return AntiMinimumLabel;
	}

	private JLabel getGradientPrecisionLabel() {
		if (GradientPrecisionLabel == null) {
			GradientPrecisionLabel = new JLabel();
			GradientPrecisionLabel.setFont(Principal.TimesBold);
			GradientPrecisionLabel.setText(Translation.Language.get(66));
			GradientPrecisionLabel.setToolTipText(Translation.Language.get(67));
		}
		return GradientPrecisionLabel;
	}

	private JLabel getMaxJumpLabel() {
		if (MaxJumpLabel == null) {
			MaxJumpLabel = new JLabel();
			MaxJumpLabel.setFont(Principal.TimesBold);
			MaxJumpLabel.setText(Translation.Language.get(68));
			MaxJumpLabel.setToolTipText(Translation.Language.get(69));
		}
		return MaxJumpLabel;
	}

	private JLabel getGeneralMethodLabel() {
		if (GeneralMethodLabel == null) {
			GeneralMethodLabel = new JLabel();
			GeneralMethodLabel.setFont(Principal.TimesBold);
			GeneralMethodLabel.setText(Translation.Language.get(70));
			GeneralMethodLabel.setToolTipText(Translation.Language.get(71));
		}
		return GeneralMethodLabel;
	}

	private JLabel getOneVariableMethodLabel() {
		if (OneVariableMethodLabel == null) {
			OneVariableMethodLabel = new JLabel();
			OneVariableMethodLabel.setFont(Principal.TimesBold);
			OneVariableMethodLabel.setText(Translation.Language.get(72));
			OneVariableMethodLabel.setToolTipText(Translation.Language.get(73));
		}
		return OneVariableMethodLabel;
	}

	private JLabel getMaxCalculationTimeLabel() {
		if (MaxCalculationTimeLabel == null) {
			MaxCalculationTimeLabel = new JLabel();
			MaxCalculationTimeLabel.setFont(Principal.TimesBold);
			MaxCalculationTimeLabel.setText(Translation.Language.get(74));
		}
		return MaxCalculationTimeLabel;
	}

	private eTextField getMaxNegativePlotTextField() {
		if (MaxNegativePlotTextField == null) {
			MaxNegativePlotTextField = new eTextField(Double
					.toString(Config.MaxNegativePlot));
			MaxNegativePlotTextField.setColumns(12);
			MaxNegativePlotTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					MaxNegativePlotTextFieldFocusFocusLost(event);
				}
			});
		}
		return MaxNegativePlotTextField;
	}

	private eTextField getMaxPositivePlotTextField() {
		if (MaxPositivePlotTextField == null) {
			MaxPositivePlotTextField = new eTextField(Double
					.toString(Config.MaxPositivePlot));
			MaxPositivePlotTextField.setColumns(12);
			MaxPositivePlotTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					MaxPositivePlotTextFieldFocusFocusLost(event);
				}
			});
		}
		return MaxPositivePlotTextField;
	}

	private JLabel getMaxNegativeLabel() {
		if (MaxNegativeLabel == null) {
			MaxNegativeLabel = new JLabel();
			MaxNegativeLabel.setFont(Principal.TimesBold);
			MaxNegativeLabel.setText(Translation.Language.get(75));
		}
		return MaxNegativeLabel;
	}

	private JLabel getMaxPositiveLabel() {
		if (MaxPositiveLabel == null) {
			MaxPositiveLabel = new JLabel();
			MaxPositiveLabel.setFont(Principal.TimesBold);
			MaxPositiveLabel.setText(Translation.Language.get(76));
		}
		return MaxPositiveLabel;
	}

	private JPanel getGeneralPane1() {
		if (GeneralPane1 == null) {
			GeneralPane1 = new JPanel();
			GeneralPane1.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(77), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("DejaVu Sans", Font.BOLD,
							12), new Color(59, 59, 59)));
			GeneralPane1.setLayout(new GroupLayout());
			GeneralPane1.add(getMaxPositiveLabel(), new Constraints(
					new Leading(6, 6, 6), new Leading(6, 6, 6)));
			GeneralPane1.add(getMaxNegativeLabel(), new Constraints(
					new Leading(6, 6, 6), new Leading(48, 10, 10)));
			GeneralPane1.add(getMaxPositivePlotTextField(), new Constraints(
					new Leading(211, 10, 10), new Leading(2, 6, 6)));
			GeneralPane1.add(getMaxNegativePlotTextField(), new Constraints(
					new Leading(211, 6, 6), new Leading(44, 6, 6)));
		}
		return GeneralPane1;
	}

	private JTextField getMaxCalculateTimeTextField() {
		if (MaxCalculateTimeTextField == null) {
			MaxCalculateTimeTextField = new eTextField(Integer
					.toString(Config.MaxCalculateTime));
			MaxCalculateTimeTextField.setColumns(7);
			MaxCalculateTimeTextField.setToolTipText(Translation.Language
					.get(78));
			MaxCalculateTimeTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					MaxCalculateTimeTextFieldFocusFocusLost(event);
				}
			});
		}
		return MaxCalculateTimeTextField;
	}

	private JLabel getMaxCalcTimeLabel() {
		if (MaxCalcTimeLabel == null) {
			MaxCalcTimeLabel = new JLabel();
			MaxCalcTimeLabel.setFont(Principal.TimesBold);
			MaxCalcTimeLabel.setText(Translation.Language.get(79));
		}
		return MaxCalcTimeLabel;
	}

	private JPanel getGeneralPane0() {
		if (GeneralPane0 == null) {
			GeneralPane0 = new JPanel();
			GeneralPane0.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(80), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("DejaVu Sans", Font.BOLD,
							12), new Color(59, 59, 59)));
			GeneralPane0.setLayout(new GroupLayout());
			GeneralPane0.add(getMaxCalcTimeLabel(), new Constraints(
					new Leading(6, 6, 6), new Leading(19, 10, 10)));
			GeneralPane0.add(getMaxCalculateTimeTextField(), new Constraints(
					new Leading(222, 6, 6), new Leading(15, 6, 6)));
		}
		return GeneralPane0;
	}

	private JPanel getJPanel9() {
		if (jPanel9 == null) {
			jPanel9 = new JPanel();
			jPanel9.setLayout(new GroupLayout());
			jPanel9.add(getGeneralPane0(), new Constraints(new Bilateral(6, 6,
					0), new Leading(6, 100, 6, 6)));
			jPanel9.add(getGeneralPane1(), new Constraints(new Bilateral(12, 6,
					0), new Leading(118, 115, 10, 10)));
		}
		return jPanel9;
	}

	private eTextField getMaxIterationTextField() {
		if (MaxIterationTextField == null) {
			MaxIterationTextField = new eTextField(Integer
					.toString(Config.MaxNumberOfIteration));
			// MaxIterationTextField = new
			// eTextField(Double.toString(Config.MaxNumberOfIteration));
			MaxIterationTextField.setColumns(7);
			MaxIterationTextField.setToolTipText(Translation.Language.get(81));
			MaxIterationTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					MaxIterationTextFieldFocusFocusLost(event);
				}
			});
		}
		return MaxIterationTextField;
	}

	private eTextField getPrecisionTextField() {
		if (PrecisionTextField == null) {
			PrecisionTextField = new eTextField(Double
					.toString(Config.Precision));
			PrecisionTextField.setColumns(7);
			PrecisionTextField.setToolTipText(Translation.Language.get(82));
			PrecisionTextField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					PrecisionTextFieldFocusFocusLost(event);
				}
			});
		}
		return PrecisionTextField;
	}

	private JLabel getMaxIterationLabel() {
		if (MaxIterationLabel == null) {
			MaxIterationLabel = new JLabel();
			MaxIterationLabel.setFont(Principal.TimesBold);
			MaxIterationLabel.setText(Translation.Language.get(83));
		}
		return MaxIterationLabel;
	}

	private JLabel getPrecisionLabel() {
		if (PrecisionLabel == null) {
			PrecisionLabel = new JLabel();
			PrecisionLabel.setFont(Principal.TimesBold);
			PrecisionLabel.setText(Translation.Language.get(84));
		}
		return PrecisionLabel;
	}

	private JPanel getEquationsPane() {
		if (EquationsPane == null) {
			EquationsPane = new JPanel();
			EquationsPane.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(85), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("DejaVu Sans", Font.BOLD,
							12), new Color(59, 59, 59)));
			EquationsPane.setLayout(new GroupLayout());
			EquationsPane.add(getPrecisionLabel(), new Constraints(new Leading(
					24, 200, 6, 6), new Leading(5, 6, 6)));
			EquationsPane.add(getMaxIterationLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(45, 6, 6)));
			EquationsPane.add(getMaxCalculationTimeLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(85, 18, 10, 10)));
			EquationsPane.add(getAntiMinimumLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(285, 6, 6)));
			EquationsPane.add(getTrustRegionLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(325, 6, 6)));
			EquationsPane.add(getOneVariableMethodLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(125, 6, 6)));
			EquationsPane.add(getGeneralMethodLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(165, 6, 6)));
			EquationsPane.add(getMaxJumpLabel(), new Constraints(new Leading(
					24, 200, 6, 6), new Leading(205, 6, 6)));
			EquationsPane.add(getGradientPrecisionLabel(), new Constraints(
					new Leading(24, 200, 6, 6), new Leading(245, 6, 6)));
			EquationsPane.add(getMaxIterationTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(40, 6, 6)));
			EquationsPane.add(getPrecisionTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(0, 6, 6)));
			EquationsPane.add(getMaxOperationsTimeTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(80, 6, 6)));
			EquationsPane.add(getSingleVariableMethodTextField(),
					new Constraints(new Leading(230, 150, 6, 6), new Leading(
							120, 6, 6)));
			EquationsPane.add(getMultiVariableMethodTextField(),
					new Constraints(new Leading(230, 150, 6, 6), new Leading(
							160, 6, 6)));
			EquationsPane.add(getMaximumJumpTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(200, 6, 6)));
			EquationsPane.add(getGradientPrecisionTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(240, 6, 6)));
			EquationsPane.add(getAntiMinimumTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(280, 6, 6)));
			EquationsPane.add(getTrustRegionTextField(), new Constraints(
					new Leading(230, 150, 6, 6), new Leading(320, 6, 6)));
		}
		return EquationsPane;
	}

	private JComboBox getLanguageComboBox() {
		if (LanguageComboBox == null) {
			LanguageComboBox = new JComboBox();
			LanguageComboBox.setModel(new DefaultComboBoxModel(new String[] {
					"English", "Español" }));
			LanguageComboBox.setSelectedItem(lang);
			LanguageComboBox.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					LanguageComboBoxActionActionPerformed(event);
				}
			});
		}
		return LanguageComboBox;
	}

	private JButton getApplyButton() {
		if (ApplyButton == null) {
			ApplyButton = new JButton(Translation.Language.get(86),
					new ImageIcon(Config.AbsolutePath
							+ "icons/dialog-apply.png"));
			ApplyButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					ApplyButtonMouseMouseClicked(event);
				}
			});
		}
		return ApplyButton;
	}

	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(new GroupLayout());
			jPanel6.add(getEquationsPane(), new Constraints(new Bilateral(6, 6,
					0), new Bilateral(6, 6, 103)));
		}
		return jPanel6;
	}

	private JComboBox getThemeComboBox() {
		if (ThemeComboBox == null) {
			ThemeComboBox = new JComboBox();
			ThemeComboBox.setModel(new DefaultComboBoxModel(new Object[] {
					"Metal", "Motif", "Nimbus", "System" }));
			ThemeComboBox.setBorder(null);
			ThemeComboBox.setSelectedItem(Config.Theme);
			ThemeComboBox.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					ThemeComboBoxActionActionPerformed(event);
				}
			});

		}
		return ThemeComboBox;
	}

	private JLabel getThemeLabel() {
		if (ThemeLabel == null) {
			ThemeLabel = new JLabel();
			ThemeLabel.setFont(Principal.TimesBold);
			ThemeLabel.setText(Translation.Language.get(87));
		}
		return ThemeLabel;
	}

	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(88), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Dialog", Font.BOLD, 12),
					new Color(51, 51, 51)));
			jPanel5.setLayout(new GroupLayout());
			jPanel5.add(getThemeLabel(), new Constraints(
					new Leading(15, 10, 10), new Leading(12, 12, 12)));
			jPanel5.add(getThemeComboBox(), new Constraints(new Leading(167,
					119, 10, 10), new Leading(12, 12, 12)));
		}
		return jPanel5;
	}

	private JLabel getLanguageLabel() {
		if (LanguageLabel == null) {
			LanguageLabel = new JLabel();
			LanguageLabel.setFont(Principal.TimesBold);
			LanguageLabel.setText(Translation.Language.get(89) + "  >>");
		}
		return LanguageLabel;
	}

	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(89), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Dialog", Font.BOLD, 12),
					new Color(51, 51, 51)));
			jPanel4.setLayout(new GroupLayout());
			jPanel4.add(getLanguageLabel(), new Constraints(new Leading(0, 12,
					12), new Leading(12, 12, 12)));
			jPanel4.add(getLanguageComboBox(), new Constraints(new Leading(186,
					110, 10, 10), new Leading(12, 6, 6)));
		}
		return jPanel4;
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "8",
					"10", "12", "14", "18", "20" }));
			jComboBox1.setBorder(null);
			jComboBox1
					.setSelectedItem(Integer.toString(Config.CurrentFontSize));
			jComboBox1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					jComboBox1ActionActionPerformed(event);
				}
			});
		}
		return jComboBox1;
	}

	private JLabel getSizeLabel() {
		if (SizeLabel == null) {
			SizeLabel = new JLabel();
			SizeLabel.setFont(Principal.TimesBold);
			SizeLabel.setText(Translation.Language.get(90));

		}
		return SizeLabel;
	}

	private JComboBox getFontComboBox() {
		if (FontComboBox == null) {
			FontComboBox = new JComboBox();
			FontComboBox.setModel(new DefaultComboBoxModel(new String[] {
					Font.MONOSPACED, Font.SERIF, Font.SANS_SERIF }));
			FontComboBox.setBorder(null);
			FontComboBox.setSelectedItem(fontname);
			FontComboBox.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) {
					FontComboBoxActionActionPerformed(event);
				}
			});

		}
		return FontComboBox;
	}

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(91), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Dialog", Font.BOLD, 12),
					new Color(51, 51, 51)));
			jPanel3.setLayout(new GroupLayout());
			jPanel3.add(getFontComboBox(), new Constraints(new Leading(0, 137,
					12, 12), new Leading(0, 12, 12)));
			jPanel3.add(getJComboBox1(), new Constraints(new Leading(303, 77,
					12, 12), new Leading(0, 12, 12)));
			jPanel3.add(getSizeLabel(), new Constraints(
					new Leading(213, 12, 12), new Leading(0, 12, 12)));
		}
		return jPanel3;
	}

	// Radians
	private JRadioButton getRadianButtonRadio() {
		if (RadianButtonRadio == null) {
			RadianButtonRadio = new JRadioButton();
			RadianButtonRadio.setSelected(CheckString.Radianes);
			RadianButtonRadio.setText(Translation.Language.get(92));
			RadianButtonRadio.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					RadianButtonRadioMouseMouseClicked(event);
				}
			});
		}
		return RadianButtonRadio;
	}

	// Degrees
	private JRadioButton getDegreeButtonRadio() {
		if (DegreeButtonRadio == null) {
			DegreeButtonRadio = new JRadioButton();
			DegreeButtonRadio.setSelected(!CheckString.Radianes);
			DegreeButtonRadio.setText(Translation.Language.get(93));
			DegreeButtonRadio.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					DegreeButtonRadioMouseMouseClicked(event);
				}
			});
		}
		return DegreeButtonRadio;
	}

	private JRadioButton getSIButtonRadio() {
		if (SIButtonRadio == null) {
			SIButtonRadio = new JRadioButton();
			SIButtonRadio.setSelected(true);
			SIButtonRadio.setText("S.I.");
			SIButtonRadio.setEnabled(false);
			SIButtonRadio.setVisible(false);

		}
		return SIButtonRadio;
	}

	private JLabel getUnitsLabel() {
		if (UnitsLabel == null) {
			UnitsLabel = new JLabel();
			UnitsLabel.setFont(Principal.TimesBold);
			UnitsLabel.setText(Translation.Language.get(94));
			UnitsLabel.setVisible(false);
		}
		return UnitsLabel;
	}

	private JLabel gettrigonometryLabel() {
		if (trigonometryLabel == null) {
			trigonometryLabel = new JLabel();
			trigonometryLabel.setFont(Principal.TimesBold);
			trigonometryLabel.setText(Translation.Language.get(95));
		}
		return trigonometryLabel;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createTitledBorder(null,
					Translation.Language.get(96), TitledBorder.LEADING,
					TitledBorder.ABOVE_TOP, new Font("Dialog", Font.BOLD, 12),
					new Color(51, 51, 51)));
			jPanel2.setLayout(new GroupLayout());

			ButtonGroup jButtonGroup = new ButtonGroup();
			jButtonGroup.add(getDegreeButtonRadio());
			jButtonGroup.add(getRadianButtonRadio());

			jPanel2.add(gettrigonometryLabel(), new Constraints(new Leading(10,
					10, 10), new Leading(0, 12, 12)));
			jPanel2.add(getUnitsLabel(), new Constraints(new Leading(247, 12,
					12), new Leading(0, 12, 12)));
			jPanel2.add(getSIButtonRadio(), new Constraints(new Leading(247, 8,
					8), new Leading(26, 8, 8)));
			// jPanel2.add(getJButtonGroup(),new Constraints(new Leading(9, 8,
			// 8), new Leading(24, 8, 8)));
			jPanel2.add(getDegreeButtonRadio(), new Constraints(new Leading(9,
					8, 8), new Leading(24, 8, 8)));
			jPanel2.add(getRadianButtonRadio(), new Constraints(new Leading(9,
					12, 12), new Leading(44, 10, 10)));
		}
		return jPanel2;
	}

	private JPanel getGeneralPane() {
		if (GeneralPane == null) {
			GeneralPane = new JPanel();
			GeneralPane.setLayout(new GroupLayout());
			GeneralPane.add(getJPanel5(), new Constraints(new Bilateral(12, 12,
					0), new Trailing(12, 95, 10, 10)));
			GeneralPane.add(getJPanel3(), new Constraints(new Bilateral(12, 12,
					368), new Trailing(229, 83, 10, 10)));
			GeneralPane.add(getJPanel2(), new Constraints(new Bilateral(12, 12,
					0), new Leading(12, 10, 321)));
			GeneralPane.add(getJPanel4(), new Constraints(new Bilateral(12, 12,
					341), new Trailing(125, 86, 10, 10)));
		}
		return GeneralPane;
	}

	private JButton getCloseButton() {
		if (CloseButton == null) {
			CloseButton = new JButton(Translation.Language.get(17),
					new ImageIcon(Config.AbsolutePath
							+ "icons/window-close.png"));
			CloseButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					CloseButtonMouseMouseClicked(event);
				}
			});
		}
		return CloseButton;
	}

	private JTabbedPane getWindowTabbed() {
		if (WindowTabbed == null) {
			WindowTabbed = new JTabbedPane();
			WindowTabbed.setTabPlacement(JTabbedPane.LEFT);
			WindowTabbed.addTab(Translation.Language.get(97), getGeneralPane());
			WindowTabbed.addTab(Translation.Language.get(98), getJPanel6());
			WindowTabbed.addTab(Translation.Language.get(99), getJPanel9());
		}
		return WindowTabbed;
	}

	private JPanel getGlobalPane() {
		if (GlobalPane == null) {
			GlobalPane = new JPanel();
			GlobalPane.setLayout(new GroupLayout());
			GlobalPane.add(getWindowTabbed(), new Constraints(new Bilateral(0,
					0, 0), new Bilateral(0, 50, 0)));
			GlobalPane.add(getCloseButton(), new Constraints(new Leading(368,
					100, 10, 10), new Trailing(14, 30, 378, 506)));
			GlobalPane.add(getApplyButton(), new Constraints(new Leading(202,
					100, 10, 10), new Trailing(14, 30, 378, 506)));
		}
		return GlobalPane;
	}

	/*----------------------------------------------------------------------------*/
	public static void jPreferences() {
		// installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Preferences dialog = new Preferences();
				dialog.setDefaultCloseOperation(Preferences.DISPOSE_ON_CLOSE);
				dialog.setTitle(Translation.Language.get(37));
				dialog.setIconImage(SaveLoad.Icon);
				// dialog.setAlwaysOnTop(true);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setResizable(false);
				dialog.setLocationRelativeTo(null);
				dialog.getContentPane().setPreferredSize(dialog.getSize());
				dialog.pack();
				dialog.setVisible(true);
			}
		});
	}

	// Close button
	private void CloseButtonMouseMouseClicked(MouseEvent event) {
		this.dispose();
	}

	// Degree radio button
	private void DegreeButtonRadioMouseMouseClicked(MouseEvent event) {
		Degrees = false;
	}

	private void RadianButtonRadioMouseMouseClicked(MouseEvent event) {
		Degrees = true;
	}

	/**
	 * Apply Button;This will apply the changes and save then into the config
	 * file
	 * 
	 * @param event
	 */
	private void ApplyButtonMouseMouseClicked(MouseEvent event) {
		/* Apply changes */

		if (!Config.Theme.equalsIgnoreCase(theme)
				| !Config.Language.equalsIgnoreCase(lang)) {
			JOptionPane.showMessageDialog(null, Translation.Language.get(100),
					Translation.Language.get(101), JOptionPane.OK_OPTION,
					new ImageIcon(Config.AbsolutePath
							+ "icons/help-browser.png"));
		}

		CheckString.Radianes = Degrees;
		Config.CurrentFontName = fontname;
		Config.CurrentFontSize = fontsize;
		Config.CurrentFont = new Font(fontname, Font.PLAIN, fontsize);
		Config.Theme = theme;
		Config.Language = lang;
		Config.MaxNumberOfIteration = Iteraciones;
		Config.Precision = accuracy;
		Config.DefaultInitialValue = defaultvalue;
		Config.MaxCalculateTime = maxcalculatetime;
		Config.MaxPositivePlot = maxpositiveplot;
		Config.MaxNegativePlot = maxnegativeplot;
		Config.IterationAntiMinimum = this.antiminimum;
		Config.GradientPrecision = this.gradientprecision;
		Config.MaxOperationsTime = this.operationcalctime;
		Config.SingleVariableMethod = this.onevariablemethod;
		Config.MultiVariableMethod = this.multivariablemethod;
		Config.MaxJump = this.maxjump;
		Config.TrustRegionRadius = this.trustregionradius;

		Principal.UpdateTextArea();
		Config C = new Config();
		C.SaveConfig();
		this.dispose();
	}

	// Theme Combo Box
	private void ThemeComboBoxActionActionPerformed(ActionEvent event) {
		try {
			theme = (String) ThemeComboBox.getSelectedItem();
			ThemeComboBox.setSelectedItem(theme);
		} catch (Exception e) {
			theme = "Nimbus";
			ThemeComboBox.setSelectedItem(theme);
		}

	}

	// FontName Combo box
	private void FontComboBoxActionActionPerformed(ActionEvent event) {
		try {
			fontname = (String) FontComboBox.getSelectedItem();
			FontComboBox.setSelectedItem(fontname);
		} catch (Exception e) {
			fontname = "monospace";
			FontComboBox.setSelectedItem(fontname);
		}
	}

	// Size combo box
	private void jComboBox1ActionActionPerformed(ActionEvent event) {

		try {
			fontsize = Integer
					.parseInt(((String) jComboBox1.getSelectedItem()));
			jComboBox1.setSelectedItem(Integer.toString(fontsize));
		} catch (Exception e) {
			fontsize = 14;
			jComboBox1.setSelectedItem(Integer.toString(fontsize));
		}
	}

	// Language ComboBox
	private void LanguageComboBoxActionActionPerformed(ActionEvent event) {
		try {
			lang = (String) LanguageComboBox.getSelectedItem();
			LanguageComboBox.setSelectedItem(lang);
		} catch (Exception e) {
			lang = "English";
		}
	}

	// Precision TextField
	private void PrecisionTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String n = PrecisionTextField.getText();
			n = n.replace(",", ".");
			accuracy = Double.parseDouble(n);
			if (accuracy < 0)
				throw new Exception();
		} catch (Exception e) {
			this.accuracy = Config.Precision;
			PrecisionTextField.setText(Double.toString(Config.Precision));
			SolverGUI.PopUpError(Translation.Language.get(102));

		}
	}

	// Iteration TextField
	private void MaxIterationTextFieldFocusFocusLost(FocusEvent event) {
		try {
			Iteraciones = Integer.parseInt(MaxIterationTextField.getText());
			if (Iteraciones <= 0)
				throw new Exception();
		} catch (Exception e) {
			this.Iteraciones = Config.MaxNumberOfIteration;
			MaxIterationTextField.setText(Integer
					.toString(Config.MaxNumberOfIteration));
			SolverGUI.PopUpError(Translation.Language.get(102));

		}
	}

	// Mathematics, max calculate time
	private void MaxCalculateTimeTextFieldFocusFocusLost(FocusEvent event) {
		try {
			maxcalculatetime = Integer.parseInt(MaxCalculateTimeTextField
					.getText());
			if (this.maxcalculatetime < 1)
				throw new Exception();
		} catch (Exception e) {
			this.maxcalculatetime = Config.MaxCalculateTime;
			MaxCalculateTimeTextField.setText(Integer
					.toString(Config.MaxCalculateTime));
			SolverGUI.PopUpError(Translation.Language.get(103));

		}
	}

	// Positive Plot
	private void MaxPositivePlotTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = MaxPositivePlotTextField.getText();
			s = s.replace(",", ".");
			maxpositiveplot = Double.parseDouble(s);
		} catch (Exception e) {
			this.maxpositiveplot = Config.MaxPositivePlot;
			MaxPositivePlotTextField.setText(Double
					.toString(Config.MaxPositivePlot));
			SolverGUI.PopUpError(Translation.Language.get(25));

		}
	}

	// Negative Plot
	private void MaxNegativePlotTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = MaxNegativePlotTextField.getText();
			s = s.replace(",", ".");
			maxnegativeplot = Double.parseDouble(s);
		} catch (Exception e) {
			this.maxnegativeplot = Config.MaxNegativePlot;
			MaxNegativePlotTextField.setText(Double
					.toString(Config.MaxNegativePlot));
			SolverGUI.PopUpError(Translation.Language.get(25));

		}
	}

	// Max Operations calculation time
	private void AntiMinimumTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = AntiMinimumTextField.getText();
			this.antiminimum = Integer.parseInt(s);
			if (this.antiminimum < 0)
				throw new Exception();

		} catch (Exception e) {
			antiminimum = Config.IterationAntiMinimum;
			AntiMinimumTextField.setText(Integer
					.toString(Config.IterationAntiMinimum));
			SolverGUI.PopUpWarning(Translation.Language.get(103));

		}
	}

	// Gradient precision
	private void GradientPrecisionTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = GradientPrecisionTextField.getText();
			s = s.replace(",", ".");

			this.gradientprecision = Double.parseDouble(s);
			if (this.gradientprecision <= 0)
				throw new Exception();
		} catch (Exception e) {
			NumberFormat Number = new DecimalFormat("0.#####E0");
			this.gradientprecision = Config.GradientPrecision;
			GradientPrecisionTextField.setText(Number
					.format(Config.GradientPrecision));
			SolverGUI.PopUpError(Translation.Language.get(102));

		}
	}

	// Maximum step jump
	private void MaximumJumpTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = MaximumJumpTextField.getText();
			s = s.replace(",", ".");
			this.maxjump = Double.parseDouble(s);
			if (this.maxjump < 0)
				throw new Exception();

		} catch (Exception e) {
			this.maxjump = Config.MaxJump;
			MaximumJumpTextField.setText(Double.toString(Config.MaxJump));
			SolverGUI.PopUpWarning(Translation.Language.get(103));

		}
	}

	// Maximum operation time
	private void MaxOperationsTimeTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = MaxOperationsTimeTextField.getText();
			this.operationcalctime = Integer.parseInt(s);
			if (this.operationcalctime <= 0)
				throw new Exception();

		} catch (Exception e) {
			this.operationcalctime = Config.MaxOperationsTime;
			MaxOperationsTimeTextField.setText(Integer
					.toString(Config.MaxOperationsTime));
			SolverGUI.PopUpWarning(Translation.Language.get(103));

		}
	}

	// Trust region radius
	private void TrustRegionTextFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = TrustRegionTextField.getText();
			s = s.replace(",", ".");
			this.trustregionradius = Double.parseDouble(s);
			if (this.trustregionradius != -1)
				if (this.trustregionradius <= 0)
					throw new Exception();

		} catch (Exception e) {
			this.trustregionradius = Config.TrustRegionRadius;
			TrustRegionTextField.setText(Double
					.toString(Config.TrustRegionRadius));
			SolverGUI.PopUpWarning(Translation.Language.get(104));

		}
	}

	// Single variable method
	private void SingleVariableMethodTextFieldActionActionPerformed(
			ActionEvent event) {

		try {
			this.onevariablemethod = (byte) SingleVariableMethodTextField
					.getSelectedIndex();
			this.onevariablemethod++;
			SingleVariableMethodTextField
					.setSelectedItem(this.onevariablemethod - 1);
		} catch (Exception e) {
			this.onevariablemethod = Config.SingleVariableMethod;
			SingleVariableMethodTextField
					.setSelectedItem(this.onevariablemethod - 1);
		}
	}

	// Multivariable method
	private void MultiVariableMethodTextFieldActionActionPerformed(
			ActionEvent event) {

		try {
			this.multivariablemethod = (byte) MultiVariableMethodTextField
					.getSelectedIndex();
			this.multivariablemethod++;
			MultiVariableMethodTextField
					.setSelectedItem(this.multivariablemethod - 1);
		} catch (Exception e) {
			this.multivariablemethod = Config.MultiVariableMethod;
			MultiVariableMethodTextField
					.setSelectedItem(this.multivariablemethod - 1);
		}
	}
}
