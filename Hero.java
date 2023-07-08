package tankgame;

import java.util.Vector;

public class Hero extends Tank {
	
	
	Shot shot = null;
	
	Vector<Shot> shots = new Vector<>();
	Vector<EnemyTank> enemyTanks = new Vector<>();
	Vector<Wood> woods= new Vector<>();
	Vector<Metal> metals= new Vector<>();
	
	public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		this.enemyTanks = enemyTanks;
	}
	public void setWoods(Vector<Wood> woods) {
		this.woods = woods;
	}
	public void setMetals(Vector<Metal> metals) {
		this.metals = metals;
	}

	
	
	

	public Hero(int x, int y) {
		super(x, y);
		
	}
	
	public boolean isTouchEnemyTank() {
		switch(this.getDirect()){
		case 0:
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
				
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
			break;
			
		case 1:
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
				
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
			
			
			break;
			
		case 2:
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
			
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
			
			break;
			
		case 3: 
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank  enemyTank = enemyTanks.get(i);
			
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
	
	public void shotEnemyTank() {
		// the maximum shots on the screen is 6.
		if(shots.size() == 6) {
			return;
		}
		
		switch(getDirect()) { // direction of my tank.
		
		case 0: // up direction.
			shot = new Shot(getX() + 20, getY(), 0);
			break;
			
		case 1: // right direction.
			shot = new Shot(getX() + 60, getY() + 20, 1);
			break;
			
		case 2: // down direction.
			shot = new Shot(getX() + 20, getY() + 60, 2);
			break;
			
		case 3: // left direction.
			shot = new Shot(getX(), getY() + 20, 3);
			break;
		
		}
		// put shot into shots
		shots.add(shot);
		
		
		// start shot.
		
		new Thread(shot).start();
	}

}
