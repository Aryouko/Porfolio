/**
 * Tris Tableau est une classe avec des méthodes variés pour trier un tableau ainsi que des méthodes utiles.
 * @author L.Carré
 */
class TrisTableau {
	
	/** Lien avec les méthodes de l'ancien TP*/
	SimplesTableau monSpleTab = new SimplesTableau();
	
	/** Variable global aidant pour le calcul de toute les complexités*/
	long cpt = 0;
	/** Variable global aidant pour le calcul d'un cas de la complexité de triParComptageFreqEfficacite*/
	long cpt2 = 0;
	
	/**
	 * Le point d'entré du programme
	 */
	void principal() {
		testRechercheSeq();
		testRechercheSeqEfficacite();
		
		testVerifTri();
		
		testRechercheDicho();
		testRechercheDichoEfficacite();
		
		testTriSimple();
		testTriSimpleEfficacite();
		
		testSeparer();
		
		testTriRapideRec();
		
		testTriRapide();
		testTriRapideEfficacite();
		
		testCreerTabFreq();
		
		testTriParComptageFreq();
		testTriParComptageFreqEfficacite();
		
		testTriABulles();
		testTriABullesEfficacite();
	}
	
	/**
	 * Recherche séquentielle d'une valeur dans un tableau. La valeur à rechercher peut exister 
	 * en plusieurs exemplaires mais la recherche s'arrête dès qu'une première valeur est trouvée. 
	 * On suppose que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0)
	 * @param leTab le tableau dans lequel effectuer la recherche
	 * @param nbElem le nombre d'entiers que contient le tableau
	 * @param aRech l'entier à rechercher dans le tableau
	 * @return l'indice (>=0) de la position de l'entier dans le tableau ou -1 s'il n'est pas présent
	 */
	int rechercheSeq(int[] leTab, int nbElem, int aRech) {
		int i = 0;
		boolean trouve = false;
		
		while (!trouve && (i < nbElem)) {
			if (aRech == leTab[i]) {
				trouve = true;
			} else {
				i++;
			}
			cpt++;
		}
		if (!trouve) {
			i = -1;
		}
		return i;
	}
	
