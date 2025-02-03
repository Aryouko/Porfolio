/**
*Programme qui test si les nombres entrés dans un tableau sont dans l'ordre croissant
*@author L.Carré
*/
class TabCroissant{
	void principal() {
		testEstCroissant();
	}	
	
	
	/**
	* Teste la méthode estCroissant()
	*/
	void testEstCroissant () {
		System.out.println ();
		System.out.println ("*** testEstParfait()");
		
		int[] test1 = {};
		int[] test2 = {7};
		int[] test3 = {-7,-2,12,234,450};
		int[] test4 = {-7,-2,12,12,234,450};
		int[] test5 = {-7,23,-1,26,54};
		
		testCasEstCroissant (test1, false);
		testCasEstCroissant (test2, true);
		testCasEstCroissant (test3, true);
		testCasEstCroissant (test4, true);
		testCasEstCroissant (test5, false);
	}
	
	/**
	* teste un appel de estCroissant
	* @param t un tableau à tester
	* @param result resultat attendu
	**/
	void testCasEstCroissant (int[] t, boolean result) {
		// Affichage
		System.out.print ("estCroissant(");
		displayTab(t);
		System.out.print (") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estCroissant(t);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste si les valeurs d’un tableau sont triées par ordre croissant
	* @param t tableau d’entiers
	* @return vrai ssi les valeurs du tableau sont en ordre croissant
	*/
	boolean estCroissant (int[] t) {
		boolean res = true;
		if (t.length > 0) {
			int val = t[0];
			for (int i = 1; ((i < t.length) && (res)); i++) {
				if (val <= t[i]) {
					val = t[i];
				} else {
					res = false;
				}
			}
		} else {
			res = false;
		}
		return res;
	}
	
	/**
	* affiche un tableau entré
	* @param t tableau d’entiers
	*/
	void displayTab(int[] t) {
		int i = 0;
		if (t.length == 0) {
			System.out.print("{}");
		} else {
			System.out.print("{");
			while (i<t.length-1) {
				System.out.print(t[i] + ",");
				i++;
			}
			System.out.print(t[i] + "}");
		}
	}
}
