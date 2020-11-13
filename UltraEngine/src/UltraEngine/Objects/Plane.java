package UltraEngine.Objects;

public class Plane extends Object3D {

	public Plane() {
		vertexList.add(new Vertex(-100,0,-100));
		vertexList.add(new Vertex(100,0,-100));
		vertexList.add(new Vertex(100,0,100));
		vertexList.add(new Vertex(-100,0,100));
	}
	
}
