import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Grundy game with AI for the machine
 * This program allows you to test the effectiveness of estGagnante()
 * with a method more efficient
 *
 * @author L.Carré and A.Coudiere
 */
class GrundyRecPerdantNeutre {
    
    /** Global variable helping with the calculation of all complexities*/
    long cpt = 0;
    
    /** Global variable recording losing positions*/
    ArrayList<ArrayList<Integer>> posPerdantes = new ArrayList<ArrayList<Integer>>();

    /** Global variable recording winning positions*/
    ArrayList<ArrayList<Integer>> posGagnantes = new ArrayList<ArrayList<Integer>>();

    /**
     * Main method of the program
     */
    void principal() {
		//leJeu();
		testEstGagnanteEfficacite();
        //testEstConnuePerdante();
        //testEstConnueGagnante();
        testJouerGagnant();
    }
	
    /**
     * The game
     */
    void leJeu() {
        // Initialisation du jeu
        int nombreAllumettes;
        // Vérification du nombre d'allumettes
		do {
			nombreAllumettes = SimpleInput.getInt("Combien d'allumettes au départ (minimum 3) : ");
		} while (nombreAllumettes < 3);

		String joueur;
		//Demande qui joue en premier
		do {
			joueur = SimpleInput.getString("Qui joue en premier ? Ordinateur (CMP) ou joueur (USER) ");
		} while (!joueur.equals("CMP") && !joueur.equals("USER"));

        ArrayList<Integer> jeu = new ArrayList<Integer>();
        jeu.add(nombreAllumettes);
        
        
        // Partie de jeu
        while (estPossible(jeu)) {
			System.out.println();
			System.out.println("État actuel du jeu : " + jeu.toString());
			System.out.println();
			
			if (joueur.equals("CMP")) {
				System.out.println("Ordinateur joue...");
				boolean nonAleatoire = jouerGagnant(jeu);
				
				if (!nonAleatoire) {
					int ligne;
					int nb;
					
					do {
						ligne = (int)(Math.random() * jeu.size());
					} while (ligne < 0 || ligne >= jeu.size() || jeu.get(ligne) < 3);
						
					do {
						nb = (int)(Math.random() * jeu.get(ligne));
					} while (nb <= 0 || nb >= jeu.get(ligne) || nb == jeu.get(ligne) - nb);
					
					enlever(jeu, ligne, nb);
				}
				
				joueur = "USER";
				
			} else {
				System.out.println("À vous de jouer !");
				
				int ligne, nb;
				
				do {
					ligne = SimpleInput.getInt("Ligne où séparer ");
				} while (ligne < 0 || ligne >= jeu.size() || jeu.get(ligne) < 3);
				
				do {
					nb = SimpleInput.getInt("Combien d'allumettes dans le premier tas ");
				} while (nb <= 0 || nb >= jeu.get(ligne) || nb == jeu.get(ligne) - nb);
				
				enlever(jeu, ligne, nb);
				
				joueur = "CMP";
			}
        }
        
        System.out.println("État actuel du jeu : " + jeu.toString());
        
        if (joueur.equals("CMP")) {
			System.out.println();
			System.out.println("Bravo tu as gagné");
		} else {
			System.out.println();
			System.out.println("Dommage l'ordinateur a gagné");
		}
    }


    /**
     * Testing the effectiveness of the method estGagnante().
     */
    void testEstGagnanteEfficacite() {
        System.out.println();
		System.out.println("*** testEstGagnanteEfficacite() ***");
		System.out.println();
		
		long t1, t2;
		double diffT;        
		
		for (int n = 3; n <= 45; n++) {
			this.posPerdantes.clear();
			this.posGagnantes.clear();
			ArrayList<Integer> jeu = new ArrayList<Integer>();
            jeu.add(n);
			
			cpt = 0;
			t1 = System.nanoTime();
			boolean test = estGagnante(jeu);
			t2 = System.nanoTime();
			diffT = (t2 - t1)/1000000d;
			
			System.out.println("Le nombre d'allumette n = " + n);
            System.out.println("Le nombre d'opérations pour n allumettes cpt = " + cpt);
			System.out.println("Le temps d'exécution pour n allumettes diffT= " + diffT + " ms");
		}
    }

