package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import String2ME.CheckString;
import String2ME.InitVal;

//VS4E -- DO NOT REMOVE THIS LINE!
public class InitialValuesGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel0;
	private JLabel VariableLabel;
	private JLabel ValueLabel;
	// private Java2sAutoTextField VariableField;
	private eTextField VariableField;
	private eTextField ValueField;
	private JButton CloseButton;
	private JButton RemoveAllButton;
	private JList Lista;
	private JScrollPane jScrollPane0;
	private JButton AddButton;
	private JButton RemoveButton;
	private JPanel Panel;
	private JLabel InformationLabel1;
	private JCheckBox RememberValuesBox;
	private DefaultListModel listModel = new DefaultListModel();
	private JLabel InformationLabel3;
	private JLabel InformationLabel2;
	private eTextField InitialValueField;
	private JLabel InitialValueLabel;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public InitialValuesGUI() {
		initComponents();
	}

	public InitialValuesGUI(Frame parent) {
		super(parent);
		initComponents();
	}

	public InitialValuesGUI(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public InitialValuesGUI(Frame parent, String title) {
		super(parent, title);
		initComponents();
	}

	public InitialValuesGUI(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public InitialValuesGUI(Frame parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public InitialValuesGUI(Dialog parent) {
		super(parent);
		initComponents();
	}

	public InitialValuesGUI(Dialog parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public InitialValuesGUI(Dialog parent, String title) {
		super(parent, title);
		initComponents();
	}

	public InitialValuesGUI(Dialog parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public InitialValuesGUI(Dialog parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public InitialValuesGUI(Window parent) {
		super(parent);
		initComponents();
	}

	public InitialValuesGUI(Window parent, ModalityType modalityType) {
		super(parent, modalityType);
		initComponents();
	}

	public InitialValuesGUI(Window parent, String title) {
		super(parent, title);
		initComponents();
	}

	public InitialValuesGUI(Window parent, String title,
			ModalityType modalityType) {
		super(parent, title, modalityType);
		initComponents();
	}

	public InitialValuesGUI(Window parent, String title,
			ModalityType modalityType, GraphicsConfiguration arg) {
		super(parent, title, modalityType, arg);
		initComponents();
	}

	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Bilateral(8, 6, 0),
				new Bilateral(8, 12, 10, 480)));
		setSize(540, 500);
	}

	private JLabel getInitialValueLabel() {
		if (InitialValueLabel == null) {
			InitialValueLabel = new JLabel();
			InitialValueLabel.setFont(Principal.TimesBold);
			InitialValueLabel.setText(Translation.Language.get(6));
		}
		return InitialValueLabel;
	}

	private JTextField getInitialValueField() {
		if (InitialValueField == null) {
			InitialValueField = new eTextField(Double
					.toString(Config.DefaultInitialValue));
			InitialValueField.setColumns(7);
			InitialValueField.setToolTipText(Translation.Language.get(7));
			InitialValueField.addFocusListener(new FocusAdapter() {

				public void focusLost(FocusEvent event) {
					InitialValueFieldFocusFocusLost(event);
				}
			});
		}
		return InitialValueField;
	}

	private JLabel getInformationLabel2() {
		if (InformationLabel2 == null) {
			InformationLabel2 = new JLabel();
			InformationLabel2.setText(Translation.Language.get(8));
		}
		return InformationLabel2;
	}

	private JLabel getInformationLabel3() {
		if (InformationLabel3 == null) {
			InformationLabel3 = new JLabel();
			InformationLabel3.setText(Translation.Language.get(9));
		}
		return InformationLabel3;
	}

	private JCheckBox getRememberValuesBox() {
		if (RememberValuesBox == null) {
			RememberValuesBox = new JCheckBox();
			RememberValuesBox.setText(Translation.Language.get(10));
			RememberValuesBox.setSelected(Config.RemeberLastValues);
			RememberValuesBox.setFocusable(false);
			RememberValuesBox.addChangeListener(new ChangeListener() {

				public void stateChanged(ChangeEvent event) {
					RememberValuesBoxChangeStateChanged(event);
				}
			});
		}
		return RememberValuesBox;
	}

	private JLabel getInformationLabel1() {
		if (InformationLabel1 == null) {
			InformationLabel1 = new JLabel();
			InformationLabel1.setText(Translation.Language.get(11));
		}
		return InformationLabel1;
	}

	private JPanel getPanel() {
		if (Panel == null) {
			Panel = new JPanel();
			// Panel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,
			// Color.black));
			Panel.setBorder(BorderFactory.createEtchedBorder());
			Panel.setLayout(new GroupLayout());
			Panel.add(getInformationLabel1(), new Constraints(new Leading(4,
					156, 10, 10), new Leading(2, 19, 10, 10)));
			Panel.add(getInformationLabel3(), new Constraints(new Leading(4, 6,
					6), new Trailing(30, 53, 53)));
			Panel.add(getInformationLabel2(), new Constraints(new Leading(4, 6,
					6), new Trailing(56, 28, 33)));
			Panel.add(getRememberValuesBox(), new Constraints(new Leading(32,
					6, 6), new Trailing(6, 28, 33)));
		}
		return Panel;
	}

	private JButton getRemoveButton() {
		if (RemoveButton == null) {
			RemoveButton = new JButton();
			RemoveButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/list-remove.png"));
			RemoveButton.setText(Translation.Language.get(12));
			RemoveButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					RemoveButtonMouseMouseClicked(event);
				}
			});
		}
		return RemoveButton;
	}

	private JButton getAddButton() {
		if (AddButton == null) {
			AddButton = new JButton();
			AddButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/list-add.png"));
			AddButton.setText(Translation.Language.get(13));
			AddButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					AddButtonMouseMouseClicked();
				}
			});
		}
		return AddButton;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getLista());
		}
		return jScrollPane0;
	}

	private JList getLista() {
		if (Lista == null) {
			Lista = new JList();
			Lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			refreshList();
			Lista.setModel(listModel);
			Lista.addListSelectionListener(new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent event) {
					ListaListSelectionValueChanged(event);
				}
			});
		}
		return Lista;
	}

	private JButton getRemoveAllButton() {
		if (RemoveAllButton == null) {
			RemoveAllButton = new JButton(Translation.Language.get(14),
					new ImageIcon(Config.AbsolutePath + "icons/user-trash.png"));
			RemoveAllButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					RemoveAllButtonMouseMouseClicked(event);
				}

				private void RemoveAllButtonMouseMouseClicked(MouseEvent event) {
					int n = JOptionPane.showOptionDialog(null,
							Translation.Language.get(15), Translation.Language
									.get(16), JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, new ImageIcon(
									Config.AbsolutePath
											+ "icons/help-browser.png"), null,
							null);
					if (n == 0) {
						Config.InitValue.clear();
						refreshList();
					} else {/* Do nothing */
					}
				}
			});

		}
		return RemoveAllButton;
	}

	private JButton getCloseButton() {
		if (CloseButton == null) {
			CloseButton = new JButton(Translation.Language.get(17),
					new ImageIcon(Config.AbsolutePath
							+ "icons/window-close.png"));
			CloseButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					CloseButtonMouseMouseClicked();
				}
			});
		}
		return CloseButton;
	}

	private eTextField getValueField() {
		if (ValueField == null) {
			ValueField = new eTextField();
			ValueField.setColumns(7);
			ValueField.addKeyListener(new KeyAdapter() {

				public void keyPressed(KeyEvent event) {
					ValueFieldKeyKeyPressed(event);
				}
			});
		}
		return ValueField;
	}

	private eTextField getVariableField() {

		if (VariableField == null) {
			VariableField = new eTextField();
			VariableField.setColumns(7);
			AutoCompleteDecorator.decorate(VariableField,
					CheckString.CaseVariables, false);

			VariableField.addKeyListener(new KeyAdapter() {

				public void keyPressed(KeyEvent event) {
					VariableFieldKeyKeyPressed(event);
				}
			});
		}
		return VariableField;
	}

	private JLabel getValueLabel() {
		if (ValueLabel == null) {
			ValueLabel = new JLabel();
			ValueLabel.setFont(Principal.TimesBold);
			ValueLabel.setText(Translation.Language.get(18));
		}
		return ValueLabel;
	}

	private JLabel getVariableLabel() {
		if (VariableLabel == null) {
			VariableLabel = new JLabel();
			VariableLabel.setFont(Principal.TimesBold);
			VariableLabel.setText(Translation.Language.get(19));
		}
		return VariableLabel;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font(
							"DejaVu Sans", Font.BOLD, 12),
					new Color(59, 59, 59)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getValueField(), new Constraints(new Leading(124, 177,
					6, 6), new Leading(71, 6, 6)));
			jPanel0.add(getVariableField(), new Constraints(new Leading(124,
					177, 6, 6), new Leading(38, 6, 6)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Leading(25, 444,
					10, 10), new Leading(156, 238, 6, 6)));
			jPanel0.add(getRemoveAllButton(), new Constraints(new Leading(25,
					6, 6), new Leading(406, 6, 6)));
			jPanel0.add(getCloseButton(), new Constraints(
					new Leading(380, 6, 6), new Leading(406, 6, 6)));
			jPanel0.add(getAddButton(), new Constraints(new Leading(97, 6, 6),
					new Leading(113, 6, 6)));
			jPanel0.add(getPanel(), new Constraints(
					new Leading(321, 175, 6, 6), new Leading(21, 100, 10, 10)));
			jPanel0.add(getRemoveButton(), new Constraints(new Leading(210, 6,
					6), new Leading(113, 6, 6)));
			jPanel0.add(getVariableLabel(), new Constraints(new Leading(6, 104,
					6, 6), new Leading(38, 25, 6, 6)));
			jPanel0.add(getValueLabel(), new Constraints(new Leading(6, 100, 6,
					6), new Leading(73, 22, 6, 6)));
			jPanel0.add(getInitialValueField(), new Constraints(new Leading(
					200, 100, 6, 6), new Leading(0, 10, 10)));
			jPanel0.add(getInitialValueLabel(), new Constraints(new Leading(6,
					186, 10, 10), new Leading(0, 20, 6, 6)));
		}
		return jPanel0;
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
	 * Creates a windows to work with the initial values
	 */
	public static void jValues() {
		// installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final InitialValuesGUI dialog = new InitialValuesGUI(
						Principal.frame);
				dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				dialog.setTitle(Translation.Language.get(20));
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

	// Add Button
	private void AddButtonMouseMouseClicked() {
		try {
			String aux = VariableField.getText();
			aux = aux.replace(" ", "");// Erase spaces
			aux = aux.replace("=", "");// Equal sign is not allowed
			String s = ValueField.getText();
			s = s.replace(",", ".");
			if (aux.length() < 1)
				SolverGUI.PopUpWarning(Translation.Language.get(21));
			else {
				boolean found = false;
				for (int j = 0; j < Config.InitValue.size(); j++) {
					if (aux.equalsIgnoreCase(Config.InitValue.get(j)
							.getVariable())) {
						// If the variable has already a initial value, then the
						// user will be asked to
						// know if he is sure to change that value
						int n = JOptionPane.showOptionDialog(null,
								Translation.Language.get(22) + Config.JumpLine
										+ "<" + aux + ">. "
										+ Translation.Language.get(23),
								Translation.Language.get(24),
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, new ImageIcon(
										Config.AbsolutePath
												+ "icons/help-browser.png"),
								null, null);
						if (n == 0) {
							Config.InitValue.get(j).setValue(
									Double.parseDouble(s));
						} else {/* Do nothing */
						}

						found = true;
						j = Config.InitValue.size();
					}
				}
				if (!found)
					Config.InitValue
							.add(new InitVal(Double.parseDouble(s), aux));

				VariableField.requestFocus();
				refreshList();
			}
		} catch (Exception e) {
			ValueField.setText("");
			SolverGUI.PopUpWarning(Translation.Language.get(25));

		}

	}

	// Remove Button
	private void RemoveButtonMouseMouseClicked(MouseEvent event) {
		String aux = VariableField.getText();
		boolean erased = false;
		aux = aux.replace(" ", "");// Erase spaces
		for (int i = 0; i < Config.InitValue.size(); i++) {
			if (Config.InitValue.get(i).getVariable().equalsIgnoreCase(aux)) {
				erased = true;
				Config.InitValue.remove(i);
				i = Config.InitValue.size();
			}
		}

		if (!erased)
			SolverGUI.PopUpWarning(Translation.Language.get(26));
		else
			refreshList();
	}

	// Close Button
	private void CloseButtonMouseMouseClicked() {
		Principal.frame.setEnabled(true);
		// Save the initial value to config
		Config C = new Config();
		C.SaveConfig();
		// clear stored variables
		CheckString.PurgeAll();
		// Call garbage collector
		System.gc();

		dispose();
	}

	private void refreshList() {
		VariableField.setText("");
		ValueField.setText("");
		listModel.clear();
		for (int i = 0; i < Config.InitValue.size(); i++) {
			listModel.addElement(Config.InitValue.get(i).getVariable() + " = "
					+ Double.toString(Config.InitValue.get(i).getValue()));
		}
	}

	private void ListaListSelectionValueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (Lista.getSelectedIndex() == -1) {
			} else {
				try {
					String aux = (String) Lista.getSelectedValue();
					aux = aux.replaceAll(" ", "");
					int i = aux.indexOf((char) 61);// (char) 61 = equal
					VariableField.setText(aux.substring(0, i));
					ValueField.setText(aux.substring(i + 1, aux.length()));
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		}

	}

	private void VariableFieldKeyKeyPressed(KeyEvent event) {
		int n = event.getKeyCode();
		if (n == KeyEvent.VK_ENTER)
			AddButtonMouseMouseClicked();
	}

	private void ValueFieldKeyKeyPressed(KeyEvent event) {
		int n = event.getKeyCode();
		if (n == KeyEvent.VK_ENTER)
			AddButtonMouseMouseClicked();
	}

	private void RememberValuesBoxChangeStateChanged(ChangeEvent event) {
		Config.RemeberLastValues = RememberValuesBox.isSelected();
	}

	private void InitialValueFieldFocusFocusLost(FocusEvent event) {
		try {
			String s = InitialValueField.getText();
			s = s.replace(",", ".");
			Config.DefaultInitialValue = Double.parseDouble(s);
		} catch (Exception e) {
			InitialValueField.setText(Double
					.toString(Config.DefaultInitialValue));
			SolverGUI.PopUpError(Translation.Language.get(25));

		}
	}

}
