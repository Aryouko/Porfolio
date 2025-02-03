/**
*Programme qui demande deux valeurs tant qu'elles ne sont pas strictement supérieur à zéro
* et qui renvoie leur PGCD
*@author L.Carré
*/
class PGCDDoWhile {
	void principal(){
		int val1;
		int val2;
		
		do {
			val1 = SimpleInput.getInt ("Première valeur (strictement positif) : ");
		} while (val1 <= 0);
		
		do {
			val2 = SimpleInput.getInt ("Deuxième valeur (strictement positif): ");
		} while (val2 <=0);
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
			} else {
				val2 = val2 - val1;
			}
		}
		System.out.println("Le PGCD de ces deux valeurs est : " + val1);
	}
}
