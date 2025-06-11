import org.junit.*; // accès aux classes JUnit4
import org.junit.runner.*; // permet l’exécution de la classe de test
import static org.junit.Assert.*; // accès aux assertions
/**
* Class allow to 
* @author L. CARRE
* @version 1.0
*/
public class TestMoney {
	
	/**
	 * Method allow to test the constructor and the view
	 */
	@Test
	public void testConstructeurToString() {
		System.out.println();
		System.out.println("*** ConstructeurToString ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		int a = 500;
		String c = "EUR";
		System.out.println("Money attendu : " + a + c);
		testCasConstructeurToString(a, c, false);
		System.out.println();
		
		System.out.println("** Cas erreur **");
		System.out.println();
		
		String c2 = "";
		System.out.println("Money attendu : " + a + c2);
		testCasConstructeurToString(a, c2, true);
		System.out.println();
		
		int a2 = 0;
		System.out.println("Money attendu : " + a2 + c);
		testCasConstructeurToString(a2, c, true);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of the constructor and the view
	 * @param theAmnt - the amount of money
	 * @param theCurr - the currency of the money
	 * @param casErr - in case of error
	 */
	private static void testCasConstructeurToString(int theAmnt, String theCurr, boolean casErr) {
		try {
			Money money = new Money(theAmnt, theCurr);
			System.out.println(money);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (RuntimeException e) {
			if (casErr) {
				System.err.println("ECHEC du test : " + e.getMessage());
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
	 * Method allow to test the getAmount method
	 */
	@Test
	public void testGetAmount() {
		System.out.println();
		System.out.println("*** TestGetAmount ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		int a = 500;
		Money money = new Money(a, "EUR");
		System.out.println(money);
		System.out.println("getAmount = " + a + " ?");
		testCasGetAmount(money, a, false);
		System.out.println();		
	}
	
	/**
	 * Method allow to test a certain case of getAmount method
	 * @param myMoney - money to test
	 * @param ret - the expected result
	 * @param casErr - in case of error
	 */
	private static void testCasGetAmount(Money myMoney, int ret, boolean casErr) {
		try {
			int res = myMoney.getAmount();
			assertEquals ("Récupération de la valeur échoué", ret, res, 0);
			if (!casErr) {
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
	 * Method allow to test the getCurrency method
	 */
	@Test
	public void testGetCurrency() {
		System.out.println();
		System.out.println("*** TestGetCurrency ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		String c = "EUR";
		Money money = new Money(500, c);
		System.out.println(money);
		System.out.println("getCurrency = " + c + " ?");
		testCasGetCurrency(money, c, false);
		System.out.println();		
	}
	
	/**
	 * Method allow to test a certain case of getCurrency method
	 * @param myMoney - money to test
	 * @param ret - the expected result
	 * @param casErr - in case of error
	 */
	private static void testCasGetCurrency(Money myMoney, String ret, boolean casErr) {
		try {
			String res = myMoney.getCurrency();
			assertEquals ("Récupération de la valeur échoué", ret, res);
			if (!casErr) {
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
	 * Method allow to test the add method
	 */
	@Test
	public void testAdd() {
		System.out.println();
		System.out.println("*** TestAdd ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		Money money = new Money(500, "EUR");
		Money money2 = new Money(500, "EUR");
		Money ret = new Money(1000, "EUR");
		System.out.println(money + " + " + money2 + " = " + ret + " ?");
		testCasAdd(money, money2, ret, false, false);
		System.out.println();
		
		Money money3 = new Money(500, "USD");
		Money[] bag = new Money[2];
		bag[0] = new Money(500, "EUR");
		bag[1] = new Money(500, "USD");
		MoneyBag ret2 = new MoneyBag(bag);
		System.out.println(money + " + " + money + " = " + ret2 + " ?");
		testCasAdd(money, money3, ret2, true, false);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of add method
	 * @param myMoney - money1 to test
	 * @param myMoney2 - money2 to test
	 * @param ret - the expected result
	 * @param isBag - if the result if a bag
	 * @param casErr - in case of error
	 */
	private static void testCasAdd(Money myMoney, Money myMoney2, IMoney ret, boolean isBag, boolean casErr) {
		try {
			if (isBag) {
				MoneyBag res = (MoneyBag) myMoney.add(myMoney2);
				res.theSame((MoneyBag) ret);
				if (!casErr) {
					System.out.println("Test réussi");
				} else {
					System.out.println("Test échoué");
				}
			} else {
				Money res = (Money) myMoney.add(myMoney2);
				if (res.equals((Money) ret) && !casErr) {
					System.out.println("Test réussi");
				} else {
					System.out.println("Test échoué");
				}
			}
		}
		catch (NotTheSameException e) {
			if (casErr) {
				System.out.println("Test réussi");
				System.err.println("ECHEC du test : " + e.getMessage());
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
		catch (RuntimeException e) {
			if (casErr) {
				System.out.println("Test réussi");
				System.err.println("ECHEC du test : " + e.getMessage());
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Method allow to test the equals method
	 */
	@Test
	public void testEquals() {
		System.out.println();
		System.out.println("*** TestEquals ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		Money money = new Money(500, "EUR");
		Money money2 = new Money(500, "EUR");
		boolean ret = true;
		System.out.println(money + " = " + money2 + " ? " + ret);
		testCasEquals(money, money2, ret, false);
		System.out.println();
		
		Money money3 = new Money(500, "USD");
		boolean ret2 = false;
		System.out.println(money + " = " + money3 + " ? " + ret2);
		testCasEquals(money, money3, ret2, false);
		System.out.println();
		
		Money money4 = new Money(501, "EUR");
		System.out.println(money + " = " + money4 + " ? " + ret2);
		testCasEquals(money, money4, ret2, false);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of add method
	 * @param myMoney - money1 to test
	 * @param myMoney2 - money2 to test
	 * @param ret - the expected result
	 * @param casErr - in case of error
	 */
	private static void testCasEquals(Money myMoney, Money myMoney2, boolean ret, boolean casErr) {
		try {
			boolean res = myMoney.equals(myMoney2);
			if ((res == ret) && !casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (Exception e) {
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
	public static void main(String args[]) {
		JUnitCore.main("TestMoney");
	}
}
