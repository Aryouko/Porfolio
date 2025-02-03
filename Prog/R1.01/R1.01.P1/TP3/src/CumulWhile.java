/**
*Programme qui créé un tableau où chaque valeur est le
*cumulé des valeurs précédentes plus la valeur de l'indiçage actuelle
*de l'autre tableau déjà créé
*@author L.Carré
*/
class CumulWhile{
	void principal(){
		int[] t = {5,-7,0,6,-10,8,4,1};
		int[] cumul = new int[t.length];
		cumul[0] = t[0];
		int i = 1;
		System.out.print("Tableau : ");
		displayTab(t);
		while (i < t.length) {
			cumul[i] = cumul[i-1]+t[i];
			i += 1;
		}
		System.out.print("Tableau cumulé : ");
		displayTab(cumul);
	}
	
	void displayTab(int[] t) {
		int i = 0;
		System.out.print("{");
		while (i<t.length-1) {
			System.out.print(t[i] + ",");
			i++;
		}
		System.out.println(t[i] + "}");
	}
}
