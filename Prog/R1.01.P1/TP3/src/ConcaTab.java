/**
*Programme qui entrelace deux tableaux déjà donnés dans
*un troisième et si les deux tableaux ne sont pas de la 
*même taille, il finit de remplir le troisième tableau 
*avec les derniers valeurs du tableau le plus long
*@author L.Carré
*/
class ConcaTab{
	void principal(){
		int[] t1 = {1,5};
		int[] t2 = {1,2,5,8};
		int[] tRes = new int[t1.length + t2.length];
		System.out.print("Tableau 1 : ");
		displayTab(t1);
		System.out.print("Tableau 2 : ");
		displayTab(t2);
		int iForT1T2 = 0;
		for (int i = 0; i < tRes.length; i+=2) {
			if (iForT1T2 < t1.length) {
				tRes[i] = t1[iForT1T2];
			} else {
				tRes[i] = t2[iForT1T2];
				iForT1T2++;
			}
			if (i+1 < tRes.length) {
				if (iForT1T2 < t2.length) {
					tRes[i+1] = t2[iForT1T2];
				} else {
					iForT1T2++;
					tRes[i+1] = t1[iForT1T2];
				}
			}
			iForT1T2++;
		}
		System.out.print("Tableau Res : ");
		displayTab(tRes);
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
