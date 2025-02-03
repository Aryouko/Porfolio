/**
*Programme qui demande deux valeurs tant qu'elles ne sont pas strictement supérieur à zéro
* et qui renvoie leur PGCD
*@author L.Carré
*/
class PGCDWhile {
	void principal(){
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt ("Première valeur (strictement positif) : ");
		
		while (val1 <= 0) {
			val1 = SimpleInput.getInt ("Première valeur (strictement positif) : ");
		}
		
		val2 = SimpleInput.getInt ("Deuxième valeur (strictement positif): ");
		
		while (val2 <=0) {
			val2 = SimpleInput.getInt ("Deuxième valeur (strictement positif): ");
		}
		
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
