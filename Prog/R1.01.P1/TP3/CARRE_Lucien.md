# R1.01 : TP3

**Nom :** Carré
**Prénom :** Lucien
**Groupe :** D2

## Exercice 1 While

```java
/**
*Programme qui décale d'une case vers la fin le contenu
*d'un tableau avec la dernière valeur qui va en première
*@author L.Carré
*/
class DecalageWhile{
	void principal(){
		int[] t = {5,7,87,56,0,-67,-45,56};
		int temp;
		int i = 0;
		System.out.print("Tableau avant : ");
		displayTab(t);
		while (i < t.length) {
			temp = t[i];
			t[i] = t[0];
			t[0] = temp;
			i += 1;
		}
		System.out.print("Tableau après : ");
		displayTab(t);
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
```

Premier test :
```cmd
Tableau avant : {5,7,87,56,0}
Tableau après : {0,5,7,87,56}
```

Deuxième test :
```cmd
Tableau avant : {5,7,87,56,0,-67,-45,56}
Tableau après : {56,5,7,87,56,0,-67,-45}
```

## Exercice 1 For
_Code :_
```java
/**
*Programme qui décale d'une case vers la fin le contenu
*d'un tableau avec la dernière valeur qui va en première
*@author L.Carré
*/
class DecalageFor{
	void principal(){
		int[] t = {5,6,4,34};
		int temp;
		System.out.print("Tableau avant : ");
		displayTab(t);
		for (int i = 1; i < t.length; i++) {
			temp = t[i];
			t[i] = t[0];
			t[0] = temp;
		}
		System.out.print("Tableau après : ");
		displayTab(t);
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Tableau avant : {56,7,230,68,0,8,4,-1}
Tableau après : {-1,56,7,230,68,0,8,4}
```

Deuxième test :
```cmd
Tableau avant : {5,7,0,6,10,8,4,1}
Tableau après : {1,5,7,0,6,10,8,4}
```

## Exercice 2 While

_Code :_

```java
/**
*Programme qui créé un tableau où chaque valeur est le
*cumulé des valeurs précédentes plus la valeur de l'indiçage 
*actuelle de l'autre tableau déjà créé
*@author L.Carré
*/
class CumulWhile{
	void principal(){
		int[] t = {5,7,0,6,10,8,4,1};
		int[] cumul = new int[t.length];
		cumul[0] = t[0];
		int i = 1;
		System.out.print("Tableau : ");
		displayTab(t);
		while (i < t.length) {
			cumul[i] = cumul[i-1]+t[i];
			i += 1;
		}
		System.out.print("Tableau cumulé : ");
		displayTab(cumul);
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Tableau : {5,7,0,6,10,8,4,1}
Tableau cumulé : {5,12,12,18,28,36,40,41}
```

Deuxième test :
```cmd
Tableau : {5,-7,0,6,-10,8,4,1}
Tableau cumulé : {5,-2,-2,4,-6,2,6,7}
```

## Exercice 2 For

_Code :_

```java
/**
*Programme qui créé un tableau où chaque valeur est le
*cumulé des valeurs précédentes plus la valeur de l'indiçage
*actuelle de l'autre tableau déjà créé
*@author L.Carré
*/
class CumulFor{
	void principal(){
		int[] t = {5,8,4,5};
		int[] cumul = new int[t.length];
		cumul[0] = t[0];
		System.out.print("Tableau : ");
		displayTab(t);
		for (int i = 1;i < t.length;i++) {
			cumul[i] = cumul[i-1]+t[i];
		}
		System.out.print("Tableau cumulé : ");
		displayTab(cumul);
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Tableau : {5,8,4,5}
Tableau cumulé : {5,13,17,22}
```

Deuxième test :
```cmd
Nombre (-1 pour arrêter)-1
Il n'y a pas assez de notes pour calculer la moyenne
```

## Exercice 3

Entre while et for :
Le while est plus intéressant dans ce cas car on ne sait pas pendant combien de temps on va être dans le tableau.

```java
/**
*Programme qui retourne la longueur de la
*plus grande séquence croissante du tableau
*@author L.Carré
*/
class SequenceLongue{
	void principal(){
		int[] t = {1,2,3,4,3,2,1};
		int maxSeq = 1;
		int seqActu = 1;
		System.out.print("Tableau : ");
		displayTab(t);
		int i = 0;
		boolean continu = true;
		while ((i < t.length-1) && continu) {
			if (t[i] < t[i+1]) {
				seqActu += 1;
				if (maxSeq < seqActu) {
					maxSeq = seqActu;
				}
			} else {
				seqActu = 1; 
			}
			i++;
			if (!(seqActu + (t.length - i) > maxSeq)) {
				continu = false;
			}
		}
		System.out.print("La plus longue séquence croissante est de : " + maxSeq + " et la boucle s'arrête à l'indice " + i);
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Tableau : {-7,-2,-1,-67,4,2,8}
La plus longue séquence croissante est de : 3 et la boucle s'arrête à l'indice 5
```

