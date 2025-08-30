package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{  // using the implement feature to make the game thread work.

	
	// SCREEN SETTINGS
	final int originalTileSize = 16; // mean 16 X 16 tile
	final int scale =3; 
	
	public final int tileSize = originalTileSize * scale; // This integer makes the scale 48 x 48 via x3
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12; // Essentially make the screen size a 4:3 ratio
	public final int screenWidth = tileSize * maxScreenCol; // 48 * 16 = 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 48 * 12 = 576 pixels making game screen 768x576
	
	// WORLD MAP PERIMETERS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	
	// FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler ();
	Sound music = new Sound();
	Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI (this);
	Thread gameThread;    // In-Game Clock system
	
	// ENTITY AND OBJ
	public Player player = new Player(this,keyH);
	public SuperObject obj[] = new SuperObject[10];
	
	
	public GamePanel () {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); //If set true, all the drawings from this component will be done in an off-screen painting buffer
		this.addKeyListener(keyH);  // Can reorganize the key input
		this.setFocusable(true);
		
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		
		playMusic(0);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);  // GamePanel shares to Threads cond.
		gameThread.start();
	}

	@Override
	public void run() {
			
			double drawInterval = 1000000000/FPS;  // = 16,6666,666.66 or .0166666 seconds
			double nextDrawTime = System.nanoTime() + drawInterval; // Single loop is .01666 seconds and redraws
			
			while(gameThread != null) {
			
				update(); 
		
				repaint();
					
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
			
	public void update() {
		
	player.update();
	
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);    // you need this to paint graphics, set by java to make this work.
		Graphics2D g2 = (Graphics2D)g;  //Graphics2D Class extends the Graphics class to provide more sophisticated control over geometry
	
		// TILE
		tileM.draw(g2); // Put above player because its like a layer
		
		// OBJECT
		for(int i = 0; i < obj.length; i++) {
			if(obj [i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		
		// PLAYER
		player.draw(g2);
		
		//UI
		ui.draw(g2);
		
		g2.dispose();  //Dispose of this graphics context and release any system resources that it is using.
	}
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		
		music.stop();
	}
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
	}
}
