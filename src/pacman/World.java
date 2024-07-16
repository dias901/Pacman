package pacman;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {
	
	public static List<Block> bloco = new ArrayList<>();
	
	public World() {
				inicializar();
	}
	
	public void mapa(int x, int y,int z) {
		bloco.add(new Block(x,y,45,45,z));
	}
	
	public Position pose(int x, int y) {
		return new Position(x,y);
	}
	public boolean tile(int x, int y) {
		Position[] pp = new Position[]{pose(90,0),pose(540,0),pose(0,90),pose(0,540),pose(90,630),pose(540,630),pose(630,540),pose(630,90)};
		String cc = pose(x,y).toString();
		boolean question=false;
		for(Position z: pp) {
			String zeto = z.toString();
			if(zeto.equals(cc)) {
				question= true;
				break;
			}
		}
		return question;
	}
		
	public void inicializar() {
		int[] vetor = {0,45,90,135,180,225,270,315,360,405,450,495,540,585,630};
		for(int q=0;q<15;q++) {
			for(int i=0;i<15;i++) {
				boolean question = tile(vetor[i],vetor[q]);
					if(question){
						mapa(vetor[i],vetor[q],3);
					}else {
						mapa(vetor[i],vetor[q],1);
					}
			}
		}
		
	}
	
	public void render(Graphics g) {
		for(int i=0; i<bloco.size();i++) {bloco.get(i).render(g);}
	}
}

