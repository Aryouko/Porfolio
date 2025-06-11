package application;
import notification.Server;
/**
 * This class only contains one main demonstrator of correct operation
 * from the alert service.
 * @author L. Carré
 * @version 1.0
*/
public class TestServer{
	/**
	* Execution of examples of use of the service.
	* @param args arguments not used in this example
	*/
	public static void main(String[] args) {
		Server serveur = new Server();
		// Inscription
		serveur.adherer("Alice", "SMS", "0633343536");
		serveur.adherer("Bob", "MAIL","bob@orange.fr");
		// Envoi d'une alerte
		serveur.alerter("Bonjour, voici une alerte importante!");
		// Désinscription de Bob
		serveur.retirer("Bob");
		// Ajout d'un nouveau client
		serveur.adherer("Charlie", "MAIL", "charlie@orange.fr");
		// Envoi d'une autre alerte
		serveur.alerter("Deuxième alerte!");
		// Affichage des inscrits
		String[] inscrits = serveur.getListeInscrits();
		System.out.println("Liste des inscrits : Nom Adresse (mode)");
		for(String ins : inscrits){
			System.out.println(ins);
		}
	}
}
