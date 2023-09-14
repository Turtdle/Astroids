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
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
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
	
	@Override
	public void mousePressed(MouseEvent e) {
		double vx =  (e.getX() - canon.getCanonBarrel().getX());
		double vy =  (e.getY() - canon.getCanonBarrel().getY());
		double length = Math.sqrt(vx*vx + vy*vy);
		vx = vx/length * 4;
		vy = vy/length * 4;
		System.out.println(vy);
		System.out.println(vx);
		Bullet toAdd = new Bullet((int) canon.getCanonBarrel().getX(), (int)canon.getCanonBarrel().getY(), vx, vy);
		bullets.add(toAdd);
		add(toAdd.getBody());
	}
	
	public void runGame() {
		while(true) {
			int rnd = new Random().nextInt(400);
			if(rnd == 5) {
				int rndx = new Random().nextInt(WINDOW_WIDTH-30) + 30;
				Astroid toAdd = new Astroid(rndx,0,1);
				astroids.add(toAdd);
				add(toAdd.getBody());
				System.out.println("1");
			}
			
			for(Astroid astroid : astroids) {
				astroid.updateAstroid();
				for(Bullet bullet : bullets) {
					if(bullet.colliod(astroid.getBody())) {
						remove(bullet.getBody());
						remove(astroid.getBody());

					}
				}
				if(astroid != null) {
					if(astroid.remove(WINDOW_WIDTH, WINDOW_HEIGHT)){
						remove(astroid.getBody());

					}
				}


			}
			for(Bullet bullet : bullets) {
				bullet.updateBullet();
				if(bullet.remove(WINDOW_WIDTH, WINDOW_HEIGHT)){
					remove(bullet.getBody());

				}

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
