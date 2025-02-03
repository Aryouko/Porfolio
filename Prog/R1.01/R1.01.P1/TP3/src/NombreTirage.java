/**
*Programme qui rentre le nombre de fois où un chiffre
*x a été tiré au hasard dans un tableau en fonction de son
*indiçage. L'indice du tableau étant le chiffre et sa valeur
*le nombre de fois tiré sur 1000 tirages
*@author L.Carré
*/
class NombreTirage{
	void principal(){
		int[] t = new int[10];
		for (int i = 0;i < 1000;i++) {
			t[(int) (Math.random() * 10)]++ ;
		}
		System.out.print("Le tableau rempli par les tirages aléatoires est : ");
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
