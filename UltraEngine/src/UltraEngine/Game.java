package UltraEngine;

import java.awt.Graphics2D;

public abstract class Game {

	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void keyPressed(int key, char ch);
	public abstract void keyReleased(int key, char ch);
	public abstract void mouseClicked(int x, int y);
	public abstract void mouseMoved(int x, int y);
	
}
