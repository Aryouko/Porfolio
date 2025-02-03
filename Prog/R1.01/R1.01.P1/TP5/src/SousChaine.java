/**
*Programme qui compte le nombre de valeurs différentes
*@author L.Carré
*/
class SousChaine{
	void principal() {
		testEstSousChaine();
	}
	
	
	
	/**
	* teste si une chaîne est une sous-chaîne d’une autre
	* @param mot chaîne de caractères
	* @param phrase chaîne de carectères
	* @return vrai ssi mot est présent dans phrase
	*/
	boolean estSousChaine (String mot, String phrase) {
		boolean res = false;
        for (int i = 0; i <= phrase.length() - mot.length(); i++) {
			int j = 0;
			int finMot = 0;
            while (j < mot.length() && !res) {
                if (phrase.charAt(i + j) == mot.charAt(j)) {
					finMot += 1;
                }
                j++;
                if (finMot == mot.length()) {
					res = true;
				}
			}
        }
        return res;
    }
	
	
	/**
	* teste un appel de estSousChaine()
	* @param mot chaîne de caractères
	* @param phrase chaîne de carectères
	* @param result resultat attendu
	**/
	void testCasEstSousChaine(String mot, String phrase, boolean result) {
		// Affichage
		System.out.print ("estSousChaine(" + mot + ", " + phrase + ") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estSousChaine(mot, phrase);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	/**
	* Teste la méthode estSousChaine()
	*/
	void testEstSousChaine() {
		System.out.println ();
		System.out.println ("*** testEstSousChaine()");
		
		String mot = "ses";
		String phrase1 = "abcdsesdef";
		String phrase2 = "abcdef";
		String phrase3 = "ab";
		String phrase4 = "absee";
		String phrase5 = "abses";
		
		
		testCasEstSousChaine(mot, phrase1, true);
		testCasEstSousChaine(mot, phrase2, false);
		testCasEstSousChaine(mot, phrase3, false);
		testCasEstSousChaine(mot, phrase4, false);
		testCasEstSousChaine(mot, phrase5, true);
		
	}
}
