/**
*Programme qui test si un nombre entré par l'utilisateur est parfait
*@author L.Carré
*/
class Parfait{
	void principal() {
		testEstParfait();
		System.out.println();
		quatreNbParfaits();
	}	
	
	/**
	* teste la divisibilité de deux entiers
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @return vrai ssi q divise p
	*/
	boolean estDiviseur (int p, int q) {
		boolean res = false;
		if (p%q == 0) {
			res = true;
		}
		return res;
	}
	
	/**
	* Teste la méthode estParfait()
	*/
	void testEstParfait () {
		System.out.println ();
		System.out.println ("*** testEstParfait()");
		
		testCasEstParfait (6, true);
		testCasEstParfait (28, true);
		testCasEstParfait (496, true);
		testCasEstParfait (4, false);
		testCasEstParfait (1, false);
		testCasEstParfait (0, false);
	}
	
	/**
	* teste un appel de estParfait
	* @param a une valeur à tester
	* @param result resultat attendu
	**/
	void testCasEstParfait (int a, boolean result) {
		// Affichage
		System.out.print ("estParfait(" + a + ") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estParfait(a);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste si un nombre est parfait
	* @param a entier positif
	* @return vrai ssi a est un nombre parfait
	*/
	boolean estParfait (int a) {
		boolean res = false;
		int somme = 0;
		for (int i = 1; i < a; i++) {
			if (estDiviseur(a, i)) {
				somme += i;
			}
		}
		if ((a == somme) && (somme != 0)) {
			res = true;
		}
		return res;
	}
	
	/**
	* Affiche les quatre premiers nombres parfaits
	*/
	void quatreNbParfaits() {
		int cpt = 0;
		int i = 0;
		System.out.println ("*** 4 premiers nombres parfaits");
		while (cpt < 4) {
			if (estParfait(i)) {
				System.out.println(i);
				cpt++;
			}
			i++;
		}
	}
}
