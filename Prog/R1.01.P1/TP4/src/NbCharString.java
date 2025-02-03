/**
*Programme qui compte le nbr d'un caractère donné dans une chaine donnée
*@author L.Carré
*/
class NbCharString{
	void principal() {
		testnbOcc();
	}	


	/**
	* Teste la méthode nbOcc()
	*/
	void testnbOcc () {
		System.out.println ();
		System.out.println ("*** testnbOcc()");
		
		char c1 = 'a';
		char c2 = 'b';
		char c3 = ' ';
		
		testCasnbOcc ("", c1, 0);
		testCasnbOcc ("abbba", c1, 2);
		testCasnbOcc ("abbba", c2, 3);
		testCasnbOcc ("  b", c3, 2);
	}
	
	/**
	* teste un appel de nbOcc
	* @param chaine une chaine de caractères
	* @param c un caractère à compter
	* @param result resultat attendu
	**/
	void testCasnbOcc (String chaine, char c, int result) {
		// Affichage
		System.out.print ("nbOcc('" + chaine + "', '" + c + "') \t= " + result + "\t : ");
		// Appel
		int resExec = nbOcc(chaine, c);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* cherche combien de fois un caractère est présent dans une chaîne de caractères
	* @param chaine Chaine de caractère
	* @param car Caractere a rechercher
	* @return nombre d’occurences de car dans chaine
	*/
	int nbOcc (String chaine, char c) {
		int cpt = 0;
		for (int i = 0; i < chaine.length(); i++) {
			if (chaine.charAt(i) == c) {
				cpt++;
			}
		}
		return cpt;
	}
}
