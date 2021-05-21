package main;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public int x, y, speed, scale;
	
	public static boolean playerKeys[];
	public static final int P_UP = 0, P_LEFT = 1, P_DOWN = 2, P_RIGHT = 3;
	
	public Player(int x, int y, int scale) {
		this.x = x;
		this.y = y;
		this.scale = scale;
		playerKeys = new boolean[4];
		speed = 3;
	}
	
	public void update() {
		if(playerKeys[P_UP]) {
			y -= speed;
		}
		if(playerKeys[P_LEFT]) {
			x -= speed;
		}
		if(playerKeys[P_DOWN]) {
			y += speed;
		}
		if(playerKeys[P_RIGHT]) {
			x += speed;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x - 10, y - 10, 20, 20); // Test.
	}
}
