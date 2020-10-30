package UltraEngine;

import UltraEngine.Renderer.Display;

public class Application {

	public Application(Game g, String title, int width, int height, boolean udc) {
		new Display(g,title,width,height,udc);
	}
	
}
