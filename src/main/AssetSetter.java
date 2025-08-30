package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	
	
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Key();  // BY THE BEACH
		gp.obj[0].worldX = 38 * gp.tileSize;
		gp.obj[0].worldY = 41 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key(); // LITTLE BUILDING
		gp.obj[1].worldX = 27 * gp.tileSize;
		gp.obj[1].worldY = 23 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key(); // BIG BUILDING
		gp.obj[2].worldX = 18 * gp.tileSize;
		gp.obj[2].worldY = 7 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Door(); 
		gp.obj[3].worldX = 40 * gp.tileSize;
		gp.obj[3].worldY = 9 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldX = 18 * gp.tileSize;
		gp.obj[4].worldY = 10 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Door(); 
		gp.obj[5].worldX = 26 * gp.tileSize;
		gp.obj[5].worldY = 25 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Chest(); // STUMP LOCATION
		gp.obj[6].worldX = 45 * gp.tileSize; 
		gp.obj[6].worldY = 9 * gp.tileSize; 
		
		gp.obj[7] = new OBJ_Boots();
		gp.obj[7].worldX = 40 * gp.tileSize;
		gp.obj[7].worldY = 41 * gp.tileSize;

	}
}
