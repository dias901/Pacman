package pacman;

import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Player extends Rectangle{

	public boolean up,right,left,down;
	public int spd = 10;
	public int animation_right =0, animation_left=0;
	public int frame_right=0, target_right=10;
	public int frame_left=0, target_left=10;
	public int dir=1;
	public Position player_position;
	
	public Player(int x, int y) {
		super(x,y,45,45);
	}
	
	public Position range(int a, int b) {
		Position p = new Position(a,b);
		if(right) {
			a+=45;
		}
		if(left) {
			a-=45;
		}
		if(up) {
			b-=45;
		}
		if(down) {
			b+=45;
		}
		boolean question = World.tile(a, b);
		if(question) {
		p = new Position(a,b);
		}
		return p;
	}
	
	public void movimento() {
		Position pp = range(x,y);
		x=pp.x;
		y=pp.y;
	}
	
	public void anima() {
		if(right && !left) {dir = 1;frame_right++;
			if(frame_right==target_right) {frame_right=0; animation_right++;
			if(animation_right==Spritesheet.player_right.length) {animation_right=0;}}}
		
		if(left && !right) {dir=2;frame_left++;
			if(frame_left==target_left) {frame_left=0;animation_left++;
			if(animation_left==Spritesheet.player_left.length) {animation_left=0;}}}
		
		if(up) {
			if(dir==1) {frame_right++;
				if(frame_right==target_right) {frame_right=0;animation_right++;
				if(animation_right==Spritesheet.player_right.length) {animation_right=0;}}}
			if(dir==2) {frame_left++;
			if(frame_left==target_left) {frame_left=0;animation_left++;
				if(animation_left==Spritesheet.player_left.length) {animation_left=0;}}}}
		
		if(down) {
			if(dir==1) {frame_right++;
				if(frame_right==target_right) {frame_right=0;animation_right++;
				if(animation_right==Spritesheet.player_right.length) {animation_right=0;}}}
			if(dir==2) {frame_left++;
				if(frame_left==target_left) {frame_left=0;animation_left++;
				if(animation_left==Spritesheet.player_left.length) {animation_left=0;}}}}
	}
	
	public void tick() {
		anima();
		movimento();
			}
	
	public void render(Graphics g) {
		if(dir==1 && !right && !left && !up && !down) {
			g.drawImage(Spritesheet.player_right[0],x,y,45,45,null);
		}
		if(dir==2 && !right && !left && !up && !down) {
			g.drawImage(Spritesheet.player_left[0],x,y,45,45,null);
		}
		
		if(right) {
			g.drawImage(Spritesheet.player_right[animation_right],x,y,45,45,null);
		}else if(left) {
			g.drawImage(Spritesheet.player_left[animation_left],x,y,45,45,null);
		}
		
		if(dir==1 && up) {
			g.drawImage(Spritesheet.player_right[animation_right],x,y,45,45,null);
		}else if(dir==2 && up) {
			g.drawImage(Spritesheet.player_left[animation_left],x,y,45,45,null);
		}
		
		if(dir==1 && down) {
			g.drawImage(Spritesheet.player_right[animation_right],x,y,45,45,null);
		}else if(dir==2 && down) {
			g.drawImage(Spritesheet.player_left[animation_left],x,y,45,45,null);
		}
		
	}
}
