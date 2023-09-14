package main;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Bullet {
	private GOval body;
	public GOval getBody() {
		return body;
	}
	public void setBody(GOval body) {
		this.body = body;
	}
	private double vX;
	private double vY;
	public Bullet(int x, int y, double vX, double vY) {
		body = new GOval( x, y, 3, 3);
		this.vX = vX;
		this.vY = vY;
	}
	public void updateBullet() {
		body.move(vX, vY);
		
	}
	public boolean remove(int x, int y) {
		if(body.getX() < 0 || body.getX() > x) {
			return true;
		}
		if(body.getY() < 0 || body.getY() > y) {
			return true;
		}
		return false;
	}
	
	public boolean colliod(GObject target) {
		if(target.getX() < body.getX() && target.getX()+25 > body.getX() && target.getY() < body.getY() && target.getY()+25 > body.getY() ) {
			return true;
		}
		return false;
	}
}
