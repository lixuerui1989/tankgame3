package tankgame;

public class Shot implements Runnable {
	
	int x;
	int y;
	int direct = 0;
	int speed = 24;
	boolean isLive = true;
	
	public Shot(int x, int y, int direct) {
		super();
		this.x = x;
		this.y = y;
		this.direct = direct;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			switch(direct){
			
			case 0: // up direction.
				y -= speed;
				break;
				
			case 1: // right direction.
				x += speed;
				break;
				
			case 2: // down direction.
				y += speed;
				break;
				
			case 3: // left direction.
				x -= speed;
				break;
			
			}
			System.out.println("bullet x = " + x + " y= " + y);
			
			// shot should be end if meet boundary or enemy tanks.
			
			if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
				isLive = false;
				break;// reach boundary.
				
			}
			
		}
		
		
		
		
		
	}

}
