/**
*Programme qui compte le nombre de valeurs différentes
*@author L.Carré
*/
class Morpion {
	void principal() {
		char[][] morpion = {{'X','O'},{' ','X'}};
		affichePlateau(morpion);
		System.out.print(alignDiagonal(morpion));
		jouer();
	}

	/**
	* Affichage du plateau de Morpion avec les indices de lignes
	* et de colonnes
	* @param plateau le tableau a afficher
	*/
	void affichePlateau(char[][] plateau) {
		System.out.print(" ");
		for (int k = 0; k < plateau.length; k++) {
			System.out.print("   " + k);
		}
		System.out.println();
		for (int i = 0; i < plateau.length; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < plateau[i].length; j++) {
				System.out.print(plateau[i][j] + " | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	/**
	* Créer un plateau de jeu carré rempli de caractere espace ’ ’
	* @param lg taille du plateau (lg < 10 : pas à vérifier)
	* @return tableau de caractere en deux dimensions
	*/
	char[][] creerPlateau(int lg) {
		char [][] plateau = new char[lg][lg];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				plateau[i][j] = ' ';
			}
		}
		return plateau;
	}
		
		
	/**
	* Demande deux coordonnees à l’utilisateur. Si les coordonnees sont
	* correctes (dans le plateau et pas de pion déjà mis à cet endroit),
	* le caractere du joueur est ajouté au plateau sinon, on redemande
	* des coordonnées à l’utilisateur en expliquant l’erreur
	* @param plateau le plateau de jeu
	* @param joueur le caractere representant le joueur : X ou O
	*/
	void ajoutePion(char[][] plateau, char joueur) {
		boolean ligneVerif = true;
		boolean caseVerif = true;
		int ligne;
		int col;
		
		do {
			ligne = SimpleInput.getInt("Ligne à jouer");
			if (ligne >= 0 && ligne < plateau.length) {
				for (int i = 0; i < plateau[ligne].length; i++) {
					if (plateau[ligne][i] == ' ') {
						ligneVerif = false;
					}
				}
			}
		} while (ligneVerif || ligne < 0 || ligne >= plateau.length);
		
		do {
			col = SimpleInput.getInt("Colonne à jouer");
			if (col >= 0 && col < plateau[ligne].length) {
				if (plateau[ligne][col] == ' ') {
					caseVerif = false;
				}
			}
		} while (caseVerif || col < 0 || col >= plateau[ligne].length);
		
		plateau[ligne][col] = joueur;
	}
	
	
	/**
	* Verifie si toutes les cases du plateau sont remplies
	* (différentes de ’ ’)
	* @param plateau le plateau de jeu
	* @return true si tout le plateau est rempli, false sinon.
	*/
	boolean estRempli(char[][] plateau) {
		boolean res = true;
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[i].length; j++) {
				if (plateau[i][j] == ' ') {
					res = false;
				}
			}
		}
		return res;
	}
	
	
	/**
	* Verifie s’il y a un alignement de n mêmes caracteres horizontalement
	* (n étant la longueur ou largeur du plateau)
	* @param plateau le plateau de jeu
	* @return true s’il existe un alignement horizontal sur une ligne du plateau
	*/
	boolean alignHorizontal(char[][] plateau) {
		boolean res = false;
		for (int i = 0; i < plateau.length; i++) {
			boolean ligne = true;
			for (int j = 0; j < plateau[i].length - 1; j++) {
				if (plateau[i][j] != plateau[i][j + 1] || plateau[i][j] == ' ') {
					ligne = false;
				}
			}
			if (ligne) {
				res = true;
			}
		}
		return res;
	}
	
	/**
	* Verifie s’il y a un alignement de n mêmes caracteres verticalement
	* (n étant la longueur ou largeur du plateau)
	* @param plateau le plateau de jeu
	* @return true s’il existe un alignement vertical sur une ligne du plateau
	*/
	boolean alignVertical(char[][] plateau) {
		boolean res = false;
		for (int i = 0; i < plateau.length - 1; i++) {
			boolean ligne = true;
			for (int j = 0; j < plateau[i].length; j++) {
				if (plateau[i][j] != plateau[i+1][i] || plateau[i][j] == ' ') {
					ligne = false;
				}
			}
			if (ligne) {
				res = true;
			}
		}
		return res;
	}
	/**
	* Verifie s’il y a un alignement de n mêmes caracteres diagonalement
	* (n étant la longueur ou largeur du plateau)
	* @param plateau le plateau de jeu
	* @return true s’il existe un alignement diagonal sur une ligne du plateau
	*/
	boolean alignDiagonal(char[][] plateau) {
		boolean res = false;
		for (int i = 0; i < plateau.length - 1; i++) {
			boolean ligne = true;
			for (int j = 0; j < plateau[i].length - 1; j++) {
				if (plateau[i][j] != plateau[i+1][j+1] || plateau[i][j] == ' ') {
					ligne = false;
				}
			}
			if (ligne) {
				res = true;
			}
		}
		for (int i = plateau.length - 1; i > 0; i--) {
			boolean ligne = true;
			for (int j = 0; j < plateau[i].length - 1; j++) {
				if (plateau[i][j] != plateau[i-1][j+1] || plateau[i][j] == ' ') {
					ligne = false;
				}
			}
			if (ligne) {
				res = true;
			}
		}
		return res;
	}
	
	
	/**
	* Change le joueur courant
	* @param joueurInitial un caractère représentant le joueur : X ou O
	* @return si le joueur ’X’ est en parametre alors renvoie ’O’
	* sinon renvoie ’X’
	*/
	char changeJoueur(char joueurInitial) {
		char joueur;
		if (joueurInitial == 'X') {
			joueur = 'O';
		} else {
			joueur = 'X';
		}
		return joueur;
	}
	
	/**
	* Lance une partie de morpion
	* @param plateau le tableau a afficher
	*/
	void jouer(){
		//Demande une taille de plateau à l’utilisateur
		int taille = SimpleInput.getInt("taille tableau");
		char[][] tab = creerPlateau(taille);
		char joueur = 'O';
		
		affichePlateau(tab);
		
		while (!(alignDiagonal(tab) || alignHorizontal(tab) || alignVertical(tab) || estRempli(tab))) {
			joueur = changeJoueur(joueur);
			ajoutePion(tab, joueur);
			affichePlateau(tab);
		}
		if (alignDiagonal(tab) || alignHorizontal(tab) || alignVertical(tab)) {
			System.out.print("Bien joué au joueur utilisant les " + joueur);
		} else {
			System.out.print("Match nul");
		}
	}
}	
