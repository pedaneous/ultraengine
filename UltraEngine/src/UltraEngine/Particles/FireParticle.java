package UltraEngine.Particles;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FireParticle extends Particle {
	
	Color c = new Color(255,165,0);
	Rectangle r;
	
	public FireParticle(int x, int y, int w, int h) {
		r = new Rectangle(x,y,w+(int)(Math.random()*4),h);
	}
	
	public void update() {
		if(r.width > 0) {
			r.x = r.x + r.width/11;
			r.y -= 3;
			r.width -= 1;
		}
		if(r.height > 0) {
			r.height -= 1;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(c);
		g.fill(r);
	}
	
}
