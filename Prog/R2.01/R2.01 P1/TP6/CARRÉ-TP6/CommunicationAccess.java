package notification;
import java.util.HashMap;
import java.util.Map;
/**
 * This class allows to guarantee the uniqueness of the communication instances but also
 * to impose a single access path to them.
 * @author L. Carré
 * @version 1.0
 */
class CommunicationAccess {
	
	
	/**
     * Stores different communications in the form (mode, strategy communication)
     */
	private static Map<String, CommunicationStrategy> medias = new HashMap<>();
	
	/**
	 * Constructor without private parameter doing nothing
	 * to ensure avoiding instantiation.
	 */
	private CommunicationAccess() {}
	
	/**
	 * Allows the Server to store in the Map, the object responsible 
	 * for communication for the desired modality.
	 * @param mode The communication method
	 * @param comObj The strategy communication
	 */
	public static void setCom(String mode, CommunicationStrategy comObj ) {
		medias.put(mode, comObj);
	}
	
	/**
	 * This method returns the instance that allows access according to the method 
	 * passed as a parameter. This instance is the one contained in the Map.
	 * @param mode The communication method
	 * @return Strategy communication or null if strategy communication not exists for the mode
	 */
	public static CommunicationStrategy getCom(String mode) {
		if (medias.containsKey(mode)) {
			return medias.get(mode);
		} else {
			return null;
		}
	}
}
