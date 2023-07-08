package tankgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

// record information and interact with I/xsO.

public class Recorder {
	private static int allEnemyTanksNum = 0;
	
	// define I/O, write data  to file(disc).
	
	private static BufferedWriter bw = null;
	private static BufferedReader br = null;
	
	
	private static String recordFile = "src//myRecord.txt";
	private static String recordFile2 = "src//myRecord2.txt";
	
	// define Vector, point to Vector of enemy tanks.
	private static Vector<EnemyTank> enemyTanks = null;
	
	private static Vector<Wood> woods = null;
	
	
	// define a node Vector to store enemy tanks.
	
	private static Vector<Node> nodes = new Vector<>();
	private static Vector<NodeWood> nodes2 = new Vector<>();
	


	public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		Recorder.enemyTanks = enemyTanks;
	}
	
	public static void setWoods(Vector<Wood> woods) {
		Recorder.woods = woods;
	}
	
	public static String getRecorderFile() {
		return recordFile;
	}
	
	public static String getRecorderFile2() {
		return recordFile2;
	}
	
	//add a method to read the file to recovery enemy tanks to continue the previous terminated game.
	public static Vector<Node> getNodesAndEnemyTankRec(){
		try {
			br = new BufferedReader(new FileReader(recordFile));
			allEnemyTanksNum = Integer.parseInt(br.readLine());
			// iterate coordinates of enemy tanks to read each line in the file.
			String line = "";
			while((line = br.readLine()) != null) {
				String[] xyd = line.split(" ");
		Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), 
				Integer.parseInt(xyd[2]));
				nodes.add(node);
				
				
			}
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		return nodes;
	}
	
	//
	public static Vector<NodeWood> getWoodsRec(){
		try {
			br = new BufferedReader(new FileReader(recordFile2));
			
			String line = "";
			while((line = br.readLine()) != null) {
				String[] xyd = line.split(" ");
		NodeWood node2 = new NodeWood(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]));
				nodes2.add(node2);
				
				
			}
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		return nodes2;
	}
	



	// add a method to save allEnemyTanksNum to myRecord file when exit.
	public static void keepRecord() {
	     try {
			bw = new BufferedWriter(new FileWriter(recordFile));
			bw.write(allEnemyTanksNum + "\r\n");
			// iterate enemy tanks from Vector and write to file.
			// OOP, define a property and use set to get the Vector.
			
			for(int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank enemyTank = enemyTanks.get(i);
				if(enemyTank.isLive) {
					String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
					bw.write(record + "\r\n");
				}
			}			
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//
	public static void keepRecord2() {
	     try {
			bw = new BufferedWriter(new FileWriter(recordFile2));
			
			
			for(int i = 0; i < woods.size(); i++) {
				Wood wood = woods.get(i);
				if(wood.isLive) {
					String record = wood.getX() + " " + wood.getY();
					bw.write(record + "\r\n");
				}
			}
							
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	  
	

	public static int getAllEnemyTanksNum() {
		return allEnemyTanksNum;
	}

	public static void setAllEnemyTanksNum(int allEnemyTanksNum) {
		Recorder.allEnemyTanksNum = allEnemyTanksNum;
	}
	
	// when I hit a enemy tank, increment allEnemyTanksNum.
	
	public static void addAllEnemyTanksNum() {
		Recorder.allEnemyTanksNum++;
	}
	
	
	
	
	

}
