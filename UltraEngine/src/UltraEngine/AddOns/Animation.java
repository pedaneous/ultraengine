package UltraEngine.AddOns;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Animation {
	private int speed;
	private int frames;

	private int index = 0;
	private int count = 0;

	public BufferedImage[] images;
	public BufferedImage currentImg;

	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		for (int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
	}

	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}
	
	public void runAnimationWithoutLoop() {
		index++;
		if(index > speed) {
			index = 0;
			nextFrameWithoutLoop();
		}
	}

	private void nextFrame() {
		for (int i = 0; i < frames; i++) {
			if (count == i) {
				currentImg = images[i];
			}
		}
		count++;
		if (count > frames)
			count = 0;
	}
	
	private void nextFrameWithoutLoop() {
		if(count < frames) {
			for (int i = 0; i < frames; i++) {
				if (count == i) {
					currentImg = images[i];
				}
			}
			count++;
		}
	}

	public void drawAnimation(Graphics2D g, int x, int y) {
		g.drawImage(currentImg, x, y, null);
	}

	public void drawAnimation(Graphics2D g, int x, int y, int width, int height) {
		g.drawImage(currentImg, x, y, width, height, null);
	}
	
	public void reset() {
		index = 1;
		count = 1;
	}
}