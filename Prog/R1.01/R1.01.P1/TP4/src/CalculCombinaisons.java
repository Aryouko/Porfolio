/**
*Programme qui calcul la combinaison de deux entiers positifs entrés par l'utilisateur
*@author L.Carré
*/
class CalculCombinaisons{
	void principal() {
		testFactorielle();
		System.out.println();
		testCombinaison();
	}
	
	
	/**
	* Teste la méthode factorielle()
	*/
	void testFactorielle () {
		System.out.println ();
		System.out.println ("*** testFactorielle()");
		
		testCasFactorielle (5, 120);
		testCasFactorielle (0, 1);
		testCasFactorielle (1, 1);
		testCasFactorielle (2, 2);
	}
	
	/**
	* teste un appel de factorielle
	* @param n valeur de la factorielle à calculer
	* @param result resultat attendu
	**/
	void testCasFactorielle (int n, int result) {
		// Affichage
		System.out.print ("factorielle (" + n + ") \t= " + result + "\t : ");
		// Appel
		int resExec = factorielle(n);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}

	/**
	* calcul de la factorielle du paramètre
	* @param n valeur de la factoriel à calculer, n>=0
	* @return factorielle de n
	*/
	int factorielle (int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res = res * i;
		}
		return res;
	}
	
	
	/**
	* Teste la méthode combinaison()
	*/
	void testCombinaison () {
		System.out.println ();
		System.out.println ("*** testCombinaison()");
		
		testCasCombinaison (25, 24, 25);
		testCasCombinaison (5, 0, 1);
		testCasCombinaison (4, 4, 1);
		testCasCombinaison (8, 2, 28);
	}
	
	/**
	* teste un appel de combinaison
	* @param n valeur de la combinaison à calculer
	* @param k autre valeur de la combinaison à calculer
	* @param result resultat attendu
	**/
	void testCasCombinaison (int n, int k, int result) {
		// Affichage
		System.out.print ("Combinaison(" + n + ", " + k + ") \t= " + result + "\t : ");
		// Appel
		int resExec = combinaison(n, k);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* calcul de la combinaison k parmi n
	* @param n cardinalité de l’ensemble
	* @param k nombre d’éléments dans n avec 0<=k<=n
	* @return nombre de combinaisons de k parmi n
	*/
	int combinaison (int n, int k) {
		return factorielle(n) / (factorielle(k) * factorielle(n-k));
	}
}
