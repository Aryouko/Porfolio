# R1.01 : TP5

**Nom :** Carré
**Prénom :** Lucien
**Groupe :** D2

## Exercice 1

```java
/**
*Programme qui test si les valeurs des deux tableaux sont différents
*@author L.Carré
*/
class Valdiff{
	void principal() {
		testSontTousDiff();
	}
	
	
	
	/**
	* vérifie si deux tableaux n’ont aucune valeur commune
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @return vrai si les tableaux tab1 et tab2 n’ont aucune valeur commune, faux sinon
	*/
	boolean sontTousDiff (int[] tab1, int[] tab2) {
		boolean res = true;
		int i=0;
		while (i < tab1.length && res) {
			int j=0;
			while (j < tab2.length && res) {
				res = !(tab1[i] == tab2[j]);
				j++;
			}
			i++;
		}
		return res;
	}
	
	
	/**
	* Teste la méthode sontTousDiff()
	*/
	void testSontTousDiff () {
		System.out.println ();
		System.out.println ("*** testSontTousDiff()");
		
		int[] test1 = {};
		int[] test2 = {7,8,9};
		int[] test3 = {10,11,12,13,14};
		int[] test4 = {10,15,16};
		
		testCasSontTousDiff(test1, test2, true);
		testCasSontTousDiff(test2, test3, true);
		testCasSontTousDiff(test3, test2, true);
		testCasSontTousDiff(test4, test3, false);
		testCasSontTousDiff(test3, test4, false);
		
	}
	
	
	/**
	* teste un appel de sontTousDiff()
	* @param tab1 premier tableau
	* @param tab2 deuxième tableau
	* @param result resultat attendu
	**/
	void testCasSontTousDiff(int[] tab1, int[] tab2, boolean result) {
		// Affichage
		System.out.print ("sontTousDiff(");
		displayTab(tab1);
		System.out.print(", ");
		displayTab(tab2);
		System.out.print(") \t= " + result + "\t : ");
		// Appel
		boolean resExec = sontTousDiff(tab1, tab2);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
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

Test :
```cmd

*** testSontTousDiff()
sontTousDiff({}, {7,8,9}) 	= true	 : OK
sontTousDiff({}, {}) 	= true	 : OK
sontTousDiff({7,8,9}, {10,11,12,13,14}) 	= true	 : OK
sontTousDiff({10,11,12,13,14}, {7,8,9}) 	= true	 : OK
sontTousDiff({10,15,16}, {10,11,12,13,14}) 	= false	 : OK
sontTousDiff({10,11,12,13,14}, {10,15,16}) 	= false	 : OK

```

## Exercice 2
_Code :_
```java
/**
*Programme qui décale les valeurs d'un tableau
*@author L.Carré
*/
class DecalTab{
	void principal() {
		int[] tab1 = {5, 7, 9, 5};
		int[] tab2 = {3, 10, 6, 20, 7};
		int[] tab3 = {3, 10, 6, 20, 7};
		int valDec = 0;
		int valRec = 4;
		
		System.out.print("decalerGauche(");
		displayTab(tab1);
		System.out.println(")");
		decalerGauche(tab1);
		System.out.println();
		
		System.out.print("decalerGaucheN(");
		displayTab(tab2);
		System.out.println(", " + valDec + ")");
		decalerGaucheN(tab2, valDec);
		System.out.println();
		
		testIndiceTab();
		System.out.println();
		
		System.out.print("decaleValeur(");
		displayTab(tab3);
		System.out.println(", " + valRec + ")");
		decaleValeur(tab3, valRec);
		System.out.println();
	}
	
	
	
