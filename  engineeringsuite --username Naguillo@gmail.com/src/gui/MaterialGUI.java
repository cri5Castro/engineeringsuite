package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import String2ME.CheckString;
import String2ME.GramErr;

//VS4E -- DO NOT REMOVE THIS LINE!
//No longer works with VS4E
/**
 * Creates the menu to works with the materials
 */
public class MaterialGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane0;
	private JPanel jPanel0;
	private JButton CloseButton;
	private JButton PasteButton;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JList SubstanceList;
	private JScrollPane jScrollPane0;
	private JList ThermodynamicList;
	private JScrollPane jScrollPane1;
	private JLabel SubstanceLabel;
	private eTextField SubstanceField;
	private JLabel PropertyLabel1;
	private JLabel FormulaLabel;
	private JLabel VariableLabel;
	private eTextField PropertiesField;
	private eTextField FormulaField;
	private eTextField VariablesField;
	private RSyntaxTextArea InputNotesArea;
	private JScrollPane jScrollPane2;
	private JLabel InformationLabel2;
	private JButton AddButton;
	private RSyntaxTextArea InformationArea;
	private JScrollPane jScrollPane3;
	private JLabel InformationLabel;
	private static MaterialMethods Materiales;
	private JLabel MaterialLabel;
	private JLabel PropertyLabel;
	private JLabel ForwardIcon;
	private JLabel BackwardIcon;
	private JButton RemoveButton;
	private JButton SeeFormulaButton;
	private DefaultListModel Substances = new DefaultListModel();
	private DefaultListModel PropertyList = new DefaultListModel();
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public MaterialGUI() {
		initComponents();
	}

	public MaterialGUI(Frame parent) {
		super(parent);
		initComponents();
	}

	public MaterialGUI(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public MaterialGUI(Frame parent, String title) {
		super(parent, title);
		initComponents();
	}

	public MaterialGUI(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public MaterialGUI(Frame parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public MaterialGUI(Dialog parent) {
		super(parent);
		initComponents();
	}

	public MaterialGUI(Dialog parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public MaterialGUI(Dialog parent, String title) {
		super(parent, title);
		initComponents();
	}

	public MaterialGUI(Dialog parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public MaterialGUI(Dialog parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public MaterialGUI(Window parent) {
		super(parent);
		initComponents();
	}

	public MaterialGUI(Window parent, ModalityType modalityType) {
		super(parent, modalityType);
		initComponents();
	}

	public MaterialGUI(Window parent, String title) {
		super(parent, title);
		initComponents();
	}

	public MaterialGUI(Window parent, String title, ModalityType modalityType) {
		super(parent, title, modalityType);
		initComponents();
	}

	public MaterialGUI(Window parent, String title, ModalityType modalityType,
			GraphicsConfiguration arg) {
		super(parent, title, modalityType, arg);
		initComponents();
	}

	private void initComponents() {
		// Get the information of the materials
		Materiales = new MaterialMethods();

		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJTabbedPane0(), new Constraints(new Bilateral(12, 12, 0),
				new Leading(12, 418, 10, 10)));
		add(getJPanel0(), new Constraints(new Bilateral(24, 12, 0),
				new Leading(442, 48, 12, 12)));
		setSize(540, 500);

	}

	// Remove Button
	/**
	 * Erase the Substance/Property
	 */
	private JButton getRemoveButton() {
		if (RemoveButton == null) {
			RemoveButton = new JButton();
			RemoveButton.setText(Translation.Language.get(12));
			RemoveButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/user-trash.png"));
			RemoveButton.setFocusable(false);
			RemoveButton.setEnabled(false);
			RemoveButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					RemoveButtonMouseMouseClicked(event);
				}

				private void RemoveButtonMouseMouseClicked(MouseEvent event) {

					if (SubstanceList.isFocusOwner()) {
						int n = JOptionPane.showOptionDialog(null,
								Translation.Language.get(353),
								Translation.Language.get(13),
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon(
										Config.AbsolutePath
												+ "icons/dialog-warning.png"),
								null, null);

						if (n == 0)
							Materiales.Materials.remove(SubstanceList
									.getSelectedIndex());
					}

					if (ThermodynamicList.isFocusOwner()) {
						int n = JOptionPane.showOptionDialog(null,
								Translation.Language.get(354),
								Translation.Language.get(13),
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon(
										Config.AbsolutePath
												+ "icons/dialog-warning.png"),
								null, null);

						if (n == 0)
							Materiales.Materials.get(
									SubstanceList.getSelectedIndex())
									.getPropertyList().remove(
											ThermodynamicList
													.getSelectedIndex());
					}

					// Saves the List
					Materiales.saveTree();
					// Updates the List
					RefreshLists();
				}
			});
		}
		return RemoveButton;
	}

	// Backward icon
	private JLabel getBackwardIcon() {
		if (BackwardIcon == null) {
			BackwardIcon = new JLabel();
			BackwardIcon.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/go-previous.png"));
			BackwardIcon.setFocusable(false);
		}
		return BackwardIcon;
	}

	// Forward icon
	private JLabel getForwardIcon() {
		if (ForwardIcon == null) {
			ForwardIcon = new JLabel();
			ForwardIcon.setFocusable(false);
			ForwardIcon.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/go-next.png"));
		}
		return ForwardIcon;
	}

	// Property label
	private JLabel getPropertyLabel1() {
		if (PropertyLabel1 == null) {
			PropertyLabel1 = new JLabel();
			PropertyLabel1.setFont(Principal.TimesBold);
			PropertyLabel1.setText(Translation.Language.get(355) + ": ");
		}
		return PropertyLabel1;
	}

	// Material label
	private JLabel getMaterialLabel() {
		if (MaterialLabel == null) {
			MaterialLabel = new JLabel();
			MaterialLabel.setFont(Principal.TimesBold);
			MaterialLabel.setText(Translation.Language.get(356) + ": ");
		}
		return MaterialLabel;
	}

	private JLabel getInformationLabel() {
		if (InformationLabel == null) {
			InformationLabel = new JLabel();
			InformationLabel.setFont(Principal.TimesBold);
			InformationLabel.setText(Translation.Language.get(357));
		}
		return InformationLabel;
	}

	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getInformationArea());
		}
		return jScrollPane3;
	}

	// Information Area
	private RSyntaxTextArea getInformationArea() {
		if (InformationArea == null) {
			InformationArea = new RSyntaxTextArea();
			SolverGUI S = new SolverGUI();
			S.PrepareSyntaxText(InformationArea, Principal.Mono, false);
			InformationArea.setHighlightCurrentLine(false);
			InformationArea.setEditable(false);
			InformationArea.setFocusable(false);
			InformationArea.setBackground(Color.LIGHT_GRAY);
		}
		return InformationArea;
	}

	// Add Button
	/**
	 * Adds the Substance/property to the data base
	 */
	private JButton getAddButton() {
		if (AddButton == null) {
			AddButton = new JButton();
			AddButton.setText(Translation.Language.get(13));
			AddButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/bookmark-new.png"));
			AddButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					AddButtonMouseMouseClicked(event);
				}

				private void AddButtonMouseMouseClicked(MouseEvent event) {
					if ((SubstanceField.getText().length() > 0)
							& (PropertiesField.getText().length() > 0)
							& (FormulaField.getText().length() > 0)) {
						CheckString.PurgeAll();
						GramErr aux2;
						CheckString aux = new CheckString();
						aux2 = aux.GramCheck(FormulaField.getText().replace(
								" ", ""));
						SolverGUI G = new SolverGUI();
						G.checkGram(aux2);
						if (aux2.GetTypeError() == 0) {
							MaterialMethods m = new MaterialMethods();

							// Check if the property is already in the material
							boolean found = false;
							try {
								for (String s : Materiales
										.getProperties(SubstanceField.getText()))
									if (s.equalsIgnoreCase(PropertiesField
											.getText())) {
										found = true;
										break;
									}
							} catch (NullPointerException e) {/*
															 * No substance
															 * found
															 */
							}
							if (!found) {
								Character c = (char) 127;

								// Save the formula in the eSuite form
								String auxiliar = CheckString.Functions.get(0)
										.getEquation().replace("Degree", "")
										.replace(CheckString.SubsEqual, "=");
								if (!InputNotesArea.getText().contains(
										c.toString()))
									m.saveTreeAndMaterial(
											cleanString(SubstanceField
													.getText()),
											cleanString(PropertiesField
													.getText()),
											auxiliar.substring(0,
													auxiliar.length() - 1)
													.replace(",", "."),
											VariablesField.getText(),
											InputNotesArea.getText());
								else
									SolverGUI
											.PopUpError("Illegal character found: "
													+ c);

								SubstanceField.setText("");
								PropertiesField.setText("");
								FormulaField.setText("");
								VariablesField.setText("");
								InputNotesArea.setText("");

								// SolverGUI.PopUpWarning(Translation.Language.get(358));
								RefreshLists();
							} else
								SolverGUI.PopUpWarning(Translation.Language
										.get(363));
						}

						CheckString.PurgeAll();
						// Refresh jList
						refreshJList();

					} else
						SolverGUI.PopUpWarning(Translation.Language.get(352));
				}
			});
		}
		return AddButton;
	}

	private JLabel getInformationLabel2() {
		if (InformationLabel2 == null) {
			InformationLabel2 = new JLabel();
			InformationLabel2.setFont(Principal.TimesBold);
			InformationLabel2.setText(Translation.Language.get(357));
		}
		return InformationLabel2;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getInputNotesArea());
		}
		return jScrollPane2;
	}

	// Input notes
	private RSyntaxTextArea getInputNotesArea() {
		if (InputNotesArea == null) {
			InputNotesArea = new RSyntaxTextArea();
			SolverGUI S = new SolverGUI();
			S.PrepareSyntaxText(InputNotesArea, Principal.Mono, true);
			InputNotesArea.setHighlightCurrentLine(false);
		}
		return InputNotesArea;
	}

	// Variables
	private eTextField getVariablesField() {
		if (VariablesField == null) {
			VariablesField = new eTextField();
			VariablesField.setText("");
			VariablesField.setBackground(Color.LIGHT_GRAY);
			VariablesField.setEditable(false);
			VariablesField.setFocusable(false);
		}
		return VariablesField;
	}

	// Formula
	private eTextField getFormulaField() {
		if (FormulaField == null) {
			FormulaField = new eTextField();
			FormulaField.setText("");
			FormulaField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					FormulaFieldFocusFocusLost();
				}

				public void FormulaFieldFocusFocusLost() {
					VariablesField.setText("");
					if (FormulaField.getText().length() > 0) {
						CheckString.PurgeAll();
						GramErr aux2;
						CheckString aux = new CheckString();
						aux2 = aux.GramCheck(FormulaField.getText());
						if (aux2.GetTypeError() == 0) {
							aux.getVariables(FormulaField.getText());
							String var = "";
							for (String s : CheckString.CaseVariables)
								var += s + ", ";
							var = var.substring(0, var.length() - 2);// To erase
																		// the
																		// last
																		// comma
							VariablesField.setText(var);
						} else
							VariablesField.setText("Error!");

						CheckString.PurgeAll();
					}
				}
			});
		}
		return FormulaField;
	}

	// Properties
	private eTextField getPropertiesField() {
		if (PropertiesField == null) {
			PropertiesField = new eTextField();
			PropertiesField.setText("");
			PropertiesField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					PropertiesFieldFocusFocusLost();
				}

				public void PropertiesFieldFocusFocusLost() {
					PropertiesField.setText(cleanString(PropertiesField
							.getText()));
				}
			});
			// Now i create a List with all the properties
			LinkedList<String> Properties = new LinkedList<String>();
			boolean found = false;
			for (MaterialList m : Materiales.Materials)
				for (MaterialStore s : m.getPropertyList()) {
					found = false;
					for (String P : Properties)
						if (s.getProperty().equalsIgnoreCase(P)) {
							found = true;
							break;
						}
					if (!found)
						Properties.add(s.getProperty());

				}

			AutoCompleteDecorator.decorate(PropertiesField, Properties, false);

		}
		return PropertiesField;
	}

	private JLabel getVariableLabel() {
		if (VariableLabel == null) {
			VariableLabel = new JLabel();
			VariableLabel.setFont(Principal.TimesBold);
			VariableLabel.setText(Translation.Language.get(362) + " >>");
		}
		return VariableLabel;
	}

	private JLabel getFormulaLabel() {
		if (FormulaLabel == null) {
			FormulaLabel = new JLabel();
			FormulaLabel.setFont(Principal.TimesBold);
			FormulaLabel.setText(Translation.Language.get(359));
		}
		return FormulaLabel;
	}

	private JLabel getPropertyLabel() {
		if (PropertyLabel == null) {
			PropertyLabel = new JLabel();
			PropertyLabel.setFont(Principal.TimesBold);
			PropertyLabel.setText(Translation.Language.get(355) + " >>");
		}
		return PropertyLabel;
	}

	// Materials
	private eTextField getSubstanceField() {
		if (SubstanceField == null) {
			SubstanceField = new eTextField();
			AutoCompleteDecorator.decorate(SubstanceField, Materiales
					.getMaterials(), false);
			SubstanceField.setText("");
			SubstanceField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					SubstanceFieldFocusFocusLost();
				}

				public void SubstanceFieldFocusFocusLost() {
					SubstanceField
							.setText(cleanString(SubstanceField.getText()));
				}
			});
		}
		return SubstanceField;
	}

	private JLabel getSubstanceLabel() {
		if (SubstanceLabel == null) {
			SubstanceLabel = new JLabel();
			SubstanceLabel.setFont(Principal.TimesBold);
			SubstanceLabel.setText(Translation.Language.get(356) + " >>");
		}
		return SubstanceLabel;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getThermodynamicList());
		}
		return jScrollPane1;
	}

	// Thermodynamic properties list
	private JList getThermodynamicList() {
		if (ThermodynamicList == null) {
			ThermodynamicList = new JList();
			// DefaultListModel listModel = new DefaultListModel();
			ThermodynamicList.setModel(PropertyList);
			ThermodynamicList.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						PasteButtonMouseMouseClicked(e);
					}

				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});

			ThermodynamicList
					.addListSelectionListener(new ListSelectionListener() {

						public void valueChanged(ListSelectionEvent event) {
							ThermodynamicListListSelectionValueChanged(event);

						}
					});
		}
		return ThermodynamicList;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getSubstanceList());
		}
		return jScrollPane0;
	}

	// Substance list
	private JList getSubstanceList() {
		if (SubstanceList == null) {
			SubstanceList = new JList();
			// DefaultListModel listModel = new DefaultListModel();
			for (String m : Materiales.getMaterials())
				Substances.addElement(m);
			SubstanceList.setModel(Substances);
			SubstanceList.addListSelectionListener(new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent event) {
					SubstanceListListSelectionValueChanged(event);

				}
			});
		}
		return SubstanceList;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getSubstanceLabel(), new Constraints(new Leading(27, 6,
					6), new Leading(26, 10, 10)));
			jPanel2.add(getPropertyLabel(), new Constraints(new Leading(27, 6,
					6), new Leading(66, 10, 10)));
			jPanel2.add(getFormulaLabel(), new Constraints(
					new Leading(27, 6, 6), new Leading(106, 10, 10)));
			jPanel2.add(getVariableLabel(), new Constraints(new Leading(27, 6,
					6), new Leading(146, 10, 10)));
			jPanel2.add(getInformationLabel2(), new Constraints(new Leading(27,
					6, 6), new Leading(210, 6, 6)));
			jPanel2.add(getJScrollPane2(), new Constraints(new Leading(27, 477,
					10, 10), new Leading(237, 104, 10, 10)));
			jPanel2.add(getAddButton(), new Constraints(new Leading(27, 6, 6),
					new Leading(353, 6, 6)));
			jPanel2.add(getSubstanceField(), new Constraints(new Leading(140,
					327, 6, 6), new Leading(22, 6, 6)));
			jPanel2.add(getPropertiesField(), new Constraints(new Leading(140,
					327, 6, 6), new Leading(62, 6, 6)));
			jPanel2.add(getFormulaField(), new Constraints(new Leading(140,
					327, 6, 6), new Leading(102, 6, 6)));
			jPanel2.add(getVariablesField(), new Constraints(new Leading(140,
					327, 6, 6), new Leading(142, 10, 10)));
		}
		return jPanel2;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getPasteButton(), new Constraints(new Leading(12, 12,
					12), new Trailing(12, 12, 12)));
			jPanel1.add(getSeeFormulaButton(), new Constraints(new Leading(120,
					12, 12), new Trailing(12, 12, 12)));
			jPanel1.add(getJScrollPane3(), new Constraints(new Bilateral(11,
					12, 25), new Trailing(276, 67, 10, 10)));
			jPanel1.add(getInformationLabel(), new Constraints(new Leading(16,
					6, 6), new Trailing(355, 6, 6)));
			jPanel1.add(getJScrollPane0(), new Constraints(new Leading(12, 201,
					10, 10), new Trailing(56, 184, 10, 10)));
			jPanel1.add(getJScrollPane1(), new Constraints(new Bilateral(271,
					12, 25), new Trailing(57, 182, 6, 6)));
			jPanel1.add(getMaterialLabel(), new Constraints(new Leading(12, 6,
					6), new Trailing(250, 6, 6)));
			jPanel1.add(getPropertyLabel1(), new Constraints(new Leading(271,
					6, 6), new Trailing(250, 6, 6)));
			jPanel1.add(getForwardIcon(), new Constraints(new Leading(224, 43,
					280), new Leading(190, 10, 10)));
			jPanel1.add(getBackwardIcon(), new Constraints(new Leading(224, 43,
					280), new Leading(262, 10, 10)));
			jPanel1.add(getRemoveButton(), new Constraints(new Trailing(12, 79,
					79), new Trailing(13, 6, 6)));
		}
		return jPanel1;
	}

	// Add substance to the textArea button
	/**
	 * Copy the selected property to the equation Area.
	 */
	private JButton getPasteButton() {
		if (PasteButton == null) {
			PasteButton = new JButton();
			PasteButton.setText(Translation.Language.get(2));
			PasteButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/list-add.png"));
			PasteButton.setEnabled(false);
			PasteButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					PasteButtonMouseMouseClicked(event);
				}

			});
		}
		return PasteButton;
	}

	// See formula
	private JButton getSeeFormulaButton() {
		if (SeeFormulaButton == null) {
			SeeFormulaButton = new JButton();
			SeeFormulaButton.setText("Formula");
			SeeFormulaButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/edit-find.png"));
			SeeFormulaButton.setEnabled(false);
			SeeFormulaButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					String Material = SubstanceList.getSelectedValue()
							.toString();
					String Property = ThermodynamicList.getSelectedValue()
							.toString();
					String text = "/*Error*/";
					for (MaterialList m : Materiales.Materials)
						if (m.getMaterial().equalsIgnoreCase(Material)) {
							m.getProperties();
							for (MaterialStore ms : m.getPropertyList())
								if (ms.getProperty().equalsIgnoreCase(Property)) {
									text = ms.getFormula();
									break;
								}
							break;

						}
					// Paste the formula in the equation area
					Principal.TextArea.TextArea.insert(Config.JumpLine + "/**"
							+ Material + "." + Property + "*/"
							+ Config.JumpLine + text + Config.JumpLine,
							Principal.TextArea.TextArea.getCaretPosition());
				}
			});
		}
		return SeeFormulaButton;
	}

	// Close button
	private JButton getCloseButton() {
		if (CloseButton == null) {
			CloseButton = new JButton();
			CloseButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/window-close.png"));
			CloseButton.setText(Translation.Language.get(17));
			CloseButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					CloseButtonMouseMouseClicked();
				}

			});
		}
		return CloseButton;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getCloseButton(), new Constraints(new Trailing(12, 12,
					12), new Leading(12, 12, 12)));
		}
		return jPanel0;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab(Translation.Language.get(360), getJPanel1());
			jTabbedPane0.addTab(Translation.Language.get(13), getJPanel2());
		}
		return jTabbedPane0;
	}

	@SuppressWarnings("unused")
	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Creates a windows with to work with thermodynamic properties
	 */
	public static void Material() {
		// installLnF();

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final MaterialGUI dialog = new MaterialGUI(Principal.frame);
				dialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				dialog.setTitle(Translation.Language.get(361));
				dialog.setIconImage(SaveLoad.Icon);
				Principal.frame.setEnabled(false);
				// dialog.setAlwaysOnTop(true);
				dialog.setModalityType(ModalityType.MODELESS);
				dialog.setResizable(false);
				dialog.setLocationRelativeTo(null);
				dialog.getContentPane().setPreferredSize(dialog.getSize());
				dialog.pack();
				dialog.setVisible(true);
				dialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						dialog.CloseButtonMouseMouseClicked();

					}
				});

			}
		});
	}

	// Close button
	private void CloseButtonMouseMouseClicked() {
		Principal.frame.setEnabled(true);
		Materiales.clear();
		dispose();
	}

	// Material list
	private void SubstanceListListSelectionValueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (SubstanceList.getSelectedIndex() == -1) {
			} else {
				try {
					// Erase Notes Area
					InformationArea.setText("");

					// Get button, remove button and formula button
					PasteButton.setEnabled(false);
					SeeFormulaButton.setEnabled(false);
					RemoveButton.setEnabled(true);

					LinkedList<String> aux = Materiales
							.getProperties(SubstanceList.getSelectedValue()
									.toString());
					if (!aux.equals(null)) {
						DefaultListModel listModel = new DefaultListModel();

						for (String s : aux)
							listModel.addElement(s);

						ThermodynamicList.setModel(listModel);
					}
					aux.clear();
				} catch (Exception E) {
					E.printStackTrace();
				}

			}
		}

	}

	// PropertyList
	private void ThermodynamicListListSelectionValueChanged(ListSelectionEvent e) {
		try {
			if (e.getValueIsAdjusting() == false)
				if (ThermodynamicList.getSelectedIndex() != -1) {
					// Erase the content of the Area Note
					InformationArea.setText("");
					String Material = SubstanceList.getSelectedValue()
							.toString();
					String Property = ThermodynamicList.getSelectedValue()
							.toString();
					LinkedList<MaterialStore> aux = Materiales
							.getMaterial(Material);
					for (MaterialStore M : aux)
						if (M.getProperty().equalsIgnoreCase(Property)) {
							InformationArea
									.append(Translation.Language.get(362)
											+ ": " + M.getVariables()
											+ Config.JumpLine);
							InformationArea.append(Translation.Language
									.get(357)
									+ M.getNote());
							InformationArea.setCaretPosition(0);
							break;
						}
					// Get button and Remove button
					PasteButton.setEnabled(true);
					RemoveButton.setEnabled(true);
					SeeFormulaButton.setEnabled(true);
				}
		} catch (NullPointerException N) {
			PasteButton.setEnabled(true);
			RemoveButton.setEnabled(true);
		}

	}

	/**
	 * Updates the values of the SubstanceList == MaterialList
	 */
	private void refreshJList() {
		try {
			PropertyList.clear();
			// Refresh SubstanceList == MaterialList
			// DefaultListModel listModel = new DefaultListModel();
			for (String s : Materiales.getMaterials())
				PropertyList.addElement(s);
			// SubstanceList.setModel(PropertyList);
			SubstanceList.setSelectedIndex(0);
			ThermodynamicList.removeAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates both Lists, substances and properties
	 */
	private void RefreshLists() {
		// Refresh the material List
		Materiales.clear();
		Materiales.getTree();

		Substances.clear();
		for (String m : Materiales.getMaterials())
			Substances.addElement(m);
		// SubstanceList.setModel(Substances);
		refreshJList();
	}

	/**
	 * This is the paste button. Adds the information to the equations area
	 * 
	 * @param event
	 */
	private void PasteButtonMouseMouseClicked(MouseEvent event) {
		String Material = SubstanceList.getSelectedValue().toString();
		String Property = ThermodynamicList.getSelectedValue().toString();
		String text = "/*Error*/";
		for (MaterialList m : Materiales.Materials)
			if (m.getMaterial().equalsIgnoreCase(Material)) {
				m.getProperties();
				for (MaterialStore ms : m.getPropertyList())
					if (ms.getProperty().equalsIgnoreCase(Property)) {
						text = "/**" + ms.getNote() + "*/" + Config.JumpLine
								+ Material + "." + Property + "("
								+ ms.getVariables() + ")";
						break;
					}
				break;
			}
		Principal.TextArea.TextArea.insert(text + Config.JumpLine,
				Principal.TextArea.TextArea.getCaretPosition());

	}

	/**
	 * Erase from the input string: spaces, dots, commas, parenthesis,claps,
	 * tabs, and ;
	 * 
	 * @param input
	 * @return
	 */
	private String cleanString(String input) {
		String retorno = new String("");
		char c = CheckString.Espacio;
		for (int i = 0; i < input.length(); i++) {
			c = input.charAt(i);
			if ((c != CheckString.Espacio) & (c != CheckString.Dot)
					& (c != CheckString.Comma) & (c != CheckString.OpenC)
					& (c != CheckString.OpenP) & (c != CheckString.CloseP)
					& (c != CheckString.CloseC) & (c != CheckString.Tab)
					& (c != CheckString.PuntoYcoma))
				retorno += c;
		}
		return retorno;
	}

}
