package notification;
/**
 * This class is responsible for instantiating the correct version of the object in charge of a transmission
 * according to a certain modality.
 * @author L. Carré
 * @version 1.0
*/
class CommunicationFactory {
	
	
	/**
	 * Constructor without private parameter doing nothing
	 * to ensure avoiding instantiation.
	 */
	private CommunicationFactory() {}
	
	/**
	 * decides to creating the correct instance of one of the subclasses of 
	 * the Communication Strategy class to instanced and to be returned 
	 * depending on the modality received.
	 * @param mode The communication method
	 * @return An instance of the CommunicationStrategy depending on the mode
	 */
	public static CommunicationStrategy create(String mode) {
		if (mode == "SMS") {
			return new SmsCommunication();
		} else if (mode == "MAIL") {
			return new MailCommunication();
		} else {
			System.out.println("Le mode donné est invalide.");
			return null;
		}
	}
}
