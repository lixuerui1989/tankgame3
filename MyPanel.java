package tankgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;
import javax.swing.JPanel;


// for monitoring keyboard event, use key listening.

// for continue to repaint, MyPanel should have Runnable interface to act as a thread.



public class MyPanel extends JPanel implements KeyListener, Runnable{
	
	
	// define my tank.
	static Hero hero = null;
	
	//define a Node Vector to recovery enemy tanks from previous game.
	Vector<Node> nodes = new Vector<>();  
	Vector<NodeWood> nodes2 = new Vector<>(); 
	
	Vector<Wood> woods = new Vector<>();
	
	Vector<Metal> metals = new Vector<>();
	
	// define enemy tanks and store them in Vector.
	Vector<EnemyTank> enemyTanks = new Vector<>();
	int enemyTanksSize = 9;
	
	// define bomb images
	// when shot hit tanks, add a bomb to the Vector.
	Vector<Bomb> bombs = new Vector<>();
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	
	
	public void initializingMetal(){	
		for(int i =0;i<2;i++) {
			Metal metal1 = new Metal(260+40*i,340);
			metals.add(metal1);
	  Metal metal2 = new Metal(560+40*i,340);
		    metals.add(metal2);  				   
		}
	
	}
		public void initializingWood() {	
		for(int i =0;i<6;i++) {
			Wood wood = new Wood(120,80+i*40);
			woods.add(wood);
			Wood wood1 = new Wood(120,400+i*40);
			woods.add(wood1);
			Wood wood2 = new Wood(420,80+i*40);
			woods.add(wood2);
			Wood wood3 = new Wood(420,400+i*40);
			woods.add(wood3);			
			Wood wood4 = new Wood(720,80+i*40);
			woods.add(wood4);
			Wood wood5 = new Wood(720,400+i*40);
			woods.add(wood5);	
		}
		}
	
	
	public MyPanel(String key) {
		File file = new File(Recorder.getRecorderFile());
		if(file.exists()) {
		
		nodes = Recorder.getNodesAndEnemyTankRec();
		}else {
			System.out.println("The file is not existed, only can start a new game.");
			key = "1";
		}
		
		File file2 = new File(Recorder.getRecorderFile2());
		if(file2.exists()) {
		
		nodes2 = Recorder.getWoodsRec();
		}else {
			System.out.println("The file is not existed, only can start a new game.");
			key = "1";
		}
	
		// Set Vector enemyTanks to recorder
			Recorder.setEnemyTanks(enemyTanks);
			Recorder.setWoods(woods);

		
		//initialize my tank.
		hero = new Hero(420, 660);
		hero.setSpeed(18);
		hero.setEnemyTanks(enemyTanks);
		hero.setMetals(metals);
		hero.setWoods(woods);
		
		
		
		switch(key) {
		case "1":
	
			// initialize enemy tanks to start a new game.
			for(int i = 0; i < enemyTanksSize; i++) {
				EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
				
				enemyTank.setEnemyTanks(enemyTanks);
				enemyTank.setMetals(metals);
				enemyTank.setWoods(woods);

				
				enemyTank.setDirect(2);
				// start enemy tank thread.
				new Thread(enemyTank).start();
				
				// add shot.
				Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
				
				enemyTank.shots.add(shot);
				
				new Thread(shot).start();
				
				enemyTanks.add(enemyTank);	
				
				
			}
			initializingWood();
			initializingMetal();
			break;
		case "2":
			// initialize enemy tanks to continue the previous game.
						for(int i = 0; i < nodes.size(); i++) {
							Node node = nodes.get(i);
							EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
							
							enemyTank.setEnemyTanks(enemyTanks);
							
							enemyTank.setDirect(node.getDirect());
							
							// start enemy tank thread.
							new Thread(enemyTank).start();
							
							// add shot.
							Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
							
							enemyTank.shots.add(shot);
							
							new Thread(shot).start();
							
							enemyTanks.add(enemyTank);	
							
							
						}
						
						initializingMetal();
						
						for(int i = 0; i < nodes2.size(); i++) {
							NodeWood node2 = nodes2.get(i);
							Wood wood = new Wood(node2.getX(), node2.getY());
							
							wood.setWoods(woods);
							
							woods.add(wood);	
							
							
						}
						
						
						break;
						
					default:
						System.out.println("The input is incorrect.");
		
		
		
	
		
		}
		
	
		
		// initialize bomb images.
		image1=Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
		image2=Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
		image3=Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));
		
		//initialize wall
		
		
		
		
		// play music.
		new AePlayWave("src//music.wav").start();

	
	}
	

	


	
	public void showInfo(Graphics g) {
		g.setColor(Color.BLACK);
		Font font = new Font("Aril", Font.BOLD, 18);
		g.setFont(font);
		
		
		
		g.drawString("Tank Game 2023", 1020, 30);
		
	
		
		g.drawString("@ Brainstormers", 1020, 680);
		
		g.drawString("Hit enemy tanks No. ", 1020, 330);
		
		drawTank(1020, 345, g, 0, 1);
		
		g.setColor(Color.BLACK);
		g.drawString(" X    " + Recorder.getAllEnemyTanksNum() + "", 1080, 385);
		
		
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);
	
		
		// show info
		
		showInfo(g);
		// draw my tank.
		if(hero != null && hero.isLive) {
		drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
		}
		
		// draw the bullet from my tank.
		
	
		
		for(int i = 0; i < hero.shots.size(); i++) {
			Shot shot = hero.shots.get(i);
			
			if(shot != null && shot.isLive) {
				g.draw3DRect(shot.x, shot.y, 1, 1, false);
				
			}else {
				hero.shots.remove(shot);
				
			}
			
		}
		
		
		
		// if bombs Vector has bombs, draw bombs.
		for(int i = 0; i < bombs.size(); i++) {
			Bomb bomb = bombs.get(i);
			if(bomb.life > 6) {				
				g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
			}else if(bomb.life > 3) {
				g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
			}else {
				g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
			}
			bomb.lifeDown();
			if(bomb.life == 0) {
				bombs.remove(bomb);
			}
		 	
		}
		
		
		// draw enemy tank, iterate enemy tanks.
		
		for(int i = 0; i < enemyTanks.size(); i++) {
			EnemyTank enemyTank = enemyTanks.get(i);
			
			// judge a enemy tank that is live before draw it.
			
			
			if(enemyTank.isLive) {
			drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
			
			// draw all shots.
			
			for(int j = 0; j < enemyTank.shots.size(); j++) {
				//get shot.
				Shot shot = enemyTank.shots.get(j);
				// paint shot.
				if(shot.isLive) {
					g.draw3DRect(shot.x, shot.y, 1, 1, false);										
				} else {
					// remove shot from Vector
					enemyTank.shots.remove(shot);					
				}			
			}
			}		
		}	
		
		// draw walls
		
		for(int i = 0; i < woods.size(); i++) {
			Wood wood = woods.get(i);
			if(wood.isLive) {
				drawWood(woods,g);
				}
		}
		
		drawMetal(metals,g);

		
	}
	
	public void drawTank(int x, int y, Graphics g, int direct, int type) {
		switch(type) {
		
		case 0: // our tanks.
			g.setColor(Color.cyan);
			break;
			
		case 1: // enemy tanks.
			g.setColor(Color.yellow);
			break;
	
		
		}
		
		// draw tanks according to different direction.
		// direct indicates direction (0: up, 1: right, 2: down, 3: left).
		
		
		
		
		switch(direct) {
		
		case 0:// up direction.
			
			g.fill3DRect(x, y, 10, 60, false);// left wheel of a tank.
			g.fill3DRect(x + 30, y, 10, 60, false);// right wheel of a tank.
			g.fill3DRect(x + 10, y + 10, 20, 40, false);// middle part of a tank.
			g.fillOval(x + 10, y + 20, 20, 20);// middle circle part of a tank.
			g.drawLine(x + 20, y + 30, x + 20, y);// barrel of a tank.
						
			break;
			
        case 1:// right direction.
			
			g.fill3DRect(x, y, 60, 10, false);// lift wheel of a tank.
			g.fill3DRect(x, y + 30, 60, 10, false);// right wheel of a tank.
			g.fill3DRect(x + 10, y + 10, 40, 20, false);// middle part of a tank.
			g.fillOval(x + 20, y + 10, 20, 20);// middle circle part of a tank.
			g.drawLine(x + 30, y + 20, x + 60, y + 20);// barrel of a tank.
						
			break;
			
        case 2:// down direction.
			
			g.fill3DRect(x, y, 10, 60, false);// left wheel of a tank.
			g.fill3DRect(x + 30, y, 10, 60, false);// right wheel of a tank.
			g.fill3DRect(x + 10, y + 10, 20, 40, false);// middle part of a tank.
			g.fillOval(x + 10, y + 20, 20, 20);// middle circle part of a tank.
			g.drawLine(x + 20, y + 30, x + 20, y + 60);// barrel of a tank.
						
			break;
			
        case 3:// left direction.
			
			g.fill3DRect(x, y, 60, 10, false);// left wheel of a tank.
			g.fill3DRect(x, y + 30, 60, 10, false);// right wheel of a tank.
			g.fill3DRect(x + 10, y + 10, 40, 20, false);// middle part of a tank.
			g.fillOval(x + 20, y + 10, 20, 20);// middle circle part of a tank.
			g.drawLine(x + 30, y + 20, x, y + 20);// barrel of a tank.
						
			break;
			
			
		default: 
			System.out.println("Not handling.");
		
		}
		
	}
	


	public void drawMetal(Vector<Metal>metals,Graphics g) {
		g.setColor(Color.white);
		for(int i =0;i<metals.size();i++) {
			Metal metal = metals.get(i);
			g.fill3DRect(metal.getX(), metal.getY(), 40, 40, false);
		}
	}
	
	public void drawWood(Vector<Wood>woods,Graphics g) {
		g.setColor(Color.green);
		for(int i=0;i<woods.size();i++) {
			Wood wood = woods.get(i);
			if(wood.getIsLive()) {
			g.fill3DRect(wood.getX(), wood.getY(),40,40,false );
			}
		}
	}
	
	// If my tank can shots multiple times, the shot should be take from its Vector 
	// to judge if they hit all enemy tanks.
	
	public void hitEnemyTank() {
		// iterate shots from my tank.
		
		for(int j = 0; j < hero.shots.size(); j++) {
			Shot shot = hero.shots.get(j);
			if(shot != null && shot.isLive) {
				for(int i = 0; i < enemyTanks.size(); i++) {
					EnemyTank enemyTank = enemyTanks.get(i);
					hitTank(shot, enemyTank);
				}
				
			}
			
		}
	}
	
	public void hitHero() {
		// iterate enemy tanks.
		for(int i = 0; i < enemyTanks.size(); i++) {
			EnemyTank enemyTank = enemyTanks.get(i);
		// iterate shots of a enemy tank.
			for(int j = 0; j < enemyTank.shots.size(); j++) {
				Shot shot = enemyTank.shots.get(j);
				// judge shot hit my tank or not.
				if(hero.isLive && shot.isLive) {
					hitTank(shot, hero);
				}
			}
			
		
			
		}
	}
	
	
		public void hitWood(Shot shot,Tank tank) {
			for(int i =0;i<woods.size();i++) {
				Wood wood = woods.get(i);
				if(shot.x>=wood.getX()
						&&shot.x<=wood.getX()+40
					&&shot.y>=wood.getY()
					&&shot.y<=wood.getY()+40) {
					shot.isLive=false;
					wood.setIsLive(false);
					woods.remove(wood);
					
				}
					
			}
		}
		
		public void hitMetal(Shot shot) {
			for(int i =0;i<metals.size();i++) {
				Metal metal = metals.get(i);
				if(shot.x>=metal.getX()
						&&shot.x<=metal.getX()+40
					&&shot.y>=metal.getY()
					&&shot.y<=metal.getY()+40) {
					shot.isLive=false;
					
				}
					
			}
		}
		
		
		public void heroHitBarrier() {
			for(int i =0;i<hero.shots.size();i++) {
				Shot shot = hero.shots.get(i);
				hitWood(shot,hero);
				hitMetal(shot);
			}
		}
	
		public void enemyHitBarrier() {
			for(int i = 0;i<enemyTanks.size();i++) {
				EnemyTank enemyTank = enemyTanks.get(i);
				for(int j=0;j<enemyTank.shots.size();j++) {
					Shot shot = enemyTank.shots.get(j);
					hitWood(shot,enemyTank);
					hitMetal(shot);
				}
				
			}
		}


	
	public void hitTank(Shot s, Tank tank) {// judge shot hit enemy or not.
		switch(tank.getDirect()) {
		case 0: // up direction.
		case 2: // down direction.
			if(s.x > tank.getX() && s.x < tank.getX() + 40
					&& s.y > tank.getY() && s.y < tank.getY() + 60) {
				s.isLive = false;
				tank.isLive = false;
				// my shot on enemy tank, remove the enemy tank from its Vector.
				enemyTanks.remove(tank);
				
				// increment enemy tanks number.
				
				if(tank instanceof EnemyTank) {
					Recorder.addAllEnemyTanksNum();
				}
				
				// create bomb object.
				
				Bomb bomb = new Bomb(tank.getX(), tank.getY());
				bombs.add(bomb);			
			}
			break;

		case 1: // right direction.
		case 3: // left direction.
			if(s.x > tank.getX() && s.x < tank.getX() + 60
					&& s.y > tank.getY() && s.y < tank.getY() + 40) {
				s.isLive = false;
				tank.isLive = false;
				// my shot on enemy tank, remove the enemy tank from its Vector.
				enemyTanks.remove(tank);
                // increment enemy tanks number.
				
				if(tank instanceof EnemyTank) {
					Recorder.addAllEnemyTanksNum();
				}
				
				Bomb bomb = new Bomb(tank.getX(), tank.getY());
				bombs.add(bomb);
			}
			break;	
		
		
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// handle wdsa key to control direction.

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_W){ // press key w.
			hero.setDirect(0);// change direction of a tank to up.
			// change x coordinate of the tank.
			if(hero.getY() > 0  && !hero.isTouchEnemyTank() && !hero.isTouchWood() && !hero.isTouchMetal()) {
			hero.moveUp();
			}
			
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			hero.setDirect(1);// change direction of a tank to right.
			if(hero.getX() + 60 < 1000 && !hero.isTouchEnemyTank() && !hero.isTouchWood() && !hero.isTouchMetal()) {
			hero.moveRight();
			}
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_S) {
			hero.setDirect(2);// change direction of a tank to down.
			if(hero.getY() + 60 < 750 && !hero.isTouchEnemyTank() && !hero.isTouchWood() && !hero.isTouchMetal()) {
			hero.moveDown();
			}
			
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_A) {
			hero.setDirect(3);// change direction of a tank to left.
			if(hero.getX() > 0 && !hero.isTouchEnemyTank() && !hero.isTouchWood() && !hero.isTouchMetal()) {
			hero.moveLeft();
			}
			
		}
		
		// if player press k on keyboard, start shot.
		if(e.getKeyCode() == KeyEvent.VK_K) {
			
			hero.shotEnemyTank();
			
			
		}	
		this.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void run() {// repaint every 100ms.
		while(true) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// judge shot hit enemy tanks or not.
		hitEnemyTank();
		hitHero();
		enemyHitBarrier();
		heroHitBarrier();
		
		
		this.repaint();
		
		
	}
	}
	
}
