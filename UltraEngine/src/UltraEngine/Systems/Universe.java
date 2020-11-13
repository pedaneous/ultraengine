package UltraEngine.Systems;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.util.ArrayList;

import UltraEngine.Objects.Object3D;
import UltraEngine.Objects.Vertex;
import UltraEngine.Renderer.Panel;

public class Universe {
	
	boolean antiAliasing = false;
	
	public ArrayList<Object3D> objects = new ArrayList<Object3D>();
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g) {
		if(antiAliasing == false) {
			antiAliasing = true;
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		for(Object3D obj : objects) {
			Polygon p = new Polygon();
			for(Vertex v : obj.vertexList) {
				double zf = 500/(500 + v.z);
				int nX = (int) (v.x * zf) + Panel.width/2;
				int nY = (int) (-v.y * zf) + Panel.height/2;
				p.addPoint(nX, nY);
			}
			g.setColor(Color.white);
			g.draw(p);
		}
	}
	
}
