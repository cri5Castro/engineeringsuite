package gui;

import evaluation.DiffAndEvaluator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
//NO LONGER WORKS WITH VS4E
/**
 * Main Class
 */
public class Principal extends JFrame {

	public static final String VERSION = new String("1.02");

	/**
	 * The actual file to save
	 */
	public static String SaveFile = new String("NoFileSelected");

	// FONTS DEFINITIONS
	public static final Font Mono = new Font(Font.MONOSPACED, Font.PLAIN, 14);
	public static final Font MonoBold = new Font(Font.MONOSPACED, Font.BOLD, 14);
	public static final Font Times = new Font(Font.SERIF, Font.PLAIN, 14);
	public static final Font TimesBold = new Font(Font.SERIF, Font.BOLD, 14);
	public static final Font Sans = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	public static final Font SansBold = new Font(Font.SANS_SERIF, Font.BOLD, 13);

	private static final long serialVersionUID = 1L;

	public static JTabbedPane SolverTabbedPane;
	private JToolBar RenderToolBar;
	public static JTabbedPane eSuiteTabbedPane;
	private JButton RefreshButton;
	public static OutputTextPane Rendered;
	private JPanel jPanel2;
	private JScrollPane jScrollPane3;
	public static JFrame frame;
	public static SyntaxPane TextArea;
	public static SyntaxPane ResultArea;
	public static SyntaxPane LogArea;
	public static MathPane mathPane;
	public static MainMenu mainmenu;

	public Principal() {
		initComponents();

	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(geteSuiteTabbedPane(), new Constraints(new Bilateral(0, 0, 97),
				new Bilateral(0, 0, 97)));

		setJMenuBar(getMainMenu());
		setSize(950, 700);

	}

