# R1.01 : TP2

**Nom :** Carré
**Prénom :** Lucien
**Groupe :** D2

## Exercice 1.1 While

_Code :_
```java
/**
*Programme demandant à l'utilisateur de saisir un nbr et l'affiche tant qu'il n'est pas égale à -1
*@author L.Carré
*/
class SuiteNbrWhile {
	void principal(){
		int nbr;
		nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		while (nbr != -1) {
			System.out.println(nbr);
			nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		}
		System.out.println("Fin");
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Nombre (-1 pour arrêter)-5
-5
Nombre (-1 pour arrêter)5
5
Nombre (-1 pour arrêter)190
190
Nombre (-1 pour arrêter)-1
Fin
```

Deuxième test :
```cmd
Nombre (-1 pour arrêter)-1
Fin
```

## Exercice 1.1 Do While

_Code :_

```java
/**
*Programme demandant à l'utilisateur de saisir un nbr et l'affiche tant qu'il n'est pas égale à -1
*@author L.Carré
*/
class SuiteNbrDoWhile {
	void principal(){
		int nbr;
		do {
			nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
			if (nbr != -1) {
				System.out.println(nbr);
			}
		} while (nbr != -1);
		System.out.println("Fin");
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Nombre (-1 pour arrêter)-8
-8
Nombre (-1 pour arrêter)96
96
Nombre (-1 pour arrêter)2
2
Nombre (-1 pour arrêter)-1
Fin
```

Deuxième test :
```cmd
Nombre (-1 pour arrêter)-1
Fin
```

## Exercice 1.2

_Code :_

```java
/**
*Programme demandant à l'utilisateur de saisir un nbr et l'affiche tant qu'il n'est pas égale à -1
et renvoie la moyenne quand -1 est entré
*@author L.Carré
*/
class SuiteNbrMoyenne {
	void principal(){
		int nbr, cpt, somme;
		nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		somme = 0;
		cpt = 0;
		while (nbr != -1) {
			System.out.println(nbr);
			somme += nbr;
			cpt += 1;
			nbr = SimpleInput.getInt("Nombre (-1 pour arrêter)");
		}
		if (cpt == 0) {
			System.out.println("Il n'y a pas assez de notes pour calculer la moyenne");
		} else {
			System.out.println("Fin, la moyenne de la suite de nombre est " + (double) somme/cpt);
		}
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Nombre (-1 pour arrêter)-5
-5
Nombre (-1 pour arrêter)5
5
Nombre (-1 pour arrêter)-1
Fin, la moyenne de la suite de nombre est 0.0
```

Deuxième test :
```cmd
Nombre (-1 pour arrêter)-1
Il n'y a pas assez de notes pour calculer la moyenne
```

Troisième test :
```cmd
Nombre (-1 pour arrêter)10
10
Nombre (-1 pour arrêter)5
5
Nombre (-1 pour arrêter)7
7
Nombre (-1 pour arrêter)-1
Fin, la moyenne de la suite de nombre est 7.333333333333333
```

## Exercice 2.1

_Réponse rédigée :_

Exécutions qui se terminent :
```cmd
Première valeur : 8
Deuxième valeur : 6
Le résultat est : 2
```

```cmd
Première valeur : 256
Deuxième valeur : 83
Le résultat est : 1
```

Exécutions qui ne se terminent pas:
```cmd
Première valeur : -6
Deuxième valeur : 6
```

```cmd
Première valeur : 0
Deuxième valeur : 4
```

Le rôle du programme :
Le rôle du programme est de trouver le PGCD (plus petit diviseur commun) des deux valeurs entrées par l'utilisateur

## Exercice 2.2 While

```java
/**
*Programme qui demande deux valeurs tant qu'elles ne sont pas strictement supérieur à zéro
* et qui renvoie leur PGCD
*@author L.Carré
*/
class PGCDWhile {
	void principal(){
		int val1;
		int val2;
		
		val1 = SimpleInput.getInt ("Première valeur (strictement positif) : ");
		
		while (val1 <= 0) {
			val1 = SimpleInput.getInt ("Première valeur (strictement positif) : ");
		}
		
		val2 = SimpleInput.getInt ("Deuxième valeur (strictement positif): ");
		
		while (val2 <=0) {
			val2 = SimpleInput.getInt ("Deuxième valeur (strictement positif): ");
		}
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
			} else {
				val2 = val2 - val1;
			}
		}
		System.out.println("Le PGCD de ces deux valeurs est : " + val1);
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Première valeur (strictement positif) : -7
Première valeur (strictement positif) : -45
Première valeur (strictement positif) : 45
Deuxième valeur (strictement positif): -13
Deuxième valeur (strictement positif): 13
Le PGCD de ces deux valeurs est : 1
```

