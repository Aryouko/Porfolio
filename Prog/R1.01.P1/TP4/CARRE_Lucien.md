# R1.01 : TP4

**Nom :** Carré
**Prénom :** Lucien
**Groupe :** D2

## Exercice 1

```java
/**
*Programme qui calcul la combinaison de deux entiers positifs
*@author L.Carré
*/
class CalculCombinaisons{
	void principal() {
		testFactorielle();
		System.out.println();
		testCombinaison();
	}
	
	
	/**
	* Teste la méthode factorielle()
	*/
	void testFactorielle () {
		System.out.println ();
		System.out.println ("*** testFactorielle()");
		
		testCasFactorielle (5, 120);
		testCasFactorielle (0, 1);
		testCasFactorielle (1, 1);
		testCasFactorielle (2, 2);
	}
	
	/**
	* teste un appel de factorielle
	* @param n valeur de la factorielle à calculer
	* @param result resultat attendu
	**/
	void testCasFactorielle (int n, int result) {
		// Affichage
		System.out.print ("factorielle (" + n + ") \t= " + result + "\t : ");
		// Appel
		int resExec = factorielle(n);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}

	/**
	* calcul de la factorielle du paramètre
	* @param n valeur de la factoriel à calculer, n>=0
	* @return factorielle de n
	*/
	int factorielle (int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res = res * i;
		}
		return res;
	}
	
	
	/**
	* Teste la méthode combinaison()
	*/
	void testCombinaison () {
		System.out.println ();
		System.out.println ("*** testCombinaison()");
		
		testCasCombinaison (25, 24, 25);
		testCasCombinaison (5, 0, 1);
		testCasCombinaison (4, 4, 1);
		testCasCombinaison (8, 2, 28);
	}
	
	/**
	* teste un appel de combinaison
	* @param n valeur de la combinaison à calculer
	* @param k autre valeur de la combinaison à calculer
	* @param result resultat attendu
	**/
	void testCasCombinaison (int n, int k, int result) {
		// Affichage
		System.out.print ("Combinaison(" + n + ", " + k + ") \t= " + result + "\t : ");
		// Appel
		int resExec = combinaison(n, k);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* calcul de la combinaison k parmi n
	* @param n cardinalité de l’ensemble
	* @param k nombre d’éléments dans n avec 0<=k<=n
	* @return nombre de combinaisons de k parmi n
	*/
	int combinaison (int n, int k) {
		return factorielle(n) / (factorielle(k) * factorielle(n-k));
	}
}
```

Test :
```cmd

*** testFactorielle()
factorielle (5) 	= 120	 : OK
factorielle (0) 	= 1	 : OK
factorielle (1) 	= 1	 : OK
factorielle (2) 	= 2	 : OK


*** testCombinaison()
Combinaison(25, 24) 	= 25	 : ERREUR
Combinaison(5, 0) 	= 1	 : OK
Combinaison(4, 4) 	= 1	 : OK
Combinaison(8, 2) 	= 28	 : OK

```

Comment expliquer le résultat obtenu de combinaison(25,24) :
La fonction combinaison utilise la fonction factorielle qui doit calculer à un moment 25! qui est a peu près égale à
1.551121e+25, le problème est que la fonction est créé pour retourné et travailler avec des int mais les int vont jusqu'à
2.147483647e+9. 25! dépasse donc ce nombre il faut donc enlever les int dérangeant et les remplacer par des double (long aurait été bien pour garder des nombres entier mais ça dépasse aussi)

