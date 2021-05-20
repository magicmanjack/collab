package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Game extends Framework implements KeyListener {
	
	private static GameMap map;
	private static boolean[] playerKeys = new boolean[4];
	private static final int P_UP = 0, P_LEFT = 1, P_DOWN = 2, P_RIGHT = 3;
	
	private static int x = 0, y = 0, speed = 3;
	
	public Game() {
		super();
		canvas.addKeyListener(this);
		
		map = new GameMap(100, 0, 6, "res/test_map_1.png");
	}
	
	@Override
	public void update() {
		if(playerKeys[P_UP]) {
			y -= speed;
			if(map.onMap(x, y - speed) && map.getMapImage().getRGB((x - map.getX()) / map.getMapScale(), (y - map.getY() - speed) / map.getMapScale()) == Color.red.getRGB()) {
				y += speed;
			}
		}
		if(playerKeys[P_LEFT]) {
			x -= speed;
			if(map.onMap(x - speed, y) && map.getMapImage().getRGB((x - map.getX() - speed) / map.getMapScale(), (y - map.getY()) / map.getMapScale()) == Color.red.getRGB()) {
				x += speed;
			}
		}
		if(playerKeys[P_DOWN]) {
			y += speed;
			if(map.onMap(x, y + speed) && map.getMapImage().getRGB((x - map.getX()) / map.getMapScale(), (y - map.getY() + speed) / map.getMapScale()) == Color.red.getRGB()) {
				y -= speed;
			}
		}
		if(playerKeys[P_RIGHT]) {
			x += speed;
			if(map.onMap(x + speed, y) && map.getMapImage().getRGB((x - map.getX() + speed) / map.getMapScale(), (y - map.getY()) / map.getMapScale()) == Color.red.getRGB()) {
				x -= speed;
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		map.draw(g);
		g.setColor(Color.BLUE);
		g.fillRect(x - 10, y - 10, 20, 20);
	}
	
	public static void main(String[] args) {
		System.out.println("Game started!");
		new Game(); 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			playerKeys[P_UP] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			playerKeys[P_LEFT] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			playerKeys[P_DOWN] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			playerKeys[P_RIGHT] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			playerKeys[P_UP] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			playerKeys[P_LEFT] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			playerKeys[P_DOWN] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			playerKeys[P_RIGHT] = false;
		}
	}
}
