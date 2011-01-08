package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.text.JTextComponent;

/**
 * This class implements the right-click pop-up menu with cut, copy and paste
 * for a JTextComponent
 * 
 */
@SuppressWarnings("all")
public class ContextMenuMouseListener extends MouseAdapter {
	private JPopupMenu popup = new JPopupMenu();

	private Action cutAction;
	private Action copyAction;
	private Action pasteAction;
	// private Action selectAllAction;

	private JTextComponent textComponent;
	@SuppressWarnings("unused")
	private String savedString = "";
	@SuppressWarnings("unused")
	private Actions lastActionSelected;

	private enum Actions {
		CUT, COPY, PASTE
	};

	public ContextMenuMouseListener() {

		cutAction = new AbstractAction(Translation.Language.get(0),
				new ImageIcon(Config.AbsolutePath + "icons/cut.png")) {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				lastActionSelected = Actions.CUT;
				savedString = textComponent.getText();
				textComponent.cut();
			}
		};

		popup.add(cutAction);

		copyAction = new AbstractAction(Translation.Language.get(1),
				new ImageIcon(Config.AbsolutePath + "icons/copy.png")) {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				lastActionSelected = Actions.COPY;
				textComponent.copy();
			}
		};
		popup.add(copyAction);
		pasteAction = new AbstractAction(Translation.Language.get(2),
				new ImageIcon(Config.AbsolutePath + "icons/paste.png")) {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				lastActionSelected = Actions.PASTE;
				savedString = textComponent.getText();
				textComponent.paste();
			}
		};

		popup.add(pasteAction);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			if (!(e.getSource() instanceof JTextComponent)) {
				return;
			}

			textComponent = (JTextComponent) e.getSource();
			textComponent.requestFocus();

			boolean enabled = textComponent.isEnabled();
			boolean editable = textComponent.isEditable();
			boolean nonempty = !(textComponent.getText() == null || textComponent
					.getText().equals(""));
			boolean marked = textComponent.getSelectedText() != null;

			boolean pasteAvailable = Toolkit.getDefaultToolkit()
					.getSystemClipboard().getContents(null)
					.isDataFlavorSupported(DataFlavor.stringFlavor);

			cutAction.setEnabled(enabled && editable && marked);
			copyAction.setEnabled(enabled && marked);
			pasteAction.setEnabled(enabled && editable && pasteAvailable);

			int nx = e.getX();

			if (nx > 500) {
				nx = nx - popup.getSize().width;
			}

			popup.show(e.getComponent(), nx, e.getY() - popup.getSize().height);
		}
	}
}
