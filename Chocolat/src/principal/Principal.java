package principal;

public class Principal {

	
	public static int boucleDeJeu(Chocolat vanilla) {
		int joueur = 1;
		int choice,nb;
		String choiceS;
		while (!vanilla.peutManger().isEmpty()) {
			
			//System.out.println("Debug :"+vanilla);
			
			System.out.println(vanilla.displayChocolat());
			System.out.println("Joueur "+joueur + ", A vous de jouer !");
			
			System.out.println(vanilla.peutManger());
			System.out.println("PAR QUEL BOUT? (0-"+(vanilla.peutManger().size()-1)+")");
			
			
			choice = ScannerInt.readIntZero(vanilla.peutManger().size());
			choiceS = vanilla.peutManger().get(choice); 
			System.out.println("Choix : ["+choiceS+"]");
			
			//System.out.println("Debug :"+vanilla);
			
			System.out.println("ET COMBIEN DE RANGEES? (1-" + vanilla.mangerMax(choiceS)+")");
			nb = ScannerInt.readInt(vanilla.mangerMax(choiceS)+1);
			
			//System.out.println("Debug :"+vanilla);
			
			vanilla.manger(choiceS, nb);
			System.out.println("===============================================================");
			System.out.println("===============================================================");
			System.out.println("BIEN BIEN BIEN, AU SUIVANT");

			if (joueur == 1)
				joueur = 2;
			else
				joueur = 1;
		}
		return joueur;
	}
	
	public static void main (String [] args) {
		System.out.println("Avant de commencer, saisissez les données X (1-20)");
		int x = ScannerInt.readInt(21);
		int rnPosX = (int )(Math.random() * x);
		
		
		System.out.println("Et les données Y ?(1-20)");
		int y = ScannerInt.readInt(21);
		int rnPosY = (int )(Math.random() * y);
		
		Chocolat vanilla = new Chocolat(x,y,rnPosX, rnPosY);
		
		System.out.println("QUE LE JEU DE LA MORT COMMENCE (avec du chocolat)");
		
		int vainqueur = boucleDeJeu(vanilla);
		System.out.println("LE JOUEUR "+ vainqueur + " A PERDU ! \nIL VA MORDRE LA POUSSIERE AVEC DU CHOCOLAT");
		System.out.println("AHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAH");
	}
}
