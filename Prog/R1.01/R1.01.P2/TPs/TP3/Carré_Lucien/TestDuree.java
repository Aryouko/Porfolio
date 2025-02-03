/**
 * Cette classe effectue les tests nécessaires à la classe Durée
 * @author L.Carré
 */
class TestDuree {
	
	/**
	 * Le point d'entré du programme
	 */
	void principal() {
		testConstructeur1EtGetLeTemps() ;
		testConstructeur2EtGetLeTemps() ;
		testAjouter() ;
		testSoustraire() ;
		testCompareA() ;
		testEnTexte() ;
	}

	/**
	 * Teste la méthode constructeur1EtGetLeTemps()
	 */
	void testConstructeur1EtGetLeTemps() {
		System.out.println();
		System.out.println("*** testConstructeur1EtGetLeTemps() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Création d'une durée positif");
		int duree = 56;
		testCasConstructeur1EtGetLeTemps(duree, duree, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Création d'une durée égale à 0");
		duree = 0;
		testCasConstructeur1EtGetLeTemps(duree, duree, false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Création d'une durée négatif");
		duree = -56;
		testCasConstructeur1EtGetLeTemps(duree, 0, true);
	}
	
	/**
	 * Teste un appel de constructeur1EtGetLeTemps()
	 * @param duree durée de la durée
	 * @param resAttendu le résultat attendu
	 * @param casErr cas d'erreur attendu
	 */
	void testCasConstructeur1EtGetLeTemps(int duree, int resAttendu, boolean casErr) {
		Duree d = new Duree(duree);
		int resExecute = d.getLeTemps();
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (!casErr) {
			if (resAttendu == resExecute){
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		} else {
			System.out.println("Message d'erreur attendu");
		}
	}
		
	/**
	 * Teste la méthode constructeur2EtGetLeTemps()
	 */
	void testConstructeur2EtGetLeTemps() {
		System.out.println();
		System.out.println("*** testConstructeur2EtGetLeTemps() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Création d'une durée positif");
		int duree = 5520000;
		testCasConstructeur2EtGetLeTemps(1, 32, 0, duree, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Création d'une durée égale à 0");
		duree = 0;
		testCasConstructeur2EtGetLeTemps(0, 0, 0, duree, false);
		System.out.println("- - - - - - - - - - -");
		System.out.println("Création d'une durée avec secondes > 60");
		duree = 72000;
		testCasConstructeur2EtGetLeTemps(0, 0, 72, duree, false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Création d'une durée négatif");
		testCasConstructeur2EtGetLeTemps(0, 0, -32, 0, true);
	}
	
	/**
	 * Teste un appel de constructeur2EtGetLeTemps()
	 * @param H heure de la durée
	 * @param M minutes de la durée
	 * @param S secondes de la durée
	 * @param resAttendu le résultat attendu
	 * @param casErr cas d'erreur attendu
	 */
	void testCasConstructeur2EtGetLeTemps(int H, int M, int S, int resAttendu, boolean casErr) {
		Duree d = new Duree(H, M, S);
		int resExecute = d.getLeTemps();
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (!casErr) {
			if (resAttendu == resExecute){
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		} else {
			System.out.println("Message d'erreur attendu");
		}
	}
	
	/**
	 * Teste la méthode ajouter()
	 */
	void testAjouter() {
		System.out.println();
		System.out.println("*** testAjouter() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Ajout d'une durée positif");
		Duree d1 = new Duree(56);
		Duree d2 = new Duree(34);
		testCasAjouter(d1, d2, 90, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Ajout d'une durée égale à 0");
		Duree d3 = new Duree(56);
		Duree d4 = new Duree(0);
		testCasAjouter(d3, d4, 56, false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Ajout d'une durée null");
		Duree d5 = new Duree(56);
		Duree d6 = null;
		testCasAjouter(d5, d6, 56, true);
	}
	
	/**
	 * Teste un appel de ajouter()
	 * @param duree1 à ajouter
	 * @param duree2 ajouté
	 * @param resAttendu le résultat attendu
	 * @param casErr cas d'erreur attendu
	 */
	void testCasAjouter(Duree duree1, Duree duree2, int resAttendu, boolean casErr) {
		duree1.ajouter(duree2);
		int resExecute = duree1.getLeTemps();
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (!casErr) {
			if (resAttendu == resExecute){
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		} else {
			System.out.println("Message d'erreur attendu");
		}
	}
	
	/**
	 * Teste la méthode soustraire()
	 */
	void testSoustraire() {
		System.out.println();
		System.out.println("*** testSoustraire() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Soustraction d'une durée positif");
		Duree d1 = new Duree(56);
		Duree d2 = new Duree(34);
		testCasSoustraire(d1, d2, 22, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Soustraction d'une durée égale à 0");
		Duree d3 = new Duree(56);
		Duree d4 = new Duree(0);
		testCasSoustraire(d3, d4, 56, false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Soustraction d'une durée null");
		Duree d5 = new Duree(56);
		Duree d6 = null;
		testCasSoustraire(d5, d6, 56, true);
		System.out.println("- - - - - - - - - - -");
		System.out.println("Soustraction d'une durée positif plus grande que la première");
		Duree d9 = new Duree(56);
		Duree d10 = new Duree(68);
		testCasSoustraire(d9, d10, 56, true);
	}
	
	/**
	 * Teste un appel de soustraire()
	 * @param duree1 durée à soustraire
	 * @param duree2 durée soustraite
	 * @param resAttendu le résultat attendu
	 * @param casErr cas d'erreur attendu
	 */
	void testCasSoustraire(Duree duree1, Duree duree2, int resAttendu, boolean casErr) {
		duree1.soustraire(duree2);
		int resExecute = duree1.getLeTemps();
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (!casErr) {
			if (resAttendu == resExecute){
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		} else {
			System.out.println("Message d'erreur attendu");
		}
	}
	
	/**
	 * Teste la méthode compareA()
	 */
	void testCompareA() {
		System.out.println();
		System.out.println("*** testCompareA() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Compare à une durée positif plus petite");
		Duree d1 = new Duree(56);
		Duree d2 = new Duree(34);
		testCasCompareA(d1, d2, 1, false);
		System.out.println("Compare à une durée positif plus grande");
		Duree d9 = new Duree(56);
		Duree d10 = new Duree(64);
		testCasCompareA(d9, d10, -1, false);
		System.out.println("Compare à une durée positif égale à la première");
		Duree d11 = new Duree(56);
		Duree d12 = new Duree(56);
		testCasCompareA(d11, d12, 0, false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Compare à une durée égale à 0");
		Duree d3 = new Duree(56);
		Duree d4 = new Duree(0);
		testCasCompareA(d3, d4, 1, false);
		System.out.println("Compare une durée avec elle-même");
		testCasCompareA(d3, d3, 0, false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Compare à une durée null");
		Duree d5 = new Duree(56);
		Duree d6 = null;
		testCasCompareA(d5, d6, -2, true);
	}
	
	/**
	 * Teste un appel de compareA()
	 * @param duree1 durée à comparer
	 * @param duree2 durée à comparer
	 * @param resAttendu le résultat attendu
	 * @param casErr cas d'erreur attendu
	 */
	void testCasCompareA(Duree duree1, Duree duree2, int resAttendu, boolean casErr) {
		int resExecute = duree1.compareA(duree2);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (!casErr) {
			if (resAttendu == resExecute){
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		} else {
			System.out.println("Message d'erreur attendu");
		}
	}
	
	/**
	 * Teste la méthode enTexte()
	 */
	void testEnTexte() {
	System.out.println();
		System.out.println("*** testEnTexte() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Affiche une durée avec le mode J");
		Duree d1 = new Duree(86000000);
		testCasEnTexte(d1, 'J', "00 jours 23 h", false);
		System.out.println("Affiche une durée avec le mode H");
		testCasEnTexte(d1, 'H', "23:53:20", false);
		System.out.println("Affiche une durée avec le mode S");
		testCasEnTexte(d1, 'S', "86000.0 sec", false);
		System.out.println("Affiche une durée avec le mode M");
		testCasEnTexte(d1, 'M', "86000000 millisec", false);
		
		System.out.println();
		System.out.println("* Cas limite *");
		System.out.println("Affiche une durée (1000 millisec) dans un mode pas assez précis");
		Duree d2 = new Duree(1000);
		testCasEnTexte(d2, 'J', "00 jours 00 h", false);
		
		System.out.println();
		System.out.println("* Cas d'erreur *");
		System.out.println("Affiche à une durée null avec un mauvais mode");
		testCasEnTexte(d1, 'Y', "null", true);
	}
	
	/**
	 * Teste un appel de enTexte()
	 * @param duree une durée à afficher
	 * @param mode le mode d'affichage
	 * @param resAttendu le résultat attendu
	 * @param casErr cas d'erreur attendu
	 */
	void testCasEnTexte(Duree duree, char mode, String resAttendu, boolean casErr) {
		String resExecute = duree.enTexte(mode);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (!casErr) {
			if (resAttendu.equals(resExecute)) {
				System.out.println ("OK");
			} else {
				System.err.println ("ERREUR");
			}
		} else {
			System.out.println("Message d'erreur attendu");
		}
	}	
}
