package pacman;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {
	
	public static List<Block> bloco = new ArrayList<>();
	int[] vetor = {0,45,90,135,180,225,270,315,360,405,450,495,540,585,630};
	public static Position[] pos = new Position[]{pose(90,0),pose(540,0),pose(0,90),pose(0,540),pose(90,630),pose(540,630),pose(630,540),pose(630,90)};
	public static List<Position> pos1 = new ArrayList<>(Arrays.asList(pos));
	
	public World() {
				inicializar();
	}
	
	public void mapa(int x, int y,int z) {
			bloco.add(new Block(x,y,45,45,z));
	}
	
	public static Position pose(int x, int y) {
		return new Position(x,y);
	}
	
	public void bloco1() {
		int x,y;
		x=45;y=45;
		for(int i=0;i<13;i++) {pos1.add(new Position(x,y));x+=45;}
		x=45;y=90;
		for(int q=0;q<2;q++) {
			for(int i=0;i<4;i++) {pos1.add(new Position(x,y));x+=180;}
			x=45;y+=45;}
		
		x=45;y=180;
		for(int i=0;i<13;i++) {pos1.add(new Position(x,y));x+=45;}
		x=45;y=225;
		for(int q=0;q<2;q++) {
			for(int i=0;i<4;i++) {pos1.add(new Position(x,y));x+=180;}
			x=45;y+=45;}

		x=45;y=315;
		for(int i=0;i<13;i++) {pos1.add(new Position(x,y));x+=45;}
		x=45;y=360;
		for(int q=0;q<2;q++) {
			for(int i=0;i<4;i++) {pos1.add(new Position(x,y));x+=180;}
			x=45;y+=45;}
		
		x=45;y=450;
		for(int i=0;i<13;i++) {pos1.add(new Position(x,y));x+=45;}
		x=45;y=495;
		for(int q=0;q<2;q++) {
			for(int i=0;i<4;i++) {pos1.add(new Position(x,y));x+=180;}
			x=45;y+=45;}
		
		x=45;y=585;
		for(int i=0;i<13;i++) {pos1.add(new Position(x,y));x+=45;}
		
	}
		
	public static boolean tile(int x, int y) {
		String cc = pose(x,y).toString();
		boolean question=false;
		for(Position z: pos1) {
			String zeto = z.toString();
			if(zeto.equals(cc)) {
				question= true;
				break;
			}
		}
		return question;
	}
		
	public void inicializar() {
		bloco1();
		for(int q=0;q<15;q++) {
			for(int i=0;i<15;i++) {
				boolean question = tile(vetor[i],vetor[q]);
					if(question){mapa(vetor[i],vetor[q],2);}else {mapa(vetor[i],vetor[q],1);}}}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<bloco.size();i++) {bloco.get(i).render(g);}
	}
}

