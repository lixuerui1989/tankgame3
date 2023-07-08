package tankgame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

import javax.swing.JFrame;

public class BSTankGame extends JFrame {
	MyPanel mp = null;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
				
		BSTankGame BSTankGame = new BSTankGame();
		
	}
	
	public BSTankGame() {
		System.out.println("Please input 1: new game or 2: continue the previous game");
		String key = scanner.next(); 
		mp = new MyPanel(key);
		// put mp to Thread and start.
		Thread thread = new Thread(mp);
		thread.start();
		
		this.add(mp);
		
		this.setSize(1500, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(mp);
		
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Recorder.keepRecord();
				Recorder.keepRecord2();
				System.exit(0);
			}
		});
	}

}