Deuxième test :
```
Tableau : {5,7,0,6,10,8,4,1}
La plus longue séquence croissante est de : 3 et la boucle s'arrête à l'indice 6
```

Troisième test :
```cmd
Tableau : {4,0,6,10,3,8}
La plus longue séquence croissante est de : 3 et la boucle s'arrête à l'indice 4
```

Quatrième test :
```cmd
Tableau : {1,2,3,1,2,3,4,5}
La plus longue séquence croissante est de : 5 et la boucle s'arrête à l'indice 7
```

Cinquième test :
```cmd
Tableau : {1}
La plus longue séquence croissante est de : 1 et la boucle s'arrête à l'indice 0
```

Sixième test :
```cmd
Tableau : {1,2,3,4,3,2,1}
La plus longue séquence croissante est de : 4 et la boucle s'arrête à l'indice 4
```

## Exercice 4

```java
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
		int[] t = {-7,-2,-1,-67,4,2,8};
		int maxSeq = 1;
		int seqActu = 1;
		int maxI = 0;
		int minI = 0;
		System.out.print("Tableau : ");
		displayTab(t);
		for (int i = 0;(i < t.length-1) && (seqActu + (t.length - i) > maxSeq);i++) {
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
		}
		System.out.print("La plus longue séquence croissante est de : " + maxSeq + " de " + minI + " à " + maxI);
	}
}
```

Premier test :
```cmd
Tableau : {-7,-2,-1,-67,4,2,8}
La plus longue séquence croissante est de : 3 de 0 à 2 et la boucle s'arrête à l'indice 5
```

Deuxième test :
```cmd
Tableau : {5,7,0,6,10,8,4,1}
La plus longue séquence croissante est de : 3 de 2 à 4 et la boucle s'arrête à l'indice 6
```

Troisième test :
```cmd
Tableau : {4,0,6,10,3,8}
La plus longue séquence croissante est de : 3 de 1 à 3 et la boucle s'arrête à l'indice 4
```

Quatrième test :
```cmd
Tableau : {1,2,3,1,2,3,4,5}
La plus longue séquence croissante est de : 5 de 3 à 7 et la boucle s'arrête à l'indice 7
```

Cinquième test :
```cmd
Tableau : {1}
La plus longue séquence croissante est de : 1 de 0 à 0 et la boucle s'arrête à l'indice 0
```

Sixième test :
```cmd
Tableau : {1,2,3,4,3,2,1}
La plus longue séquence croissante est de : 4 de 0 à 3 et la boucle s'arrête à l'indice 4
```

## Exercice 5

J'ai choisi une boucle For pour parcourir et remplir plus facilement le tableau que je créé au début

_Code :_

```java
/**
*Programme qui rentre le nombre de fois où un chiffre
*x a été tiré au hasard dans un tableau en fonction de son
*indiçage. L'indice du tableau étant le chiffre et sa valeur
*le nombre de fois tiré sur 1000 tirages
*@author L.Carré
*/
class NombreTirage{
	void principal(){
		int[] t = new int[10];
		for (int i = 0;i < 1000;i++) {
			t[(int) (Math.random() * 10)]++ ;
		}
		System.out.print("Le tableau rempli par les tirages aléatoires est : ");
		displayTab(t);
	}
}
```

Premier test :
```cmd
Le tableau rempli par les tirages aléatoires est : {110,110,85,115,98,93,106,94,92,97}
```

Deuxième test :
```cmd
Le tableau rempli par les tirages aléatoires est : {94,113,91,96,97,109,112,93,105,90}
```

## Exercice 6

1ère boucle :
La première boucle demande un entier à l'utilisateur tant qu'il n'est pas strictement positif, j'opterais donc pour une
boucle Do while pour demander une première fois puis plusieurs si il le faut et on ne sait pas combien de fois on va
demander donc pas de For

2ème boucle :
La deuxième boucle tourne tant que cette entier n'est pas égale à 1, si il est impair on multiplie cette entier par 3
puis on ajoute 1 ou si c'est pair on le divise par 2, j'ai donc choisi un While car il peut-être à 1 directement et
qu'on ne sait pas combien de fois la boucle va tourner

_Code :_

```java
/**
*Programme demandant un entier tant qu'il n'est pas strictement 
*positif ensuite tant que l'entier n'est pas égale à 1, si l'entier
*est impair on multiplie cette entier par 3 puis on ajoute 1
*ou si c'est pair on le divise par 2
*Le programme retourne le nombre de fois passé dans la boucle
*et le plus grand nombre dans tout les calculs
*@author L.Carré
*/
class ConjectureSyracuse{
	void principal(){
		int entier;
		do {
			entier = SimpleInput.getInt("Entier (strictement positif): ");
		} while (entier <= 0);
		System.out.print("Le nombre de départ est " + entier);
		int nbStep = 0;
		int nbMax = 1;
		while (entier != 1) {
			if (entier%2 == 0) {
				entier = entier / 2;
				nbStep++;
			} else {
				entier = entier * 3 + 1;
				nbStep++;
				if (nbMax < entier) {
					nbMax = entier;
				}
			}
		}
		if (nbStep == 0) {
			System.out.println(", l'objectif est donc déjà atteint");
		} else {
			System.out.println(" et pour arriver à 1, il aura fallu " + nbStep + " étapes et passer par une valeur maximale de " + nbMax);
		}
	}
}
```