	/**
	* décale les entiers d’un tableau d’une position vers la gauche
	* L’élément en 0 se retrouve à la fin du tableau
	* @param tab tableau d’entiers
	Semestre 1 - R1.01 1
	U.B.S. — I.U.T. de Vannes Dépt. INFO
	*/
	void decalerGauche (int[] tab) {
		System.out.print("Tableau avant : ");
		displayTab(tab);
		System.out.println();
		int temp;
		for (int i = 0; i < tab.length - 1; i++) {
			temp = tab[i];
			tab[i] = tab[i+1];
			tab[i+1] = temp;
		}
		System.out.print("Tableau après : ");
		displayTab(tab);
		System.out.println();
	}
	
	
	/**
	* décale les entiers d’un tableau de n positions vers la gauche
	* @param tab tableau d’entiers
	* @param n entier nombre de cases à décaler
	*/
	void decalerGaucheN (int[] tab, int n) {
		System.out.print("Tableau avant : ");
		displayTab(tab);
		System.out.println();
		int temp;
		while (n > 0) {
			for (int i = 0; i < tab.length - 1; i++) {
				temp = tab[i];
				tab[i] = tab[i+1];
				tab[i+1] = temp;
			}
			n--;
		}
		System.out.print("Tableau après : ");
		displayTab(tab);
		System.out.println();
	}
	
	
	/**
	* cherche l’indice de la premiere occurrence d’une valeur dans un tableau
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	* @return l’indice de la première valeur v dans tab si v est dans tab, -1 sinon
	*/
	int indiceTab (int[] tab, int v) {
		int res = -1;
		int i = 0;
		while (res == -1 && i < tab.length) {
			if (tab[i] == v) {
			res = i;
			}
			i++;
		}
		return res;
	}
	
	
	/**
	* teste un appel de indiceTab()
	* @param tab un tableau
	* @param result resultat attendu
	**/
	void testCasIndiceTab(int[] tab, int v, int result) {
		// Affichage
		System.out.print ("indiceTab(");
		displayTab(tab);
		System.out.print(", " + v + ") \t= " + result + "\t : ");
		// Appel
		int resExec = indiceTab(tab, v);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	/**
	* Teste la méthode indiceTab()
	*/
	void testIndiceTab() {
		System.out.println ();
		System.out.println ("*** testIndiceTab()");
		
		int[] test = {3, 10, 6, 10, 7};
		
		testCasIndiceTab(test, 3, 0);
		testCasIndiceTab(test, 10, 1);
		testCasIndiceTab(test, 6, 2);
		testCasIndiceTab(test, 20, -1);
		testCasIndiceTab(test, 7, 4);
		
	}
	
	
	/**
	* décale les valeurs d’un tableau de manière à ramener la valeur cherchée à l’indice 0
	* Si la valeur n’est pas présente, le tableau n’est pas modifié
	* @param tab tableau d’entiers
	* @param v valeur à chercher
	*/
	void decaleValeur (int[] tab, int v) {
		int n = indiceTab(tab, v);
		if (n != -1) {
			decalerGaucheN(tab, n);
		} else {
			decalerGaucheN(tab, 0);
		}
	}
	
	
	/**
	* affiche un tableau entré
	* @param t tableau d’entiers
	*/
	void displayTab(int[] t) {
		int i = 0;
		System.out.print("{");
		while (i<t.length-1) {
			System.out.print(t[i] + ",");
			i++;
		}
		System.out.print(t[i] + "}");
	}
}
```

_Réponse rédigée :_

Test de la méthode de test:
```cmd

*** testIndiceTab()
indiceTab({3,10,6,10,7}, 3) 	= 0	 : OK
indiceTab({3,10,6,10,7}, 10) 	= 1	 : OK
indiceTab({3,10,6,10,7}, 6) 	= 2	 : OK
indiceTab({3,10,6,10,7}, 20) 	= -1	 : OK
indiceTab({3,10,6,10,7}, 7) 	= 4	 : OK

```

Test des fonctions sans méthode de test :

Premier test : 
```cmd
decalerGauche({3,10,6,20,7})
Tableau avant : {3,10,6,20,7}
Tableau après : {10,6,20,7,3}

decalerGaucheN({3,10,6,20,7}, 3)
Tableau avant : {3,10,6,20,7}
Tableau après : {20,7,3,10,6}

decaleValeur({3,10,6,20,7}, 20)
Tableau avant : {3,10,6,20,7}
Tableau après : {20,7,3,10,6}

```

Deuxième test : 
```cmd
decalerGauche({5,7,9,5})
Tableau avant : {5,7,9,5}
Tableau après : {7,9,5,5}

decalerGaucheN({3,10,6,20,7}, 9)
Tableau avant : {3,10,6,20,7}
Tableau après : {7,3,10,6,20}

decaleValeur({3,10,6,20,7}, 6)
Tableau avant : {3,10,6,20,7}
Tableau après : {6,20,7,3,10}

```

Troisième test : 
```cmd
decalerGauche({5,7,9,5})
Tableau avant : {5,7,9,5}
Tableau après : {7,9,5,5}

decalerGaucheN({3,10,6,20,7}, 2)
Tableau avant : {3,10,6,20,7}
Tableau après : {6,20,7,3,10}

decaleValeur({3,10,6,20,7}, 3)
Tableau avant : {3,10,6,20,7}
Tableau après : {3,10,6,20,7}

```

Quatrième test :
```cmd
decalerGauche({5,7,9,5})
Tableau avant : {5,7,9,5}
Tableau après : {7,9,5,5}

decalerGaucheN({3,10,6,20,7}, 0)
Tableau avant : {3,10,6,20,7}
Tableau après : {3,10,6,20,7}

decaleValeur({3,10,6,20,7}, 4)
Tableau avant : {3,10,6,20,7}
Tableau après : {3,10,6,20,7}

```


## Exercice 3

_Code :_

```java
/**
*Programme qui compte le nombre de valeurs différentes
*@author L.Carré
*/
class DiffVal{
	void principal() {
		testCompteDiffVal();
	}
	
	
	
