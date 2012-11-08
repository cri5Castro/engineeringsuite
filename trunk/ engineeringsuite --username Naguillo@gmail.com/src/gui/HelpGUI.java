package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
//This class does no longer works with VisualSwing4Eclipse
/**
 * Creates the help window
 */
public class HelpGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private JScrollPane jScrollPane0;
	private JTree Index;
	private JScrollPane jScrollPane1;
	private JSeparator jSeparator0;
	private OutputTextPane ShowHelpPane;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public HelpGUI() {
		initComponents();
	}

	public HelpGUI(Frame parent) {
		super(parent);
		initComponents();
	}

	public HelpGUI(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public HelpGUI(Frame parent, String title) {
		super(parent, title);
		initComponents();
	}

	public HelpGUI(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public HelpGUI(Frame parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public HelpGUI(Dialog parent) {
		super(parent);
		initComponents();
	}

	public HelpGUI(Dialog parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	public HelpGUI(Dialog parent, String title) {
		super(parent, title);
		initComponents();
	}

	public HelpGUI(Dialog parent, String title, boolean modal) {
		super(parent, title, modal);
		initComponents();
	}

	public HelpGUI(Dialog parent, String title, boolean modal,
			GraphicsConfiguration arg) {
		super(parent, title, modal, arg);
		initComponents();
	}

	public HelpGUI(Window parent) {
		super(parent);
		initComponents();
	}

	public HelpGUI(Window parent, ModalityType modalityType) {
		super(parent, modalityType);
		initComponents();
	}

	public HelpGUI(Window parent, String title) {
		super(parent, title);
		initComponents();
	}

	public HelpGUI(Window parent, String title, ModalityType modalityType) {
		super(parent, title, modalityType);
		initComponents();
	}

	public HelpGUI(Window parent, String title, ModalityType modalityType,
			GraphicsConfiguration arg) {
		super(parent, title, modalityType, arg);
		initComponents();
	}

	private void initComponents() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(new Color(223, 223, 223));
		setForeground(Color.black);
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Bilateral(208, 8, 566),
				new Bilateral(4, 6, 10, 495)));
		add(getJSeparator0(), new Constraints(new Bilateral(192, 583, 7),
				new Bilateral(4, 11, 10, 490)));
		add(getJScrollPane1(), new Constraints(new Leading(8, 178, 591, 591),
				new Bilateral(5, 11, 25)));
		setSize(852, 605);
	}

	private OutputTextPane getShowHelpPane() {
		if (ShowHelpPane == null) {
			ShowHelpPane = new OutputTextPane();
			ShowHelpPane.setBorder(null);
			ShowHelpPane.setEditable(false);
			ShowHelpPane.setText("");
			ShowHelpPane.PrintComplex("engineering Suite\n\n\n", 30, true);
			ShowHelpPane.PrintText(Translation.Language.get(205));
		}
		return ShowHelpPane;
	}

	private JSeparator getJSeparator0() {
		if (jSeparator0 == null) {
			jSeparator0 = new JSeparator();
			jSeparator0.setOrientation(SwingConstants.VERTICAL);
			jSeparator0.setBorder(null);
		}
		return jSeparator0;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getIndex());
		}
		return jScrollPane1;
	}

	private JTree getIndex() {
		if (Index == null) {
			Index = new JTree();
			Index.setBorder(BorderFactory.createBevelBorder(
					BevelBorder.LOWERED, null, null, null, null));
			DefaultTreeModel treeModel = null;
			{
				DefaultMutableTreeNode node0 = new DefaultMutableTreeNode(
						"eSuite");
				{
					DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(
							"Solver");
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								"FAQ");
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(197));// Errors
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								"Log");
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(198));// Results
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(199));// Render
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(200));// Equations
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(37));// Preferences
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(366));// Formulas
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(201));// Examples
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(202));// Algorithms
						node1.add(node2);
					}
					{
						DefaultMutableTreeNode node2 = new DefaultMutableTreeNode(
								Translation.Language.get(203));
						node1.add(node2);
					}
					node0.add(node1);
				}
				{
					DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(
							Translation.Language.get(204));

					node0.add(node1);
				}
				treeModel = new DefaultTreeModel(node0);
			}
			Index.setModel(treeModel);
			Index.addTreeSelectionListener(new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent event) {
					IndexTreeSelectionValueChanged(event);
				}
			});
		}
		return Index;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setBorder(BorderFactory.createTitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font(
							"DejaVu Sans", Font.BOLD, 12),
					new Color(59, 59, 59)));
			jScrollPane0.setViewportView(getShowHelpPane());
		}
		return jScrollPane0;
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
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */
	public static void jHelp() {
		// installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				HelpGUI dialog = new HelpGUI();
				dialog.setDefaultCloseOperation(HelpGUI.DISPOSE_ON_CLOSE);
				dialog.setTitle(Translation.Language.get(28));
				dialog.setIconImage(SaveLoad.Icon);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setResizable(true);
				dialog.setLocationRelativeTo(null);
				dialog.getContentPane().setPreferredSize(dialog.getSize());
				dialog.pack();
				dialog.setVisible(true);
			}
		});
	}

	/**
	 * Writes in the ShowHelpPane the information depending on the selection in
	 * the index.
	 * 
	 * @param Index
	 *            selection
	 */
	private void IndexTreeSelectionValueChanged(TreeSelectionEvent event) {
		// At first erase the content of the panel
		ShowHelpPane.setText("");
		// eSuite
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				"eSuite")) {
			ShowHelpPane.PrintComplex("engineering Suite\n\n\n", 30, true);
			ShowHelpPane.PrintText(Translation.Language.get(205));
		}
		// Solver
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				"Solver")) {
			ShowHelpPane.PrintComplex("eSuite Solver\n\n\n", 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(206));
			ShowHelpPane.printEnumeration("1- ", Translation.Language.get(207));
			ShowHelpPane.printEnumeration("2- ", Translation.Language.get(208));
			ShowHelpPane.printEnumeration("3- ", Translation.Language.get(209));
			ShowHelpPane.printEnumeration("4- ", Translation.Language.get(210));
			ShowHelpPane.printEnumeration("5- ", Translation.Language.get(211));
			ShowHelpPane.printEnumeration("6- ", Translation.Language.get(212));
			ShowHelpPane.printEnumeration("7- ", Translation.Language.get(213));
			ShowHelpPane.printEnumeration("8- ", Translation.Language.get(214));
			ShowHelpPane.printEnumeration("9- ", Translation.Language.get(215));
		}
		// FAQ
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				"FAQ")) {
			ShowHelpPane.PrintComplex("Frequently Asked Questions\n\n\n", 24,
					true);
			ShowHelpPane.PrintComplex(Translation.Language.get(216), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(217));
			ShowHelpPane.PrintComplex(Translation.Language.get(218), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(219));
			ShowHelpPane.PrintComplex(Translation.Language.get(220), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(221));
			ShowHelpPane.PrintComplex(Translation.Language.get(222), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(223));
			ShowHelpPane.PrintComplex(Translation.Language.get(224), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(225));
			ShowHelpPane.PrintComplex(Translation.Language.get(226), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(227));
			ShowHelpPane.PrintComplex(Translation.Language.get(228), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(229));
			ShowHelpPane.PrintComplex(Translation.Language.get(230), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(231));

		}
		// Errors
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(197))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(232), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(233));
			ShowHelpPane.printEnumeration("1- ", Translation.Language.get(234));
			ShowHelpPane.printEnumeration("2- ", Translation.Language.get(235));
			ShowHelpPane.printEnumeration("3- ", Translation.Language.get(236));
			ShowHelpPane.printEnumeration("4- ", Translation.Language.get(237));
			ShowHelpPane.printEnumeration("5- ", Translation.Language.get(238));
			ShowHelpPane.printEnumeration("6- ", Translation.Language.get(239));
			ShowHelpPane.printEnumeration("7- ", Translation.Language.get(240));
			ShowHelpPane.printEnumeration("8- ", Translation.Language.get(241));
			ShowHelpPane.printEnumeration("9- ", Translation.Language.get(242));
			ShowHelpPane.printEnumeration("10-", Translation.Language.get(243));
			ShowHelpPane.printEnumeration("11-", Translation.Language.get(244));
			ShowHelpPane.printEnumeration("12-", Translation.Language.get(245));
			ShowHelpPane.printEnumeration("13-", Translation.Language.get(246));
			ShowHelpPane.printEnumeration("14-", Translation.Language.get(247));
			ShowHelpPane.printEnumeration("15-", Translation.Language.get(374));
			ShowHelpPane.printEnumeration("16-", Translation.Language.get(384));
			ShowHelpPane.printEnumeration("17-", Translation.Language.get(248));
		}
		// Log
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				"Log")) {
			ShowHelpPane.PrintComplex(Translation.Language.get(260), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(249));
			ShowHelpPane.PrintText(Translation.Language.get(250));
			ShowHelpPane.PrintText(Translation.Language.get(251));
			ShowHelpPane.printEnumeration("1- ", Translation.Language.get(252));
			ShowHelpPane.printEnumeration("2- ", Translation.Language.get(253));
			ShowHelpPane.printEnumeration("3- ", Translation.Language.get(254));
		}
		// Results
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(198))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(255), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(256));
			ShowHelpPane.printEnumeration(Translation.Language.get(257),
					Translation.Language.get(261));
			ShowHelpPane.printEnumeration(Translation.Language.get(258),
					Translation.Language.get(262));
			ShowHelpPane.printEnumeration(Translation.Language.get(259),
					Translation.Language.get(263));
		}
		// Render equations
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(199))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(264), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(265));
			ShowHelpPane.PrintText(Translation.Language.get(266));
			ShowHelpPane.PrintText(Translation.Language.get(267));
		}
		// Equations
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(200))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(268), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(269));
			ShowHelpPane.printEnumeration("1- ", Translation.Language.get(270));
			ShowHelpPane.printEnumeration("2- ", Translation.Language.get(271));
			ShowHelpPane.printEnumeration("3- ", Translation.Language.get(272));
			ShowHelpPane.printEnumeration("4- ", Translation.Language.get(273));
			ShowHelpPane.printEnumeration("5- ", Translation.Language.get(274));
			ShowHelpPane.printEnumeration("6- ", Translation.Language.get(275));
			ShowHelpPane.printEnumeration("7- ", Translation.Language.get(276));
			ShowHelpPane.printEnumeration("8- ", Translation.Language.get(277));
		}
		// Preferences
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(37))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(37) + "\n\n\n",
					24, true);
			ShowHelpPane.PrintText(Translation.Language.get(278));
			ShowHelpPane.PrintComplex(Translation.Language.get(279), 14, true);
			ShowHelpPane.printEnumeration("    1- ", Translation.Language
					.get(280));
			ShowHelpPane.printEnumeration("    2- ", Translation.Language
					.get(281));
			ShowHelpPane.printEnumeration("    3- ", Translation.Language
					.get(282));
			ShowHelpPane.printEnumeration("    4- ", Translation.Language
					.get(283));
			ShowHelpPane.PrintComplex(Translation.Language.get(284), 14, true);
			ShowHelpPane.printEnumeration("    1- ", Translation.Language
					.get(285));
			ShowHelpPane.printEnumeration("    2- ", Translation.Language
					.get(286));
			ShowHelpPane.printEnumeration("    3- ", Translation.Language
					.get(287));
			ShowHelpPane.printEnumeration("    4- ", Translation.Language
					.get(288));
			ShowHelpPane.printEnumeration("    5- ", Translation.Language
					.get(289));
			ShowHelpPane.printEnumeration("    6- ", Translation.Language
					.get(290));
			ShowHelpPane.printEnumeration("    7- ", Translation.Language
					.get(291));
			ShowHelpPane.printEnumeration("    8- ", Translation.Language
					.get(292));
			ShowHelpPane.PrintComplex(Translation.Language.get(293), 14, true);
			ShowHelpPane.printEnumeration("    1- ", Translation.Language
					.get(294));
			ShowHelpPane.printEnumeration("    2- ", Translation.Language
					.get(295));
		}
		// Thermodynamic formulas
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(366))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(366) + "\n\n\n",
					24, true);
			ShowHelpPane.PrintText(Translation.Language.get(367)
					+ Config.JumpLine + Config.JumpLine);
			ShowHelpPane.PrintComplex(Translation.Language.get(368)
					+ Config.JumpLine, 14, true);
			ShowHelpPane.printEnumeration("    1-", Translation.Language
					.get(369)
					+ Config.JumpLine + Config.JumpLine);
			ShowHelpPane.printEnumeration("    2- ", Translation.Language
					.get(370)
					+ Config.JumpLine + Config.JumpLine);
			ShowHelpPane.printEnumeration("    3- ", Translation.Language
					.get(371)
					+ Config.JumpLine + Config.JumpLine);
			ShowHelpPane.printEnumeration("    4- ", Translation.Language
					.get(372)
					+ Config.JumpLine + Config.JumpLine);
			ShowHelpPane.printEnumeration("    5- ", Translation.Language
					.get(373)
					+ Config.JumpLine + Config.JumpLine);
			ShowHelpPane.printEnumeration("    6- ", Translation.Language
					.get(377)
					+ Config.JumpLine + Config.JumpLine);
		}
		// Initial Values
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(201))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(296), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(297));
			ShowHelpPane.PrintText(Translation.Language.get(298));
			ShowHelpPane.PrintComplex(Translation.Language.get(299), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(300));
			ShowHelpPane.PrintComplex(Translation.Language.get(301), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(302));
			ShowHelpPane.PrintComplex(Translation.Language.get(303), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(304));
		}
		// Examples
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(202))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(305), 24, true);
			ShowHelpPane.PrintText(Translation.Language.get(306));
			ShowHelpPane.printEnumeration(Translation.Language.get(307),
					Translation.Language.get(308));
			ShowHelpPane.PrintComplex(Translation.Language.get(309), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(310));
			ShowHelpPane.PrintComplex(Translation.Language.get(311), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(312));
			ShowHelpPane.PrintComplex(Translation.Language.get(313), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(314));
			ShowHelpPane.PrintComplex(Translation.Language.get(315), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(316));
			ShowHelpPane.PrintComplex(Translation.Language.get(317), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(318));
		}
		// Algorithms
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(203))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(319), 24, true);
			ShowHelpPane.PrintComplex(Translation.Language.get(320), 18, true);
			ShowHelpPane.PrintComplex(Translation.Language.get(321), 18, true);
			ShowHelpPane.PrintText(Translation.Language.get(322));
			ShowHelpPane.PrintText(Translation.Language.get(323));
			ShowHelpPane.PrintText(Translation.Language.get(324));
			ShowHelpPane.PrintComplex(Translation.Language.get(325), 14, true);
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/1Sinordenar.jpg"), true);
			ShowHelpPane.PrintComplex(Translation.Language.get(326), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(327));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/2Ordenado.jpg"), true);
			ShowHelpPane.PrintComplex(Translation.Language.get(328), 14, true);
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/3Sistema1.jpg"), true);
			ShowHelpPane.PrintComplex(Translation.Language.get(329), 14, true);
			ShowHelpPane.PrintText(Translation.Language.get(330));
			ShowHelpPane
					.addImage(Toolkit.getDefaultToolkit().getImage(
							Config.AbsolutePath
									+ "Imagenes/4VariableSuelta.jpg"), true);
			ShowHelpPane.PrintComplex(Translation.Language.get(331), 14, true);
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/5Sistema2.jpg"), true);
			ShowHelpPane.PrintText(Translation.Language.get(332));
			ShowHelpPane.PrintComplex(Translation.Language.get(333), 18, true);
			ShowHelpPane.PrintText(Translation.Language.get(334));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/function.jpg"), true);
			ShowHelpPane.PrintText(Translation.Language.get(335));
			ShowHelpPane.PrintText(Translation.Language.get(336));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image1.jpg"), true);
			ShowHelpPane.printEnumeration("\n 2.1) ", Translation.Language
					.get(337));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image2.jpg"), true);
			ShowHelpPane.printEnumeration("\n 2.2) ", Translation.Language
					.get(338));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image3.jpg"), true);
			ShowHelpPane.printEnumeration("\n 2.3) ", Translation.Language
					.get(339));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image4.jpg"), true);
			ShowHelpPane.printEnumeration("\n 2.4) ", Translation.Language
					.get(340));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image5.jpg"), true);
			ShowHelpPane.printEnumeration("\n 2.5) ", Translation.Language
					.get(341));
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image6.jpg"), true);
			ShowHelpPane.addImage(Toolkit.getDefaultToolkit().getImage(
					Config.AbsolutePath + "Imagenes/Image7.jpg"), true);

		}
		// Mathematics
		if (event.getPath().getLastPathComponent().toString().equalsIgnoreCase(
				Translation.Language.get(204))) {
			ShowHelpPane.PrintComplex(Translation.Language.get(342), 24, true);
			ShowHelpPane.PrintComplex(Translation.Language.get(343), 14, true);
			ShowHelpPane.printEnumeration("1- ", Translation.Language.get(344));
			ShowHelpPane.printEnumeration("2- ", Translation.Language.get(345));
			ShowHelpPane.printEnumeration("3- ", Translation.Language.get(346));
			ShowHelpPane.printEnumeration("4- ", Translation.Language.get(347));
			ShowHelpPane.printEnumeration("5- ", Translation.Language.get(348));

		}

		ShowHelpPane.setCaretPosition(0);
	}

}
