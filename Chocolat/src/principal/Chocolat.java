package principal;

import java.util.ArrayList;
import java.util.List;

public class Chocolat {

	
	private int longX;
	private int longY;
	private int posX;
	private int posY;
	
	public Chocolat (int longX, int longY, int posX, int posY) {
		this.longX = longX;
		this.longY = longY;
		this.posX = posX;
		this.posY = posY;
	}
	
	public String toString () {
		return "("+this.longX+","+this.longY+","+this.posX+","+this.posY+")";
	}
	public String displayChocolat() {
		String display = "";
		
		for( int x = 0 ; x < (longX*2+1) ; x++) {
			display += "-";
		}
		display += "\n";
		
		for( int y = 0 ; y < longY ; y++) {
			display += "|";
			for (int x = 0 ; x < longX ; x++) {
				if ((x == posX) && (y == posY))
					display += "X|";
				else 
					display += "-|";
			}
			display += "\n";
		}
		for( int x = 0 ; x < (longX*2+1) ; x++) {
			display += "-";
		}
		
		return display + "\n";
	}
	
	/*----------------------------------------*/
	
	public void manger(String s, int nb) {
		switch(s) {
		case "Haut" :
			mangerHaut(nb);
			break;
		case "Bas" :
			mangerBas(nb);
			break;
		case "Gauche" :
			mangerGauche(nb);
			break;
		case "Droite" :
			mangerDroite(nb);
			break;
		}
	}
	
	private void mangerDroite(int nb){
		this.longX -= nb;
	}
	
	private void mangerGauche(int nb){
		this.longX -= nb;
		this.posX -= nb;
	}
	
	private void mangerHaut(int nb){
		this.longY -= nb;
		this.posY -= nb;
	}
	
	private void mangerBas(int nb) {
		this.longY -= nb;
	}
	
	
	/*-----------------------------------*/
	public List<String> peutManger () {
		List<String> l = new ArrayList<String>();
		if (this.posY > 0)
			l.add("Haut");
		if (this.longY > this.posY+1)
			l.add("Bas");
		if (this.posX > 0)
			l.add("Gauche");
		if (this.longX > this.posX+1)
			l.add("Droite");
			
		return l;
	}
	/*-----------------------------------*/
	
	public int mangerMax(String s) {
		int nb = -1;
		switch(s) {
			case "Haut" :
				nb = posY;
				break;
			case "Bas" :
				nb = this.longY - (this.posY+1);
				break;
			case "Gauche" :
				nb = posX;
				break;
			case "Droite" :
				nb = this.longX - (this.posX+1);
				break;
		}
			
		return nb;
	}
	
	
}
