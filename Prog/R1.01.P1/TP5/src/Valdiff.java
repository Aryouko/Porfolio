/**
*Programme qui test si les valeurs des deux tableaux sont différents
*@author L.Carré
*/
class Valdiff{
	void principal() {
		testSontTousDiff();
	}
	
	
	
	/**
	* vérifie si deux tableaux n’ont aucune valeur commune
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @return vrai si les tableaux tab1 et tab2 n’ont aucune valeur commune, faux sinon
	*/
	boolean sontTousDiff (int[] tab1, int[] tab2) {
		boolean res = true;
		int i=0;
		while (i < tab1.length && res) {
			int j=0;
			while (j < tab2.length && res) {
				res = !(tab1[i] == tab2[j]);
				j++;
			}
			i++;
		}
		return res;
	}
	
	
	/**
	* Teste la méthode sontTousDiff()
	*/
	void testSontTousDiff () {
		System.out.println ();
		System.out.println ("*** testSontTousDiff()");
		
		int[] test1 = {};
		int[] test2 = {7,8,9};
		int[] test3 = {10,11,12,13,14};
		int[] test4 = {10,15,16};
		
		testCasSontTousDiff(test1, test2, true);
		testCasSontTousDiff(test1, test1, true);
		testCasSontTousDiff(test2, test3, true);
		testCasSontTousDiff(test3, test2, true);
		testCasSontTousDiff(test4, test3, false);
		testCasSontTousDiff(test3, test4, false);
		
	}
	
	
	/**
	* teste un appel de sontTousDiff()
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @param result resultat attendu
	**/
	void testCasSontTousDiff(int[] tab1, int[] tab2, boolean result) {
		// Affichage
		System.out.print ("sontTousDiff(");
		displayTab(tab1);
		System.out.print(", ");
		displayTab(tab2);
		System.out.print(") \t= " + result + "\t : ");
		// Appel
		boolean resExec = sontTousDiff(tab1, tab2);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
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
