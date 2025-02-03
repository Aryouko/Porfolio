/**
*Programme qui demande la valeur du produit dans le distributeur puis demande l'argent inséré
*tant qu'il n'est pas suffisant et ensuite renvoie le rendu de l'argent
*@author L.Carré
*/
class Distributeur {
	void principal(){
		int prix, argentInsere, aRendre, totArgentInsere;
		String rendu = "";
		argentInsere = 0;
		totArgentInsere = 0;
		
		do {
			prix = SimpleInput.getInt ("Prix du produit: ");
		} while (prix <= 0);
		
		System.out.println("Prix du produit enregistré : " + prix);
		
		do {
			argentInsere = SimpleInput.getInt ("Argent inséré: ");
			if (argentInsere > 0) {
				totArgentInsere += argentInsere;
			}
			System.out.println("Vous avez inséré : " + totArgentInsere);
		} while (totArgentInsere < prix);
		
		System.out.println("Produit acheté");
		
		if (totArgentInsere == prix) {
			System.out.println("Pas de rendu de monnaie");
		} else {
			aRendre = totArgentInsere - prix;
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