    /**
     * Play the winning move if it exists
     * 
     * @param jeu game board
     * @return true if there is a winning move, false otherwise
     */
    boolean jouerGagnant(ArrayList<Integer> jeu) {
	
        boolean gagnant = false;
		
        if (jeu == null) {
            System.err.println("jouerGagnant(): le paramètre jeu est null");
        } else {
			
            ArrayList<Integer> essai = new ArrayList<Integer>();
			
			// Une toute première décomposition est effectuée à partir de jeu.
			// Cette première décomposition du jeu est enregistrée dans essai.
			// ligne est le numéro de la case du tableau ArrayList (qui commence à zéro) qui
			// mémorise le tas (nbre d'allumettes) qui a été décomposé
            int ligne = premier(jeu, essai);
			
			// mise en oeuvre de la règle numéro2
			// Une situation (ou position) est dite gagnante pour la machine, s’il existe AU MOINS UNE décomposition
			// (c-à-d UNE action qui consiste à décomposer un tas en 2 tas inégaux) perdante pour l’adversaire. C'est
			// évidemment cette décomposition perdante qui sera choisie par la machine.
            while (ligne != -1 && !gagnant) {
				// estPerdante est récursif
                if (estPerdante(essai)) {
					// estPerdante (pour l'adversaire) à true ===> Bingo essai est la décomposition choisie par la machine qui est alors
					// certaine de gagner !!
                    jeu.clear();
                    gagnant = true;
					// essai est recopié dans jeu car essai est la nouvelle situation de jeu après que la machine ait joué (gagnant)
                    for (int i = 0; i < essai.size(); i++) {
                        jeu.add(essai.get(i));
                    }
                } else {
					// estPerdante à false ===> la machine essaye une autre décomposition en faisant appel à "suivant".
					// Si, après exécution de suivant, ligne est à (-1) alors il n'y a plus de décomposition possible à partir de jeu (et on sort du while).
					// En d'autres mots : la machine n'a PAS trouvé à partir de jeu UNE décomposition gagnante.
                    ligne = suivant(jeu, essai, ligne);
                }
            }
        }
		
        return gagnant;
    }
	
	/**
     * RECURSIVE method which indicates if the configuration (of the current game or test game) is losing.
	 * This method is used by the machine to know if the opponent can lose (100%).
     * 
     * @param jeu current game board (the state of the game at a certain point during the game)
     * @return true if the configuration (of the game) is a loser, false otherwise
     */
    boolean estPerdante(ArrayList<Integer> jeu) {
	
        boolean ret = true; // par défaut la configuration est perdante

        if (jeu == null) {
            System.err.println("estPerdante(): le paramètre jeu est null");
        }

        ArrayList<Integer> jeu_temp = new ArrayList<Integer>();
		for (int i = 0; i < jeu.size(); i++) {
            ArrayList<Integer> test = new ArrayList<>();
            jeu_temp.add(jeu.get(i));
            test.add(jeu.get(i));
			if (estConnuePerdante(test)) {
				jeu_temp.remove(jeu_temp.size() - 1);
			}
		}
        
        if (estConnuePerdante(jeu_temp)) {
			ret = true;
		}
		
		else if (estConnueGagnante(jeu_temp)) {
			ret = false;
		}
		
		else {
			// si il n'y a plus que des tas de 1 ou 2 allumettes dans le plateau de jeu
			// alors la situation est forcément perdante (ret=true) = FIN de la récursivité
            if ( !estPossible(jeu) ) {
                ret = true;
            }
			
			else {
				
				// création d'un jeu d'essais qui va examiner toutes les décompositions
				// possibles à partir de jeu
                ArrayList<Integer> essai = new ArrayList<Integer>(); // size = 0 !
				
				// toute première décomposition : enlever 1 allumette au premier tas qui possède
				// au moins 3 allumettes, ligne = -1 signifie qu'il n'y a plus de tas d'au moins 3 allumettes
                int ligne = premier(jeu, essai);
				
                while ( (ligne != -1) && ret) {
					cpt++;
				
					// mise en oeuvre de la règle numéro1
					// Une situation (ou position) est dite perdante si et seulement si TOUTES ses décompositions possibles
					// (c-à-d TOUTES les actions qui consistent à décomposer un tas en 2 tas inégaux) sont TOUTES gagnantes 
					// (pour l’adversaire).
					// L'appel à "estPerdante" est RECURSIF.
					
					// Si "estPerdante(essai)" est true c'est équivalent à "estGagnante" est false, la décomposition
					// essai n'est donc pas gagnante, on sort du while et on renvoie false.
                    if (estPerdante(essai) == true) {
					
						// Si UNE SEULE décomposition (à partir du jeu) est perdante (pour l'adversaire) alors le jeu n'EST PAS perdant.
						// On renverra donc false : la situation (jeu) n'est PAS perdante.
                        ret = false;
						
                    } else {
							
						// génère la configuration d'essai suivante (c'est-à-dire UNE décomposition possible)
						// à partir du jeu, si ligne = -1 il n'y a plus de décomposition possible
                        ligne = suivant(jeu, essai, ligne);
                    }
                }
                
                ArrayList<Integer> liste = new ArrayList<Integer>();
                for (int i = 0; i < jeu.size(); i++) {
						if (jeu.get(i) > 2) {
							liste.add(jeu.get(i));
						}
					}
				Collections.sort(liste);
                if (ret) {
					posPerdantes.add(liste);
				} else {
					posGagnantes.add(liste);
				}
            }
        }
		
        return ret;
    }
    
