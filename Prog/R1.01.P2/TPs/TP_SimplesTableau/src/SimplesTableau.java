/**
 * Cette classe effectue des opérations élémentaires sur un ou plusieurs tableaux d'entiers. La taille d'un tableau est par définition le nombre TOTAL de cases = tab.length. Un tableau d'entiers créé possède nbElem éléments qui est nécessairement inférieur ou égal à la taille du tableau : nbElem plus petit ou égale à tab.length (= taille)
 *@author L.Carré
 */
class SimplesTableau {
	
	/**
	 * Le point d'entré du programme
	 */
	void principal() {
		testVerifTab();
		testAfficherTab();
		testTirerAleatoire();
		testRemplirAleatoire();
		testEgalite();
		testCopier();
		testLeMax();
		testInverse();
		testEchange();
		testMelange();
		testDecalerGche();
		testSupprimerUneValeur();
		testInclusion();
		testRemplirToutesDiff();
	}
	
	/**
	 * Factorisation : appelé chaque fois qu'une vérification doit se faire sur la validité d'un tableau. Le tableau n'est pas valide si celui-ci est inexistant ou si le nombre d'éléments qu'il contiendra est incompatible avec sa taille (leTab.length)
	 * @param leTab le tableau dont on doit vérifier l'existence (leTab différent de null)
	 * @param nbElem le nombre d'éléments que contiendra le tableau, doit vérifier la condition 0 plus petit nbElem plus grand ou égale leTab.length
	 * @return vrai ssi le tableau est valide
	 */
	boolean verifTab(int[] leTab, int nbElem) {
		boolean res = false;
		
		if (leTab != null) {
			if ((nbElem <= leTab.length) && (nbElem > 0)) {
				res = true;
			} else {
				System.err.println("verifTab - Erreur : nbElem incorrecte");
			}
		} else {
			System.err.println("verifTab - Erreur : leTab inexistant");
		}
		return res;
	}
	
	/**
	 * Teste la méthode verifTab()
	 */
	void testVerifTab() {
		int[] tab1 = new int[4];
		int[] tab2 = new int[2];
		int[] tab3 = null;
		int[] tab4 = {};
		
		System.out.println();
		System.out.println("*** testVerifTab() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab et nbElem sont valide");
		testCasVerifTab(tab1, 4, true);
		System.out.println("- - - - - - - - - - -");
		testCasVerifTab(tab1, 2, true);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : nbElem n'est pas valide");
		testCasVerifTab(tab2, 4, false);
		System.out.println("- - - - - - - - - - -");
		testCasVerifTab(tab2, -2, false);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab est null");
		testCasVerifTab(tab3, 0, false);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab est vide");
		testCasVerifTab(tab4, 0, false);
	}
	
