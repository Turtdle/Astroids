package main;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
public class Canon {
	private GOval canonBase;
	private GRect canonBarrel;
	private GCompound canonCompound = new GCompound();
	private float angle = 90;
	public Canon() {
		canonBase = new GOval(100,100);
		canonBarrel = new GRect(1, 50);
		canonCompound.add(canonBase);
		canonCompound.add(canonBarrel);
		
	}
	public GOval getCanonBase() {
		return canonBase;
	}
	public void setCanonBase(GOval canonBase) {
		this.canonBase = canonBase;
	}
	public GRect getCanonBarrel() {
		return canonBarrel;
	}
	public void setCanonBarrel(GRect canonBarrel) {
		this.canonBarrel = canonBarrel;
	}
	public GCompound getCanonCompound() {
		return canonCompound;
	}
	public void setCanonCompound(GCompound canonCompound) {
		this.canonCompound = canonCompound;
	}
	public void pointToCurser(int mouseX, int mouseY) {
		float xDistance = (float) (mouseX - canonBarrel.getX());
		float yDistance = (float) (mouseY - canonBarrel.getY());
		double rotationAngle = Math.toDegrees(Math.atan2(yDistance, xDistance));
		if(angle < rotationAngle) {
			canonBarrel.rotate(-1);
			angle++;
		}
		if(angle > rotationAngle) {
			canonBarrel.rotate(1);
			angle--;
		}

		
	}
	public void centerCanon(int w, int h) {
		canonBase.setLocation((w/2)-50, h-50);
		canonBarrel.setLocation(((w/2)), h-50);
	}
	

}
