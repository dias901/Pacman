package pacman;

import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Block extends Rectangle{

	public int z, wid, hei;
	
	public Block(int x, int y,int wid,int hei, int z) {
		super(x,y,wid,hei);
		this.z=z;
		this.wid=wid;
		this.hei=hei;
	}
	
	public void render(Graphics g) {
		if(z==1) {
			g.drawImage(Spritesheet.parede, x, y, 45, 45, null);
		}
		
		if(z==2) {
			g.drawImage(Spritesheet.tile,x,y,45,45,null);
		}
	}
}