## Exercice 1 Bonus
_Code :_
```java
/**
*Programme qui calcul la combinaison de deux entiers positifs
*@author L.Carré
*/
class CalculCombinaisonsBonus{
	void principal() {
		testFactorielle();
		System.out.println();
		testCombinaison();
	}
	
	
	/**
	* Teste la méthode factorielle()
	*/
	void testFactorielle () {
		System.out.println ();
		System.out.println ("*** testFactorielle()");
		
		testCasFactorielle (5, 120);
		testCasFactorielle (0, 1);
		testCasFactorielle (1, 1);
		testCasFactorielle (2, 2);
	}
	
	/**
	* teste un appel de factorielle
	* @param n valeur de la factorielle à calculer
	* @param result resultat attendu
	**/
	void testCasFactorielle (double n, double result) {
		// Affichage
		System.out.print ("factorielle (" + n + ") \t= " + result + "\t : ");
		// Appel
		double resExec = factorielle(n);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}

	/**
	* calcul de la factorielle du paramètre
	* @param n valeur de la factoriel à calculer, n>=0
	* @return factorielle de n
	*/
	double factorielle (double n) {
		double res = 1;
		for (int i = 1; i <= n; i++) {
			res = res * i;
		}
		return res;
	}
	
	
	/**
	* Teste la méthode combinaison()
	*/
	void testCombinaison () {
		System.out.println ();
		System.out.println ("*** testCombinaison()");
		
		testCasCombinaison (25, 24, 25);
		testCasCombinaison (5, 0, 1);
		testCasCombinaison (4, 4, 1);
		testCasCombinaison (8, 2, 28);
	}
	
	/**
	* teste un appel de combinaison
	* @param n valeur de la combinaison à calculer
	* @param k autre valeur de la combinaison à calculer
	* @param result resultat attendu
	**/
	void testCasCombinaison (double n, double k, double result) {
		// Affichage
		System.out.print ("Combinaison(" + n + ", " + k + ") \t= " + result + "\t : ");
		// Appel
		double resExec = combinaison(n, k);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* calcul de la combinaison k parmi n
	* @param n cardinalité de l’ensemble
	* @param k nombre d’éléments dans n avec 0<=k<=n
	* @return nombre de combinaisons de k parmi n
	*/
	double combinaison (double n, double k) {
		return factorielle(n) / (factorielle(k) * factorielle(n-k));
	}
}
```

_Réponse rédigée :_

Test :
```cmd

*** testFactorielle()
factorielle (5.0) 	= 120.0	 : OK
factorielle (0.0) 	= 1.0	 : OK
factorielle (1.0) 	= 1.0	 : OK
factorielle (2.0) 	= 2.0	 : OK


*** testCombinaison()
Combinaison(25.0, 24.0) 	= 25.0	 : OK
Combinaison(5.0, 0.0) 	= 1.0	 : OK
Combinaison(4.0, 4.0) 	= 1.0	 : OK
Combinaison(8.0, 2.0) 	= 28.0	 : OK

```

## Exercice 2 

_Code :_

```java
/**
*Programme qui test si un nombre divise l'autre nombre
*@author L.Carré
*/
class Diviseur{
	void principal() {
		testEstDiviseur();
	}
	
	
	/**
	* Teste la méthode estDiviseur()
	*/
	void testEstDiviseur () {
		System.out.println ();
		System.out.println ("*** testEstDiviseur()");
		
		testCasEstDiviseur (0, 2, true);
		testCasEstDiviseur (10, 2, true);
		testCasEstDiviseur (7, 7, true);
		testCasEstDiviseur (29, 1, true);
		testCasEstDiviseur (4, 14, false);
		testCasEstDiviseur (22, 8, false);
	}
	
	/**
	* teste un appel de estDiviseur
	* @param q diviseur à calculer
	* @param p entier divisé
	* @param result resultat attendu
	**/
	void testCasEstDiviseur (int p, int q, boolean result) {
		// Affichage
		System.out.print ("estDiviseur(" + p + ", " + q + ") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estDiviseur(p, q);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste la divisibilité de deux entiers
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @return vrai ssi q divise p
	*/
	boolean estDiviseur (int p, int q) {
		boolean res = false;
		if (p%q == 0) {
			res = true;
		}
		return res;
	}
}
```

_Réponse rédigée :_

Test :
```cmd

*** testEstDiviseur()
estDiviseur(0, 2) 	= true	 : OK
estDiviseur(10, 2) 	= true	 : OK
estDiviseur(7, 7) 	= true	 : OK
estDiviseur(29, 1) 	= true	 : OK
estDiviseur(4, 14) 	= false	 : OK
estDiviseur(22, 8) 	= false	 : OK

```

## Exercice 3

_Code :_

