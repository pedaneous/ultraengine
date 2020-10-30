package UltraEngine.AddOns;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import UltraEngine.Renderer.Panel;
import UltraEngine.Shapes.Tile;

public class Player {

	int x,y;
	int width,height;
	
	double xspeed, yspeed;
	
	boolean keyUp, keyDown, keyLeft, keyRight;
	boolean facingLeft = false;
	
	Rectangle hitBox;
	
	ArrayList<Tile> walls;
	
	boolean jumping;
	
	public Player(ArrayList<Tile> walls, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle(x, y, width, height);
		
		this.walls = walls;
		
		loadSpriteSheet();
		loadSprites();
	}
	
	public void loadSpriteSheet() {
		
	}
	
	public void loadSprites() {
		
	}
	
	public void update() {
		if(keyLeft && keyRight || !keyLeft && !keyRight) xspeed *= 0.8;
		
		if(keyLeft) xspeed--;
		if(keyRight) xspeed++;
		
		if(xspeed > 0 && xspeed < 0.75) xspeed = 0;
		if(xspeed < 0 && xspeed > -0.75) xspeed = 0;
		
		if(xspeed > 7) xspeed = 7;
		if(xspeed < -7) xspeed = -7;
		
		if(keyUp) {
			hitBox.y++;
			for(Tile w : walls) {
				if(w.hitBox.intersects(hitBox)) yspeed = -6;
				jumping = true;;
			}
			hitBox.y--;
		}
		
		yspeed += 0.3;
		
		//Horizontal Collision
		hitBox.x += xspeed;
		for(Tile w : walls) {
			if(w.hitBox.intersects(hitBox)) {
				hitBox.x -= xspeed;
				while(!w.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
				hitBox.x -= Math.signum(xspeed);
				xspeed = 0;
				x = hitBox.x;
			}
		}
		
		//Vertical Collision
		hitBox.y += yspeed;
		for(Tile w : walls) {
			if(w.hitBox.intersects(hitBox)) {
				hitBox.y -= yspeed;
				while(!w.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
				hitBox.y -= Math.signum(yspeed);
				yspeed = 0;
				y = hitBox.y;
				jumping = false;
			}
		}
		
		x += xspeed;
		y += yspeed;
		
		if(x < 0) x = 0;
		if(x + width > Panel.width) x = Panel.width - width;
		
		hitBox.x = x;
		hitBox.y = y;
	}
	
	public void draw(Graphics2D g) {
		
	}
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_W) keyUp = true;
		if(key == KeyEvent.VK_A) {keyLeft = true; facingLeft = true;};
		if(key == KeyEvent.VK_S) keyDown = true;
		if(key == KeyEvent.VK_D) {keyRight = true; facingLeft = false;};
	}
	
	public void keyReleased(int key) {
		if(key == KeyEvent.VK_W) keyUp = false;
		if(key == KeyEvent.VK_A) keyLeft = false;
		if(key == KeyEvent.VK_S) keyDown = false;
		if(key == KeyEvent.VK_D) keyRight = false;
	}
	
}
