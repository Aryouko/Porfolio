/**
*Programme qui décale les valeurs d'un tableau
*@author L.Carré
*/
class DecalTab{
	void principal() {
		int[] tab1 = {5, 7, 9, 5};
		int[] tab2 = {3, 10, 6, 20, 7};
		int[] tab3 = {3, 10, 6, 20, 7};
		int valDec = 0;
		int valRec = 4;
		
		System.out.print("decalerGauche(");
		displayTab(tab1);
		System.out.println(")");
		decalerGauche(tab1);
		System.out.println();
		
		System.out.print("decalerGaucheN(");
		displayTab(tab2);
		System.out.println(", " + valDec + ")");
		decalerGaucheN(tab2, valDec);
		System.out.println();
		
		testIndiceTab();
		System.out.println();
		
		System.out.print("decaleValeur(");
		displayTab(tab3);
		System.out.println(", " + valRec + ")");
		decaleValeur(tab3, valRec);
		System.out.println();
	}
	
	
	
	/**
	* décale les entiers d’un tableau d’une position vers la gauche
	* L’élément en 0 se retrouve à la fin du tableau
	* @param tab tableau d’entiers
	Semestre 1 - R1.01 1
	U.B.S. — I.U.T. de Vannes Dépt. INFO
	*/
	void decalerGauche (int[] tab) {
		System.out.print("Tableau avant : ");
		displayTab(tab);
		System.out.println();
		int temp;
		for (int i = 0; i < tab.length - 1; i++) {
			temp = tab[i];
			tab[i] = tab[i+1];
			tab[i+1] = temp;
		}
		System.out.print("Tableau après : ");
		displayTab(tab);
		System.out.println();
	}
	
	
	/**
	* décale les entiers d’un tableau de n positions vers la gauche
	* @param tab tableau d’entiers
	* @param n entier nombre de cases à décaler
	*/
	void decalerGaucheN (int[] tab, int n) {
		System.out.print("Tableau avant : ");
		displayTab(tab);
		System.out.println();
		int temp;
		while (n > 0) {
			for (int i = 0; i < tab.length - 1; i++) {
				temp = tab[i];
				tab[i] = tab[i+1];
				tab[i+1] = temp;
			}
			n--;
		}
		System.out.print("Tableau après : ");
		displayTab(tab);
		System.out.println();
	}
	
	
	/**
	* cherche l’indice de la premiere occurrence d’une valeur dans un tableau
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	* @return l’indice de la première valeur v dans tab si v est dans tab, -1 sinon
	*/
	int indiceTab (int[] tab, int v) {
		int res = -1;
		int i = 0;
		while (res == -1 && i < tab.length) {
			if (tab[i] == v) {
			res = i;
			}
			i++;
		}
		return res;
	}
	
	
	/**
	* teste un appel de indiceTab()
	* @param tab un tableau
	* @param result resultat attendu
	**/
	void testCasIndiceTab(int[] tab, int v, int result) {
		// Affichage
		System.out.print ("indiceTab(");
		displayTab(tab);
		System.out.print(", " + v + ") \t= " + result + "\t : ");
		// Appel
		int resExec = indiceTab(tab, v);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	/**
	* Teste la méthode indiceTab()
	*/
	void testIndiceTab() {
		System.out.println ();
		System.out.println ("*** testIndiceTab()");
		
		int[] test = {3, 10, 6, 10, 7};
		
		testCasIndiceTab(test, 3, 0);
		testCasIndiceTab(test, 10, 1);
		testCasIndiceTab(test, 6, 2);
		testCasIndiceTab(test, 20, -1);
		testCasIndiceTab(test, 7, 4);
		
	}
	
	
	/**
	* décale les valeurs d’un tableau de manière à ramener la valeur cherchée à l’indice 0
	* Si la valeur n’est pas présente, le tableau n’est pas modifié
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	*/
	void decaleValeur (int[] tab, int v) {
		int n = indiceTab(tab, v);
		if (n != -1) {
			decalerGaucheN(tab, n);
		} else {
			decalerGaucheN(tab, 0);
		}
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
		System.out.print(t[i] + "}");
	}
}
