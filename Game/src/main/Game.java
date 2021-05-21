package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Framework implements KeyListener {
	
	private GameMap map;
	private Player player;
	
	public Game() {
		super();
		canvas.addKeyListener(this);
		
		map = new GameMap(100, 0, 6, "res/test_map_1.png");
		player = new Player(0, 0, 1);
	}
	
	@Override
	public void update() {
		player.update();
	}
	
	@Override
	public void render(Graphics g) {
		map.draw(g);
		player.draw(g);
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
			Player.playerKeys[Player.P_UP] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			Player.playerKeys[Player.P_LEFT] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			Player.playerKeys[Player.P_DOWN] = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			Player.playerKeys[Player.P_RIGHT] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			Player.playerKeys[Player.P_UP] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			Player.playerKeys[Player.P_LEFT] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			Player.playerKeys[Player.P_DOWN] = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			Player.playerKeys[Player.P_RIGHT] = false;
		}
	}
}
