/**
*Programme demandant 2 nombres a et b dans un tableau
*et regardant si il se retrouve dans cette ordre a b
*sans pour autant être consécutif 
*@author L.Carré
*/
class OrdreAB{
	void principal(){
		int[] t = {-7,-2,-1,-67,4,-2,8};
		int entierA = SimpleInput.getInt("Entier a (du tableau): ");
		int entierB = SimpleInput.getInt("Entier b (du tableau): ");
		int indA = -1;
		int indB = -1;
		System.out.print("Tableau : ");
		displayTab(t);
		if (entierA == entierB) {
			int cpt = 0;
			for (int i = 0; i < t.length; i++) {
				if (t[i] == entierA) {
					cpt++;
				}
			}
			if (cpt >= 2) {
				System.out.println("a et b se retrouve bien dans l'ordre a b dans le tableau");
			} else {
				System.out.println("a et b sont égaux ils sont donc à la même place, ils ne sont pas dans l'ordre a b");
			}
		} else {
			for (int i = 0; i < t.length; i++) {
				if (entierA == t[i] && indA == -1) {
					indA = i;
				}
				if (entierB == t[i]) {
					indB = i;
				}
			}
			if (indA == -1 || indB == -1) {
				System.out.println("a ou b ou les deux ne sont pas présents dans le tableau actuel");
			} else if (indA < indB){
				System.out.println("a et b se retrouve bien dans l'ordre a b dans le tableau");
			} else if (indA > indB) {
				System.out.println("a et b ne se retrouve pas dans l'ordre a b dans le tableau");
			}
		}
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
