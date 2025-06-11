package notification;
/**
 * Abstract interface describing the public interface of all
 * communication methods.
 * @author L. Carré
 * @version 1.0
*/
abstract interface CommunicationStrategy {
	
	/**
	 * This method allows to send a message to a client
	 * @param clientName The name of the client
	 * @param adresse The communication methods to contact the client
	 * @param message The message send to the client
	 */
	public abstract void envoyer(String clientName, String adresse, String message);
}
