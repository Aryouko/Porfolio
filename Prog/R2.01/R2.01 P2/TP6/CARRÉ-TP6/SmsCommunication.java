package notification;
/**
 * Concrete subclass of the abstract CommunicationStrategy interface. She redefines the
 * send method for “SMS” mode.
 * @author L. Carré
 * @version 1.0
*/
class SmsCommunication implements CommunicationStrategy {
	
	/**
	 * This method allows to send a message with the phone number to a client
	 * @param clientName The name of the client
	 * @param adresse The phone number to contact the client
	 * @param message The message send to the client
	 */
	public void envoyer(String clientName, String adresse, String message) {
		System.out.println("[SMS (" + adresse + ") -> " + clientName + "] " + message);
	}
	
	/**
	 * This method allows to find a syntax error in the address depending on the mode 'SMS'
	 * @param adresse The communication methods to contact the client
	 * @return True or False if the address is correct or not
	 */
	public boolean isCorrect(String adresse) {
		return adresse != null && adresse.matches("^(06|07)\\d{8}$");
	}
}