Deuxième test :
```
Première valeur (strictement positif) : 2
Deuxième valeur (strictement positif): 6
Le PGCD de ces deux valeurs est : 2
```

## Exercice 2.2 Do While

```java
/**
*Programme qui demande deux valeurs tant qu'elles ne sont pas strictement supérieur à zéro
* et qui renvoie leur PGCD
*@author L.Carré
*/
class PGCDDoWhile {
	void principal(){
		int val1;
		int val2;
		
		do {
			val1 = SimpleInput.getInt ("Première valeur (strictement positif) : ");
		} while (val1 <= 0);
		
		do {
			val2 = SimpleInput.getInt ("Deuxième valeur (strictement positif): ");
		} while (val2 <=0);
		
		while (val1 != val2) {
			if (val1 > val2) {
				val1 = val1 - val2;
			} else {
				val2 = val2 - val1;
			}
		}
		System.out.println("Le PGCD de ces deux valeurs est : " + val1);
	}
}
```

Premier test :
```cmd
Première valeur (strictement positif) : -6
Première valeur (strictement positif) : 6
Deuxième valeur (strictement positif): -56
Deuxième valeur (strictement positif): -4
Deuxième valeur (strictement positif): 4
Le PGCD de ces deux valeurs est : 2
```

Deuxième test :
```
Première valeur (strictement positif) : 47
Deuxième valeur (strictement positif): 15
Le PGCD de ces deux valeurs est : 1
```

## Exercice 3

_Code :_

```java
/**
*Programme qui demande une valeur tant qu'elle n'est pas inférieur à celle d'avant
*@author L.Carré
*/
class NbrInferieur {
	void principal(){
		int val1, val2;
		val2 = SimpleInput.getInt ("Première valeur : ");
		
		do {
			val1 = val2;
			val2 = SimpleInput.getInt ("Valeur suivante: ");
		} while (val1 <= val2);
		
		System.out.println("La valeur était inférieur à la précédente");
	}
}
```

Premier test :
```cmd
Première valeur : -6
Valeur suivante: -45
La valeur était inférieur à la précédente
```

Deuxième test :
```cmd
Première valeur : -6
Valeur suivante: 0
Valeur suivante: 16
Valeur suivante: -5
La valeur était inférieur à la précédente
```

Troisième test :
```cmd
Première valeur : -6
Valeur suivante: 2
Valeur suivante: 56
Valeur suivante: 678
Valeur suivante: 678
Valeur suivante: 677
La valeur était inférieur à la précédente
```

## Exercice 4

_Code :_

```java
/**
*Programme qui demande la valeur du produit dans le distributeur puis demande l'argent inséré
*tant qu'il n'est pas suffisant et ensuite renvoie le rendu de l'argent
*@author L.Carré
*/
class Distributeur {
	void principal(){
		int prix, argentInsere, aRendre;
		String rendu = "";
		argentInsere = 0;
		do {
			prix = SimpleInput.getInt ("Prix du produit: ");
		} while (prix <= 0);
		
		System.out.println("Prix du produit enregistré : " + prix);
		
		do {
			argentInsere += SimpleInput.getInt ("Argent inséré: ");
			if (argentInsere < 0) {
				argentInsere = 0;
			}
			System.out.println("Vous avez inséré : " + argentInsere);
		} while (argentInsere < prix);
		
		System.out.println("Produit acheté");
		
		if (argentInsere == prix) {
			System.out.println("Pas de rendu de monnaie");
		} else {
			aRendre = argentInsere - prix;
			while (aRendre != 0) {
				if (aRendre > 50) {
					aRendre -= 50;
					rendu += "50 ";
				} else if (aRendre >= 20) {
					aRendre -= 20;
					rendu += "20 ";
				} else if (aRendre >= 10) {
					aRendre -= 10;
					rendu += "10 ";
				} else if (aRendre >= 5) {
					aRendre -= 5;
					rendu += "5 ";
				} else if (aRendre >= 2) {
					aRendre -= 2;
					rendu += "2 ";
				} else {
					aRendre -= 1;
					rendu += "1 ";
				}
			}
			System.out.println("Le montant rendu est de " + rendu);
		}
	}
}
```