	/**
	* compte le nombre de valeurs différentes dans un tableau
	* @param tab tableau d’entiers
	* @return le nombre de valeurs différentes du tableau
	*/
	int compteDiffVal(int[] tab) {
		int cpt = 0;
		if (tab.length > 0) {
			cpt = 1;
			int[] tabVal = new int[tab.length];
			tabVal[0] = tab[0];
			for (int i = 1; i < tab.length; i++) {
				boolean verif = true;
				for (int j = 0; j < cpt; j++) {
					if (tab[i] == tabVal[j]) {
						verif = false;
					}
				}
				if (verif) {
					tabVal[cpt] = tab[i];
					cpt++;
				}
			}
		}
		return cpt;
	}
	
	
	/**
	* teste un appel de compteDiffVal()
	* @param tab un tableau
	* @param result resultat attendu
	**/
	void testCasCompteDiffVal(int[] tab, int result) {
		// Affichage
		System.out.print ("compteDiffVal(");
		displayTab(tab);
		System.out.print(") \t= " + result + "\t : ");
		// Appel
		int resExec = compteDiffVal(tab);
		// Verification
		if (resExec == result){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	
	/**
	* Teste la méthode compteDiffVal()
	*/
	void testCompteDiffVal() {
		System.out.println ();
		System.out.println ("*** testCompteDiffVal()");
		
		int[] test1 = {3, 10, 6, 10, 7};
		int[] test2 = {0, 0, 2, 3, 0, 2, 1, 3, 3, 0};
		int[] test3 = {1,1,1,1,1};
		int[] test4 = {1,35,24,7,9,0};
		int[] test5 = {};
		
		testCasCompteDiffVal(test1, 4);
		testCasCompteDiffVal(test2, 4);
		testCasCompteDiffVal(test3, 1);
		testCasCompteDiffVal(test4, 6);
		testCasCompteDiffVal(test5, 0);
		
	}
	
	
	/**
	* affiche un tableau entré
	* @param t tableau d’entiers
	*/
	void displayTab(int[] t) {
		int i = 0;
		System.out.print("{");
		while (i<t.length-1) {
			System.out.print(t[i] + ",");
			i++;
		}
		if (t.length > 0) {
			System.out.print(t[i] + "}");
		} else {
			System.out.print("}");
		}
	}
}
```

_Réponse rédigée :_

Test :
```cmd

*** testCompteDiffVal()
compteDiffVal({3,10,6,10,7}) 	= 4	 : OK
compteDiffVal({0,0,2,3,0,2,1,3,3,0}) 	= 4	 : OK
compteDiffVal({1,1,1,1,1}) 	= 1	 : OK
compteDiffVal({1,35,24,7,9,0}) 	= 6	 : OK
compteDiffVal({}) 	= 0	 : OK

```

## Exercice 4

_Code :_

```java
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
```

_Réponse rédigée :_

Test :
```cmd

*** testEstSousChaine()
estSousChaine(ses, abcdsesdef) 	= true	 : OK
estSousChaine(ses, abcdef) 	= false	 : OK
estSousChaine(ses, ab) 	= false	 : OK
estSousChaine(ses, absee) 	= false	 : OK
estSousChaine(ses, abses) 	= true	 : OK

```

## Exercice 5

_Code :_

```java
/**
*Programme qui compte le nombre de valeurs différentes
*@author L.Carré
*/
class SaisirTrier{
	final int LG_TAB = 5;
	void principal() {
		int[] tab = saisirEtTrier();
		System.out.println("Voici le tableau créé et trié de taille " + LG_TAB);
		displayTab(tab);
	}
	
	
	/**
	* Crée et saisit un tableau trié de LG_TAB entiers
	* @return tableau trié de LG-TAB entiers
	*/
	int[] saisirEtTrier () {
	int[] t = new int[LG_TAB];
	for (int i = 0; i < t.length; i++) {
		t[i] = SimpleInput.getInt ("Entrer un entier");
		// insertion de la valeur en ordre croissant dans t
		int j = i;
		while (j > 0) {
			if (t[j] < t[j - 1]) {
				int tmp = t[j];
				t[j] = t[j - 1];
				t[j - 1] = tmp;
			}				
			j--;
		}
	}
	return t;
	}	
	
	
	/**
	* affiche un tableau entré
	* @param t tableau d’entiers
	*/
	void displayTab(int[] t) {
		int i = 0;
		System.out.print("{");
		while (i<t.length-1) {
			System.out.print(t[i] + ",");
			i++;
		}
		System.out.print(t[i] + "}");
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Entrer un entier7
Entrer un entier28
Entrer un entier-52
Entrer un entier-2
Entrer un entier67
Voici le tableau créé et trié de taille 5
{-52,-2,7,28,67}

```

Deuxième test :
```cmd
Entrer un entier2
Entrer un entier3
Entrer un entier4
Entrer un entier5
Entrer un entier6
Voici le tableau créé et trié de taille 5
{2,3,4,5,6}

```

Troisième test :
```cmd
Entrer un entier56
Entrer un entier689
Entrer un entier67
Entrer un entier67
Entrer un entier12
Voici le tableau créé et trié de taille 5
{12,56,67,67,689}

```