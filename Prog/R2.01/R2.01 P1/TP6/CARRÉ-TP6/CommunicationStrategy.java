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
	
	/**
	 * This method allows to find a syntax error in the address depending on the chosen mode
	 * @param adresse The communication methods to contact the client
	 * @return True or False if the address is correct or not
	 */
	public default boolean isCorrect(String adresse) {
		return true;
	}
}
