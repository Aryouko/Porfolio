/**
*Programme qui retourne la longueur de la
*plus grande séquence croissante du tableau
*ainsi que l'indice de départ et de fin de 
*la sequence (en cas de double séquence, les
*indices de la 1ère séquence sont donnés)
*@author L.Carré
*/
class SequenceLongueBis{
	void principal(){
		int[] t = {1,2,3,4,3,2,1};
		int maxSeq = 1;
		int seqActu = 1;
		int maxI = 0;
		int minI = 0;
		System.out.print("Tableau : ");
		displayTab(t);
		int i = 0;
		boolean continu = true;
		while ((i < t.length-1) && continu) {
			if (t[i] < t[i+1]) {
				seqActu += 1;
				if (maxSeq < seqActu) {
					maxSeq = seqActu;
					maxI = i+1;
					minI = maxI-maxSeq+1;
				}
			} else {
				seqActu = 1;
			}
			i++;
			if (!(seqActu + (t.length - i) > maxSeq)) {
				continu = false;
			}
		}
		System.out.print("La plus longue séquence croissante est de : " + maxSeq + " de " + minI + " à " + maxI + " et la boucle s'arrête à l'indice " + i);
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
