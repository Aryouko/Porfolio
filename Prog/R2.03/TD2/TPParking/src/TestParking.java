/**
 * Class allow test methods of Voiture class
 * @author L. CARRE
 * @version 1.0
 */
public class TestParking {
	
	/**
	 * Entry of the program
	 * @param args - useless here
	 */
	public static void main ( String[] args ) {
		testGarer();
		testSortir();
	}
	
	/**
	 *  Method to test "garer" method in Parking class
	 */
	public static void testGarer() {
		Parking park = new Parking();
		Parking park2 = new Parking();
		
		System.out.println();
		System.out.println("*** TestGarer ***");
		System.out.println();
		
		System.out.println(park);
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		Voiture voit1 = new Voiture("Renault", "Megane 3 Bose", 130);
		testCasGarer(park, voit1, 1, false);
		System.out.println();
		
		System.out.println("** Cas d'erreur **");
		System.out.println();
		
		System.out.println("* Cas de place invalide *");
		testCasGarer(park, voit1, 56, true);
		System.out.println();
		
		System.out.println("* Cas de place occupée *");
		Voiture voit2 = new Voiture("Renault", "Clio 4", 110);
		park2.garer(voit2, 1);
		testCasGarer(park2, voit1, 1, true);
		System.out.println();
	}
	
	/**
	 * Method to test certain cases in "garer" method in Parking class
	 * @param park - the car park
	 * @param voit - the car to place
	 * @param numPlace - the numero of the place
	 * @param casErr - in case of error
	 */
	private static void testCasGarer(Parking park, Voiture voit, int numPlace, boolean casErr) {
		try {
			park.garer(voit, numPlace);
			System.out.println(park); //test visuel
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (RuntimeException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 *  Method to test "sortir" method in Parking class
	 */
	public static void testSortir() {
		Parking park = new Parking();
		Voiture voit1 = new Voiture("Renault", "Megane 3 Bose", 130);
		park.garer(voit1, 1);
		
		System.out.println();
		System.out.println("*** TestSortir ***");
		System.out.println();
		
		System.out.println(park);
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		testCasGarer(park, 1, false);
		System.out.println();
		
		System.out.println("** Cas d'erreur **");
		System.out.println();
		
		System.out.println("* Cas de place invalide *");
		testCasGarer(park, 56, true);
		System.out.println();
		
		System.out.println("* Cas de place occupée *");
		testCasGarer(park, 1, true);
		System.out.println();
	}
	
	/**
	 * Method to test certain cases in "sortir" method in Parking class
	 * @param park - the car park
	 * @param numPlace - the numero of the place
	 * @param casErr - in case of error
	 */
	private static void testCasGarer(Parking park, int numPlace, boolean casErr) {
		try {
			park.sortir(numPlace);
			System.out.println(park); //test visuel
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (RuntimeException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
}