	/**
	 * teste un appel de verifTab()
	 * @param leTab le tableau
	 * @param nbElem le nombre de cases
	 * @param resAttendu resultat attendu
	 */
	void testCasVerifTab(int[] leTab, int nbElem, boolean resAttendu) {
		boolean resExecute = verifTab(leTab, nbElem);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resExecute == resAttendu){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Affiche le contenu des nbElem cases d'un tableau une par une
	 * @param leTab le tableau à afficher
	 * @param nbElem le nombre d'entiers que contient le tableau
	 */
	void afficherTab(int[] leTab, int nbElem) {
		boolean verif = verifTab(leTab, nbElem);
		
		if (verif) {
			System.out.print("{");
			for (int i = 0; i < nbElem - 1; i++) {
				System.out.print(leTab[i] + ",");
			}
			System.out.print(leTab[nbElem - 1] + "}");
		} else {
			System.err.print("afficherTab - Erreur : verifTab(leTab, nbElem)");
		}
	}
	
	/**
	 * Teste la méthode afficheTab()
	 */
	void testAfficherTab() {
		int[] tab1 = new int[4];
		int[] tab2 = null;
		int[] tab3 = {};
		
		System.out.println();
		System.out.println("*** testAfficherTab() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab et nbElem sont valide");
		afficherTab(tab1, 2);
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		afficherTab(tab1, 4);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : leTab et nbElem sont valide et nbElem est égale à 1 donc cas limite car un tableau de une case n'est pas réaliste");
		afficherTab(tab1, 1);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem est égale à 0");
		afficherTab(tab1, 0);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem n'est pas valide");
		afficherTab(tab1, 6);
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		afficherTab(tab1, -2);
		
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab est null");
		afficherTab(tab2, 0);
		
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab est vide");
		afficherTab(tab3, 0);
		System.out.println();
		System.out.println();
	}
	
	/**
	 * Renvoie un entier aléatoire compris entre min et max (min plus petit ou égale valeur plus grand ou égale max)
	 * @param min la valeur de l'entier minimum
	 * @param max la valeur de l'entier maximum
	 * @return l'entier aléatoire
	 */
	int tirerAleatoire(int min, int max) {
		int res = -1;
		
		if ((min <= max) && (min >= 0)) {
			res = min + (int)(Math.random() * (max + 1 - min));
		} else {
			System.err.println("tirerAleatoire - Erreur : max ou min incorrectes");
		}
		return res;
	}
	
	/**
	 * Teste la méthode tirerAleatoire()
	 */
	void testTirerAleatoire() {
		System.out.println();
		System.out.println("*** testTirerAleatoire() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : min et max sont valide");
		testCasTirerAleatoire(3, 7, 3);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : min et max sont valide et égaux ce qui ne sert à rien de tirer au hasard donc");
		testCasTirerAleatoire(3, 3, 3);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : max invalide");
		testCasTirerAleatoire(8, 7, -1);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : min invalide");
		testCasTirerAleatoire(-2, 7, -1);
	}
	
	/**
	 * teste un appel de tirerAleatoire()
	 * @param min le minimum
	 * @param max le maximum
	 * @param resAttendu resultat attendu
	 */
	void testCasTirerAleatoire(int min, int max, int resAttendu) {
		int resExecute = tirerAleatoire(min, max);
		
		if (resAttendu == -1) {
			System.out.print("Résultat attendu -1 : ");
		} else {
			System.out.print("Résultat attendu différent de -1 : ");
		}
		
		if ((resExecute == resAttendu) || (resExecute != -1)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * A partir d'un tableau créé, remplir aléatoirement ce tableau de nbElem valeurs comprises entre min et max
	 * @param leTab le tableau à remplir de valeurs tirées aléatoirement
	 * @param nbElem le nombre d'entiers que contiendra le tableau
	 * @param min la valeur de l'entier minimum
	 * @param max la valeur de l'entier maximum
	 */
	void remplirAleatoire(int[] leTab, int nbElem, int min, int max) {
		boolean verif = verifTab(leTab, nbElem);
		int eltAlea = tirerAleatoire(min, max);
		
		if (verif) {
			if (eltAlea != -1) {
				for (int i = 0; i < nbElem; i++) {
					leTab[i] = eltAlea;
					eltAlea = tirerAleatoire(min, max);
				}
			} else {
				System.err.println("remplirAleatoire - Erreur : tirerAleatoire(min, max)");
			}
		} else {
			if (eltAlea != -1) {
				System.err.println("remplirAleatoire - Erreur : verifTab(leTab, nbElem)");
			} else {
				System.err.println("remplirAleatoire - Erreur : verifTab(leTab, nbElem) et tirerAleatoire(min, max)");
			}
		}
	}
	
	/**
	 * Teste la méthode remplirAleatoire()
	 */
	void testRemplirAleatoire() {
		int[] tab1 = new int[4];
		int[] tab2 = new int[4];
		int[] tab3 = new int[4];
		int[] tab4 = new int[4];
		int[] tab5 = new int[4];
		int[] tab7 = new int[4];
		int[] tab8 = new int[4];
		int[] tab6 = null;
		
		System.out.println();
		System.out.println("*** testRemplirAleatoire() ***");
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab, nbElem, min et max sont valide");
		remplirAleatoire(tab1, 3, 2, 9);
		afficherTab(tab1, 3);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem valide mais est égale à 1");
		remplirAleatoire(tab7, 1, 2, 9);
		afficherTab(tab7, 3);
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : min et max valide mais égaux");
		remplirAleatoire(tab8, 3, 2, 2);
		afficherTab(tab8, 3);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem n'est pas valide");
		remplirAleatoire(tab2, -3, 2, 9);
		afficherTab(tab2, 3);
		
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : max invalide");
		remplirAleatoire(tab3, 3, 2, 1);
		afficherTab(tab3, 3);
		
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : min invalide");
		remplirAleatoire(tab4, 3, -2, 9);
		afficherTab(tab4, 3);
		
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : min et nbElem invalide");
		remplirAleatoire(tab5, -3, -2, 9);
		afficherTab(tab5, 3);
		
		System.out.println();
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide");
		remplirAleatoire(tab6, 0, 2, 9);
		afficherTab(tab6, 3);
	}
	
	/**
	 * Renvoie vrai si les 2 tableaux passés en paramètre sont exactement les mêmes en nombre d'éléments et en contenu (case par case). Tenir compte des cas d'erreurs concernant tab1, nbElem1 et tab2, nbElem2 (appel de verifTab 2 fois) et afficher un éventuel message d'erreur (et dans ce cas renvoyer faux)
	 * @param tab1 le 1er tableau à comparer
	 * @param tab2 le 2ème tableau à comparer
	 * @param nbElem1 le nombre d'entiers présents dans le 1er tableau
	 * @param nbElem2 le nombre d'entiers présents dans le 2ème tableau
	 * @return true si égalité parfaite sinon false
	 */
	boolean egalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		boolean res = true;
		boolean verif1 = verifTab(tab1, nbElem1);
		boolean verif2 = verifTab(tab2, nbElem2);
		
		if (nbElem1 == nbElem2) {
			if (verif1 && verif2) {
				for (int i = 0; i < nbElem1; i++) {
					if (tab1[i] != tab2[i]) {
						res = false;
					}
				}
				if (res) {
					System.out.println("Les deux tableaux sont identiques");
				} else {
					System.out.println("Les deux tableaux sont différents");
				}
			} else {
				res = false;
				System.err.println("egalite - Erreur : verifTab(tab1, nbElem1) ou verifTab(tab2, nbElem2");
			}
		} else {
			res = false;
			if (verif1 && verif2) {
				System.err.println("egalite - Erreur : nbElem1 et nbElem2 sont différents");
			} else {
				System.err.println("egalite - Erreur : nbElem1 et nbElem2 sont différents et verifTab(tab1, nbElem1) ou verifTab(tab2, nbElem2");
			}
		}
		return res;
	}
	
	/**
	 * Teste la méthode egalite()
	 */
	void testEgalite() {
		int[] tab1 = new int[4];
		int[] tab2 = new int[4];
		int[] tab3 = {0, 0, 0, 1};
		int[] tab4 = null;
		
		System.out.println();
		System.out.println("*** testEgalite() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : tab1, tab2, nbElem1 et nbElem2 valide et nbElem1 = nbElem2");
		testCasEgalite(tab1, tab2, 4, 4, true);
		System.out.println("- - - - - - - - - - -");
		testCasEgalite(tab1, tab3, 4, 4, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem1 ou nbElem2 égaux à 1");
		testCasEgalite(tab1, tab2, 1, 1, true);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem1 n'est pas égale à nbElem2");
		testCasEgalite(tab1, tab3, 4, 3, false);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : nbElem1 ou nbElem2 invalide");
		testCasEgalite(tab1, tab3, 4, -4, false);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : tab1 ou tab2 invalide");
		testCasEgalite(tab1, tab4, 4, 4, false);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : tab1 ou tab2 invalide et nbElem1 ou nbElem2 invalide");
		testCasEgalite(tab1, tab4, -4, 4, false);
	}
	
	/**
	 * teste un appel de egalite()
	 * @param tab1 le tableau 1
	 * @param tab2 le tableau 2
	 * @param nbElem1 nombre de cases pour tab1
	 * @param nbElem2 nombre de cases pour tab2
	 * @param resAttendu resultat attendu
	 */
	void testCasEgalite(int[] tab1, int[] tab2, int nbElem1, int nbElem2, boolean resAttendu) {
		boolean resExecute = egalite(tab1, tab2, nbElem1, nbElem2);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resExecute == resAttendu){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Renvoie la copie exacte (clone) du tableau passé en paramètre
	 * @param tabToCopy le tableau à copier
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return le nouveau tableau qui est la copie du tableau passé en paramètre
	 */
	int[] copier(int[] tabToCopy, int nbElem) {
		int[] res;
		boolean verif = verifTab(tabToCopy, nbElem);
		
		if (verif) {
			res = new int[nbElem];
			for (int i = 0; i < nbElem; i++) {
				res[i] = tabToCopy[i];
			}
		} else {
			System.err.println("copier - Erreur : verifTab(tabToCopy, nbElem)");
			res = null;
		}
		return res;
	}
	
	/**
	 * Teste la méthode copier()
	 */
	void testCopier() {
		int[] tab1 = {6, 9, 2, -7};
		int[] tab2 = {6, 9, 2};
		int[] tab3 = null;
		int[] tab4 = {6};
		
		System.out.println();
		System.out.println("*** testCopier() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : tabToCopy et nbElem sont valide");
		testCasCopier(tab1, 4, tab1);
		System.out.println("- - - - - - - - - - -");
		testCasCopier(tab1, 3, tab2);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem est égale à 1");
		testCasCopier(tab1, 1, tab4);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasCopier(tab1, 0, null);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : tabToCopy invalide");
		testCasCopier(tab3, 4, null);
	}
	
	/**
	 * teste un appel de copier()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param resAttendu resultat attendu
	 */
	void testCasCopier(int[] leTab, int nbElem, int[] resAttendu) {
		int[] resExecute = copier(leTab, nbElem);
		boolean tabEgaux = egalite(resAttendu, resExecute, nbElem, nbElem);
		
		System.out.print("Résultat attendu = ");
		afficherTab(resAttendu, nbElem);
		System.out.print(" : ");
		if (resAttendu == null) {
			tabEgaux = !tabEgaux;
		}
		if (tabEgaux){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
		
	/**
	 * Renvoie le maximum parmi les éléments du tableau
	 * @param leTab le tableau
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return le maximum des éléments du tableau
	 */
	int leMax(int[] leTab, int nbElem) {
		int res;
		boolean verif = verifTab(leTab, nbElem);
		
		if (verif) {
			res = leTab[0];
			for (int i = 1; i < nbElem; i++) {
				if (res < leTab[i]) {
					res = leTab[i];
				}
			}
		} else {
			System.err.println("leMax - Erreur : verifTab(leTab, nbElem)");
			res = 0;
		}
		return res;
	}
	
	/**
	 * Teste la méthode leMax()
	 */
	void testLeMax() {
		int[] tab1 = {6, 9, 2, -7};
		int[] tab2 = {6, -16, 81};
		int[] tab3 = null;
		
		System.out.println();
		System.out.println("*** testLeMax() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab et nbElem sont valide");
		testCasLeMax(tab1, 4, 9);
		System.out.println("- - - - - - - - - - -");
		testCasLeMax(tab2, 2, 6);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem est égale à 1");
		testCasLeMax(tab1, 1, 6);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasLeMax(tab1, 0, 0);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide");
		testCasLeMax(tab3, 4, 0);
	}
	
	/**
	 * teste un appel de leMax()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param resAttendu resultat attendu
	 */
	void testCasLeMax(int[] leTab, int nbElem, int resAttendu) {
		int resExecute = leMax(leTab, nbElem);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resExecute == resAttendu){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Renvoie un nouveau tableau qui est l'inverse de celui passé en paramètre. Son jème élément est égal au (nbElem+1-j) élément du tableau initial (dans l'explication, j=1 signifie premier élément du tableau)
	 * @param leTab le tableau
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return le nouveau tableau qui est l'inverse de leTab sur la plage (0...nbElem-1)
	 */
	int[] inverse(int[] leTab, int nbElem) {
		int[] res;
		boolean verif = verifTab(leTab, nbElem);
		int temp;
		
		if (verif) {
			res = new int[nbElem];
			for (int i = 0; i < nbElem; i++) {
				res[i] = leTab[nbElem - i - 1];
			}
		} else {
			System.err.println("inverse - Erreur : verifTab(leTab, nbElem)");
			res = null;
		}
		return res;
	}
	
	/**
	 * Teste la méthode inverse()
	 */
	void testInverse() {
		int[] tab1 = {6, 9, 2, -7};
		int[] tab2 = {-7, 2, 9, 6};
		int[] tab3 = {2, 9, 6};
		int[] tab4 = null;
		int[] tab5 = {2, 9, 6};
		int[] tab6 = {2};
		
		System.out.println();
		System.out.println("*** testInverse() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab et nbElem sont valide");
		testCasInverse(tab1, 4, tab2);
		System.out.println("- - - - - - - - - - -");
		testCasInverse(tab1, 3, tab3);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasInverse(tab5, 1, tab6);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasInverse(tab1, 0, null);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide");
		testCasInverse(tab4, 4, null);
	}
	
	/**
	 * teste un appel de inverse()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param resAttendu resultat attendu
	 */
	void testCasInverse(int[] leTab, int nbElem, int[] resAttendu) {
		int[] resExecute = inverse(leTab, nbElem);
		boolean tabEgaux = egalite(resAttendu, resExecute, nbElem, nbElem);
		
		System.out.print("Résultat attendu = ");
		afficherTab(resAttendu, nbElem);
		System.out.print(" : ");
		if (resAttendu == null) {
			tabEgaux = !tabEgaux;
		}
		if (tabEgaux){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Echange les contenus des cases du tableau passé en paramètre, cases identifiées par les indices ind1 et ind2. Vérifier que les indices ind1 et ind2 sont bien compris entre zéro et (nbElem-1), sinon afficher un message d'erreur
	 * @param leTab le tableau
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @param ind1 numéro de la première case à échanger
	 * @param ind2 numéro de la deuxième case à échanger
	 */
	void echange(int[] leTab, int nbElem, int ind1, int ind2) {
		boolean verif = verifTab(leTab, nbElem);
		int temp;
		
		if (verif) {
			if ((ind1 < nbElem) && (ind1 >= 0) && (ind2 < nbElem) && (ind2 >= 0)) {
				temp = leTab[ind1];
				leTab[ind1] = leTab[ind2];
				leTab[ind2] = temp;
			} else {
				System.err.println("echange - Erreur : ind1 ou ind2 est invalide");
			}
		} else {
			System.err.println("echange - Erreur : verifTab(leTab, nbElem)");
		}
	}
	
	/**
	 * Teste la méthode echange()
	 */
	void testEchange() {
		int[] tab1 = {1, 5, 8, 4};
		int[] tab2 = {1, 5, 8, 4};
		int[] tab4 = {1, 5, 8, 4};
		int[] tab5 = {1, 5, 8, 4};
		int[] tab3 = null;
		
		System.out.println();
		System.out.println("*** testEchange() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab, nbElem, min et max sont valide");
		afficherTab(tab1, 4);
		System.out.println();
		System.out.println("Echange de l'élément 1 et 3");
		echange(tab1, 4, 1, 3);
		afficherTab(tab1, 4);
		System.out.println();
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem n'est pas valide");
		afficherTab(tab4, 4);
		System.out.println();
		System.out.println("Echange de l'élément 1 et 1 innutile dans ce cas");
		echange(tab4, 4, 1, 1);
		afficherTab(tab4, 4);
		System.out.println();
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : nbElem est égale à 1");
		afficherTab(tab5, 1);
		System.out.println();
		System.out.println("Echange de l'élément 1 et 1");
		echange(tab5, 1, 0, 0);
		afficherTab(tab5, 1);
		System.out.println();
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem n'est pas valide");
		afficherTab(tab2, 4);
		System.out.println();
		System.out.println("Echange de l'élément 1 et 3 avec nbElem pas valide donc non changement du tableau");
		echange(tab2, 0, 1, 3);
		afficherTab(tab2, 4);
		System.out.println();
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide (donc non affichage)");
		afficherTab(tab3, 4);
		System.out.println();
		System.out.println("Echange de l'élément 1 et 3 avec leTab pas valide donc non changement du tableau");
		echange(tab3, 0, 1, 3);
		afficherTab(tab3, 4);
		System.out.println();
	}
	
	/**
	 * Retourne un nouveau tableau qui a la même taille et les mêmes occurrences d'élements que le tableau passé en paramètre mais ces éléments sont répartis selon des indices aléatoires (0 plus petit ou égale indice plus petit ou égale nbElem-1). Une technique simple consiste à utiliser les méthodes "echange" et "tirerAleatoire" pour effectuer le mélange
	 * @param leTab le tableau
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @return le nouveau tableau qui a le même contenu que le tableau initial mais mélangé
	 */
	int[] melange(int[] leTab, int nbElem) {
		int[] res;
		boolean verif = verifTab(leTab, nbElem);
		int j;
		
		if (verif) {
			res = copier(leTab, nbElem);
			for (int i = 0; i < nbElem; i++) {
				j = tirerAleatoire(0, nbElem - 1);
				echange(res, nbElem, i, j);
			}
		} else {			
			System.err.println("melange - Erreur : verifTab(leTab, nbElem)");
			res = null;
		}
		return res;
	}
	
	/**
	 * Teste la méthode melange()
	 */
	void testMelange() {
		int[] tab1 = {6, 9, 2, -7};
		int[] tab2 = {6, 9, 2, -7};
		int[] tab3 = {6, 9, 2, -7};
		int[] tab5 = {6, 9, 2, -7};
		int[] tab4 = null;
		
		System.out.println();
		System.out.println("*** testMelange() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab et nbElem sont valide");
		testCasMelange(tab1, 4, tab1);
		System.out.println("- - - - - - - - - - -");
		testCasMelange(tab2, 3, tab1);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem est égale à 1");
		testCasMelange(tab5, 1, tab5);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasMelange(tab3, 0, null);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide");
		testCasMelange(tab4, 4, null);
	}
	
	/**
	 * teste un appel de melange()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param resAttendu resultat attendu
	 */
	void testCasMelange(int[] leTab, int nbElem, int[] resAttendu) {
		int[] resExecute = melange(leTab, nbElem);
		boolean result = resExecute == null;
		
		if (resExecute != null) {
			System.out.print("Résultat attendu = différent de null : ");
			result = !result;
		} else {
			System.out.print("Résultat attendu = null : ");
		}
		
		if (result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Décale de une case de la droite vers la gauche toutes les cases d'un tableau à partir d'un indice "ind" et jusque nbElem-1 ([ind]-[ind+1]-[ind+2]-...-[nbElem-2]-[nbElem-1]). Vérifier que ind est compris entre 0 et (nbElem-2) sinon afficher une erreur
	 * @param leTab le tableau
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @param ind l'indice à partir duquel commence le décalage à gauche
	 */
	void decalerGche(int[] leTab, int nbElem, int ind) {
		boolean verif = verifTab(leTab, nbElem);
		
		if (verif) {
			if ((ind <= nbElem - 2) && (ind >= 0)) {
				for (int i = ind; i < nbElem - 1; i++) {
					leTab[i] = leTab[i+1];
				}
			} else {
				System.err.println("decalerGche - Erreur : ind n'est pas compris entre 0 et nbElem - 2");
			}
		} else {			
			System.err.println("decalerGche - Erreur : verifTab(leTab, nbElem)");
		}
	}
	
	/**
	 * Teste la méthode decalerGche()
	 */
	void testDecalerGche() {
		int[] tab1 = {1, 5, 8, 4};
		int[] tab2 = {1, 5, 8, 4};
		int[] tab4 = {1, 5, 8, 4};
		int[] tab5 = {1, 5, 8, 4};
		int[] tab3 = null;
		
		System.out.println();
		System.out.println("*** testDecalerGche() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab, nbElem et ind sont valide");
		afficherTab(tab1, 4);
		System.out.println();
		System.out.println("Decaler à partir de 1");
		decalerGche(tab1, 4, 0);
		afficherTab(tab1, 4);
		System.out.println();
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem n'est pas valide");
		afficherTab(tab2, 4);
		System.out.println();
		System.out.println("Decaler à partir de 1");
		decalerGche(tab2, 0, 1);
		afficherTab(tab2, 4);
		System.out.println();
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : nbElem est égale à 1");
		afficherTab(tab4, 1);
		System.out.println();
		System.out.println("Decaler à partir de 0");
		decalerGche(tab4, 1, 0);
		afficherTab(tab4, 1);
		System.out.println();
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : ind n'est pas valable");
		afficherTab(tab5, 4);
		System.out.println();
		System.out.println("Decaler à partir de 3");
		decalerGche(tab5, 4, 3);
		afficherTab(tab5, 4);
		System.out.println();
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide (donc non affichage)");
		afficherTab(tab3, 4);
		System.out.println();
		System.out.println("Decaler à partir de 1");
		decalerGche(tab3, 0, 1);
		afficherTab(tab3, 4);
		System.out.println();
	}
	
	/**
	 * Supprime du tableau la première case rencontrée dont le contenu est égale à "valeur". La case du tableau est supprimée par décalage à gauche des cases du tableau. L'appel de la méthode "decalerGche" est obligatoire. A l'issue de la suppression (si elle existe) le nombre d'éléments dans le tableau est décrémenté et retourné
	 * @param leTab le tableau
	 * @param nbElem le nombre d'entiers présents dans le tableau
	 * @param valeur le contenu de la première case à supprimer
	 * @return le nombre d'éléments dans le tableau (éventuellement inchangé)
	 */
	int supprimerUneValeur(int[] leTab, int nbElem, int valeur) {
		boolean verif = verifTab(leTab, nbElem);
		boolean valExiste = true;
		
		if (verif) {
			int i = 0;
			while (i < nbElem && valExiste) {
				if (leTab[i] == valeur) {
					if (i != nbElem - 1) {
						decalerGche(leTab, nbElem, i);
					}
					valExiste = false;
					nbElem--;
				}
				i++;
			}
		} else {			
			System.err.println("supprimerUneValeur - Erreur : verifTab(leTab, nbElem)");
		}
		return nbElem;
	}
	
	/**
	 * Teste la méthode supprimerUneValeur()
	 */
	void testSupprimerUneValeur() {
		int[] tab1 = {6, 9, 2, -7};
		int[] tab2 = {6, 9, 2, -7};
		int[] tab3 = {6, 9, 2, -7};
		int[] tab5 = {6};
		int[] tab4 = null;
		
		System.out.println();
		System.out.println("*** testSupprimerUneValeur() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab, nbElem et valeur sont valide");
		testCasSupprimerUneValeur(tab1, 4, 9, 3);
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : valeur est égale au dernier élément du tableau");
		testCasSupprimerUneValeur(tab2, 4, -7, 3);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem est égale à 1");
		testCasSupprimerUneValeur(tab5, 1, 6, 0);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasSupprimerUneValeur(tab3, 0, 2, 0);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide");
		
		testCasSupprimerUneValeur(tab4, 4, 2, 4);
	}
	
	/**
	 * teste un appel de supprimerUneValeur()
	 * @param leTab le tableau
	 * @param nbElem nombre de cases
	 * @param valeur le contenu de la première case à supprimer
	 * @param resAttendu resultat attendu
	 */
	void testCasSupprimerUneValeur(int[] leTab, int nbElem, int valeur, int resAttendu) {
		int resExecute = supprimerUneValeur(leTab, nbElem, valeur);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu == resExecute){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Renvoie vrai ssi le tableau tab1 est inclus dans tab2. Autrement dit, si tous les éléments de tab1 se retrouvent intégralement dans tab2 (y compris les doublons) mais pas nécessairement dans le même ordre
	 * @param tab1 le premier tableau
	 * @param tab2 le deuxième tableau
	 * @param nbElem1 le nombre d'entiers présents dans le tableau1
	 * @param nbElem2 le nombre d'entiers présents dans le tableau2
	 * @return vrai ssi tableau1 est inclus dans tableau2
	 */
	boolean inclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2) {
		boolean verif1 = verifTab(tab1, nbElem1);
		boolean verif2 = verifTab(tab2, nbElem2);
		boolean res = true;
		int[] tab2Copy;
		int nbElem2Copy = nbElem2;
		int nbElem2CopyTemp = nbElem2Copy;
		
		if (verif1 && verif2) {
			tab2Copy = copier(tab2, nbElem2);
			int i = 0; 
			
			while (i < nbElem1 && res) {
				nbElem2Copy = supprimerUneValeur(tab2Copy, nbElem2Copy, tab1[i]);
				if (nbElem2Copy == nbElem2CopyTemp) {
					res = false;
				}
				nbElem2CopyTemp = nbElem2Copy;
				i++;
			}
		} else {			
			System.err.println("supprimerUneValeur - Erreur : verifTab(tab1, nbElem1) ou verifTab(tab2, nbElem2)");
			res = false;
		}
		return res;
	}
	
	/**
	 * Teste la méthode inclusion()
	 */
	void testInclusion() {
		int[] tab1 = {6, 9, 2, -7};
		int[] tab2 = {6, 6, 2, -7};
		int[] tab3 = {-7, 8, 2, 9, 6, 6};
		int[] tab4 = {-7, 8, 0, 9};
		int[] tab6 = {-7};
		int[] tab5 = null;
		
		System.out.println();
		System.out.println("*** testInclusion() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab, nbElem et valeur sont valide");
		testCasInclusion(tab1, tab3, 4, 5, true);
		System.out.println("- - - - - - - - - - -");
		testCasInclusion(tab2, tab3, 4, 6, true);
		System.out.println("- - - - - - - - - - -");
		testCasInclusion(tab2, tab4, 4, 4, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem1 est égale à 1");
		testCasInclusion(tab6, tab3, 1, 4, true);
		System.out.println("Cas : nbElem1 plus grand que nbElem2 ");
		testCasInclusion(tab3, tab1, 6, 4, false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem invalide");
		testCasInclusion(tab1, tab3, 4, 9, false);
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide");
		testCasInclusion(tab5, tab4, 4, 6, false);
	}
	
	/**
	 * teste un appel de inclusion()
	 * @param tab1 le premier tableau
	 * @param tab2 le deuxième tableau
	 * @param nbElem1 le nombre d'entiers présents dans le tableau1
	 * @param nbElem2 le nombre d'entiers présents dans le tableau2
	 * @param resAttendu resultat attendu
	 */
	void testCasInclusion(int[] tab1, int[] tab2, int nbElem1, int nbElem2, boolean resAttendu) {
		boolean resExecute = inclusion(tab1, tab2, nbElem1, nbElem2);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu == resExecute){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * A partir d'un tableau déjà créé, remplir le tableau de nbElem valeurs saisies par l'utilisateur. Au fur et à mesure de la saisie, si la nouvelle valeur saisie existe déjà dans le tableau alors ne pas l'insérer et demander de ressaisir. Tenir compte des cas d'erreurs concernant leTab et nbElem (appel de verifTab)
	 * @param leTab le tableau à remplir d'éléments tous différents
	 * @param nbElem le nombre d'entiers que contiendra le tableau
	 */
	void remplirToutesDiff(int[] leTab, int nbElem) {
		boolean verif = verifTab(leTab, nbElem);
		
		if (verif) {
			for (int i = 0; i < nbElem; i++) {
				int val;
				boolean inclus;
				do {
					val = SimpleInput.getInt("Valeur de la case " + i + " du tableau");
					int[] valChoisi = {val};
					inclus = inclusion(valChoisi, leTab, 1, nbElem);
				} while (inclus);
				leTab[i] = val;
				}
		} else {			
			System.err.println("supprimerUneValeur - Erreur : verifTab(leTab, nbElem)");
		}
	}
	
	/**
	 * Teste la méthode remplirToutesDiff()
	 */
	void testRemplirToutesDiff() {
		int[] tab1 = new int[5];
		int[] tab2 = new int[1];
		int[] tab3 = new int[5];
		int[] tab4 = null;
		
		System.out.println();
		System.out.println("*** testRemplirToutesDiff() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Cas : leTab, nbElem et ind sont valide");
		afficherTab(tab1, 5);
		System.out.println();
		remplirToutesDiff(tab1, 5);
		afficherTab(tab1, 5);
		System.out.println();
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Cas : nbElem est égale à 1");
		afficherTab(tab2, 1);
		System.out.println();
		System.out.println("nbElem est égale à 1");
		remplirToutesDiff(tab2, 1);
		afficherTab(tab2, 1);
		System.out.println();
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Cas : nbElem n'est pas valide");
		afficherTab(tab3, 5);
		System.out.println();
		System.out.println("nbElem invalide donc non changement du tableau");
		remplirToutesDiff(tab3, 0);
		afficherTab(tab3, 5);
		System.out.println();
		
		System.out.println("- - - - - - - - - - -");
		System.out.println("Cas : leTab invalide (donc non affichage)");
		afficherTab(tab4, 5);
		System.out.println();
		System.out.println("leTab invalide donc non changement du tableau");
		remplirToutesDiff(tab4, 0);
		afficherTab(tab4, 5);
		System.out.println();
	}
}
