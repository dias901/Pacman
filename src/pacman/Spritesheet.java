package pacman;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage[] player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage parede;
	public static BufferedImage tile;
	public static BufferedImage inimigo;
	
	public Spritesheet() {
		try {
			parede = ImageIO.read(getClass().getResource("/parede.png"));
			tile = ImageIO.read(getClass().getResource("/Tile.png"));
			
			inimigo = ImageIO.read(getClass().getResource("/ghost1.png"));
			
			player_right = new BufferedImage[2];
			player_right[0] = ImageIO.read(getClass().getResource("/pacman1.png"));
			player_right[1] = ImageIO.read(getClass().getResource("/pacman3.png"));
			
			player_left = new BufferedImage[2];
			player_left[0] = ImageIO.read(getClass().getResource("/pacman2.png"));
			player_left[1] = ImageIO.read(getClass().getResource("/pacman3.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