```java
/**
*Programme qui test si un nombre est parfait
*@author L.Carré
*/
class Parfait{
	void principal() {
		testEstParfait();
		System.out.println();
		quatreNbParfaits();
	}	
	
	/**
	* teste la divisibilité de deux entiers
	* @param p entier positif à tester pour la divisibilité
	* @param q diviseur strictement positif
	* @return vrai ssi q divise p
	*/
	boolean estDiviseur (int p, int q) {
		boolean res = false;
		if (p%q == 0) {
			res = true;
		}
		return res;
	}
	
	/**
	* Teste la méthode estParfait()
	*/
	void testEstParfait () {
		System.out.println ();
		System.out.println ("*** testEstParfait()");
		
		testCasEstParfait (6, true);
		testCasEstParfait (28, true);
		testCasEstParfait (496, true);
		testCasEstParfait (4, false);
		testCasEstParfait (1, false);
		testCasEstParfait (0, false);
	}
	
	/**
	* teste un appel de estParfait
	* @param a une valeur à tester
	* @param result resultat attendu
	**/
	void testCasEstParfait (int a, boolean result) {
		// Affichage
		System.out.print ("estParfait(" + a + ") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estParfait(a);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste si un nombre est parfait
	* @param a entier positif
	* @return vrai ssi a est un nombre parfait
	*/
	boolean estParfait (int a) {
		boolean res = false;
		int somme = 0;
		for (int i = 1; i < a; i++) {
			if (estDiviseur(a, i)) {
				somme += i;
			}
		}
		if ((a == somme) && (somme != 0)) {
			res = true;
		}
		return res;
	}
	
	/**
	* Affiche les quatre premiers nombres parfaits
	*/
	void quatreNbParfaits() {
		int cpt = 0;
		int i = 0;
		System.out.println ("*** 4 premiers nombres parfaits");
		while (cpt < 4) {
			if (estParfait(i)) {
				System.out.println(i);
				cpt++;
			}
			i++;
		}
	}
}
```

_Réponse rédigée :_

Test :
```cmd

*** testEstParfait()
estParfait(6) 	= true	 : OK
estParfait(28) 	= true	 : OK
estParfait(496) 	= true	 : OK
estParfait(4) 	= false	 : OK
estParfait(1) 	= false	 : OK
estParfait(0) 	= false	 : OK

*** 4 premiers nombres parfaits
6
28
496
8128

```

## Exercice 4

_Code :_

```java
/**
*Programme qui test si les nombres entrés dans un tableau sont dans l'ordre croissant
*@author L.Carré
*/
class TabCroissant{
	void principal() {
		testEstCroissant();
	}	
	
	
	/**
	* Teste la méthode estCroissant()
	*/
	void testEstCroissant () {
		System.out.println ();
		System.out.println ("*** testEstParfait()");
		
		int[] test1 = {};
		int[] test2 = {7};
		int[] test3 = {-7,-2,12,234,450};
		int[] test4 = {-7,-2,12,12,234,450};
		int[] test5 = {-7,23,-1,26,54};
		
		testCasEstCroissant (test1, false);
		testCasEstCroissant (test2, true);
		testCasEstCroissant (test3, true);
		testCasEstCroissant (test4, true);
		testCasEstCroissant (test5, false);
	}
	
	/**
	* teste un appel de estCroissant
	* @param t un tableau à tester
	* @param result resultat attendu
	**/
	void testCasEstCroissant (int[] t, boolean result) {
		// Affichage
		System.out.print ("estCroissant(");
		displayTab(t);
		System.out.print (") \t= " + result + "\t : ");
		// Appel
		boolean resExec = estCroissant(t);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	* teste si les valeurs d’un tableau sont triées par ordre croissant
	* @param t tableau d’entiers
	* @return vrai ssi les valeurs du tableau sont en ordre croissant
	*/
	boolean estCroissant (int[] t) {
		boolean res = true;
		if (t.length > 0) {
			int val = t[0];
			for (int i = 1; ((i < t.length) && (res)); i++) {
				if (val <= t[i]) {
					val = t[i];
				} else {
					res = false;
				}
			}
		} else {
		    res = false;
		}
		return res;
	}
	
	/**
	* affiche un tableau entré
	* @param t tableau d’entiers
	*/
	void displayTab(int[] t) {
		int i = 0;
		if (t.length == 0) {
			System.out.print("{}");
		} else {
			System.out.print("{");
			while (i<t.length-1) {
				System.out.print(t[i] + ",");
				i++;
			}
			System.out.print(t[i] + "}");
		}
	}
}
```

_Réponse rédigée :_

Test :
```cmd

*** testEstParfait()
estCroissant({}) 	= false	 : OK
estCroissant({7}) 	= true	 : OK
estCroissant({-7,-2,12,234,450}) 	= true	 : OK
estCroissant({-7,-2,12,12,234,450}) 	= true	 : OK
estCroissant({-7,23,-1,26,54}) 	= false	 : OK

```

## Exercice 5

```java
/**
*Programme qui compte le nbr d'un caractère dans une chaine
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
```

Test :
```cmd

*** testnbOcc()
nbOcc('', 'a') 	= 0	 : OK
nbOcc('abbba', 'a') 	= 2	 : OK
nbOcc('abbba', 'b') 	= 3	 : OK
nbOcc('  b', ' ') 	= 2	 : OK

```