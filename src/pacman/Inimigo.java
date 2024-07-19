package pacman;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

@SuppressWarnings("serial")
public class Inimigo extends Rectangle{

	public int x,y,z;
	Position position;
	
	public Inimigo(int x, int y) {
		super(x,y,45,45);
		this.x=x;
		this.y=y;
		z=escolha();
	}
	
	public int escolha() {
		Random random = new Random();
		int u = random.nextInt(105);
		return u;
	}
	
	public boolean Escolher(Position position) {
		String cc = position.toString();
		boolean question=false;
		for(Position z: World.pos1) {
			String zeto = z.toString();
			if(zeto.equals(cc)) {
				question= true;
				break;
			}
		}
		return question;
	}
	
	public void tick() {
		position=World.pos1.get(z);
		if(x==position.x && y==position.y) {
			z=escolha();
			System.out.println("foi");
		}
		
		if(x<position.x) {
			int w=x;
			x+=45;
			if(!Escolher(new Position(x,y))) {
			x=w;
			}
		}else if(x>position.x){
			int w = x;
			x-=45;
			if(!Escolher(new Position(x,y))) {
				x=w;
				}
		}
		if(y>position.y) {
			int w=y;
			y-=45;
			if(!Escolher(new Position(x,y))) {
				y=w;;
				}
			
		}else if(y<position.y){
			int w=y;
			y+=45;
			if(!Escolher(new Position(x,y))) {
				y=w;
				}
		}
		
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.inimigo,x,y,45,45,null);
	}
}
