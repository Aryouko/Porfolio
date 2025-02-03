# R1.01 : TP1

**Nom :** Carré
**Prénom :** Lucien
**Groupe :** D2

## Exercice 2

_Code :_
```java
/**
* Programme qui renvoie l'entier le plus grand entre les trois qui sont entrés par l'utilisateur
* @author L. Carré
**/
class Syntaxe{
    void principal(){
		
		int val1, val2, val3;
		
		val1 = SimpleInput.getInt("Premier entier :");
		val2 = SimpleInput.getInt("Deuxième entier :");
		val3 = SimpleInput.getInt("Troisième entier :");
		
		if (val1 < val3 && val2 < val3) {
			System.out.println("Le troisième entier " + val3 + " est le plus grand.");
		} else if (val1 < val2 && val3 < val2) {
			System.out.println("Le deuxième entier " + val2 + " est le plus grand.");
		} else if (val2 < val1 && val3 < val1) {
			System.out.println("Le premier entier " + val1 + " est le plus grand.");
		}
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Premier entier :3
Deuxième entier :6
Troisième entier :7
Le troisième entier 7 est le plus grand.
```

Deuxième test :
```cmd
Premier entier :-9
Deuxième entier :145
Troisième entier :45
Le deuxième entier 145 est le plus grand.
```

Troisième test :
```cmd
Premier entier :-3
Deuxième entier :-67
Troisième entier :-235
Le premier entier -3 est le plus grand.
```

## Exercice 3

_Code :_

```java
/**
* Programme qui calcule l'aire et le périmètre d'un cercle avec son rayon
* @author L. Carré
**/
class AirePerimetre{
	void principal(){
		double rayon, aire, perimetre;
		rayon = SimpleInput.getDouble("Rayon du cercle = ");
		if (rayon < 0) {
			System.out.println("Rayon invalide");
		} else {
			aire = (rayon * rayon) * Math.PI;
			perimetre = 2 * rayon * Math.PI;
			System.out.println("Le cercle de rayon " + rayon + " à pour aire " + aire + " et pour perimetre " + perimetre);
		}
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Rayon du cercle = 4
Le cercle de rayon 4.0 à pour aire 50.26548245743669 et pour perimetre 25.132741228718345
```

Deuxième test :
```cmd
Rayon du cercle = -4
Rayon invalide
```

## Exercice 4

_Code :_

```java
/**
* Programme qui calcule le nombre de quilles tombées
* @author L. Carré
**/
class Bowling{
	void principal(){
		int quilles1 = SimpleInput.getInt("Nombre de quilles (premier lancer) : ");
		if (quilles1 == 10) {
			System.out.println("Strike !");
		} else if ((quilles1 > 10) || (quilles1 < 0)) {
			System.out.println("Nombre incorrect");
		} else {
			int quilles2 = SimpleInput.getInt("Nombre de quilles (deuxieme lancer) : ");
			if ((quilles2 > 10) || (quilles2 < 0)) {
				System.out.println("Nombre incorrect");
			} else {
				int quillesTotal = quilles1 + quilles2;
				if (quillesTotal == 10){
					System.out.println("Spare");
				} else if ((quillesTotal > 10) || (quillesTotal < 0)) {
					System.out.println("Nombre incorrect");
				} else {
					System.out.println(quillesTotal);
				}
			}
		}
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Nombre de quilles (premier lancer) : -6
Nombre incorrect
```

Deuxième test :
```cmd
Nombre de quilles (premier lancer) : 6
Nombre de quilles (deuxieme lancer) : -4
Nombre incorrect
```

Troisième test :
```cmd
Nombre de quilles (premier lancer) : 4
Nombre de quilles (deuxieme lancer) : 5
9
```

Quatrième test :
```cmd
Nombre de quilles (premier lancer) : 6
Nombre de quilles (deuxieme lancer) : 4
Spare
```

Cinquième test :
```cmd
Nombre de quilles (premier lancer) : 10
Strike !
```

## Exercice 5

_Code :_

```java
/**
* Programme qui affiche le salaire brut, les prélèvements, le total des prélèvement et le salaire net
* et qui calcule les prélèvements ainsi que le salaire net en demandant le salaire brut
* @author L. Carré
**/
class Prelevements{
	void principal(){
		double salaireBrut = SimpleInput.getDouble("Votre salaire brut : ");
		if (salaireBrut < 0) {
			System.out.println("Salaire invalide");
		} else {
			double salaireAssuMal = salaireBrut * 0.0075;
			double salaireAssuVieiDepl = salaireBrut * 0.001;
			double salaireAssuVieiPl = salaireBrut * 0.0675;
			double salairePro = salaireBrut * 0.0175;
			double salaireContSocGen = (salaireBrut - salairePro) * 0.075;
			double salaireCRDS = (salaireBrut - salairePro) * 0.005;
			double salaireChom = salaireBrut * 0.024;
			double prelevTot = salaireChom + salaireCRDS + salaireContSocGen + salairePro + salaireAssuVieiPl + salaireAssuVieiDepl + salaireAssuMal;
			
			System.out.println("Salaire brut : " + salaireBrut);
			System.out.println("Prélèvement Assurance maladie : " + salaireAssuMal);
			System.out.println("Prélèvement Assurance vieillesse déplafonnée : " + salaireAssuVieiDepl);
			System.out.println("Prélèvement Assurance vieillesse plafonnée : " + salaireAssuVieiPl);
			System.out.println("Prélèvement Frais professionels : " + salairePro);
			System.out.println("Prélèvement Contribution sociale généralisée : " + salaireContSocGen);
			System.out.println("Prélèvement CRDS : " + salaireCRDS);
			System.out.println("Prélèvement Chômage : " + salaireChom);
			System.out.println("Total prélèvement : " + prelevTot);
			System.out.println("Salaire net : " + (salaireBrut - prelevTot));		
		}
	}
}
```

