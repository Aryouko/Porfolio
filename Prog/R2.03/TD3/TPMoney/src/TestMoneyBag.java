import org.junit.*; // accès aux classes JUnit4
import org.junit.runner.*; // permet l’exécution de la classe de test
import static org.junit.Assert.*; // accès aux assertions
/**
* Class allow to 
* @author L. CARRE
* @version 1.0
*/
public class TestMoneyBag {
	
	/**
	 * Method allow to test the constructor1 and the view
	 */
	@Test
	public void testConstructeur1ToString() {
		System.out.println();
		System.out.println("*** Constructeur1ToString ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		
		Money money = new Money(500, "EUR");
		System.out.println("Money attendu dans le sac: " + money);
		testCasConstructeur1ToString(money, false);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of the constructor1 and the view
	 * @param money - a money to add
	 * @param casErr - in case of error
	 */
	private static void testCasConstructeur1ToString(Money money, boolean casErr) {
		try {
			MoneyBag bag = new MoneyBag();
			bag.appendMoney(money);
			System.out.println(bag);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (Exception e) {
			if (casErr) {
				System.err.println("ECHEC du test : " + e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Method allow to test the constructor2 and the view
	 */
	@Test
	public void testConstructeur2ToString() {
		System.out.println();
		System.out.println("*** Constructeur2ToString ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		Money[] bag = new Money[3];
		Money money = new Money(500, "EUR");
		Money money2 = new Money(25, "USD");
		Money money3 = new Money(430, "EUR");
		bag[0] = money;
		bag[1] = money2;
		bag[2] = money3;
		System.out.println("Money attendu dans le sac: " + money + ", " + money2 + ", " + money3);
		testCasConstructeur2ToString(bag, false);
		System.out.println();
		
		System.out.println("** erreur **");
		System.out.println();
		
		System.out.println("Money attendu dans le sac: null");
		testCasConstructeur2ToString(null, true);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of the constructor2 and the view
	 * @param moneyBag - a bag of monies
	 * @param casErr - in case of error
	 */
	private static void testCasConstructeur2ToString(Money[] moneyBag, boolean casErr) {
		try {
			MoneyBag bag = new MoneyBag(moneyBag);
			System.out.println(bag);
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
	}
	
	/**
	 * Method allow to test the appendMoney method
	 */
	@Test
	public void testAppendMoney() {
		System.out.println();
		System.out.println("*** TestAppendMoney ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		Money[] bag = new Money[2];
		bag[0] = new Money(500, "EUR");
		bag[1] = new Money(25, "USD");
		Money money = new Money(430, "EUR");
		MoneyBag moneyBag = new MoneyBag(bag);
		System.out.print(moneyBag);
		System.out.println(" + " + money);
		System.out.println("appendMoney = (930 EUR, 25 USD) ?");
		Money[] bag2 = new Money[2];
		bag2[0] = new Money(930, "EUR");
		bag2[1] = new Money(25, "USD");
		MoneyBag ret = new MoneyBag(bag2);
		testCasAppendMoney(moneyBag, money, ret, false);
		System.out.println();		
		
		Money[] bag3 = new Money[2];
		bag3[0] = new Money(500, "EUR");
		bag3[1] = new Money(25, "USD");
		Money money2 = new Money(430, "DIN");
		MoneyBag moneyBag2 = new MoneyBag(bag3);
		System.out.print(moneyBag2);
		System.out.println(" + " + money2);
		System.out.println("appendMoney = (500 EUR, 25 USD, 430 DIN) ?");
		Money[] bag4 = new Money[3];
		bag4[0] = new Money(500, "EUR");
		bag4[1] = new Money(25, "USD");
		bag4[2] = new Money(430, "DIN");
		MoneyBag ret2 = new MoneyBag(bag4);
		testCasAppendMoney(moneyBag2, money2, ret2, false);
		System.out.println();	
		
		System.out.println("** Cas limite **");
		System.out.println();
		
		Money[] bag5 = new Money[1];
		bag5[0] = new Money(500, "EUR");
		Money money3 = new Money(-500, "EUR");
		MoneyBag moneyBag3 = new MoneyBag(bag5);
		System.out.print(moneyBag3);
		System.out.println(" + " + money3);
		System.out.println("appendMoney = () ?");
		MoneyBag ret3 = new MoneyBag();
		testCasAppendMoney(moneyBag3, money3, ret3, false);
		System.out.println();	
		
		System.out.println("** Cas erreur **");
		System.out.println();
		
		MoneyBag moneyBag4 = new MoneyBag(bag5);
		System.out.print(moneyBag4);
		System.out.println(" + null");
		System.out.println("appendMoney = " + moneyBag4 + " ?");
		MoneyBag ret4 = new MoneyBag(bag5);
		testCasAppendMoney(moneyBag4, null, ret4, true);
		System.out.println();	
	}
	
	/**
	 * Method allow to test a certain case of appendMoney method
	 * @param bag - bag to test
	 * @param money - money to add
	 * @param ret - the expected result
	 * @param casErr - in case of error
	 */
	private static void testCasAppendMoney(MoneyBag bag, Money money, MoneyBag ret, boolean casErr) {
		try {
			bag.appendMoney(money);
			System.out.println("Résultat " + bag);
			bag.theSame(ret);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (NotTheSameException e) {
			if (casErr) {
				System.err.println("ECHEC du test : " + e.getMessage());
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
	}
	
	/**
	 * Method allow to test the theSame method
	 */
	@Test
	public void testTheSame() {
		System.out.println();
		System.out.println("*** TestTheSame ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		Money[] bag = new Money[1];
		bag[0] = new Money(500, "EUR");
		MoneyBag moneyBag = new MoneyBag(bag);
		Money[] bag2 = new Money[1];
		bag2[0] = new Money(500, "EUR");
		MoneyBag moneyBag2 = new MoneyBag(bag2);
		System.out.println(moneyBag + " = " + moneyBag2 + " ? Oui");
		testCasTheSame(moneyBag, moneyBag2, false);
		System.out.println();
		
		System.out.println("** Cas erreur **");
		System.out.println();
		
		Money[] bag3 = new Money[1];
		bag3[0] = new Money(500, "EUR");
		MoneyBag moneyBag3 = new MoneyBag(bag3);
		Money[] bag4 = new Money[1];
		bag4[0] = new Money(400, "EUR");
		MoneyBag moneyBag4 = new MoneyBag(bag4);
		System.out.println(moneyBag3 + " = " + moneyBag4 + " ? Non");
		testCasTheSame(moneyBag3, moneyBag4, true);
		System.out.println();
		
		Money[] bag5 = new Money[1];
		bag5[0] = new Money(500, "EUR");
		MoneyBag moneyBag5 = new MoneyBag(bag5);
		Money[] bag6 = new Money[1];
		bag6[0] = new Money(500, "USD");
		MoneyBag moneyBag6 = new MoneyBag(bag6);
		System.out.println(moneyBag5 + " = " + moneyBag6 + " ? Non");
		testCasTheSame(moneyBag5, moneyBag6, true);
		System.out.println();
	}
	
	/**
	 * Method allow to test a certain case of theSame method
	 * @param bag1 - bag1 to test
	 * @param bag2 - bag2 to test
	 * @param casErr - in case of error
	 */
	private static void testCasTheSame(MoneyBag bag1, MoneyBag bag2, boolean casErr) {
		try {
			bag1.theSame(bag2);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
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
		
		Money[] bag = new Money[2];
		bag[0] = new Money(500, "EUR");
		bag[1] = new Money(25, "USD");
		Money moneyAdd = new Money(500, "EUR");
		MoneyBag moneyBagAdd = new MoneyBag(bag);
		Money[] bag2 = new Money[2];
		bag2[0] = new Money(1000, "EUR");
		bag2[1] = new Money(25, "USD");
		MoneyBag ret = new MoneyBag(bag2);
		System.out.println(moneyBagAdd + " + " + moneyAdd + " = " + ret + " ?");
		testCasAdd(moneyBagAdd, moneyAdd, ret, false);
		System.out.println();
		
		System.out.println("** Cas erreur **");
		System.out.println();
		
		MoneyBag moneyBagAdd2 = new MoneyBag(bag);
		MoneyBag ret2 = new MoneyBag(bag);
		System.out.println(moneyBagAdd2 + " + null = " + ret2 + " ?");
		testCasAdd(moneyBagAdd2, null, ret2, true);
		System.out.println();	
	}
	
	/**
	 * Method allow to test a certain case of add method
	 * @param myMoneyBag - moneyBag to test
	 * @param myMoney - money to add
	 * @param ret - the expected result
	 * @param casErr - in case of error
	 */
	private static void testCasAdd(MoneyBag myMoneyBag, Money myMoney, MoneyBag ret, boolean casErr) {
		try {
			MoneyBag res = (MoneyBag) myMoneyBag.add(myMoney);
			res.theSame(ret);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
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
		catch (RuntimeException e) {
			if (casErr) {
				System.err.println("ECHEC du test : " + e.getMessage());
				System.out.println("Test réussi");
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
		JUnitCore.main("TestMoneyBag");
	}
}
