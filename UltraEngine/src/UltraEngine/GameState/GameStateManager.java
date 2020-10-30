package UltraEngine.GameState;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {

	public ArrayList<GameState> states = new ArrayList<GameState>();
	public int currentState = 0;
	
	public GameStateManager() {
		//init states
		states.add(new MenuState(this));
	}
	
	public void update() {
		states.get(currentState).update();
	}
	
	public void draw(Graphics2D g) {
		states.get(currentState).draw(g);
	}
	
	public void keyPressed(int key, char ch) {
		states.get(currentState).keyPressed(key, ch);
	}
	
	public void keyReleased(int key, char ch) {
		states.get(currentState).keyReleased(key, ch);
	}
	
	public void mouseClicked(int x, int y) {
		states.get(currentState).mouseClicked(x, y);
	}
	
	public void mouseMoved(int x, int y) {
		states.get(currentState).mouseMoved(x, y);
	}
	
}
