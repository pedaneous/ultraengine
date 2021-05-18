class Tween {
	
	Point end;
	double speed;
	
	Vector2 tweenPoint = new Vector2(0,0);
	
	public Tween(Point end, double speed) {
		this.end = end;
		this.speed = speed;
	}
	
	public Vector2 update(Vector2 instance){
		tweenPoint.x = (end.x-instance.x)*speed;
		tweenPoint.y = (end.y-instance.y)*speed;
		return tweenPoint;
	}
	
}