    /**
     * Checks if the game state is not already losing using a database
     * 
     * @param jeu game board
     * @return true if the configuration is losing, false otherwise
     */
    boolean estConnuePerdante (ArrayList<Integer> jeu) {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < jeu.size(); i++) {
			if (jeu.get(i) > 2) {
				liste.add(jeu.get(i));
			}
		}
	

    
		Collections.sort(liste);
		
		boolean trouve = false;
		for (int i = 0; (i < this.posPerdantes.size() && !trouve); i++) {
			if (liste.equals(this.posPerdantes.get(i))) {
				trouve = true;
			}
		}
		return trouve;
	}
	
    /**
     * Brief tests of the method estConnuePerdante()
     */
    void testEstConnuePerdante() {
        System.out.println();
        System.out.println("*** testEstConnuePerdante() ***");

        System.out.println("Test des cas normaux");
        ArrayList<Integer> jeu1 = new ArrayList<Integer>();
        jeu1.add(6);
        jeu1.add(3);
        this.posPerdantes.clear();
        ArrayList<Integer> perdante1 = new ArrayList<Integer>();
        perdante1.add(3);
        perdante1.add(6);
        posPerdantes.add(perdante1);
        testCasEstConnuePerdante(jeu1, posPerdantes, true);

        this.posPerdantes.clear();
        ArrayList<Integer> jeu2 = new ArrayList<Integer>();
        jeu2.add(4);
        testCasEstConnuePerdante(jeu2, posPerdantes, false);
        this.posPerdantes.clear();
    }

    /**
     * Testing a case of the method estConnuePerdante()
     *
     * @param jeu game board
     * @param posPerdantes the list of known losing positions
     * @param res the result expected by estConnuePerdante
     */
    void testCasEstConnuePerdante(ArrayList<Integer> jeu, ArrayList<ArrayList<Integer>> posPerdantes, boolean res) {
        System.out.print("estConnuePerdante (" + jeu.toString() + ", " + posPerdantes.toString() + ") : ");

        boolean resExec = estConnuePerdante(jeu);

        if (res == resExec) {
            System.out.println("OK\n");
        } else {
            System.err.println("ERREUR\n");
        }
    }

    /**
     * Checks if the game state is not already winning using a database
     * 
     * @param jeu game board
     * @return true if the configuration is winning, false otherwise
     */
	boolean estConnueGagnante (ArrayList<Integer> jeu) {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < jeu.size(); i++) {
			if (jeu.get(i) > 2) {
				liste.add(jeu.get(i));
			}
		}
		
		Collections.sort(liste);
		
		boolean trouve = false;
		for (int i = 0; (i < this.posGagnantes.size() && !trouve); i++) {
			if (liste.equals(this.posGagnantes.get(i))) {
				trouve = true;
			}
		}
		return trouve;
	}

    /**
     * Brief tests of the method estConnueGagnante()
     */
    void testEstConnueGagnante() {
        System.out.println();
        System.out.println("*** testEstConnueGagnante() ***");

        System.out.println("Test des cas normaux");
        ArrayList<Integer> jeu1 = new ArrayList<Integer>();
        jeu1.add(4);
        jeu1.add(3);
        this.posGagnantes.clear();
        ArrayList<Integer> gagnante1 = new ArrayList<Integer>();
        gagnante1.add(3);
        gagnante1.add(4);
        posGagnantes.add(gagnante1);
        testCasEstConnueGagnante(jeu1, posGagnantes, true);

        this.posGagnantes.clear();
        ArrayList<Integer> jeu2 = new ArrayList<Integer>();
        jeu2.add(3);
        testCasEstConnueGagnante(jeu2, posGagnantes, false);
        this.posGagnantes.clear();
    }

    /**
     * Testing a case of the method estConnueGagnante()
     *
     * @param jeu game board
     * @param posGagnantes the list of known losing positions
     * @param res the result expected by estConnueGagnante
     */
    void testCasEstConnueGagnante(ArrayList<Integer> jeu, ArrayList<ArrayList<Integer>> posGagnantes, boolean res) {
        System.out.print("estConnueGagnante (" + jeu.toString() + ", " + posGagnantes.toString() + ") : ");

        boolean resExec = estConnueGagnante(jeu);

        if (res == resExec) {
            System.out.println("OK\n");
        } else {
            System.err.println("ERREUR\n");
        }
    }
	
	/**
     * Indicates if the configuration is winning.
	 * Method that simply calls "estPerdante".
     * 
     * @param jeu game board
     * @return true if the configuration is winning, false otherwise
     */
    boolean estGagnante(ArrayList<Integer> jeu) {
        boolean ret = false;
        if (jeu == null) {
            System.err.println("estGagnante(): le paramètre jeu est null");
        } else {
            ret = !estPerdante(jeu);
        }
        return ret;
    }

    /**
     * Brief tests of the method joueurGagnant()
     */
    void testJouerGagnant() {
        System.out.println();
        System.out.println("*** testJouerGagnant() ***");

        System.out.println("Test des cas normaux");
        ArrayList<Integer> jeu1 = new ArrayList<Integer>();
        jeu1.add(6);
        ArrayList<Integer> resJeu1 = new ArrayList<Integer>();
        resJeu1.add(4);
        resJeu1.add(2);
		
        testCasJouerGagnant(jeu1, resJeu1, true);
        
    }

    /**
     * Testing a case of the method jouerGagnant()
	 *
	 * @param jeu game board
	 * @param resJeu the game board after playing winning
	 * @param res the result expected by jouerGagnant
     */
    void testCasJouerGagnant(ArrayList<Integer> jeu, ArrayList<Integer> resJeu, boolean res) {
        // Arrange
        System.out.print("jouerGagnant (" + jeu.toString() + ") : ");

        // Act
        boolean resExec = jouerGagnant(jeu);

        // Assert
        System.out.print(jeu.toString() + " " + resExec + " : ");
		boolean egaliteJeux = jeu.equals(resJeu);
        if (  egaliteJeux && (res == resExec) ) {
            System.out.println("OK\n");
        } else {
            System.err.println("ERREUR\n");
        }
    }	

    /**
     * Divide the matches from a row of games into two piles (1 row = 1 pile).
	 * The new heap is necessarily placed at the end of the table.
	 * The pile that is divided decreases by the number of matches removed.
     * 
     * @param jeu   table of matches by line
     * @param ligne pile for which matches must be separated
     * @param nb    number of matches REMOVED from the pile (line) during separation
     */
    void enlever ( ArrayList<Integer> jeu, int ligne, int nb ) {
		// traitement des erreurs
        if (jeu == null) {
            System.err.println("enlever() : le paramètre jeu est null");
        } else if (ligne >= jeu.size()) {
            System.err.println("enlever() : le numéro de ligne est trop grand");
        } else if (nb >= jeu.get(ligne)) {
            System.err.println("enlever() : le nb d'allumettes à retirer est trop grand");
        } else if (nb <= 0) {
            System.err.println("enlever() : le nb d'allumettes à retirer est trop petit");
        } else if (2 * nb == jeu.get(ligne)) {
            System.err.println("enlever() : le nb d'allumettes à retirer est la moitié");
        } else {
			// nouveau tas ajouté au jeu (nécessairement en fin de tableau)
			// ce nouveau tas contient le nbre d'allumettes retirées (nb) du tas à séparer			
            jeu.add(nb);
			// le tas restant possède "nb" allumettes en moins
            jeu.set ( ligne, (jeu.get(ligne) - nb) );
        }
    }

    /**
     * Test if it is possible to separate one of the piles
     * 
     * @param jeu      game board
     * @return true if there is at least one pile of 3 or more matches, false otherwise
     */
    boolean estPossible(ArrayList<Integer> jeu) {
        boolean ret = false;
        if (jeu == null) {
            System.err.println("estPossible(): le paramètre jeu est null");
        } else {
            int i = 0;
            while (i < jeu.size() && !ret) {
                if (jeu.get(i) > 2) {
                    ret = true;
                }
                i = i + 1;
            }
        }
        return ret;
    }

    /**
     * Create a very first test setup from the game
     * 
     * @param jeu      game board
     * @param jeuEssai new game configuration
     * @return the number of the pile divided in two or (-1) if there is no pile of at least 3 matches
     */
    int premier(ArrayList<Integer> jeu, ArrayList<Integer> jeuEssai) {
	
        int numTas = -1; // pas de tas à séparer par défaut
		int i;
		
        if (jeu == null) {
            System.err.println("premier(): le paramètre jeu est null");
        } else if (!estPossible((jeu)) ){
            System.err.println("premier(): aucun tas n'est divisible");
        } else if (jeuEssai == null) {
            System.err.println("premier(): le paramètre jeuEssai est null");
        } else {
            // avant la copie du jeu dans jeuEssai il y a un reset de jeuEssai 
            jeuEssai.clear(); // size = 0
            i = 0;
			
			// recopie case par case de jeu dans jeuEssai
			// jeuEssai est le même que le jeu avant la première configuration d'essai
            while (i < jeu.size()) {
                jeuEssai.add(jeu.get(i));
                i = i + 1;
            }
			
            i = 0;
			// rechercher un tas d'allumettes d'au moins 3 allumettes dans le jeu
			// sinon numTas = -1
			boolean trouve = false;
            while ( (i < jeu.size()) && !trouve) {
				
				// si on trouve un tas d'au moins 3 allumettes
				if ( jeuEssai.get(i) >= 3 ) {
					trouve = true;
					numTas = i;
				}
				
				i = i + 1;
            }
			
			// sépare le tas (case numTas) en un nouveau tas d'UNE SEULE allumette qui vient se placer en fin du tableau 
			// le tas en case numTas a diminué d'une allumette (retrait d'une allumette)
			// jeuEssai est le plateau de jeu qui fait apparaître cette séparation
            if ( numTas != -1 ) enlever ( jeuEssai, numTas, 1 );
        }
		
        return numTas;
    }

    /**
     * Brief tests of the method premier()
     */
    void testPremier() {
        System.out.println();
        System.out.println("*** testPremier()");

        ArrayList<Integer> jeu1 = new ArrayList<Integer>();
        jeu1.add(10);
        jeu1.add(11);
        int ligne1 = 0;
        ArrayList<Integer> res1 = new ArrayList<Integer>();
        res1.add(9);
        res1.add(11);
        res1.add(1);
        testCasPremier(jeu1, ligne1, res1);
    }

    /**
     * Test a case of the testPremier method
	 * @param jeu game board
	 * @param ligne the number of the pile separated first
	 * @param res the game board after a first separation
     */
    void testCasPremier(ArrayList<Integer> jeu, int ligne, ArrayList<Integer> res) {
        // Arrange
        System.out.print("premier (" + jeu.toString() + ") : ");
        ArrayList<Integer> jeuEssai = new ArrayList<Integer>();
        // Act
        int noLigne = premier(jeu, jeuEssai);
        // Assert
        System.out.println("\nnoLigne = " + noLigne + " jeuEssai = " + jeuEssai.toString());
		boolean egaliteJeux = jeuEssai.equals(res);
        if ( egaliteJeux && noLigne == ligne ) {
            System.out.println("OK\n");
        } else {
            System.err.println("ERREUR\n");
        }
    }

    /**
     * Generates the following test configuration (i.e. ONE possible decomposition)
     * 
     * @param jeu      gameborad
     * @param jeuEssai test configuration of the game after separation
     * @param ligne    the number of the pile which was the last to have been separated
     * @return the heap number divided in two for the new configuration, -1 if no further decomposition is possible
     */
    int suivant(ArrayList<Integer> jeu, ArrayList<Integer> jeuEssai, int ligne) {
	
        // System.out.println("suivant(" + jeu.toString() + ", " +jeuEssai.toString() +
        // ", " + ligne + ") = ");
		
		int numTas = -1; // par défaut il n'y a plus de décomposition possible
		
        int i = 0;
		// traitement des erreurs
        if (jeu == null) {
            System.err.println("suivant(): le paramètre jeu est null");
        } else if (jeuEssai == null) {
            System.err.println("suivant() : le paramètre jeuEssai est null");
        } else if (ligne >= jeu.size()) {
            System.err.println("suivant(): le paramètre ligne est trop grand");
        }
		
		else {
		
			int nbAllumEnLigne = jeuEssai.get(ligne);
			int nbAllDernCase = jeuEssai.get(jeuEssai.size() - 1);
			
			// si sur la même ligne (passée en paramètre) on peut encore retirer des allumettes,
			// c-à-d si l'écart entre le nombre d'allumettes sur cette ligne et
			// le nombre d'allumettes en fin de tableau est > 2, alors on retire encore
			// 1 allumette sur cette ligne et on ajoute 1 allumette en dernière case		
            if ( (nbAllumEnLigne - nbAllDernCase) > 2 ) {
                jeuEssai.set ( ligne, (nbAllumEnLigne - 1) );
                jeuEssai.set ( jeuEssai.size() - 1, (nbAllDernCase + 1) );
                numTas = ligne;
            } 
			
			// sinon il faut examiner le tas (ligne) suivant du jeu pour éventuellement le décomposer
			// on recrée une nouvelle configuration d'essai identique au plateau de jeu
			else {
                // copie du jeu dans JeuEssai
                jeuEssai.clear();
                for (i = 0; i < jeu.size(); i++) {
                    jeuEssai.add(jeu.get(i));
                }
				
                boolean separation = false;
                i = ligne + 1; // tas suivant
				// si il y a encore un tas et qu'il contient au moins 3 allumettes
				// alors on effectue une première séparation en enlevant 1 allumette
                while ( i < jeuEssai.size() && !separation ) {
					// le tas doit faire minimum 3 allumettes
                    if ( jeu.get(i) > 2 ) {
                        separation = true;
						// on commence par enlever 1 allumette à ce tas
                        enlever(jeuEssai, i, 1);
						numTas = i;
                    } else {
                        i = i + 1;
                    }
                }				
            }
        }
		
        return numTas;
    }

    /**
     * Brief tests of the method suivant()
     */
    void testSuivant() {
        System.out.println();
        System.out.println("*** testSuivant() ****");

        int ligne1 = 0;
        int resLigne1 = 0;
        ArrayList<Integer> jeu1 = new ArrayList<Integer>();
        jeu1.add(10);
        ArrayList<Integer> jeuEssai1 = new ArrayList<Integer>();
        jeuEssai1.add(9);
        jeuEssai1.add(1);
        ArrayList<Integer> res1 = new ArrayList<Integer>();
        res1.add(8);
        res1.add(2);
        testCasSuivant(jeu1, jeuEssai1, ligne1, res1, resLigne1);

        int ligne2 = 0;
        int resLigne2 = -1;
        ArrayList<Integer> jeu2 = new ArrayList<Integer>();
        jeu2.add(10);
        ArrayList<Integer> jeuEssai2 = new ArrayList<Integer>();
        jeuEssai2.add(6);
        jeuEssai2.add(4);
        ArrayList<Integer> res2 = new ArrayList<Integer>();
        res2.add(10);
        testCasSuivant(jeu2, jeuEssai2, ligne2, res2, resLigne2);

        int ligne3 = 1;
        int resLigne3 = 1;
        ArrayList<Integer> jeu3 = new ArrayList<Integer>();
        jeu3.add(4);
        jeu3.add(6);
        jeu3.add(3);
        ArrayList<Integer> jeuEssai3 = new ArrayList<Integer>();
        jeuEssai3.add(4);
        jeuEssai3.add(5);
        jeuEssai3.add(3);
        jeuEssai3.add(1);
        ArrayList<Integer> res3 = new ArrayList<Integer>();
        res3.add(4);
        res3.add(4);
        res3.add(3);
        res3.add(2);
        testCasSuivant(jeu3, jeuEssai3, ligne3, res3, resLigne3);

    }

    /**
     * Test a case of the method suivant
	 * 
	 * @param jeu game board
	 * @param jeuEssai the game board obtained after separating a pile
	 * @param ligne the number of the pile which was the last to have been separated
	 * @param resJeu is the jeuEssai expected after separation
	 * @param resLigne is the expected number of the heap that is separated
     */
    void testCasSuivant(ArrayList<Integer> jeu, ArrayList<Integer> jeuEssai, int ligne, ArrayList<Integer> resJeu, int resLigne) {
        // Arrange
        System.out.print("suivant (" + jeu.toString() + ", " + jeuEssai.toString() + ", " + ligne + ") : ");
        // Act
        int noLigne = suivant(jeu, jeuEssai, ligne);
        // Assert
        System.out.println("\nnoLigne = " + noLigne + " jeuEssai = " + jeuEssai.toString());
		boolean egaliteJeux = jeuEssai.equals(resJeu);
        if ( egaliteJeux && noLigne == resLigne ) {
            System.out.println("OK\n");
        } else {
            System.err.println("ERREUR\n");
        }
    }

}
