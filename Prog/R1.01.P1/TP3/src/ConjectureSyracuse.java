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
