package pacman;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable, KeyListener{

	public static int WIDTH = 675, HEIGHT = 675;
	public static Player player;
	public static World world;
	public static Inimigo inimigo,inimigo2;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		new Spritesheet();
		player = new Player(315,315);
		inimigo = new Inimigo(45,45);
		inimigo2 = new Inimigo(585,585);
		world = new World();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;			
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0,0,WIDTH, HEIGHT);
		
		world.render(g);
		player.render(g);
		inimigo.render(g);
		inimigo2.render(g);
		
		bs.show();
	}
	
	public void tick() {
		player.tick();
		inimigo.tick();
		inimigo2.tick();
	}
	
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Pacman");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		Thread t1 = new Thread(game);
		t1.start();
	}

	@Override
	public void run() {
		requestFocus();
	
		while (true) {
			tick();
			render();
			
			try {
				Thread.sleep(10000/80);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}	
}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right=true;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up=true;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right=false;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up=false;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down=false;
		}
	}

}