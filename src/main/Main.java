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
	public void run() {
		addMouseListeners();
	}
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
	public static void main(String[] args) {

		
		new Main().start();
		

	}
}
