/**
*Programme qui demande une valeur tant qu'elle n'est pas inférieur à celle d'avant
*@author L.Carré
*/
class NbrInferieur {
	void principal(){
		int val1, val2;
		val2 = SimpleInput.getInt ("Première valeur : ");
		
		do {
			val1 = val2;
			val2 = SimpleInput.getInt ("Valeur suivante: ");
		} while (val1 <= val2);
		
		System.out.println("La valeur était inférieur à la précédente");
	}
}
