/**
*Programme qui décale d'une case vers la fin le contenu
*d'un tableau avec la dernière valeur qui va en première
*@author L.Carré
*/
class DecalageWhile{
	void principal(){
		int[] t = {5,7,87,56,0,-67,-45,56};
		int temp;
		int i = 0;
		System.out.print("Tableau avant : ");
		displayTab(t);
		while (i < t.length) {
			temp = t[i];
			t[i] = t[0];
			t[0] = temp;
			i += 1;
		}
		System.out.print("Tableau après : ");
		displayTab(t);
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
