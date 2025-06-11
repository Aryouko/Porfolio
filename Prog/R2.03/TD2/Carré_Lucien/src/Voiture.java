/**
 * Class allow create a car
 * @author L. CARRE
 * @version 1.0
 */
public class Voiture {
	
	/**
	 * The brand of the car
	 */
	private String marque;
	/**
	 * The modele of the car
	 */
	private String modele;
	/**
	 * The power of the car
	 */
	private int puissance;
	
	/**
	 * Constructor of the class
	 * @param marque - the brand of the car
	 * @param modele - the modele of the car
	 * @param puissance - the power of the car
	 */
	public Voiture (String marque, String modele, int puissance) {
		this.marque = marque;
		this.modele = modele;
		this.puissance = puissance;
	}
	
	/**
	 * Method allow to show properly
	 */
	public String toString() {
		return this.marque + " " + this.modele + ", " + this.puissance + " chevaux";
	}
}