	private JMenuBar getMainMenu() {
		mainmenu = new MainMenu();
		mainmenu.getJMenuBar0();
		mainmenu.jEdit.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent event) {
				mainmenuMouseMousePressed(event);
			}
		});
		mainmenu.jFile.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent event) {
				mainmenuMouseMousePressed(event);
			}
		});
		mainmenu.jHelp.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent event) {
				mainmenuMouseMousePressed(event);
			}
		});

		return mainmenu.jMenuBar0;
	}

	private void mainmenuMouseMousePressed(MouseEvent event) {
		boolean paste = Toolkit.getDefaultToolkit().getSystemClipboard()
				.getContents(null).isDataFlavorSupported(
						DataFlavor.stringFlavor);
		boolean CutCopy = true;

		switch (SolverGUI.windowFocused()) {
		case 1:
			CutCopy = Principal.TextArea.TextArea.getSelectedText() != null;
			SolverGUI.setMenustatus(true, true, CutCopy, CutCopy, paste);
			break;
		case 3:
			CutCopy = Principal.LogArea.TextArea.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, false, CutCopy, false);
			break;
		case 4:
			CutCopy = Principal.ResultArea.TextArea.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, false, CutCopy, false);
			break;
		case 5:
			CutCopy = Principal.mathPane.jCommandInput.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, CutCopy, CutCopy, paste);
			break;
		case 6:
			CutCopy = Principal.mathPane.Consola.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, false, CutCopy, false);
			break;
		case 7:
			CutCopy = Principal.TextArea.jSearch.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, CutCopy, CutCopy, paste);
			break;
		case 8:
			CutCopy = Principal.LogArea.jSearch.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, CutCopy, CutCopy, paste);
			break;
		case 9:
			CutCopy = Principal.ResultArea.jSearch.getSelectedText() != null;
			SolverGUI.setMenustatus(false, false, CutCopy, CutCopy, paste);
			break;
		default:
			SolverGUI.setMenustatus(false, false, false, false, false);
		}

	}

	private JToolBar getRenderToolBar() {
		if (RenderToolBar == null) {
			RenderToolBar = new JToolBar();
			RenderToolBar.setFloatable(false);
			RenderToolBar.setPreferredSize(new Dimension(200, 35));
			RenderToolBar.setOpaque(false);
			RenderToolBar.addSeparator();
			RenderToolBar.add(getRefreshButton());

		}
		return RenderToolBar;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createTitledBorder(null, "",
					TitledBorder.LEADING, TitledBorder.ABOVE_TOP, new Font(
							"Serif", Font.PLAIN, 14), new Color(59, 59, 59)));
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getRenderToolBar(), new Constraints(
					new Leading(5, 0, 0), new Leading(0, 0, 0)));
			jPanel2.add(getJScrollPane3(), new Constraints(new Bilateral(0, 0,
					0), new Bilateral(34, 0, 0)));
		}
		return jPanel2;
	}

	private JTabbedPane getSolverTabbedPane() {
		if (SolverTabbedPane == null) {

			ResultArea = new SyntaxPane();
			TextArea = new SyntaxPane(ResultArea);
			LogArea = new SyntaxPane();

			SolverTabbedPane = new JTabbedPane();
			SolverTabbedPane.setFont(SansBold);
			SolverTabbedPane.addTab(Translation.Language.get(3), null, TextArea
					.getSyntaxPane(true), Translation.Language.get(105));
			SolverTabbedPane.addTab(Translation.Language.get(106), null,
					getJPanel2(), Translation.Language.get(107));
			SolverTabbedPane.addTab(Translation.Language.get(5), null, LogArea
					.getSyntaxPane(false), Translation.Language.get(108));
			SolverTabbedPane.addTab(Translation.Language.get(4), null,
					ResultArea.getSyntaxPane(false), Translation.Language
							.get(109));

			// Set the text of the LogArea
			// createLog();

		}
		return SolverTabbedPane;
	}

	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getRendered());
		}
		return jScrollPane3;
	}

	private OutputTextPane getRendered() {
		if (Rendered == null) {
			Rendered = new OutputTextPane();
			Rendered.setFont(Mono);
			Rendered.setEditable(false);

		}
		return Rendered;
	}

	private JButton getRefreshButton() {
		if (RefreshButton == null) {
			RefreshButton = new JButton();
			RefreshButton.setIcon(new ImageIcon(Config.AbsolutePath
					+ "icons/view-refresh.png"));
			RefreshButton.setText(Translation.Language.get(110));
			RefreshButton.setToolTipText(Translation.Language.get(111));
			RefreshButton.setBorder(BorderFactory.createCompoundBorder(null,
					null));
			RefreshButton.setDefaultCapable(false);
			RefreshButton.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent event) {
					MainMenu.jRefreshMouseMouseReleased();
				}
			});

		}
		return RefreshButton;
	}

	private JTabbedPane geteSuiteTabbedPane() {
		if (eSuiteTabbedPane == null) {
			eSuiteTabbedPane = new JTabbedPane();
			mathPane = new MathPane();
			eSuiteTabbedPane.setFont(Principal.SansBold);
			eSuiteTabbedPane
					.addTab(
							"<html><body leftmargin=5 topmargin=4 marginwidth=90 marginheight=5>eSuite Solver</body></html>",
							null, getSolverTabbedPane(), Translation.Language
									.get(114));
			eSuiteTabbedPane
					.addTab(
							"<html><body leftmargin=5 topmargin=4 marginwidth=90 marginheight=5>eSuite Mathematics</body></html>",
							null, mathPane.getMathematicsPane(),
							Translation.Language.get(115));
		}
		return eSuiteTabbedPane;
	}

	/*-----------------------------------------Look And Feel----------------------------------------*/

	private static void installLnF() {
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(Config.getTheme(Config.Theme));

		} catch (Exception e) {
			System.err.println("Cannot install " + e.getMessage()
					+ "; on this platform:" + PREFERRED_LOOK_AND_FEEL);
		}
	}

	/*-------------------------------------MAIN-----------------------------------------------*/
	/**
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// To avoid problems with relative path in Linux
				Config.getAbsolutePath();
				// Reads the stored configuration of the program
				Config C = new Config();
				C.ReadConfig();
				Config.makeEpsilon();
				/* Translation T = */new Translation();
				installLnF();
				frame = new Principal();
				frame.setDefaultCloseOperation(Principal.DO_NOTHING_ON_CLOSE);
				frame.setTitle("Engineering Suite " + VERSION);
				frame.setIconImage(SaveLoad.Icon);
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setExtendedState(Principal.MAXIMIZED_BOTH);
				// WindowLister
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(WindowEvent winEvt) {
						SaveLoad.Salir();
					}
				});

				// This changes the font of all the JOptionPane
				UIManager.put("OptionPane.messageFont", new FontUIResource(
						Principal.Sans));
				// This is to change the font options of the
				// rSyntaxtTextAreaPanels
				UpdateTextArea();

				// This is to initiate F.initSymbols just one time
				// Matheclipse need it to operate properly
				DiffAndEvaluator.PrepareME();
				// Set the focus in the textArea
				TextArea.TextArea.requestFocusInWindow();
				// If it is the first execute an example will be shown
				if (Config.FirstRun)
					C.writeInitialExample();

			}
		});
	}

	/*------------------BUTTONS, CHECKBOXES AND EVENTS-----------------------------*/

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	/**
	 * Calls to the repaint method
	 */
	protected void RefreshAplicattion() {
		this.repaint();
		TextArea.Refresh();
	}

	/**
	 * Updates the font of the equationArea, resultArea y logArea
	 */
	public static void UpdateTextArea() {
		TextArea.TextArea.setFont(Config.CurrentFont);
		TextArea.TextArea.repaint();
		ResultArea.TextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN,
				Config.CurrentFont.getSize()));
		ResultArea.TextArea.repaint();
		LogArea.TextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN,
				Config.CurrentFont.getSize()));
		ResultArea.TextArea.repaint();
	}

	/**
	 * This acts like the constructor of the LogArea
	 */
	protected static void createLog() {
		LogArea.TextArea.setText("");
		LogArea.TextArea.setText(Config.JumpLine + Translation.Language.get(47)
				+ Config.JumpLine + Config.JumpLine);

	}
}
