/**
*Programme qui compte le nombre de valeurs différentes
*@author L.Carré
*/
class DiffVal{
	void principal() {
		testCompteDiffVal();
	}
	
	
	
	/**
	* compte le nombre de valeurs différentes dans un tableau
	* @param tab tableau d’entiers
	* @return le nombre de valeurs différentes du tableau
	*/
	int compteDiffVal(int[] tab) {
		int cpt = 0;
		if (tab.length > 0) {
			cpt = 1;
			int[] tabVal = new int[tab.length];
			tabVal[0] = tab[0];
			for (int i = 1; i < tab.length; i++) {
				boolean verif = true;
				for (int j = 0; j < cpt; j++) {
					if (tab[i] == tabVal[j]) {
						verif = false;
					}
				}
				if (verif) {
					tabVal[cpt] = tab[i];
					cpt++;
				}
			}
		}
		return cpt;
	}
	
	
	/**
	* teste un appel de compteDiffVal()
	* @param tab un tableau
	* @param result resultat attendu
	**/
	void testCasCompteDiffVal(int[] tab, int result) {
		// Affichage
		System.out.print ("compteDiffVal(");
		displayTab(tab);
		System.out.print(") \t= " + result + "\t : ");
		// Appel
		int resExec = compteDiffVal(tab);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	/**
	* Teste la méthode compteDiffVal()
	*/
	void testCompteDiffVal() {
		System.out.println ();
		System.out.println ("*** testCompteDiffVal()");
		
		int[] test1 = {3, 10, 6, 10, 7};
		int[] test2 = {0, 0, 2, 3, 0, 2, 1, 3, 3, 0};
		int[] test3 = {1,1,1,1,1};
		int[] test4 = {1,35,24,7,9,0};
		int[] test5 = {};
		
		testCasCompteDiffVal(test1, 4);
		testCasCompteDiffVal(test2, 4);
		testCasCompteDiffVal(test3, 1);
		testCasCompteDiffVal(test4, 6);
		testCasCompteDiffVal(test5, 0);
		
	}
	
	
	/**
	* affiche un tableau entré
	* @param t tableau d’entiers
	*/
	void displayTab(int[] t) {
		int i = 0;
		System.out.print("{");
		while (i<t.length-1) {
			System.out.print(t[i] + ",");
			i++;
		}
		if (t.length > 0) {
			System.out.print(t[i] + "}");
		} else {
			System.out.print("}");
		}
	}
}
