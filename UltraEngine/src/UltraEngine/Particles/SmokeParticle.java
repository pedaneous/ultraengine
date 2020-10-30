package UltraEngine.Particles;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class SmokeParticle extends Particle {
	
	Color c = Color.gray;
	Rectangle r;
	
	int trans = 150;
	
	public SmokeParticle(int x, int y, int w, int h) {
		r = new Rectangle(x,y,w,h);
	}
	
	public void update() {
		if(trans > 0) {
			trans -= 1;
		}
		if(r.width < 50) {
			r.x -= 1;
			r.width += 1;
		}
		if(r.height < 50) {
			r.y -= 1;
			r.height += 1;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue(), trans));
		g.fillOval(r.x, r.y, r.width, r.height);
	}
	
}
