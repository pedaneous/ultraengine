package UltraEngine.Shapes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Tile {

	int x,y;
	int width,height;
	
	Image img;
	
	public Rectangle hitBox;
	
	public Tile(Image img2, int x, int y, int width, int height) {
		this.img = img2;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x,y,width,height);
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(img, x, y, width, height, null);
	}
	
}
