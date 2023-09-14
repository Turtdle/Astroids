package main;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class Astroid {
	private GOval body;
	public GOval getBody() {
		return body;
	}
	public void setBody(GOval body) {
		this.body = body;
	}
	public int getVel() {
		return vel;
	}
	public void setVel(int vel) {
		this.vel = vel;
	}
	private int vel;
	public Astroid(int x, int y, int velocity) {
		body = new GOval( x, y, 25, 25);
		vel = velocity;
	}
	public void updateAstroid() {
		body.move(0, vel);
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
}
