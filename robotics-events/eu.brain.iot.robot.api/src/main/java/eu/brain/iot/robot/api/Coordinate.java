package eu.brain.iot.robot.api;

public class Coordinate {
	double x = 0;
	double y = 0;
	double z = 0;
	
	public Coordinate() {

	}
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "Cooridinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	
}
