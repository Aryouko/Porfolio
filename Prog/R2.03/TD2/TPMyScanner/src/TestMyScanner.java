import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
/**
 * Class allow test methods of MyScanner class
 * @author L. CARRE
 * @version 1.0
 */
public class TestMyScanner {
	
	/**
	 * Entry of the program
	 * @param args - useless here
	 */
	public static void main ( String[] args ) {
		testConstructeur();
        testClose();
        testHasNextLine();
        testNextLine();
	}
	
	/**
	 * Method to test the constructor of MyScanner class
	 */
	public static void testConstructeur() {
		System.out.println();
		System.out.println("*** TestConstructeur ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		File f = new File("../test.txt");
		testCasConstructeur(f, false);
		System.out.println();
		
		System.out.println("** Cas d'erreur **");
		System.out.println();
		
		System.out.println("* Cas de fichier introuvable *");
		File f2 = new File("../autre.txt");
		testCasConstructeur(f2, true);
		System.out.println();
	}
	
	/**
	 * Method to test certain cases of the constructor of MyScanner class
	 * @param source - a file to be scanned
	 * @param casErr - in case of error
	 */
	public static void testCasConstructeur(File source, boolean casErr) {
		try {
			MyScanner myScan = new MyScanner(source);
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (FileNotFoundException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Method to test the close method in MyScanner class
	 */
	public static void testClose() {
		System.out.println();
		System.out.println("*** TestClose ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		System.out.println("* Cas avec scanner ouvert *");
		testCasClose(false, false);
		System.out.println();
		
		System.out.println("* Cas avec scanner fermé *");
		testCasClose(true, false);
		System.out.println();
	}
	
	/**
	 * Method to test certain cases of the close method in MyScanner class
	 * @param fermer - if you would the scan is close
	 * @param casErr - in case of error
	 */
	public static void testCasClose(boolean fermer, boolean casErr) {
		try {
			File f = new File("../test.txt");
			MyScanner myScan = new MyScanner(f);
			if (fermer) {
				myScan.close();
			}
			myScan.close();
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (FileNotFoundException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Method to test the hasNextLine method in MyScanner class
	 */
	public static void testHasNextLine() {
		System.out.println();
		System.out.println("*** TestHasNextLine ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		System.out.println("* Cas avec scanner ouvert *");
		testCasHasNextLine(false, false);
		System.out.println();
		
		System.out.println("** Cas d'erreur **");
		System.out.println();
		
		System.out.println("* Cas avec scanner fermé *");
		testCasHasNextLine(true, true);
		System.out.println();
	}
	
	/**
	 * Method to test certain cases of the hasNextLine method in MyScanner class
	 * @param fermer - if you would the scan is close
	 * @param casErr - in case of error
	 */
	public static void testCasHasNextLine(boolean fermer, boolean casErr) {
		try {
			File f = new File("../test.txt");
			MyScanner myScan = new MyScanner(f);
			if (fermer) {
				myScan.close();
			}
			myScan.hasNextLine();
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (FileNotFoundException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (IllegalStateException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
	}
	
	/**
	 * Method to test the nextLine method in MyScanner class
	 */
	public static void testNextLine() {
		System.out.println();
		System.out.println("*** TestNextLine ***");
		System.out.println();
		
		System.out.println("** Cas normal **");
		System.out.println();
		
		System.out.println("* Cas avec scanner ouvert *");
		File f = new File("../test.txt");
		testCasNextLine(f, false, false);
		System.out.println();
		
		System.out.println("** d'erreur **");
		System.out.println();
		
		System.out.println("* Cas avec scanner fermé *");
		testCasNextLine(f, true, true);
		System.out.println();
		
		System.out.println("* Cas avec la fin du fichier atteinte *");
		File f2 = new File("../test2.txt");
		testCasNextLine(f2, false, true);
		System.out.println();
		
	}
	
	/**
	 * Method to test certain cases of the nextLine method in MyScanner class
	 * @param source - a file to be scanned
	 * @param fermer - if you would the scan is close
	 * @param casErr - in case of error
	 */
	public static void testCasNextLine(File source, boolean fermer, boolean casErr) {
		try {
			MyScanner myScan = new MyScanner(source);
			if (fermer) {
				myScan.close();
			}
			System.out.println(myScan.nextLine());
			if (!casErr) {
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (FileNotFoundException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (IllegalStateException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}
		catch (NoSuchElementException e) {
			if (casErr) {
				System.err.println(e.getMessage());
				System.out.println("Test réussi");
			} else {
				System.out.println("Test échoué");
			}
		}	
	}	
}
