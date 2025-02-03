/**
*Programme demandant à l'utilisateur de saisir un nbr et l'affiche tant qu'il n'est pas égale à -1
*@author L.Carré
*/
class SuiteNbrWhile {
	void principal(){
		int nbr;
		nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		while (nbr != -1) {
			System.out.println(nbr);
			nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		}
		System.out.println("Fin");
	}
}