Premier test :
```cmd
Prix du produit: -56
Prix du produit: 56
Prix du produit enregistré : 56
Argent inséré: -45
Vous avez inséré : 0
Argent inséré: 45
Vous avez inséré : 45
Argent inséré: 16
Vous avez inséré : 61
Produit acheté
Le montant rendu est de 5 
```

Deuxième test :
```cmd
Prix du produit: 78
Prix du produit enregistré : 78
Argent inséré: 56
Vous avez inséré : 56
Argent inséré: 22
Vous avez inséré : 78
Produit acheté
Pas de rendu de monnaie
```

Troisième test :
```cmd
Prix du produit: 0
Prix du produit: 18
Prix du produit enregistré : 18
Argent inséré: 56
Vous avez inséré : 56
Produit acheté
Le montant rendu est de 20 10 5 2 1 
```

Quatrième test :
```cmd
Prix du produit: 34
Prix du produit enregistré : 34
Argent inséré: 22
Vous avez inséré : 22
Argent inséré: -12
Vous avez inséré : 22
Argent inséré: -56
Vous avez inséré : 22
Argent inséré: 56
Vous avez inséré : 78
Produit acheté
Le montant rendu est de 20 20 2 2 
```

Cinquième test :
```cmd
Prix du produit: 32
Prix du produit enregistré : 32
Argent inséré: 156
Vous avez inséré : 156
Produit acheté
Le montant rendu est de 50 50 20 2 2 
```

## Exercice 5

_Code :_

```java
/**
*Programme qui choisit un nombre entre 0 et 100 et demande à
*l'utilisateur de deviner le nombre tant qu'il ne l'a pas trouvé
*@author L.Carré
*/
class JeuEntre0Et100{
	void principal(){
		int nbrRecherche = (int) (Math.random() * 100);
		int nbrUser = SimpleInput.getInt("Nombre entre 0 et 100 ");
		int essaies = 1;
		
		while (nbrUser != nbrRecherche) {
			if (nbrUser < nbrRecherche) {
				System.out.println("Trop petit !");
			} else {
				System.out.println("Trop grand !");
			}
			nbrUser = SimpleInput.getInt("Nombre entre 0 et 100 ");
			essaies += 1;
		}
		System.out.println("Vous avez trouvé le nombre en " + essaies + " essaies");
	}
}
```

Premier test :
```cmd
Nombre entre 0 et 100 -67
Trop petit !
Nombre entre 0 et 100 2672
Trop grand !
Nombre entre 0 et 100 50
Trop petit !
Nombre entre 0 et 100 75
Trop petit !
Nombre entre 0 et 100 87
Trop petit !
Nombre entre 0 et 100 95
Trop grand !
Nombre entre 0 et 100 91
Trop grand !
Nombre entre 0 et 100 89
Trop grand !
Nombre entre 0 et 100 88
Vous avez trouvé le nombre en 9 essaies
```

Deuxième test :
```cmd
Nombre entre 0 et 100 50
Trop petit !
Nombre entre 0 et 100 75
Trop grand !
Nombre entre 0 et 100 63
Trop petit !
Nombre entre 0 et 100 69
Trop petit !
Nombre entre 0 et 100 72
Trop petit !
Nombre entre 0 et 100 73
Trop petit !
Nombre entre 0 et 100 74
Vous avez trouvé le nombre en 7 essaies
```

## Exercice 6.1

_Code :_

```java
/**
*Programme qui devine le nombre choisit par l'utilisateur
*en choisissant un nombre aléatoire tant qu'il n'est pas trouvé
*@author L.Carré
*/
class JeuEntre0Et1000{
	void principal(){
		int min = 0;
		int max = 1000;
		int nbrRecherche = min + (int) (Math.random() * max);
		System.out.println("Ton nombre choisit (si tu t'en souviens plus) : " + SimpleInput.getInt("Ton nombre "));
		char repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
		
		while (repUser != '=') {
			if (repUser == '+') {
				min = nbrRecherche + 1;
			} else if (repUser == '-') {
				max = nbrRecherche;
			}
			nbrRecherche = min + (int) (Math.random() * (max - min));
			repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
		}
		System.out.println("L'ordinateur a trouvé le nombre " + nbrRecherche);
	}
}
```

