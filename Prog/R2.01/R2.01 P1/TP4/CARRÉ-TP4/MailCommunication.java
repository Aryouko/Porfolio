package notification;
/**
 * Concrete subclass of the abstract CommunicationStrategy class. She redefines the
 * send method for “MAIL” mode.
 * @author L. Carré
 * @version 1.0
*/
class MailCommunication extends CommunicationStrategy {
	
	/**
	 * This method allows to send a message with the email address to a client
	 * @param clientName The name of the client
	 * @param adresse The email address to contact the client
	 * @param message The message send to the client
	 */
	public void envoyer(String clientName, String adresse, String message) {
		System.out.println("[MAIL (" + adresse + ") -> " + clientName + "] " + message);
	}
}
