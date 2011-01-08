package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 * A jTextField with cut,copy,paste pop-up menu
 * 
 * @author pablo salinas
 * 
 */
public class eTextField extends JTextField implements MouseListener {

	private static final long serialVersionUID = 5256241782660714671L;

	public eTextField() {
		super();
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

	}

	public eTextField(int columns) {
		super(columns);
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

	}

	public eTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

	}

	public eTextField(String text) {
		super(text);
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

	}

	public eTextField(String text, int columns) {
		super(text, columns);
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gui.ContextMenuMouseListener n = new gui.ContextMenuMouseListener();
		n.mouseClicked(e);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}