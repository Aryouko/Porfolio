/**
*Programme qui test si un nombre entré par l'utilisateur divise l'autre nombre entré par l'utilisateur
*@author L.Carré
*/
class Diviseur{
	void principal() {
		testEstDiviseur();
	}
	
	
	/**
	* Teste la méthode estDiviseur()
	*/
	void testEstDiviseur () {
		System.out.println ();
		System.out.println ("*** testEstDiviseur()");
		
		testCasEstDiviseur (0, 2, true);
		testCasEstDiviseur (10, 2, true);
		testCasEstDiviseur (7, 7, true);
		testCasEstDiviseur (29, 1, true);
		testCasEstDiviseur (4, 14, false);
		testCasEstDiviseur (22, 8, false);
	}
	
	/**
	* teste un appel de estDiviseur
	* @param q diviseur à calculer
	* @param p entier divisé
	* @param result resultat attendu
	**/
	void testCasEstDiviseur (int p, int q, boolean result) {
		// Affichage
		System.out.print ("estDiviseur(" + p + ", " + q + ") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estDiviseur(p, q);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
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
}
