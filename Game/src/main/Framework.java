package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Framework extends Thread {
	
	public static final int WIDTH = 800, HEIGHT = 600; // The dimensions of the canvas.
	
	protected static JFrame frame; // The window frame that the game will be contained in.
	protected static Canvas canvas; // The drawing area that all things are rendered to.
	
	private static boolean running;
	private static double fps = 60.0;
	
	public Framework() {
		frame = new JFrame();
		canvas = new Canvas();
		frame.add(canvas);
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		running = true;
		start();
	}
	
	@Override
	public void run() {
		long now = System.nanoTime(), then = now;
		double nsPerTick = 1000000000.0d / fps;
		double updateQueue = 0.0d;
		boolean canRender = false;
		
		int updates = 0, frames = 0;
		long lastTime = System.currentTimeMillis();
		
		while(running) {
			now = System.nanoTime();
			updateQueue += (now - then) / nsPerTick;
			then = now;
			
			while(updateQueue >= 1) {
				updateQueue--;
				update();
				updates++;
				canRender = true;
			}
			
			if(canRender) {
				if(canvas.getBufferStrategy() == null) {
					canvas.createBufferStrategy(2);
				} else {
					BufferStrategy bs = canvas.getBufferStrategy(); // Used to have more control over the way that canvas renders.
					Graphics g = bs.getDrawGraphics();
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, WIDTH, HEIGHT);
					render(g);
					bs.show();
					frames++;
					canRender = false;
				}
			}

			if(System.currentTimeMillis() - lastTime >= 1000) {
				lastTime += 1000;
				System.out.printf("Updates: %d Frames: %d\n", updates, frames);
				updates = 0;
				frames = 0;
			}
		}
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
}
