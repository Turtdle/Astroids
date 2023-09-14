package main;
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
public class Main extends GraphicsProgram{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 1000;
	public static final int INIT_X_VELOCITY = 5;
	public boolean notStarted = true;
	public int health = 20;
	private RandomGenerator rgen;
	public int gameTimer = 0;
	GLabel healthLabel = new GLabel(String.valueOf(health), 50, 50);
	public Canon canon;
	public ArrayList<Astroid> astroids = new ArrayList<Astroid>();
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public void run() {

		addMouseListeners();

		startMenu();
		canon = new Canon();
		canon.centerCanon(WINDOW_WIDTH, WINDOW_HEIGHT);
		add(canon.getCanonCompound());
		runGame();
		removeAll();
		notStarted = true;
		GLabel death = new GLabel("You Lost", WINDOW_WIDTH/2-40,WINDOW_HEIGHT/2-100);
		add(death);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(!notStarted) {
			if(e != null) {
				canon.pointToCurser(e.getX(), e.getY());
			}
		}


	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(notStarted) {
			if(e.getX() > WINDOW_WIDTH/2-150 && e.getX()<WINDOW_WIDTH/2+150 && e.getY() > WINDOW_HEIGHT/2 && e.getY() < WINDOW_HEIGHT/2 + 50) {
				notStarted = false;
			}
		}

		if(!notStarted) {
			double vx =  (e.getX() - canon.getCanonBarrel().getX());
			double vy =  (e.getY() - canon.getCanonBarrel().getY());
			double length = Math.sqrt(vx*vx + vy*vy);
			vx = vx/length * 4;
			vy = vy/length * 4;
			Bullet toAdd = new Bullet((int) canon.getCanonBarrel().getX(), (int)canon.getCanonBarrel().getY(), vx, vy);
			bullets.add(toAdd);
			add(toAdd.getBody());
		}

	}
	
	public void runGame() {
		while(health >= 1) {
			gameTimer++;
			int rnd = new Random().nextInt(500-gameTimer/200);
			if(rnd == 5) {
				int rndx = new Random().nextInt(WINDOW_WIDTH-30) + 30;
				Astroid toAdd = new Astroid(rndx,0,1);
				astroids.add(toAdd);
				add(toAdd.getBody());

			}
			
			for(Astroid astroid : astroids) {
				astroid.updateAstroid();
				for(Bullet bullet : bullets) {
					if(bullet.colliod(astroid.getBody())) {
						astroid.getBody().setVisible(false);
						remove(bullet.getBody());
						remove(astroid.getBody());

					}
				}
				if(astroid != null) {
					if(astroid.remove(WINDOW_WIDTH, WINDOW_HEIGHT)){
						if(astroid.getBody().isVisible()) {
							health--;
						}
						astroid.getBody().setVisible(false);
						remove(astroid.getBody());
						astroid = null;
						astroids.remove(astroid);

					}
				}


			}
			for(Bullet bullet : bullets) {
				bullet.updateBullet();
				if(bullet.remove(WINDOW_WIDTH, WINDOW_HEIGHT)){
					remove(bullet.getBody());

				}

			}
			healthLabel.setLabel(String.valueOf(health));
			add(healthLabel);
			pause(2);
		}
	}
	
	public void startMenu() {
		
		GRect button = new GRect(WINDOW_WIDTH/2-150,WINDOW_HEIGHT/2,300,50);
		GLabel label = new GLabel("Press to start", WINDOW_WIDTH/2-40,WINDOW_HEIGHT/2-100);
		while(notStarted) {
			rgen = RandomGenerator.getInstance();
			pause(300);
			button.setColor(rgen.nextColor());
			button.setFilled(true);
			add(button);
			add(label);
		}
		removeAll();
	}
	public void deathScreen() {
		
	}
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		requestFocus();
	}
	public static void main(String[] args) {

		new Main().start();
		
		

	}
}
