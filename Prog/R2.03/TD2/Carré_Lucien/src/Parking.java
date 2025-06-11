/**
 * Class allow create a parking
 * @author L. CARRE
 * @version 1.0
 */
public class Parking {
	
	/**
	 * Number of places in the parking
	 */
	private final int NB_PLACES = 20;
	/**
	 * The table references on a table of Voiture
	 */
	private Voiture[] lesPlaces;
	
	/**
	 * Constructor of the class
	 */
	public Parking () {
		this.lesPlaces = new Voiture[NB_PLACES];
	}
	
	/**
	 * Method allow to show properly
	 * @return the show String 
	 */
	public String toString() {
		String ret = "";
		for (int i = 0; i < NB_PLACES - 1; i++) {
			if (lesPlaces[i] == null) {
				ret += (i + 1) + " : place libre - ";
			} else {
				ret += (i + 1) + " : " + lesPlaces[i] + " - ";
			}
		}
		if (lesPlaces[NB_PLACES - 1] == null) {
			ret += NB_PLACES + " : place libre";
		} else {
			ret += NB_PLACES + " : " + lesPlaces[NB_PLACES - 1];
		}
		return ret;
	}
	
	/**
	 * Method allow to watch if a place is valid
	 * @param numPlace - the numero of the place tested
	 * @throws ArrayIndexOutOfBoundsException - out of bounds error
	 */
	private void numeroValide (int numPlace) throws ArrayIndexOutOfBoundsException {
		if (numPlace < 1 || numPlace > NB_PLACES) {
			throw new ArrayIndexOutOfBoundsException ("Numéro de place non valide");
		}
	}
	
	/**
	 * Method allow to set a car in a place if the place is valid
	 * @param voit - the car to place
	 * @param numPlace - the numero of the place
	 * @throws RuntimeException - runtime error
	 */
	public void garer (Voiture voit, int numPlace) throws RuntimeException {
		this.numeroValide(numPlace);
		if (lesPlaces[numPlace - 1] != null) {
			throw new RuntimeException ("Place déjà occupée");
		} else {
			lesPlaces[numPlace - 1] = voit;
		}
	}
	
	/**
	 * Method allow to remove a car in a place if the place is valid and if a car is in the place
	 * @param numPlace - the numero of the place
	 * @throws RuntimeException - runtime error
	 * @return the car on the place
	 */
	public Voiture sortir (int numPlace) throws RuntimeException {
		Voiture voit = null;
		this.numeroValide(numPlace);
		if (lesPlaces[numPlace - 1] == null) {
			throw new RuntimeException ("Pas de voiture à cette place");
		} else {
			voit = lesPlaces[numPlace];
			lesPlaces[numPlace - 1] = null;
		}
		return voit;
	}
}
