/**
*Programme qui compte le nombre de valeurs différentes
*@author L.Carré
*/
class SaisirTrier{
	final int LG_TAB = 5;
	void principal() {
		int[] tab = saisirEtTrier();
		System.out.println("Voici le tableau créé et trié de taille " + LG_TAB);
		displayTab(tab);
	}
	
	
	/**
	* Crée et saisit un tableau trié de LG_TAB entiers
	* @return tableau trié de LG-TAB entiers
	*/
	int[] saisirEtTrier () {
	int[] t = new int[LG_TAB];
	for (int i = 0; i < t.length; i++) {
		t[i] = SimpleInput.getInt ("Entrer un entier");
		// insertion de la valeur en ordre croissant dans t
		int j = i;
		while (j > 0) {
			if (t[j] < t[j - 1]) {
				int tmp = t[j];
				t[j] = t[j - 1];
				t[j - 1] = tmp;
			}				
			j--;
		}
	}
	return t;
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
