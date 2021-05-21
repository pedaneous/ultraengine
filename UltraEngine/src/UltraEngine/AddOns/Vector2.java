package UltraEngine.AddOns;

class Vector2 {
	public double x,y;
	
	public Vector2(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void add(double x, double y){
		this.x += x;
		this.y += y;
	}
	
	public void add(Vector2 vector){
		this.x += vector.x;
		this.y += vector.y;
	}
}
