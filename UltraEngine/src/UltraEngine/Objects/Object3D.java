package UltraEngine.Objects;

import java.util.ArrayList;

public abstract class Object3D {
	
	public ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
	
	public void translateX(int amt) {
		for(Vertex v : vertexList) {
			v.x += amt;
		}
	}
	
	public void translateY(int amt) {
		for(Vertex v : vertexList) {
			v.y += amt;
		}
	}
	
	public void translateZ(int amt) {
		for(Vertex v : vertexList) {
			v.z += amt;
		}
	}
	
	//xz zy yx
	
	public void rotateX(double amt) {
		for(Vertex v : vertexList) {
			double sin = Math.sin(amt);
			double cos = Math.cos(amt);
			
			double temp = (v.x * cos) - (v.z * sin);
			v.z = (v.x * sin) + (v.z * cos);
			v.x = temp;
		}
	}
	
	public void rotateY(double amt) {
		
	}
	
	public void rotateZ(double amt) {
		
	}
	
}
