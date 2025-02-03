/**
*Programme demandant à l'utilisateur de saisir un nbr et l'affiche tant qu'il n'est pas égale à -1
et renvoie la moyenne quand -1 est entré
*@author L.Carré
*/
class SuiteNbrMoyenne {
	void principal(){
		int nbr, cpt, somme;
		nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		somme = 0;
		cpt = 0;
		while (nbr != -1) {
			System.out.println(nbr);
			somme += nbr;
			cpt += 1;
			nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		}
		if (cpt == 0) {
			System.out.println("Il n'y a pas assez de notes pour calculer la moyenne");
		} else {
			System.out.println("Fin, la moyenne de la suite de nombre est " + (double) somme/cpt);
		}
	}
}
