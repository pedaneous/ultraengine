package UltraEngine.Renderer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import UltraEngine.Game;

@SuppressWarnings("serial")
public class Panel extends JPanel implements Runnable {

	public static int width, height;
	
	Thread t;
	boolean running;
	
	BufferedImage img;
	Graphics2D g;
	
	Game game;
	
	public Panel(Game game, int width, int height) {
		this.game = game;
		Panel.width = width;
		Panel.height = height;
		setPreferredSize(new Dimension(width, height));
		img = new BufferedImage(width, height, 0x1);
		g = (Graphics2D) img.getGraphics();
	}
	
	public void addNotify() {
		super.addNotify();
		if(t == null) {
			t = new Thread(this);
			t.start();
			running = true;
		}
	}
	
	public void run() {
		long l = System.nanoTime();
		final double ns = 1000000000D / 60;
		double d = 0;
		while(running) {
			long n = System.nanoTime();
			d += (n - l) / ns;
			l = n;
			while(d >= 1) {
				update();
				d--;
				draw();
				drawToScreen();
			}
		}
	}
	
	private void update() {
		game.update();
	}
	
	private void draw() {
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		game.draw(g);
	}
	
	private void drawToScreen() {
		Graphics2D g2 = (Graphics2D) getGraphics();
		g2.drawImage(img, 0, 0, width, height, null);
		g2.dispose();
	}
	
}
