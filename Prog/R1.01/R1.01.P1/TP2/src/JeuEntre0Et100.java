/**
*Programme qui choisit un nombre entre 0 et 100 et demande à
*l'utilisateur de deviner le nombre tant qu'il ne l'a pas trouvé
*@author L.Carré
*/
class JeuEntre0Et100{
	void principal(){
		int nbrRecherche = (int) (Math.random() * 100);
		int nbrUser = SimpleInput.getInt("Nombre entre 0 et 100 ");
		int essaies = 1;
		
		while (nbrUser != nbrRecherche) {
			if (nbrUser < nbrRecherche) {
				System.out.println("Trop petit !");
			} else {
				System.out.println("Trop grand !");
			}
			nbrUser = SimpleInput.getInt("Nombre entre 0 et 100 ");
			essaies += 1;
		}
		System.out.println("Vous avez trouvé le nombre en " + essaies + " essaies");
	}
}
