package notification;
import java.util.HashMap;
import java.util.Map;
/**
 * The only public class in the package for now, it is the conductor of the alert service.
 * @author L. Carré
 * @version 1.0
*/
public class Server {

    
    /**
     * Stores user subscriptions in the form (name, subscriber)
     */
    private Map<String, Subscriber> abonnements;

    /**
     * Server Constructor: Initializes the subscriber storage structure
     */
    public Server() {
        this.abonnements = new HashMap<>();
	}
	
	/**
	 * Method which adds a subscription for a new customer identified by 
	 * his name and according to a modality for the address provided
	 * @param clientName name of the client
	 * @param mode communication mode chosen by the subscriber
	 * @param adr address of the subscriber
	 */
	public void adherer(String clientName, String mode, String adr) {
		if (abonnements.containsKey(clientName)) {
            System.out.println("Le client est déjà inscrit.");
        } else {
	        CommunicationStrategy strategy = CommunicationAccess.getCom(mode);
			if (strategy == null) {
				strategy = CommunicationFactory.create(mode);
				if (strategy == null) {
					System.out.println("Mode de communication invalide.");
				} else {
					CommunicationAccess.setCom(mode, strategy);
				}
			}
			if (!strategy.isCorrect(adr)) {
				System.out.println(clientName + ", votre adresse (" + adr + ") n'est pas dans le bon format pour la modalité " + mode);
			} else {
				Subscriber subscriber = new Subscriber(clientName, mode, adr);
				abonnements.put(clientName, subscriber);
			}
		}
	}
	
	/**
	 * Method which withdraws membership from the alert service for the named 
	 * customer if he is a member, otherwise displays a message of error.
	 * @param clientName name of the client
	 */
	public void retirer(String clientName) {
		if (abonnements.containsKey(clientName)) {
			abonnements.remove(clientName);
		} else {
			System.out.println("Aucun client trouvé.");
		}
	}
	
	/**
	 * Method which sends the message passed as a parameter to all subscribers 
	 * according to the method they have chosen.
	 * @param message message sent to everyone
	 */
	public void alerter(String message) {
		if (message == null || message == "") {
            System.out.println("Message vide, alerte non envoyée.");
        } else {
			for (Subscriber abonne : abonnements.values()) {
				CommunicationAccess.getCom(abonne.getMode()).envoyer(abonne.getNom(), abonne.getAdresse(), message);
			}
        }
	}
	
	/**
	 * Method which returns in the form of an array of channels the list of subscribers 
	 * according to the format for each string: “NomDuClient  (modeChoisi)”
	 * @return The list of subscribers
	 */
	public String[] getListeInscrits() {
		String[] ret = new String[abonnements.size()];
		int i = 0;
		for (Subscriber abonne : abonnements.values()) {
			ret[i] = abonne.getNom() + " " + abonne.getAdresse() + " (" + abonne.getMode() + ")";
			i++;
		}
		return ret;
	}
}