Premier test :
```cmd
Ton nombre 565
Ton nombre choisit (si tu t'en souviens plus) : 565
Le nombre choisit par l'ordi est 776-
Le nombre choisit par l'ordi est 712-
Le nombre choisit par l'ordi est 239+
Le nombre choisit par l'ordi est 240+
Le nombre choisit par l'ordi est 431+
Le nombre choisit par l'ordi est 457+
Le nombre choisit par l'ordi est 570-
Le nombre choisit par l'ordi est 554+
Le nombre choisit par l'ordi est 567-
Le nombre choisit par l'ordi est 566-
Le nombre choisit par l'ordi est 564+
Le nombre choisit par l'ordi est 565=
L'ordinateur a trouvé le nombre 565
```

Deuxième test :
```cmd
Ton nombre 0
Ton nombre choisit (si tu t'en souviens plus) : 0
Le nombre choisit par l'ordi est 271-
Le nombre choisit par l'ordi est 163-
Le nombre choisit par l'ordi est 101-
Le nombre choisit par l'ordi est 50-
Le nombre choisit par l'ordi est 34-
Le nombre choisit par l'ordi est 4-
Le nombre choisit par l'ordi est 1-
Le nombre choisit par l'ordi est 0=
L'ordinateur a trouvé le nombre 0
```

Troisième test :
```cmd
Ton nombre 999
Ton nombre choisit (si tu t'en souviens plus) : 999
Le nombre choisit par l'ordi est 913+
Le nombre choisit par l'ordi est 938+
Le nombre choisit par l'ordi est 985+
Le nombre choisit par l'ordi est 995+
Le nombre choisit par l'ordi est 997+
Le nombre choisit par l'ordi est 999=
L'ordinateur a trouvé le nombre 999
```

## Exercice 6.2

_Code :_

```java
/**
*Programme qui devine le nombre choisit par l'utilisateur
*en choisissant un nombre aléatoire tant qu'il n'est pas trouvé
*et trouve le chiffre si sa valeur supérieur et inférieur on été proposé
*@author L.Carré
*/
class JeuEntre0Et1000bis{
	void principal(){
		int min = 0;
		int max = 1000;
		int minPc = -1; //Pour le cas de 0 qui est compris en -1 et 1
		int nbrRecherche = min + (int) (Math.random() * max);
		System.out.println("Ton nombre choisit (si tu t'en souviens plus) : " + SimpleInput.getInt("Ton nombre "));
		char repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
		
		while (repUser != '=') {
			if (repUser == '+') {
				min = nbrRecherche + 1;
				minPc = nbrRecherche;
			} else if (repUser == '-') {
				max = nbrRecherche;
			}
			nbrRecherche = min + (int) (Math.random() * (max - min));
			if ((nbrRecherche == max - 1) && (nbrRecherche == minPc + 1)) {
				repUser = '=';
			} else {
				repUser = SimpleInput.getChar("Le nombre choisit par l'ordi est " + nbrRecherche);
			}
		}
		System.out.println("L'ordinateur a trouvé le nombre " + nbrRecherche);
	}
}
```


Premier test :
```cmd
Ton nombre 155
Ton nombre choisit (si tu t'en souviens plus) : 155
Le nombre choisit par l'ordi est 438-
Le nombre choisit par l'ordi est 317-
Le nombre choisit par l'ordi est 15+
Le nombre choisit par l'ordi est 234-
Le nombre choisit par l'ordi est 228-
Le nombre choisit par l'ordi est 148+
Le nombre choisit par l'ordi est 194-
Le nombre choisit par l'ordi est 154+
Le nombre choisit par l'ordi est 170-
Le nombre choisit par l'ordi est 161-
Le nombre choisit par l'ordi est 160-
Le nombre choisit par l'ordi est 156-
L'ordinateur a trouvé le nombre 155
```

Deuxième test :
```cmd
Ton nombre 0
Ton nombre choisit (si tu t'en souviens plus) : 0
Le nombre choisit par l'ordi est 162-
Le nombre choisit par l'ordi est 66-
Le nombre choisit par l'ordi est 58-
Le nombre choisit par l'ordi est 19-
Le nombre choisit par l'ordi est 6-
Le nombre choisit par l'ordi est 1-
L'ordinateur a trouvé le nombre 0
```

Troisième test :
```cmd
Ton nombre 999
Ton nombre choisit (si tu t'en souviens plus) : 999
Le nombre choisit par l'ordi est 326+
Le nombre choisit par l'ordi est 934+
Le nombre choisit par l'ordi est 983+
Le nombre choisit par l'ordi est 986+
Le nombre choisit par l'ordi est 990+
Le nombre choisit par l'ordi est 998+
L'ordinateur a trouvé le nombre 999
```
