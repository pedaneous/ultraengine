package UltraEngine.Renderer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import UltraEngine.Game;

@SuppressWarnings("serial")
public class Display extends JFrame {

	Panel p;
	
	public Display(Game g, String title, int width, int height, boolean udc) {
		super(title);
		setDefaultCloseOperation(0x3);
		p = new Panel(g, width, height);
		setContentPane(p);
		setResizable(false);
		setUndecorated(udc);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				g.keyPressed(ke.getKeyCode(), ke.getKeyChar());
			}
			public void keyReleased(KeyEvent ke) {
				g.keyReleased(ke.getKeyCode(), ke.getKeyChar());
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				g.mouseClicked(me.getX(), me.getY());
			}
		});
		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent me) {
				g.mouseMoved(me.getX(), me.getY());
			}
		});
	}
	
}
