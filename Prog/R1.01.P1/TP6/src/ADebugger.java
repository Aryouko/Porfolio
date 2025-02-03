/**
 * Compte le nombre de jours entre deux dates
 * @author Stagiaire LN
 */
class ADebugger {
    
    void principal () {
		testAnneeBisextile();
		testNbJourAnnee();
		testNbJourMois();
		testNbJourEntreDates();
    }
    
    /**
     * Méthode permettant de tester si une année est bisextile
     * @param annee un entier représentant l'année
     * @return un boolean true si c'est une année bisextile, false sinon
     */
    boolean anneeBisextile (int annee){
        return (annee%4 == 0 && annee%100 !=0)||(annee%400 == 0);
    }
    
    /**
	* Procédure permettant de tester un appel de anneeBisextile()
	* @param annee un entier
	* @param result resultat attendu
	**/
	void testCasAnneeBisextile(int annee, boolean result) {
		
		// Affichage
		System.out.print ("anneeBisextile(" + annee + ") \t= " + result + "\t : ");
		
		// Appel
		boolean resExec = anneeBisextile(annee);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* Procédure permettant de tester la méthode anneeBisextile()
	*/
	void testAnneeBisextile() {
		System.out.println ();
		System.out.println ("*** testAnneeBisextile()");
		
		testCasAnneeBisextile(4, true);
		testCasAnneeBisextile(400, true);
		testCasAnneeBisextile(2024, true);
		testCasAnneeBisextile(2023, false);
		testCasAnneeBisextile(2022, false);
		testCasAnneeBisextile(100, false);
	}	
    
    /**
     * Méthode permettant de compter le nombre de jour dans une année
     * @param annee un entier représentant l'année
     * @return nbJour le nombre de jour
     */
    int nbJourAnnee (int annee){
        int nbJour = 0;
        
        if (anneeBisextile(annee)) {
			nbJour = 366;
        } else {
			nbJour = 365;
		}
        
        return nbJour;
    }
    
    /**
	* Procédure permettant de tester un appel de nbJourAnnee()
	* @param annee un entier
	* @param result resultat attendu
	**/
	void testCasNbJourAnnee(int annee, int result) {
		
		// Affichage
		System.out.print ("nbJourAnnee(" + annee + ") \t= " + result + "\t : ");
		
		// Appel
		int resExec = nbJourAnnee(annee);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* Procédure permettant de tester la méthode nbJourAnnee()
	*/
	void testNbJourAnnee() {
		System.out.println ();
		System.out.println ("*** testNbJourAnnee()");
		
		testCasNbJourAnnee(4, 366);
		testCasNbJourAnnee(400, 366);
		testCasNbJourAnnee(2024, 366);
		testCasNbJourAnnee(2023, 365);
		testCasNbJourAnnee(2022, 365);
		testCasNbJourAnnee(100, 365);
	}
    
       
	/**
     * Méthode permettant de compter le nombre de jour dans un mois
     * @param mois un entier représentant le mois
     * @param annee un entier représentant l'année
     * @return nbJour le nombre de jour
     */
    int nbJourMois (int mois, int annee){
        int nbJour = 0;
        
        if (mois == 2) {
			if (anneeBisextile(annee)) {
				nbJour = 29;
			} else {
				nbJour = 28;
			}
        } else if(mois <= 7) {
			nbJour = 30 + mois%2;
        } else {
			nbJour = 31 - mois%2;
        }   
        
        return nbJour;
    }
    
    /**
	* Procédure permettant de tester un appel de nbJourMois()
	* @param mois un entier
	* @param annee un entier
	* @param result resultat attendu
	**/
	void testCasNbJourMois(int mois, int annee, int result) {
		
		// Affichage
		System.out.print ("nbJourMois(" + mois + ", " + annee + ") \t= " + result + "\t : ");
		
		// Appel
		int resExec = nbJourMois(mois, annee);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* Procédure permettant de tester la méthode nbJourMois()
	*/
	void testNbJourMois() {
		System.out.println ();
		System.out.println ("*** testNbJourMois()");
		
		testCasNbJourMois(12, 1762, 31);
		testCasNbJourMois(6, 400, 30);
		testCasNbJourMois(2, 400, 29);
		testCasNbJourMois(2, 2023, 28);
	}
    
    /**
     * Méthode permettant de compter le nombre de jour dans un mois
     * @param jourDate1 un entier représentant le jour de la première date
     * @param moisDate1 un entier représentant le mois de la première date
     * @param anneeDate1 un entier représentant l'année de la première date
     * @param jourDate2 un entier représentant le jour de la deuxième date
     * @param moisDate2 un entier représentant le mois de la deuxième date
     * @param anneeDate2 un entier représentant l'année de la deuxième date
     * @return nbJour le nombre de jour entre les deux dates
     */
    int nbJourEntreDates (int jourDate1, int moisDate1, int anneeDate1, int jourDate2, int moisDate2, int anneeDate2){
        int nbJour = 0;
        int i = anneeDate1+1;

        while (i < anneeDate2) {
			nbJour += nbJourAnnee (i);
			i = i + 1;
        }

        i = moisDate1 + 1;
        while (i <= 12 && anneeDate1 < anneeDate2) {
			nbJour += nbJourMois (i,anneeDate1);
			i++;
        }

        i = 1;
        while (i < moisDate2 && anneeDate1 < anneeDate2) {
			nbJour += nbJourMois (i, anneeDate2);
			i++;
        }
		
		if (moisDate1 == moisDate2 && anneeDate1 == anneeDate2) {
			nbJour += jourDate2 - jourDate1;
		} else {
			nbJour += nbJourMois (moisDate1, anneeDate1) - jourDate1;
			nbJour += jourDate2 ;
		}

        return nbJour;
        
    }
    
    /**
	* Procédure permettant de tester un appel de nbJourEntreDates()
	* @param mois un entier
	* @param annee un entier
	* @param result resultat attendu
	**/
	void testCasNbJourEntreDates(int jourDate1, int moisDate1, int anneeDate1, int jourDate2, int moisDate2, int anneeDate2, int result) {
		
		// Affichage
		System.out.print ("nbJourEntreDates(" + jourDate1 + ", " + moisDate1 + ", " + anneeDate1 + ", " + jourDate2 + ", " + moisDate2 + ", " + anneeDate2 + ", " + ") \t= " + result + "\t : ");
		
		// Appel
		int resExec = nbJourEntreDates(jourDate1, moisDate1, anneeDate1, jourDate2, moisDate2, anneeDate2);
		
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* Procédure permettant de tester la méthode nbJourEntreDates()
	*/
	void testNbJourEntreDates() {
		System.out.println ();
		System.out.println ("*** testNbJourEntreDates()");
		
		testCasNbJourEntreDates(27,10,1818,30,10,1818, 3);
		testCasNbJourEntreDates(24,03,2006,15,10,2024, 6780);
		testCasNbJourEntreDates(27,10,1818,27,11,1818, 31);
		testCasNbJourEntreDates(27,02,2024,3,03,2024, 5);
	}


}   
