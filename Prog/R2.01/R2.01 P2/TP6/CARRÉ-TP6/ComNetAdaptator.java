package notification;
import utilitaire.ComNet;
/**
 * Concrete subclass of the abstract CommunicationStrategy interface. She redefines the
 * send method for “CHAT” mode.
 * @author L. Carré
 * @version 1.0
*/
class ComNetAdaptator implements CommunicationStrategy {
	
	/**
     * Private variable containing the comNet
     */
	private ComNet comNet;
    
    /**
	 * Constructor doing instance comNet.
	 */
    public ComNetAdaptator() {
        this.comNet = new ComNet();
    }
    
	/**
	 * This method allows to send a message with the address to a client
	 * @param clientName The name of the client
	 * @param adresse The address to contact the client
	 * @param message The message send to the client
	 */
	public void envoyer(String clientName, String adresse, String message) {
		comNet.send(adresse, message);
		System.out.println("[CHAT (" + adresse + ") -> " + clientName + "] " + message);
	}
}
