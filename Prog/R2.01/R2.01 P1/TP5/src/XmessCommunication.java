package notification;
/**
 * Concrete subclass of the abstract CommunicationStrategy interface. She redefines the
 * send method for “XMESS” mode.
 * @author L. Carré
 * @version 1.0
*/
class XmessCommunication implements CommunicationStrategy {
	
	/**
	 * This method allows to send a message with the social network account to a client
	 * @param clientName The name of the client
	 * @param adresse The social network account to contact the client
	 * @param message The message send to the client
	 */
	public void envoyer(String clientName, String adresse, String message) {
		System.out.println("[XMESS (" + adresse + ") -> " + clientName + "] " + message);
	}
}
