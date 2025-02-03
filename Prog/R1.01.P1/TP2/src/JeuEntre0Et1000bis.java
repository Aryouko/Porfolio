/**
*Programme qui devine le nombre choisit par l'utilisateur
*en choisissant un nombre aléatoire tant qu'il n'est pas trouvé
*et trouve le chiffre si sa valeur supérieur et inférieur on été proposé
*@author L.Carré
*/
class JeuEntre0Et1000bis{
	void principal(){
		int min = 0;
		int max = 1000;
		int minPc = -1; //Pour le cas de 0 qui est compris en -1 et 1
		int nbrRecherche = min + (int) (Math.random() * max);
		System.out.println("Ton nombre choisit (si tu t'en souviens plus) : " + SimpleInput.getInt("Ton nombre "));
		char repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
		
		while (repUser != '=') {
			if (repUser == '+') {
				min = nbrRecherche + 1;
				minPc = nbrRecherche;
			} else if (repUser == '-') {
				max = nbrRecherche;
			}
			nbrRecherche = min + (int) (Math.random() * (max - min));
			if ((nbrRecherche == max - 1) && (nbrRecherche == minPc + 1)) {
				repUser = '=';
			} else {
				repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
			}
		}
		System.out.println("L'ordinateur a trouvé le nombre " + nbrRecherche);
	}
}
