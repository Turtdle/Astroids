package main;
import acm.program.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Main extends GraphicsProgram{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 1000;
	public static final int INIT_X_VELOCITY = 5;
	public Canon canon;
	public ArrayList<Astroid> astroids = new ArrayList<Astroid>();
	public void run() {
		canon = new Canon();
		canon.centerCanon(WINDOW_WIDTH, WINDOW_HEIGHT);
		addMouseListeners();
		add(canon.getCanonCompound());
		runGame();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(e != null) {
			canon.pointToCurser(e.getX(), e.getY());
		}

	}
	
	public void runGame() {
		while(true) {
			int rnd = new Random().nextInt(50);
			if(rnd == 5) {
				int rndx = new Random().nextInt(WINDOW_WIDTH-100) + 100;
				Astroid toAdd = new Astroid(rndx,0,1);
				astroids.add(toAdd);
				add(toAdd.getBody());
				System.out.println("1");
			}
			
			for(Astroid astroid : astroids) {
				astroid.updateAstroid();
			}
			pause(2);
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
