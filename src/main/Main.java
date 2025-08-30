package main;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Dwarf Adventure");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack();  // Causes the Window to be sized to fit the pref. size and layouts
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
			
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	} 

}
