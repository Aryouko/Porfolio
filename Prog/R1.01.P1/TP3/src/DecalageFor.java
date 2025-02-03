/**
*Programme qui décale d'une case vers la fin le contenu
*d'un tableau avec la dernière valeur qui va en première
*@author L.Carré
*/
class DecalageFor{
	void principal(){
		int[] t = {56,7,230,68,0,8,4,-1};
		int temp;
		System.out.print("Tableau avant : ");
		displayTab(t);
		for (int i = 1; i < t.length; i++) {
			temp = t[i];
			t[i] = t[0];
			t[0] = temp;
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
