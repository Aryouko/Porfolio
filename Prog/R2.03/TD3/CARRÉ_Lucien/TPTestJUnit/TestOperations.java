import org.junit.*; // accès aux classes JUnit4
import org.junit.runner.*; // permet l’exécution de la classe de test
import static org.junit.Assert.*; // accès aux assertions
import java.lang.Math;
/**
* Class allow to test Operations class
* @author L. CARRE
* @version 1.0
*/
public class TestOperations {
	
	/**
	 * Instance of Operations
	 */
	private Operations op;
	
	/**
	 * Method allow to instance
	 */
	@Before
	public void instancier() {
		this.op = new Operations();
	}
	
	/**
	 * Method allow to test the Additionne method
	 */
	@Test
	public void testAdditionne() {
		System.out.println();
		System.out.println("*** TestAdditionne ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		int p = 1;
		int s = 2;
		int ret = 3;
		System.out.println(p + " + " + s + " = " + ret + " ?");
		testCasAdditionne(p, s, ret, false);
		System.out.println();
		
		System.out.println("** Cas erreur **");
		System.out.println();
		
		
		int ret2 = 4;
		System.out.println(p + " + " + s + " = " + ret2 + " ?");
		testCasAdditionne(p, s, ret2, true);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of Additionne method
	 * @param premier - the first value
	 * @param second - the second value
	 * @param ret - the expected result
	 * @param casErr - in case of error
	 */
	private static void testCasAdditionne(int premier, int second, int ret, boolean casErr) {
		try {
			int res = this.op.additionne(premier, second);
			assertEquals("Somme incorrecte", ret, res);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (AssertionError e) {
			if (casErr) {
				System.err.println("ECHEC du test : " + e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Method allow to test the Additionne method
	 */
	@Test
	public void testCalculeRacineCarree() {
		System.out.println();
		System.out.println("*** TestCalculeRacineCarree ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		double v = 4;
		double ret = 2;
		double delta = 0;
		System.out.println("Racine de " + v + " = " + ret + " ?");
		testCasCalculeRacineCarree(v, ret, delta, false);
		System.out.println();
		
		System.out.println("** Cas limite **");
		System.out.println();
		
		double v2 = 0;
		double ret2 = 0;
		System.out.println("Racine de " + v2 + " = " + ret2 + " ?");
		testCasCalculeRacineCarree(v2, ret2, delta, false);
		System.out.println();
		
		
		System.out.println("** Cas erreur **");
		System.out.println();
		
		double ret3 = 1;
		System.out.println("Racine de " + v + " = " + ret3 + " ?");
		testCasCalculeRacineCarree(v, ret3, delta, true);
		System.out.println();
		
		double v4 = -1;
		double ret4 = Double.NaN;
		System.out.println("Racine de " + v4 + " = " + ret4 + " ?");
		testCasCalculeRacineCarree(v4, ret4, delta, true);
		System.out.println();
		
	}
	
	/**
	 * Method allow to test a certain case of Additionne method
	 * @param val - the value will calculate
	 * @param ret - the expected result
	 * @param delta - the reach around the result
	 * @param casErr - in case of error
	 */
	private static void testCasCalculeRacineCarree(double val, double ret, double delta, boolean casErr) {
		try {
			double res = this.op.calculeRacineCarree(val);
			assertEquals ("Racine carrée incorrecte", ret, res, delta);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (ArithmeticException e) {
			if (casErr) {
				System.err.println("ECHEC du test : " + e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (AssertionError e) {
			if (casErr) {
				System.out.println("Test réussi");
				System.err.println("ECHEC du test : " + e.getMessage());
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Entry of the program
	 * @param args - useless here
	 */
	public static void main ( String args[]) {
		JUnitCore.main("TestOperations");
	}
}
