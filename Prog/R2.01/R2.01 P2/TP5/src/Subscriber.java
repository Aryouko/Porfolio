package notification;
/**
 * This class stores information about a service subscriber via 4 attributes.
 * @author L. Carré
 * @version 1.0
*/
class Subscriber {
	
	/**
     * Private variable containing the name of the subscriber
     */
	private String nom;
	
	/**
     * Private variable containing the mode chosen by the subscriber
     */
	private String mode;
	
	/**
     * Private variable containing the address of the subscriber
     */
	private String adresse;
	
	/**
     * Private variable containing the communication strategy of the subscriber
     */
	private CommunicationStrategy strategy;
	
	/**
	 * Constructor of the class, initializes a subscriber with his name, 
	 * the mode of communication he has chosen for membership, the address 
	 * to contact him in the chosen modality and the subject of the correct 
	 * modality who will be responsible for sending alerts to him.
	 * @param nom name of the subscriber
	 * @param mode communication mode chosen by the subscriber
	 * @param adr address of the subscriber
	 * @param strategy communication strategy of the subscriber
	 */
	public Subscriber(String nom, String mode, String adr, CommunicationStrategy strategy) {
		if (nom == "" || nom == null) {
			System.out.println("Le nom n'a pas été renseigné. Valeur par défaut initialisé.");
			this.nom = "PasDeNom";
		} else {
			this.nom = nom;
		}
		
		if (mode == "" || mode == null) {
			System.out.println("Le mode n'a pas été renseigné. Valeur par défaut initialisé.");
			this.mode = "PasDeMode";
		} else {
			this.mode = mode;
		}
		
		if (adr == "" || adr == null) {
			System.out.println("L'adresse n'a pas été renseignée. Valeur par défaut initialisé.");
			this.adresse = "PasDAdresse";
		} else {
			this.adresse = adr;
		}
		
		if (strategy == null) {
			System.out.println("La stratégie de communication n'a pas été renseigné. Valeur par défaut initialisé.");
			this.strategy = null;
		} else {
			this.strategy = strategy;
		}
	}
	
	/**
	 * This method allows to get the name of the subscriber
	 * @return The name of the subscriber
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * This method allows to get the mode chosen by the subscriber
	 * @return The mode chosen by the subscriber
	 */
	public String getMode() {
		return this.mode;
	}
	
	/**
	 * This method allows to get the address of the subscriber
	 * @return The address of the subscriber
	 */
	public String getAdresse() {
		return this.adresse;
	}
	
	/**
	 * This method allows to get the strategy
	 * @return The communication strategy of the subscriber
	 */
	public CommunicationStrategy getStrategy() {
		return this.strategy;
	}
}
