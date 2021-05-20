package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameMap {
	
	private int x, y, mapScale; // Map Dimensions and position.
	private BufferedImage map; // The map image file.
	
	public GameMap(int x, int y, int scale, String filename) {
		this.x = x;
		this.y = y;
		mapScale = scale;
		try {
			map = ImageIO.read(new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean onMap(int xPos, int yPos) {
		if(xPos >= x && xPos <= x + map.getWidth() * mapScale && yPos >= y && yPos <= y + map.getHeight() * mapScale) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(map, x, y, map.getWidth() * mapScale, map.getHeight() * mapScale, null);
	}
	
	public BufferedImage getMapImage() {
		return map;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return map.getWidth();
	}
	
	public int getHeight() {
		return map.getHeight();
	}
	
	public int getMapScale() {
		return mapScale;
	}
}