	/**
	 * Teste la méthode rechercheSeq()
	 */
	void testRechercheSeq() {
		System.out.println();
		System.out.println("*** testRechercheSeq() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		testCasRechercheSeq(tab, tab.length, 12, 1);
		System.out.println("- - - - - - - - - - -");
		testCasRechercheSeq(tab, tab.length, 55, 7);
		System.out.println("- - - - - - - - - - -");
		testCasRechercheSeq(tab, tab.length, 22, -1);
	}
	
	/**
	 * teste un appel de rechercheSeq()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param aRech nombre à rechercher
	 * @param resAttendu resultat attendu
	 */
	void testCasRechercheSeq(int[] leTab, int nbElem, int aRech, int resAttendu) {
		int resExecute = rechercheSeq(leTab, nbElem, aRech);
		
		monSpleTab.afficherTab(leTab, nbElem);
		System.out.println("Recherche du nombre : " + aRech);
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu == resExecute){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de l'efficacite de rechercheSeq()
	 */
	void testRechercheSeqEfficacite() {
		System.out.println();
		System.out.println("*** testRechercheSeqfficacite() ***");
		System.out.println();
		
		int[] tab;
		int n, indice;
		long t1, t2;
		double diffT;
		n = 8388608;
		
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			cpt = 0;
			t1 = System.nanoTime();
			indice = rechercheSeq(tab, n, -1);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			System.out.println("cpt/n = " + (double) cpt/n + " constant = 1");
			n = n * 2;
		}
	}
	
	/**
	 * Vérifie que le tableau passé en paramètre est trié par ordre croissant des valeurs. On suppose que le tableau passé en paramètre est
	 * créé et possède au moins une valeur (nbElem > 0)
	 * @param leTab le tableau à vérifier (trié en ordre croissant)
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return true si le tableau est trié
	 */
	boolean verifTri(int[] leTab, int nbElem) {
		boolean res = true;
		
		for (int i = 0;i < nbElem - 1; i++) {
			if (leTab[i] > leTab[i + 1]) {
				res = false;
			}
		}
		return res;
	}	
	
	/**
	 * Teste la méthode verifTri()
	 */
	void testVerifTri() {
		System.out.println();
		System.out.println("*** testVerifTri() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		int[] tab3 = {1};
		testCasVerifTri(tab, tab.length, false);
		System.out.println("- - - - - - - - - - -");
		testCasVerifTri(tab2, tab2.length, true);
		System.out.println("- - - - - - - - - - -");
		testCasVerifTri(tab3, tab3.length, true);
	}
	
	/**
	 * teste un appel de verifTri()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param resAttendu resultat attendu
	 */
	void testCasVerifTri(int[] leTab, int nbElem, boolean resAttendu) {
		boolean resExecute = verifTri(leTab, nbElem);
		
		monSpleTab.afficherTab(leTab, nbElem);
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu == resExecute){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Recherche dichotomique d'une valeur dans un tableau. On suppose que le tableau est trié par ordre croissant. La valeur à
	 * rechercher peut exister en plusieurs exemplaires, dans ce cas, c'est la valeur à l'indice le + faible qui sera trouvé. On suppose
	 * également que le tableau passé en paramètre est créé et possède au moins une valeur (nbElem > 0)
	 * @param leTab le tableau trié par ordre croissant dans lequel effectuer la recherche
	 * @param nbElem le nombre d'entiers que contient le tableau
	 * @param aRech l'entier à rechercher dans le tableau
	 * @return l'indice (>=0) de la position de l'entier dans le tableau ou -1 s'il n'est pas présent
	 */
	int rechercheDicho(int[] leTab, int nbElem, int aRech) {
		int indM, res;
		int indD = 0;
		int indF = nbElem - 1; 
		
		while ( indD != indF ) { 
			indM = ( indD + indF ) / 2; 
			if ( aRech > leTab[indM] ) {
				indD = indM + 1; 
			} else {
				indF = indM; 
			}
			cpt++;
		}
		if (aRech == leTab[indD]) {
			res = indD; 
		} else {
			res = -1;
		}
		return res;
	}
	
	/**
	 * Teste la méthode rechercheDicho()
	 */
	void testRechercheDicho() {
		System.out.println();
		System.out.println("*** testRechercheDicho() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		testCasRechercheSeq(tab, tab.length, 12, 1);
		System.out.println("- - - - - - - - - - -");
		testCasRechercheSeq(tab, tab.length, 55, 7);
		System.out.println("- - - - - - - - - - -");
		testCasRechercheSeq(tab, tab.length, 22, -1);
	}
	
	/**
	 * teste un appel de rechercheDicho()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param aRech nombre à rechercher
	 * @param resAttendu resultat attendu
	 */
	void testCasRechercheDicho(int[] leTab, int nbElem, int aRech, int resAttendu) {
		int resExecute = rechercheDicho(leTab, aRech, nbElem);
		
		monSpleTab.afficherTab(leTab, nbElem);
		System.out.println("Recherche du nombre : " + aRech);
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu == resExecute){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de l'efficacite de rechercheDicho()
	 */
	void testRechercheDichoEfficacite() {
		System.out.println();
		System.out.println("*** testRechercheDichofficacite() ***");
		System.out.println();
		
		int[] tab;
		int n, indice;
		long t1, t2;
		double diffT;
		double log2n;
		n = 8388608;
		
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			cpt = 0;
			t1 = System.nanoTime();
			indice = rechercheDicho(tab, n, -1);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			log2n = Math.log10(n) / Math.log10(2);
			System.out.println("cpt/log2n = " + (double) cpt/log2n + " constant = 1");
			n = n * 2;
		}
	}
	
	/**
	 * Tri par ordre croissant d'un tableau selon la méthode simple : l'élément minimum est placé en début de tableau (efficacité en n carré)
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void triSimple(int[] leTab, int nbElem) {
		int p, k, min;
		for (int i = 0; i <= (nbElem - 2); i++) {
			min = leTab[i];
			k = i;
			for (p=(i+1); p <= (nbElem - 1); p++) {
				if (leTab[p] < min) {
					min = leTab[p];
					k = p;
				}
				cpt++;
			}
			monSpleTab.echange(leTab, nbElem, i, k);
		}
	}
	
	/**
	 * Teste la méthode triSimple()
	 */
	void testTriSimple() {
		System.out.println();
		System.out.println("*** testTriSimple() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		int[] tab3 = {1};
		testCasTriSimple(tab, tab.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriSimple(tab2, tab2.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriSimple(tab3, tab3.length);
	}
	
	/**
	 * teste un appel de triSimple()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 */
	void testCasTriSimple(int[] leTab, int nbElem) {
		System.out.println("Avant : ");
		monSpleTab.afficherTab(leTab, nbElem);
		triSimple(leTab, nbElem);
		boolean verif = verifTri(leTab, nbElem);
		
		System.out.println("Après : ");
		monSpleTab.afficherTab(leTab, nbElem);
	}
	
	/**
	 * Teste de l'efficacite de triSimple()
	 */
	void testTriSimpleEfficacite() {
		System.out.println();
		System.out.println("*** testTriSimpleEfficacite() ***");
		System.out.println();
		
		int[] tab;
		int n, indice;
		long t1, t2;
		double diffT;
		n = 1024; // 2 à la puissance
		
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 0, 10000);
			cpt = 0;
			t1 = System.nanoTime();
			triSimple(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			System.out.println("cpt/((n-1)*n/2) = " + (double) cpt/(n*n) + " constant = 0,5");
			n = n * 2;
		}
	}
	
	/**
	 * Cette méthode renvoie l’indice de séparation du tableau en 2 parties par placement du pivot à la bonne case
	 * @param tab le tableau des valeurs
	 * @param indL indice Left de début de tableau
	 * @param indR indice Right de fin de tableau
	 * @return l’indice de séparation du tableau
	 */
	int separer (int[] tab, int indL, int indR) {
		int res;
		int pivot = tab[indL];
		int i = indR + 1;
		
		for (int j = indR; j > indL; j--) {
			if (tab[j] > pivot) {
				i--;
				monSpleTab.echange(tab, tab.length, i, j);
			}
			cpt++;
		}
		res = i - 1;
		monSpleTab.echange(tab, tab.length, res, indL);
		return res;
	}
	
	/**
	 * Teste la méthode separer()
	 */
	void testSeparer() {
		System.out.println();
		System.out.println("*** testSeparer() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab3 = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		testCasSeparer(tab, 0, tab.length - 1, 4);
		System.out.println("- - - - - - - - - - -");
		testCasSeparer(tab3, 4, tab3.length - 1, 6);
		System.out.println("- - - - - - - - - - -");
		testCasSeparer(tab2, 0, tab2.length - 1, 0);
	}
	
	/**
	 * teste un appel de separer()
	 * @param leTab le tableau des valeurs
	 * @param indL indice Left de début de tableau
	 * @param indR indice Right de fin de tableau
	 * @param resAttendu resultat attendu
	 */
	void testCasSeparer(int[] leTab, int indL, int indR, int resAttendu) {
		System.out.println("Séparation de l'indice " + indL + " à " + indR);
		System.out.print("Tableau avant");
		monSpleTab.afficherTab(leTab, leTab.length);
		int resExecute = separer(leTab, indL, indR);
		
		System.out.print("Tableau après");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu == resExecute){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Méthode de tri récursive selon le principe de séparation. La méthode s'appelle elle-même sur les tableaux gauche et droite par
	 * rapport à un pivot
	 * @param tab le tableau sur lequel est effectué la séparation
	 * @param indL l'indice gauche de début de tableau
	 * @param indR l'indice droite de fin de tableau
	 */
	void triRapideRec(int[] tab, int indL, int indR) {		
		int indPivot = separer(tab, indL, indR);
		
		if ((indPivot - 1) > indL) {
			triRapideRec(tab, indL, indPivot - 1);
		}
		
		if ((indPivot + 1) < indR) {
			triRapideRec(tab, indPivot + 1, indR);
		}
	}
	
	/**
	 * Teste la méthode triRapideRec()
	 */
	void testTriRapideRec() {
		System.out.println();
		System.out.println("*** testTriRapideRec() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		int[] tab3 = {56,89,4,5,67,15,25,156};
		testCasTriRapideRec(tab, 0, tab.length - 1);
		System.out.println("- - - - - - - - - - -");
		testCasTriRapideRec(tab2, 0, tab2.length - 1);
		System.out.println("- - - - - - - - - - -");
		testCasTriRapideRec(tab3, 0, tab3.length - 1);
	}
	
	/**
	 * teste un appel de triRapideRec()
	 * @param leTab le tableau des valeurs
	 * @param indL indice Left de début de tableau
	 * @param indR indice Right de fin de tableau
	 */
	void testCasTriRapideRec(int[] leTab, int indL, int indR) {
		System.out.print("Tableau avant");
		monSpleTab.afficherTab(leTab, leTab.length);
		triRapideRec(leTab, indL, indR);
		
		System.out.print("Tableau après");
		monSpleTab.afficherTab(leTab, leTab.length);
		System.out.print("Trié : ");
		boolean verif = verifTri(leTab, leTab.length);
		if (verif){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri rapide (QuickSort). On suppose que le tableau passé en paramètre est
	 * créé et possède au moins une valeur (nbElem > 0). Cette méthode appelle triRapideRec(...) qui elle
	 * effectue réellement le tri rapide selon la méthode de séparation récursive.
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void triRapide(int[] leTab, int nbElem) {
		int indL = 0;
		int indR = nbElem - 1;
		triRapideRec(leTab, indL, indR);
	}
	
	/**
	 * Teste la méthode triRapide()
	 */
	void testTriRapide() {
		System.out.println();
		System.out.println("*** testTriRapide() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		int[] tab3 = {56,89,4,5,67,15,25,156};
		testCasTriRapide(tab, tab.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriRapide(tab2, tab2.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriRapide(tab3, tab3.length);
	}
	
	/**
	 * teste un appel de triRapide()
	 * @param leTab le tableau des valeurs
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void testCasTriRapide(int[] leTab, int nbElem) {
		System.out.print("Tableau avant");
		monSpleTab.afficherTab(leTab, nbElem);
		triRapide(leTab, nbElem);
		
		System.out.print("Tableau après");
		monSpleTab.afficherTab(leTab, nbElem);
		System.out.print("Trié : ");
		boolean verif = verifTri(leTab, nbElem);
		if (verif){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de l'efficacite de triRapide()
	 */
	void testTriRapideEfficacite() {
		System.out.println();
		System.out.println("*** testTriRapideEfficacite() ***");
		System.out.println();
		
		int[] tab;
		int n, indice;
		long t1, t2;
		double diffT;
		double nlog2n;
		n = 2097152;
		
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 0, 1000000000);
			
			cpt = 0;
			t1 = System.nanoTime();
			triRapide(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			nlog2n = n * (Math.log10(n) / Math.log10(2));
			System.out.println("cpt/nlog2n = " + (double) cpt/nlog2n + " constant = 1");
			n = n * 2;
		}
	}
	
	/**
	 * A partir d'un tableau initial passé en paramètre "leTab", cette méthode renvoie un nouveau tableau "tabFreq" d'entiers où chaque
	 * case contient la fréquence d'apparition des valeurs dans le tableau initial. Pour simplifier, on suppose que le tableau initial ne contient
	 * que des entiers compris entre 0 et max (>0). Dès lors le tableau "tabFreq" se compose de (max+1) cases et chaque case "i"
	 * (0 plus petit ou égale à i plus petit ou égale à max) contient le nombre de fois que l'entier "i" apparait dans le tableau initial. On suppose que le tableau passé en
	 * paramètre est créé et possède au moins une valeur (nbElem plus grand à 0). Ceci ne doit donc pas être vérifié. Par contre, on vérifiera que le
	 * min est plus grand ou égale à  0. Dans le cas contraire, renvoyer un tableau "null".
	 * @param leTab le tableau initial
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return le tableau des fréquences de taille (max+1) ou null si la méthode ne s'applique pas
	 */
	int[] creerTabFreq(int[] leTab, int nbElem) {
		int[] res;
		int min = monSpleTab.leMin(leTab, nbElem);
		int max = monSpleTab.leMax(leTab, nbElem);
		
		if (min < 0) {
			res = null;
		} else {
			res = new int[max + 1];
			for (int i = 0; i < nbElem; i++) {
				res[leTab[i]]++;
				cpt++;
			}
		}
		return res;
	}
	
	/**
	 * Teste la méthode creerTabFreq()
	 */
	void testCreerTabFreq() {
		System.out.println();
		System.out.println("*** testCreerTabFreq() ***");
		
		int[] tab = {10, 5, 7, 7, 4, 3, 8};
		int[] tabFreq = {0, 0, 0, 1, 1, 1, 0, 2, 1, 0, 1};
		int[] tab2 = {0, 0, 1, 3, 2, 1, 1, 5};
		int[] tabFreq2 = {2, 3, 1, 1, 0, 1};
		int[] tab3 = {-2, 3, 3, 7, 9};
		int[] tabFreq3 = null;
		testCasCreerTabFreq(tab, tab.length, tabFreq);
		System.out.println("- - - - - - - - - - -");
		testCasCreerTabFreq(tab2, tab2.length, tabFreq2);
		System.out.println("- - - - - - - - - - -");
		testCasCreerTabFreq(tab3, tab3.length, tabFreq3);
	}
	
	/**
	 * teste un appel de creerTabFreq()
	 * @param leTab le tableau des valeurs
	 * @param nbElem le nombre d'entiers que contient le tableau
	 * @param resAttendu le tableau des fréquences attendu
	 */
	void testCasCreerTabFreq(int[] leTab, int nbElem, int[] resAttendu) {
		System.out.print("Tableau initial : ");
		monSpleTab.afficherTab(leTab, nbElem);
		int[] resExecute = creerTabFreq(leTab, nbElem);
		boolean verif;
		
		System.out.print("Tableau de fréquence du tableau initial");
		if (resExecute == null) {
			System.out.println();
			System.out.println("Tableau null");
		} else {
			monSpleTab.afficherTab(resExecute, resExecute.length);
		}
		
		if (resAttendu == null && resExecute == null) {
			verif = true;
		} else if (resAttendu == null || resExecute == null) {
			verif = false;
		} else {
			verif = monSpleTab.egalite(resExecute, resAttendu, resExecute.length, resAttendu.length);
		}
		
		if (verif){
			System.out.println ("OK, ceci est le bon tableau de fréquence");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri par comptage de fréquences. On suppose que le tableau passé en
	 * paramètre est créé et possède au moins une valeur (nbElem > 0).
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void triParComptageFreq(int[] leTab, int nbElem) {
		int[] leFreq = creerTabFreq(leTab, nbElem);
		int indTab = 0;
		
		for (int i = 0; i < leFreq.length; i++) {
			while (leFreq[i] > 0) {
				leTab[indTab] = i;
				indTab++;
				leFreq[i]--;
				cpt++;
			}
			cpt2++;
		}
	}
	
	/**
	 * Teste la méthode triParComptageFreq()
	 */
	void testTriParComptageFreq() {
		System.out.println();
		System.out.println("*** testTriParComptageFreq() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		int[] tab3 = {56,89,4,5,67,15,25,156};
		testCasTriParComptageFreq(tab, tab.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriParComptageFreq(tab2, tab2.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriParComptageFreq(tab3, tab3.length);
	}
	
	/**
	 * teste un appel de triParComptageFreq()
	 * @param leTab le tableau des valeurs
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void testCasTriParComptageFreq(int[] leTab, int nbElem) {
		System.out.print("Tableau avant");
		monSpleTab.afficherTab(leTab, nbElem);
		triParComptageFreq(leTab, nbElem);
		
		System.out.print("Tableau après");
		monSpleTab.afficherTab(leTab, nbElem);
		System.out.print("Trié : ");
		boolean verif = verifTri(leTab, nbElem);
		if (verif){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de l'efficacite de triParComptageFreq()
	 */
	void testTriParComptageFreqEfficacite() {
		System.out.println();
		System.out.println("*** testTriParComptageFreqEfficacite() ***");
		System.out.println();
		
		int[] tab;
		int n, indice, k;
		long t1, t2;
		double diffT;
		n = 8388608;
		
		System.out.println("* Cas où k est très petit alors la constante dépendra de n *");
		System.out.println();
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 0, 1000);
			cpt = 0;
			k = monSpleTab.leMax(tab, n) + 1;
			t1 = System.nanoTime();
			triParComptageFreq(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			System.out.println("cpt/(n+k) = " + (double) cpt/(n+k) + " constant = 2");
			n = n * 2;
		}
		
		n = 8192;
		System.out.println();
		System.out.println("* Cas où n est petit et k très grand donc ça dépend de k *");
		System.out.println();
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 0, 268435456);
			cpt2 = 0;
			k = monSpleTab.leMax(tab, n) + 1;
			t1 = System.nanoTime();
			triParComptageFreq(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			System.out.println("cpt/(n+k) = " + (double) cpt2/(n+k) + " constant = 1");
			n = n * 2;
		}
	}
	
	
	/**
	 * Tri par ordre croissant d'un tableau selon la méthode du tri à bulles : tant que le tableau qu'il reste à trier a au moins 2 cases,
	 * permuter le contenu de 2 cases successives si leTab[i] > leTab[i+1]. On suppose que le tableau passé en paramètre est créé et
	 * possède au moins une valeur (nbElem > 0).
	 * @param leTab le tableau à trier par ordre croissant
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void triABulles(int[] leTab, int nbElem) {
		boolean trie = true;
		for (int i = 0; i < nbElem - 1 && trie; i++) {
			trie = false;
			for (int j = 0; j < nbElem - 1 - i; j++) {
				if (leTab[j] > leTab[j + 1]) {
					monSpleTab.echange(leTab, nbElem, j, j + 1);
					trie = true;
				}
				cpt++;
			}
		}
	}
	
	/**
	 * Teste la méthode triABulles()
	 */
	void testTriABulles() {
		System.out.println();
		System.out.println("*** testTriABulles() ***");
		
		int[] tab = {44, 12, 65, 46, 42, 23, 18, 55};
		int[] tab2 = {1, 2, 3, 4, 5, 6};
		int[] tab3 = {56,89,4,5,67,15,25,156};
		testCasTriABulles(tab, tab.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriABulles(tab2, tab2.length);
		System.out.println("- - - - - - - - - - -");
		testCasTriABulles(tab3, tab3.length);
	}
	
	/**
	 * teste un appel de triABulles()
	 * @param leTab le tableau des valeurs
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void testCasTriABulles(int[] leTab, int nbElem) {
		System.out.print("Tableau avant");
		monSpleTab.afficherTab(leTab, nbElem);
		triABulles(leTab, nbElem);
		
		System.out.print("Tableau après");
		monSpleTab.afficherTab(leTab, nbElem);
		System.out.print("Trié : ");
		boolean verif = verifTri(leTab, nbElem);
		if (verif){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de l'efficacite de triABulles()
	 */
	void testTriABullesEfficacite() {
		System.out.println();
		System.out.println("*** testTriABullesEfficacite() ***");
		System.out.println();
		
		int[] tab;
		int n, indice, k;
		long t1, t2;
		double diffT;
		n = 1024;
		
		for ( int i = 1; i <= 6; i++ ) {
			tab = new int[n];
			monSpleTab.remplirAleatoire(tab, n, 0, 100000000);
			cpt = 0;
			k = monSpleTab.leMax(tab, n) + 1;
			t1 = System.nanoTime();
			triABulles(tab, n);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			System.out.println("Tableau de taille n = " + n);
			System.out.println("Tps = " + diffT + " ms");
			System.out.println("cpt/(n*n) = " + (double) cpt/(n*n) + " constant = 0,5");
			n = n * 2;
		}
	}
}
