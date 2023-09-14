package main;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends GraphicsProgram{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 1000;
	public static final int INIT_X_VELOCITY = 5;
	public Canon canon;
	public void run() {
		canon = new Canon();
		canon.centerCanon(WINDOW_WIDTH, WINDOW_HEIGHT);
		addMouseListeners();
		add(canon.getCanonCompound());

	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(e != null) {
			canon.pointToCurser(e.getX(), e.getY());
		}

	}
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
	public static void main(String[] args) {

		new Main().start();
		

	}
}
