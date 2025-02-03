/**
*Programme demandant à l'utilisateur de saisir un nbr et l'affiche tant qu'il n'est pas égale à -1
*@author L.Carré
*/
class SuiteNbrDoWhile {
	void principal(){
		int nbr;
		do {
			nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
			if (nbr != -1) {
				System.out.println(nbr);
			}
		} while (nbr != -1);
		System.out.println("Fin");
	}
}
