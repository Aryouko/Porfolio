/**
*Programme qui devine le nombre choisit par l'utilisateur
*en choisissant un nombre aléatoire tant qu'il n'est pas trouvé
*@author L.Carré
*/
class JeuEntre0Et1000{
	void principal(){
		int min = 0;
		int max = 1000;
		int nbrRecherche = min + (int) (Math.random() * max);
		System.out.println("Ton nombre choisit (si tu t'en souviens plus) : " + SimpleInput.getInt("Ton nombre "));
		char repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
		
		while (repUser != '=') {
			if (repUser == '+') {
				min = nbrRecherche + 1;
			} else if (repUser == '-') {
				max = nbrRecherche;
			}
			nbrRecherche = min + (int) (Math.random() * (max - min));
			repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
		}
		System.out.println("L'ordinateur a trouvé le nombre " + nbrRecherche);
	}
}
