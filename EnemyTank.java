package tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
	// apply vector to store shots.
	
	Vector<Shot> shots = new Vector<>();
	
	Vector<EnemyTank> enemyTanks = new Vector<>();
	Vector<Wood> woods= new Vector<>();
	Vector<Metal> metals= new Vector<>();
	
	boolean isLive = true;

	

	public EnemyTank(int x, int y) {
		super(x, y);		
	}


	public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		this.enemyTanks = enemyTanks;
	}
	public void setWoods(Vector<Wood> woods) {
		this.woods = woods;
	}
	public void setMetals(Vector<Metal> metals) {
		this.metals = metals;
	}

	
	
	
	
	public boolean isTouchEnemyTank() {
		switch(this.getDirect()){
		case 0:
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
				if(enemyTank != this) {
					if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +40
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						
						if(this.getX() + 40 >= enemyTank.getX() 
								&& this.getX() + 40 <= enemyTank.getX() +40
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						
					}
					
                    if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                    	if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +60
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
                    	if(this.getX() + 40 >= enemyTank.getX() 
								&& this.getX() + 40 <= enemyTank.getX() +60
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
                    	
						
					}
					
				}
				
			}
			break;
			
		case 1:
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
				if(enemyTank != this) {
					if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						if(this.getX() + 60 >= enemyTank.getX() 
								&& this.getX() + 60 <= enemyTank.getX() +40
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						
						if(this.getX() + 60 >= enemyTank.getX() 
								&& this.getX() + 60 <= enemyTank.getX() +40
								&& this.getY() + 40 >= enemyTank.getY() 
								&& this.getY() + 40 <= enemyTank.getY() + 60) {
							return true;
						}
						
					}
					
                    if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                    	if(this.getX() + 60 >= enemyTank.getX() 
								&& this.getX()+ 60 <= enemyTank.getX() +60
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
                    	if(this.getX() + 60 >= enemyTank.getX() 
								&& this.getX() + 60 <= enemyTank.getX() +60
								&& this.getY() + 40 >= enemyTank.getY() 
								&& this.getY() + 40 <= enemyTank.getY() + 40) {
							return true;
						}
                    	
						
					}
					
				}
				
			}
			
			
			break;
			
		case 2:
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
				if(enemyTank != this) {
					if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +40
								&& this.getY() + 60 >= enemyTank.getY() 
								&& this.getY() + 60 <= enemyTank.getY() + 60) {
							return true;
						}
						
						if(this.getX() + 40 >= enemyTank.getX() 
								&& this.getX() + 40 <= enemyTank.getX() +40
								&& this.getY() + 60 >= enemyTank.getY() 
								&& this.getY() + 60 <= enemyTank.getY() + 60) {
							return true;
						}
						
					}
					
                    if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                    	if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +60
								&& this.getY() + 60 >= enemyTank.getY() 
								&& this.getY() + 60 <= enemyTank.getY() + 40) {
							return true;
						}
                    	if(this.getX() + 40 >= enemyTank.getX() 
								&& this.getX() + 40 <= enemyTank.getX() +60
								&& this.getY() + 60 >= enemyTank.getY() 
								&& this.getY() + 60 <= enemyTank.getY() + 40) {
							return true;
						}
                    	
						
					}
					
				}
				
			}
			
			break;
			
		case 3: 
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
				if(enemyTank != this) {
					if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +40
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						
						if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +40
								&& this.getY() + 40 >= enemyTank.getY() 
								&& this.getY() + 40 <= enemyTank.getY() + 60) {
							return true;
						}
						
					}
					
                    if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
                    	if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +60
								&& this.getY() >= enemyTank.getY() 
								&& this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
                    	if(this.getX() >= enemyTank.getX() 
								&& this.getX() <= enemyTank.getX() +60
								&& this.getY() + 40 >= enemyTank.getY() 
								&& this.getY() + 40 <= enemyTank.getY() + 40) {
							return true;
						}
                    	
						
					}
					
				}
				
			}
			
			break;
		}
		
		return false;
	}
	public boolean isTouchWood() {

		switch(this.getDirect()) {
		case 0:
			for(int i =0;i<woods.size();i++) {
				
				Wood wood = woods.get(i);
				
				if(this.getX()>=wood.getX()
					&&this.getX()<=wood.getX()+40
					&&this.getY()>=wood.getY()
					&&this.getY()<=wood.getY()+40)
					return true;
				
				if(this.getX()+40>=wood.getX()
						&&this.getX()+40<=wood.getX()+40
						&&this.getY()>=wood.getY()
						&&this.getY()<=wood.getY()+40)
						return true;	
				
			}
			break;
		case 1:
			for(int i =0;i<woods.size();i++) {
				
				Wood wood = woods.get(i);
				
				if(this.getX()+60>=wood.getX()
					&&this.getX()+60<=wood.getX()+40
					&&this.getY()>=wood.getY()
					&&this.getY()<=wood.getY()+40)
					return true;
				
				if(this.getX()+60>=wood.getX()
						&&this.getX()+60<=wood.getX()+40
						&&this.getY()+40>=wood.getY()
						&&this.getY()+40<=wood.getY()+40)
						return true;	
			}
			break;
		case 2:
			for(int i =0;i<woods.size();i++) {
				
				Wood wood = woods.get(i);
				
				if(this.getX()>=wood.getX()
					&&this.getX()<=wood.getX()+40
					&&this.getY()+60>=wood.getY()
					&&this.getY()+60<=wood.getY()+40)
					return true;
				
				if(this.getX()+40>=wood.getX()
						&&this.getX()+40<=wood.getX()+40
						&&this.getY()+60>=wood.getY()
						&&this.getY()+60<=wood.getY()+40)
						return true;	
			}
			break;
		case 3:
			for(int i =0;i<woods.size();i++) {
				
				Wood wood = woods.get(i);
				
				if(this.getX()+60>=wood.getX()
					&&this.getX()+60<=wood.getX()+40
					&&this.getY()>=wood.getY()
					&&this.getY()<=wood.getY()+40)
					return true;
			
				if(this.getX()>=wood.getX()
						&&this.getX()<=wood.getX()+40
						&&this.getY()+40>=wood.getY()
						&&this.getY()+40<=wood.getY()+40)
						return true;	
			}
			break;
		}
		return false;
	
	}
	
	public boolean isTouchMetal() {
		switch(this.getDirect()) {
		case 0:
			for(int i =0;i<metals.size();i++) {
				
				Metal metal = metals.get(i);
				
				if(this.getX()>=metal.getX()
					&&this.getX()<=metal.getX()+40
					&&this.getY()>=metal.getY()
					&&this.getY()<=metal.getY()+40)
					return true;
				
				if(this.getX()+40>=metal.getX()
						&&this.getX()+40<=metal.getX()+40
						&&this.getY()>=metal.getY()
						&&this.getY()<=metal.getY()+40)
						return true;	
				
			}
			break;
		case 1:
			for(int i =0;i<metals.size();i++) {
				
				Metal metal = metals.get(i);
				
				if(this.getX()+60>=metal.getX()
					&&this.getX()+60<=metal.getX()+40
					&&this.getY()>=metal.getY()
					&&this.getY()<=metal.getY()+40)
					return true;
				
				if(this.getX()+60>=metal.getX()
						&&this.getX()+60<=metal.getX()+40
						&&this.getY()+40>=metal.getY()
						&&this.getY()+40<=metal.getY()+40)
						return true;	
			}
			break;
		case 2:
			for(int i =0;i<metals.size();i++) {
				
				Metal metal = metals.get(i);
				
				if(this.getX()>=metal.getX()
					&&this.getX()<=metal.getX()+40
					&&this.getY()+60>=metal.getY()
					&&this.getY()+60<=metal.getY()+40)
					return true;
				
				if(this.getX()+40>=metal.getX()
						&&this.getX()+40<=metal.getX()+40
						&&this.getY()+60>=metal.getY()
						&&this.getY()+60<=metal.getY()+40)
						return true;	
			}
			break;
		case 3:
			for(int i =0;i<metals.size();i++) {
				
				Metal metal = metals.get(i);
				
				if(this.getX()+60>=metal.getX()
					&&this.getX()+60<=metal.getX()+40
					&&this.getY()>=metal.getY()
					&&this.getY()<=metal.getY()+40)
					return true;
			
				if(this.getX()>=metal.getX()
						&&this.getX()<=metal.getX()+40
						&&this.getY()+40>=metal.getY()
						&&this.getY()+40<=metal.getY()+40)
						return true;	
			}
			break;
		}
		return false;
	}
	
	public boolean isTouchHero() {
		switch(this.getDirect()){
		case 0:
			
			
					if(MyPanel.hero.getDirect() == 0 || MyPanel.hero.getDirect() == 2) {
						if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +40
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
						if(this.getX() + 40 >= MyPanel.hero.getX() 
								&& this.getX() + 40 <= MyPanel.hero.getX() +40
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
					}
					
                    if(MyPanel.hero.getDirect() == 1 || MyPanel.hero.getDirect() == 3) {
                    	if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +60
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	if(this.getX() + 40 >= MyPanel.hero.getX() 
								&& this.getX() + 40 <= MyPanel.hero.getX() +60
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	
						
					}
					
			
			break;
			
		case 1:
			
			
					if(MyPanel.hero.getDirect() == 0 || MyPanel.hero.getDirect() == 2) {
						if(this.getX() + 60 >= MyPanel.hero.getX() 
								&& this.getX() + 60 <= MyPanel.hero.getX() +40
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
						if(this.getX() + 60 >= MyPanel.hero.getX() 
								&& this.getX() + 60 <= MyPanel.hero.getX() +40
								&& this.getY() + 40 >= MyPanel.hero.getY() 
								&& this.getY() + 40 <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
					}
					
                    if(MyPanel.hero.getDirect() == 1 || MyPanel.hero.getDirect() == 3) {
                    	if(this.getX() + 60 >= MyPanel.hero.getX() 
								&& this.getX()+ 60 <= MyPanel.hero.getX() +60
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	if(this.getX() + 60 >= MyPanel.hero.getX() 
								&& this.getX() + 60 <= MyPanel.hero.getX() +60
								&& this.getY() + 40 >= MyPanel.hero.getY() 
								&& this.getY() + 40 <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	
						
					}
					
			
			
			
			break;
			
		case 2:
			
			
					if(MyPanel.hero.getDirect() == 0 || MyPanel.hero.getDirect() == 2) {
						if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +40
								&& this.getY() + 60 >= MyPanel.hero.getY() 
								&& this.getY() + 60 <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
						if(this.getX() + 40 >= MyPanel.hero.getX() 
								&& this.getX() + 40 <= MyPanel.hero.getX() +40
								&& this.getY() + 60 >= MyPanel.hero.getY() 
								&& this.getY() + 60 <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
					}
					
                    if(MyPanel.hero.getDirect() == 1 || MyPanel.hero.getDirect() == 3) {
                    	if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +60
								&& this.getY() + 60 >= MyPanel.hero.getY() 
								&& this.getY() + 60 <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	if(this.getX() + 40 >= MyPanel.hero.getX() 
								&& this.getX() + 40 <= MyPanel.hero.getX() +60
								&& this.getY() + 60 >= MyPanel.hero.getY() 
								&& this.getY() + 60 <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	
						
					}
					
			
			
			break;
			
		case 3: 
			
			
					if(MyPanel.hero.getDirect() == 0 || MyPanel.hero.getDirect() == 2) {
						if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +40
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
						if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +40
								&& this.getY() + 40 >= MyPanel.hero.getY() 
								&& this.getY() + 40 <= MyPanel.hero.getY() + 60) {
							return true;
						}
						
					}
					
                    if(MyPanel.hero.getDirect() == 1 ||MyPanel.hero.getDirect() == 3) {
                    	if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +60
								&& this.getY() >= MyPanel.hero.getY() 
								&& this.getY() <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	if(this.getX() >= MyPanel.hero.getX() 
								&& this.getX() <= MyPanel.hero.getX() +60
								&& this.getY() + 40 >= MyPanel.hero.getY() 
								&& this.getY() + 40 <= MyPanel.hero.getY() + 40) {
							return true;
						}
                    	
						
					}
					
			
			
			break;
		}
		
		return false;
	}
	
	
	
	


	@Override
	public void run() {
		while(true) {
			
			// see if the shot of an alive enemy tank is 0 and add shot into Vector.
			
			if(isLive && shots.size() < 6) {
				Shot s = null;
				switch(getDirect()) {
				case 0:
					s = new Shot(getX() + 20, getY(), 0);
					break;
				case 1:
					s = new Shot(getX() + 60, getY()+ 20, 1);
					break;
				case 2:
					s = new Shot(getX() + 20, getY()+ 60, 2);
					break;
				case 3:
					s = new Shot(getX(), getY()+ 20, 3);
					break;
				}
				
				shots.add(s);
				
				new Thread(s).start();
			}
			
			// enemy tanks continue move according to their initial directions.
		
			switch(getDirect()) {
			case 0: // up direction. keep on move 30 steps.
				for(int i = 0; i < 30; i++) {
					if(getY() > 0 && !isTouchEnemyTank() && !isTouchWood() && !isTouchMetal() && !isTouchHero()) {
				moveUp();
					}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				}
				break;
			case 1: // right direction
				for(int i = 0; i < 30; i++) {
					if(getX() + 60 < 1000 && !isTouchEnemyTank() && !isTouchWood() && !isTouchMetal() && !isTouchHero()) {
				moveRight();
					}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				}
				break;
			case 2: // down direction
				for(int i = 0; i < 30; i++) {
					if(getY() + 60 < 750 && !isTouchEnemyTank() && !isTouchWood() && !isTouchMetal() && !isTouchHero()) {
				moveDown();
					}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				}
				break;
			case 3: // left direction.
				for(int i = 0; i< 30; i++) {
					if(getX() > 0 && !isTouchEnemyTank() && !isTouchWood() && !isTouchMetal() && !isTouchHero()) {
				moveLeft();	
					}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				}
				break;
				
			}
		
			
			// sleep for 50 ms.
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
			// change directions randomly.
			setDirect((int)(Math.random() * 4));
			
			// end the thread.
			
			if(!isLive) {
				break;
			}
			
			
			
		}
	}

}