Premier test :
```cmd
Entier (strictement positif): 7
Le nombre de départ est 7 et pour arriver à 1, il aura fallu 16 étapes et passer par une valeur maximale de 52
```

Deuxième test :
```cmd
Entier (strictement positif): -8
Entier (strictement positif): 0
Entier (strictement positif): 6
Le nombre de départ est 6 et pour arriver à 1, il aura fallu 8 étapes et passer par une valeur maximale de 16
```

Troisième test :
```cmd
Entier (strictement positif): 1
Le nombre de départ est 1, l'objectif est donc déjà atteint
```

## Exercice 7

_Code :_

```java
/**
*Programme demandant 2 nombres a et b dans un tableau
*et regardant si il se retrouve dans cette ordre a b
*sans pour autant être consécutif 
*@author L.Carré
*/
class OrdreAB{
	void principal(){
		int[] t = {-7,-2,-1,-67,4,-2,8};
		int entierA = SimpleInput.getInt("Entier a (du tableau): ");
		int entierB = SimpleInput.getInt("Entier b (du tableau): ");
		int indA = -1;
		int indB = -1;
		System.out.print("Tableau : ");
		displayTab(t);
		if (entierA == entierB) {
			int cpt = 0;
			for (int i = 0; i < t.length; i++) {
				if (t[i] == entierA) {
					cpt++;
				}
			}
			if (cpt >= 2) {
				System.out.println("a et b se retrouve bien dans l'ordre a b dans le tableau");
			} else {
				System.out.println("a et b sont égaux ils sont donc à la même place, ils ne sont pas dans l'ordre a b");
			}
		} else {
			for (int i = 0; i < t.length; i++) {
				if (entierA == t[i] && indA == -1) {
					indA = i;
				}
				if (entierB == t[i]) {
					indB = i;
				}
			}
			if (indA == -1 || indB == -1) {
				System.out.println("a ou b ou les deux ne sont pas présents dans le tableau actuel");
			} else if (indA < indB){
				System.out.println("a et b se retrouve bien dans l'ordre a b dans le tableau");
			} else if (indA > indB) {
				System.out.println("a et b ne se retrouve pas dans l'ordre a b dans le tableau");
			}
		}
	}
}
```

Premier test :
```cmd
Entier a (du tableau): 5
Entier b (du tableau): -1
Tableau : {-7,-2,-1,-67,4,-2,8}
a ou b ou les deux ne sont pas présents dans le tableau actuel
```

Deuxième test :
```cmd
Entier a (du tableau): -2
Entier b (du tableau): 4
Tableau : {-7,-2,-1,-67,4,-2,8}
a et b se retrouve bien dans l'ordre a b dans le tableau
```

Troisième test :
```cmd
Entier a (du tableau): -2
Entier b (du tableau): -2
Tableau : {-7,-2,-1,-67,4,-2,8}
a et b se retrouve bien dans l'ordre a b dans le tableau
```

Quatrième test :
```cmd
Entier a (du tableau): -1
Entier b (du tableau): -1
Tableau : {-7,-2,-1,-67,4,-2,8}
a et b sont égaux ils sont donc à la même place, ils ne sont pas dans l'ordre a b
```

Cinquième test :
```cmd
Entier a (du tableau): 8
Entier b (du tableau): -67
Tableau : {-7,-2,-1,-67,4,-2,8}
a et b ne se retrouve pas dans l'ordre a b dans le tableau
```

Sixième test :
```cmd
Entier a (du tableau): -67
Entier b (du tableau): 8
Tableau : {-7,-2,-1,-67,4,-2,8}
a et b se retrouve bien dans l'ordre a b dans le tableau
```

## Exercice 8

_Code :_

```java
/**
*Programme qui entrelace deux tableaux déjà donnés dans
*un troisième et si les deux tableaux ne sont pas de la 
*même taille, il finit de remplir le troisième tableau 
*avec les derniers valeurs du tableau le plus long
*@author L.Carré
*/
class ConcaTab{
	void principal(){
		int[] t1 = {1,5,3,6,7,8};
		int[] t2 = {1,2,4};
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
}
```

Premier test :
```cmd
Tableau 1 : {1,5,3,6,7,8,9}
Tableau 2 : {1,2,4}
Tableau Res : {1,1,5,2,3,4,6,7,8,9}
```

Deuxième test :
```cmd
Tableau 1 : {1,5,3}
Tableau 2 : {1,23,4}
Tableau Res : {1,1,5,23,3,4}
```

Troisième test :
```cmd
Tableau 1 : {1,5,3}
Tableau 2 : {1,23,4,-6,-90,12}
Tableau Res : {1,1,5,23,3,4,-6,-90,12}
```