_Réponse rédigée :_

Premier test :
```cmd
Votre salaire brut : 2000
Salaire brut : 2000.0
Prélèvement Assurance maladie : 15.0
Prélèvement Assurance vieillesse déplafonnée : 2.0
Prélèvement Assurance vieillesse plafonnée : 135.0
Prélèvement Frais professionels : 35.0
Prélèvement Contribution sociale généralisée : 147.375
Prélèvement CRDS : 9.825000000000001
Prélèvement Chômage : 48.0
Total prélèvement : 392.2
Salaire net : 1607.8
```

Deuxième test :
```
Votre salaire brut : -1500
Salaire invalide
```

## Exercice 6

_Code :_

```java
/**
* Programme qui dit si on a eu son année avec combien de note entre 8 et 10
* ou si on ne l'a pas eu et pourquoi on ne l'a pas eu
* @author L. Carré
**/
class ObtentionAnnee{
	void principal(){
		double noteC1 = SimpleInput.getDouble("Votre note dans la compétence 1 : ");
		double noteC2 = SimpleInput.getDouble("Votre note dans la compétence 2 : ");
		double noteC3 = SimpleInput.getDouble("Votre note dans la compétence 3 : ");
		double noteC4 = SimpleInput.getDouble("Votre note dans la compétence 4 : ");
		double noteC5 = SimpleInput.getDouble("Votre note dans la compétence 5 : ");
		double noteC6 = SimpleInput.getDouble("Votre note dans la compétence 6 : ");
		int noteSup10 = 0;
		int noteBet810 = 0;
		int noteInf8 = 0;
		
		if ((noteC1 < 0 || noteC1 > 20) || (noteC2 < 0 || noteC2 > 20) || (noteC3 < 0 || noteC3 > 20) || (noteC4 < 0 || noteC4 > 20) || (noteC5 < 0 || noteC5 > 20) || (noteC6 < 0 || noteC6 > 20)) {
			System.out.println("Erreur durant la saisie des notes");
		} else {
			if (noteC1 >= 10) {
				noteSup10 += 1;
			} else if (noteC1 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC2 >= 10) {
				noteSup10 += 1;
			} else if (noteC2 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC3 >= 10) {
				noteSup10 += 1;
			} else if (noteC3 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC4 >= 10) {
				noteSup10 += 1;
			} else if (noteC4 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC5 >= 10) {
				noteSup10 += 1;
			} else if (noteC5 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC6 >= 10) {
				noteSup10 += 1;
			} else if (noteC6 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			
			
			
			if ((noteSup10 >= 4) && (noteInf8 == 0)) {
				System.out.println("Vous avez votre année avec " + noteBet810 + " notes entre 8 et 10.");
			} else if ((noteSup10 >= 4) && (noteInf8 != 0)) {
				System.out.println("Vous n'avez pas votre année, vous avez une ou plusieurs notes en dessous de 8.");
			} else if ((noteSup10 < 4) && (noteInf8 == 0)) {
				System.out.println("Vous n'avez pas votre année, vous n'avez pas assez de notes au dessus de 10.");
			} else {
				System.out.println("Vous n'avez pas votre année, vous n'avez pas assez de notes au dessus de 10 et vous avez une ou plusieurs notes en dessous de 8.");
			}
		}
	}
}
```

Premier test :
```cmd
Votre note dans la compétence 1 : 8
Votre note dans la compétence 2 : 8
Votre note dans la compétence 3 : 1
Votre note dans la compétence 4 : 14
Votre note dans la compétence 5 : 14
Votre note dans la compétence 6 : 14
Vous n'avez pas votre année, vous n'avez pas assez de notes au dessus de 10 et vous avez une ou plusieurs notes en dessous de 8.
```

Deuxième test :
```cmd
Votre note dans la compétence 1 : 9
Votre note dans la compétence 2 : 9
Votre note dans la compétence 3 : 8
Votre note dans la compétence 4 : 14
Votre note dans la compétence 5 : 15
Votre note dans la compétence 6 : 12
Vous n'avez pas votre année, vous n'avez pas assez de notes au dessus de 10.
```

Troisième test :
```cmd
Votre note dans la compétence 1 : 11
Votre note dans la compétence 2 : 12
Votre note dans la compétence 3 : 4
Votre note dans la compétence 4 : 14
Votre note dans la compétence 5 : 14
Votre note dans la compétence 6 : 14
Vous n'avez pas votre année, vous avez une ou plusieurs notes en dessous de 8.
9
```

Quatrième test :
```cmd
Votre note dans la compétence 1 : 11
Votre note dans la compétence 2 : 11
Votre note dans la compétence 3 : 9
Votre note dans la compétence 4 : 11
Votre note dans la compétence 5 : 11
Votre note dans la compétence 6 : 11
Vous avez votre année avec 1 notes entre 8 et 10.
```

Cinquième test :
```cmd
Votre note dans la compétence 1 : 21
Votre note dans la compétence 2 : 11
Votre note dans la compétence 3 : 11
Votre note dans la compétence 4 : 11
Votre note dans la compétence 5 : 11
Votre note dans la compétence 6 : 11
Erreur durant la saisie des notes
```