/**
 * Class allow test methods of Voiture class
 * @author L. CARRE
 * @version 1.0
 */
public class TestVoiture {
	
	/**
	 * Entry of the program
	 * @param args - useless here
	 */
	public static void main ( String[] args ) {
		testConstructeuEtToString();
	}
	
	/**
	 *  Method to test Voiture class
	 */
	public static void testConstructeuEtToString() {
		System.out.println();
		System.out.println("*** TestConstructeuEtToString ***");
		testCasConstructeuEtToString("Renault", "Megane 3 Bose", 130);
		testCasConstructeuEtToString("Renault", "Clio 4", 110);
	}
	
	/**
	 * Method to test certain cases in Voiture class
	 * @param marque - the brand of the car
	 * @param modele - the modele of the car
	 * @param puissance - the power of the car
	 */
	private static void testCasConstructeuEtToString(String marque, String modele, int puissance) {
		Voiture maVoiture = new Voiture(marque, modele, puissance);
		System.out.println(maVoiture); //test visuel
	}
}
