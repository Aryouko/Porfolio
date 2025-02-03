import java.util.*;
import java.io.*;
/**
 * Cette classe permet d'accéder à plusieurs méthodes afin de faire une planification des trains
 * @author L.Carré
 */
class Planification {
	
	/** Variables globales accessibles par toutes les méthodes contenant les informations du trajets*/
	ArrayList<String> trajets = new ArrayList<String>();
	/** Variables globales accessibles par toutes les méthodes contenant les informations des horaires*/
	ArrayList<Integer> horaires = new ArrayList<Integer>();
	
	/**
	 * Le point d'entré du programme
	 */
	void principal() {
		testRemplirLesCollections();
		testAfficherHorairesEtDureeTrajets();
		testAfficherHorairesEtDureeTrajets2Gares();
		testChercherCorrespondances();
		testObtenirInfosUnTrajet();
		testObtenirInfosUnHoraire();
		testTrouverTousLesTrajets();
	}
	
	/**
	 * Méthode permettant de remplir les attributs trajets et horaires de la classe grâce à un
	 * fichier texte passé en paramètre
	 * @param nomFich contenant des informations sur des trajets et horaires de trains
	 */
	void remplirLesCollections(String nomFich) {
		//Afin de vider les collections trajets et horaires
		this.trajets.clear();
		this.horaires.clear();
		
		boolean eof = false; 
		String str;
		BufferedReader tampon; 
		FileReader file;
		
		try {
			tampon = new BufferedReader(new	FileReader(nomFich));
			while (!eof) {
				str = tampon.readLine();
				if (str == null) {
					eof = true; 
				} else {
					String[] donnees = str.split(" / ");
					if (donnees.length == 4) {
						for (int i = 0; i < donnees.length; i++)
							this.trajets.add(donnees[i]);
					} else {
						for (int i = 0; i < donnees.length; i++)
							this.horaires.add(Integer.parseInt(donnees[i]));
					}
				}
			}
			tampon.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Méthode permettant d'afficher toutes les informations de chaque trajets
	 */
	void afficherHorairesEtDureeTousTrajets() {
		for (int i = 0; i < (this.trajets.size() / 4); i++) {
			int tempsDepH, tempsDepM, tempsDestH , tempsDestM;
			Duree dureeDest = null;
			Duree dureeDep = null;
			
			int numero = Integer.parseInt(this.trajets.get(i*4));
			String typeTrain = this.trajets.get(i*4 + 1);
			String gareDep = this.trajets.get(i*4 + 2);
			String gareDest = this.trajets.get(i*4 + 3);
			
			for (int j = 0; j < (this.horaires.size() / 5); j++) {
				if (this.horaires.get(j*5) == numero) {
					dureeDep = new Duree(this.horaires.get(j*5 + 1), this.horaires.get(j*5 + 2), 0);
					dureeDest = new Duree(this.horaires.get(j*5 + 3), this.horaires.get(j*5 + 4), 0);
				}
			}
			
			System.out.println();
			System.out.println("Train " + typeTrain + " numéro " + numero);
			System.out.println("Départ de " + gareDep + " à " + dureeDep.enTexte('H'));
			System.out.println("Arrivée à " + gareDest + " à " + dureeDest.enTexte('H'));
			dureeDest.soustraire(dureeDep);
			System.out.println("Durée du trajet " + dureeDest.enTexte('H'));
			System.out.println();
		}
	}
	
	/**
	 * Méthode permettant d'afficher toutes les informations des trajets ayant pour
	 * gare de départ celle passé en paramètre et garde d'arrivé celle passé en paramètre aussi
	 * @param gareDep gare de départ recherché
	 * @param gareDest gare d'arrivée recherché
	 */
	void afficherHorairesEtDureeTrajets2Gares(String gareDep, String gareDest) {
		for (int i = 0; i < (this.trajets.size() / 4); i++) {
			if (this.trajets.get(i*4 + 2).equals(gareDep) && this.trajets.get(i*4 + 3).equals(gareDest)) {
				int tempsDepH, tempsDepM, tempsDestH , tempsDestM;
				Duree dureeDest = null;
				Duree dureeDep = null;
				
				int numero = Integer.parseInt(this.trajets.get(i*4));
				String typeTrain = this.trajets.get(i*4 + 1);
				
				for (int j = 0; j < (this.horaires.size() / 5); j++) {
					if (this.horaires.get(j*5) == numero) {
						dureeDep = new Duree(this.horaires.get(j*5 + 1), this.horaires.get(j*5 + 2), 0);
						dureeDest = new Duree(this.horaires.get(j*5 + 3), this.horaires.get(j*5 + 4), 0);
					}
				}
				
				System.out.println();
				System.out.println("Train " + typeTrain + " numéro " + numero);
				System.out.println("Départ de " + gareDep + " à " + dureeDep.enTexte('H'));
				System.out.println("Arrivée à " + gareDest + " à " + dureeDest.enTexte('H'));
				dureeDest.soustraire(dureeDep);
				System.out.println("Durée du trajet " + dureeDest.enTexte('H'));
				System.out.println();
			}
		}
	}
	
	/**
	 * Méthode permettant de récupérer la liste de chaine de caractères des 
	 * trajets où la gare de départ correspond à celle passé en paramètre et
	 * où l'heure de départ est plus grande que celle passé en paramètre
	 * @param gare la gare de départ recherché
	 * @param heure l'heure permettant la recherche d'une heure plus grande
	 * @return ret la liste des trajets correspondants
	 */
	ArrayList<String> chercherCorrespondances(String gare, Duree heure) {
		ArrayList<String> ret = new ArrayList<String>();
		ArrayList<String> tousLesTrajetsDep = trouverTousLesTrajets(gare);
		for (int i = 0; i < tousLesTrajetsDep.size(); i++) {
			int[] horaireTrajet = obtenirInfosUnHoraire(tousLesTrajetsDep.get(i));
			Duree dureeDep = new Duree(horaireTrajet[0], horaireTrajet[1], 0);
			if (dureeDep.compareA(heure) == 1) {
				ret.add(tousLesTrajetsDep.get(i));
			}
		}
		return ret;
	}
	
	/**
	 * Méthode permettant de récupérer le tableau de chaine de caractères
	 * contenant 3 informations : le type de train, la gare de départ et 
	 * la gare de destination grâce à l'identifiant du trajet donné en paramètre
	 * @param idTrajet l'identifiant du trajet dont on recherche les informations
	 * @return ret le tableau des informations du trajet du train
	 */
	String[] obtenirInfosUnTrajet(String idTrajet) {
		String[] ret = null;
		boolean trouve = false;
		for (int i = 0; i < (this.trajets.size() / 4) && !trouve; i++) {
			if (this.trajets.get(i*4).equals(idTrajet)) {
				ret = new String[3];
				ret[0] = this.trajets.get(i*4 + 1);
				ret[1] = this.trajets.get(i*4 + 2);
				ret[2] = this.trajets.get(i*4 + 3);
				trouve = true;
			}
		}
		return ret;
	}
	
	/**
	 * Méthode permettant de récupérer le tableau d'entiers contenant 
	 * 4 informations : heure départ, minutes départ, heure arrivée, 
	 * minutes arrivée grâce à l'identifiant du trajet donné en paramètre
	 * @param idTrajet l'identifiant du trajet dont on recherche les informations
	 * @return ret le tableau des informations des horaires du train
	 */
	int[] obtenirInfosUnHoraire(String idTrajet) {
		int numero = Integer.parseInt(idTrajet);
		int[] ret = null;
		boolean trouve = false;
		for (int i = 0; i < (this.horaires.size() / 5) && !trouve; i++) {
			if (this.horaires.get(i*5) == numero) {
				ret = new int[4];
				ret[0] = this.horaires.get(i*5 + 1);
				ret[1] = this.horaires.get(i*5 + 2);
				ret[2] = this.horaires.get(i*5 + 3);
				ret[3] = this.horaires.get(i*5 + 4);
				trouve = true;
			}
		}
		return ret;
	}
	
	/**
	 * Méthode permettant de récupérer la liste de chaine de caractères des identifiants 
	 * des trajets où la gare de départ correspond à celle passé en paramètre
	 * @param gareDep la gare de départ recherché
	 * @return ret la liste des identifiants des trajets correspondants
	 */
	ArrayList<String> trouverTousLesTrajets(String gareDep) {
		ArrayList<String> ret = new ArrayList<String>();
		for (int i = 0; i < (this.trajets.size() / 4); i++) {
			String idTrajet = String.valueOf(this.trajets.get(i*4));
			String[] infoTrajet = obtenirInfosUnTrajet(idTrajet);
			if (infoTrajet != null && infoTrajet[1].equals(gareDep)) {
				ret.add(idTrajet);
			}
		}
		return ret;
	}
	
	
	/*** Les méthodes de test ***/
	
	/**
	 * Teste de la méthode remplirLesCollections()
	 */
	void testRemplirLesCollections() {
		System.out.println();
		System.out.println("*** testRemplirLesCollections() ***");
		
		// Appel de la méthode à tester “cas normal”
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Vérification visuel");
		testCasRemplirLesCollections("./TrajetsEtHoraires.txt", 10); 
	}
	
	/**
	 * Teste un appel de remplirLesCollections()
	 * @param nomFich contenant des informations sur des trajets et horaires de trains
	 * @param lines nombre de "lignes" attendu dans les variables globales
	 */
	void testCasRemplirLesCollections(String nomFich, int lines) {
		remplirLesCollections(nomFich);
		afficherHorairesEtDureeTousTrajets();
		
		System.out.print("Lignes attendus dans les variable globales = " + lines + " : ");
		if ((this.trajets.size() / 4 == lines) && (this.horaires.size() / 5 == lines)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de la méthode afficherHorairesEtDureeTrajets()
	 */
	void testAfficherHorairesEtDureeTrajets() {
		System.out.println();
		System.out.println("*** testAfficherHorairesEtDureeTrajets() ***");
		
		// Appel de la méthode à tester “cas normal”
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Vérification visuel");
		testCasAfficherHorairesEtDureeTrajets("./TrajetsEtHoraires.txt", 10); 
	}
	
	/**
	 * Teste un appel de afficherHorairesEtDureeTrajets()
	 * @param nomFich contenant des informations sur des trajets et horaires de trains
	 * @param lines nombre de "lignes" attendu dans les variables globales
	 */
	void testCasAfficherHorairesEtDureeTrajets(String nomFich, int lines) {
		remplirLesCollections(nomFich);
		afficherHorairesEtDureeTousTrajets();
		
		System.out.print("Lignes attendus dans les variable globales = " + lines + " : ");
		if ((this.trajets.size() / 4 == lines) && (this.horaires.size() / 5 == lines)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de la méthode afficherHorairesEtDureeTrajets2Gares()
	 */
	void testAfficherHorairesEtDureeTrajets2Gares() {
		System.out.println();
		System.out.println("*** testAfficherHorairesEtDureeTrajets2Gares() ***");
		
		// D’abord remplir les collections        
		remplirLesCollections("./TrajetsEtHoraires.txt");
		
		System.out.println();
		System.out.println("* Cas normal *");
		System.out.println("Vérification visuel");
		testCasAfficherHorairesEtDureeTrajets2Gares("Vannes", "Redon");
	}
	
	/**
	 * Teste un appel de afficherHorairesEtDureeTrajets2Gares()
	 * @param gareDep gare de départ recherché
	 * @param gareDest gare d'arrivée recherché
	 */
	void testCasAfficherHorairesEtDureeTrajets2Gares(String gareDep, String gareDest) {
		afficherHorairesEtDureeTrajets2Gares(gareDep, gareDest);
	}
	
	/**
	 * Teste de la méthode afficherHorairesEtDureeTrajets2Gares()
	 */
	void testChercherCorrespondances() {
		System.out.println();
		System.out.println("*** testChercherCorrespondances() ***");
		
		// D’abord remplir les collections        
		remplirLesCollections("./TrajetsEtHoraires.txt");
		
		System.out.println();
		System.out.println("* Cas normal *");
		ArrayList<String> res1 = new ArrayList<String>();
		res1.add("6");
		res1.add("5");
		testCasChercherCorrespondances("Vannes", new Duree(10,0,0), res1);
		System.out.println("- - - - - - - - - - -");
		ArrayList<String> res2 = new ArrayList<String>();
		testCasChercherCorrespondances("Vannes", new Duree(20,0,0), res2);
		System.out.println("- - - - - - - - - - -");
		ArrayList<String> res3 = new ArrayList<String>();
		res3.add("3");
		res3.add("4");
		testCasChercherCorrespondances("Redon", new Duree(5,0,0), res3);
		System.out.println("- - - - - - - - - - -");
		ArrayList<String> res4 = new ArrayList<String>();
		testCasChercherCorrespondances("Strasbourg", new Duree(10,0,0), res4);
	}
	
	/**
	 * Teste un appel de chercherCorrespondances()
	 * @param gare la gare de départ recherché
	 * @param heure l'heure permettant la recherche d'une heure plus grande
	 * @param resAttendu le résultat attendu
	 */
	void testCasChercherCorrespondances(String gare, Duree heure, ArrayList<String> resAttendu) {
		ArrayList<String> resExecute = chercherCorrespondances(gare, heure);
		
		System.out.print("Résultat attendu pour " + gare + " et " + heure.enTexte('H') + " = " + resAttendu + " : ");
		if (resAttendu.equals(resExecute)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de la méthode obtenirInfosUnTrajet()
	 */
	void testObtenirInfosUnTrajet() {
		System.out.println();
		System.out.println("*** testObtenirInfosUnTrajet() ***");
		
		// D’abord remplir les collections        
		remplirLesCollections("./TrajetsEtHoraires.txt");
		
		System.out.println();
		System.out.println("* Cas normal *");
		String[] res1 = {"TER","Vannes","Redon"};
		testCasObtenirInfosUnTrajet("1", res1);
		System.out.println("- - - - - - - - - - -");
		String[] res2 = {"TGV","Rennes","Nantes"};
		testCasObtenirInfosUnTrajet("9", res2);
		System.out.println("- - - - - - - - - - -");
		int[] res3 = null;
		testCasObtenirInfosUnHoraire("100", res3);
	}
	
	/**
	 * Teste un appel de obtenirInfosUnTrajet()
	 * @param idTrajet l'identifiant du trajet dont on recherche les informations
	 * @param resAttendu le résultat attendu
	 */
	void testCasObtenirInfosUnTrajet(String idTrajet, String[] resAttendu) {
		String[] resExecute = obtenirInfosUnTrajet(idTrajet);
		
		System.out.print("Résultat attendu pour l'id " + idTrajet + " = " + Arrays.toString(resAttendu) + " : ");
		if (Arrays.equals(resAttendu, resExecute)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de la méthode obtenirInfosUnHoraire()
	 */
	void testObtenirInfosUnHoraire() {
		System.out.println();
		System.out.println("*** testObtenirInfosUnHoraire() ***");
		
		// D’abord remplir les collections        
		remplirLesCollections("./TrajetsEtHoraires.txt");
		
		System.out.println();
		System.out.println("* Cas normal *");
		int[] res1 = {9,35,10,30};
		testCasObtenirInfosUnHoraire("1", res1);
		System.out.println("- - - - - - - - - - -");
		int[] res2 = {10,12,11,28};
		testCasObtenirInfosUnHoraire("9", res2);
		System.out.println("- - - - - - - - - - -");
		int[] res3 = null;
		testCasObtenirInfosUnHoraire("100", res3);
	}
	
	/**
	 * Teste un appel de obtenirInfosUnHoraire()
	 * @param idTrajet l'identifiant du trajet dont on recherche les informations
	 * @param resAttendu le résultat attendu
	 */
	void testCasObtenirInfosUnHoraire(String idTrajet, int[] resAttendu) {
		int[] resExecute = obtenirInfosUnHoraire(idTrajet);
		
		System.out.print("Résultat attendu pour l'id " + idTrajet + " = " + Arrays.toString(resAttendu) + " : ");
		if (Arrays.equals(resAttendu, resExecute)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
	
	/**
	 * Teste de la méthode trouverTousLesTrajets()
	 */
	void testTrouverTousLesTrajets() {
		System.out.println();
		System.out.println("*** testTrouverTousLesTrajets() ***");
		
		// D’abord remplir les collections        
		remplirLesCollections("./TrajetsEtHoraires.txt");
		
		System.out.println();
		System.out.println("* Cas normal *");
		ArrayList<String> res1 = new ArrayList<String>();
		res1.add("1");
		res1.add("2");
		res1.add("6");
		res1.add("7");
		res1.add("5");
		res1.add("8");
		testCasTrouverTousLesTrajets("Vannes", res1);
		System.out.println("- - - - - - - - - - -");
		ArrayList<String> res2 = new ArrayList<String>();
		res2.add("3");
		res2.add("4");
		testCasTrouverTousLesTrajets("Redon", res2);
		System.out.println("- - - - - - - - - - -");
		ArrayList<String> res3 = new ArrayList<String>();
		testCasTrouverTousLesTrajets("Strasbourg", res3);
	}
	
	/**
	 * Teste un appel de trouverTousLesTrajets()
	 * @param gareDep la gare de départ recherché
	 * @param resAttendu le résultat attendu
	 */
	void testCasTrouverTousLesTrajets(String gareDep, ArrayList<String> resAttendu) {
		ArrayList<String> resExecute = trouverTousLesTrajets(gareDep);
		
		System.out.print("Résultat attendu = " + resAttendu + " : ");
		if (resAttendu.equals(resExecute)){
			System.out.println ("OK");
		} else {
			System.err.println ("ERREUR");
		}
	}
}
