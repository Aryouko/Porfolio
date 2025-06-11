import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
/**
 * Class allow to modify and read file
 * @author L. CARRE
 * @version 1.0
 */
public class MyScanner {
	
	/**
	 * The bufferedReader
	 */
	private BufferedReader br;
	
	/**
	 * A boolean to know if the file is open or not
	 */
    private boolean isClosed;
    
    
    /**
	 * Constructor of the class
	 * @param source - a file to be scanned
	 * @throws FileNotFoundException - file not found
	 */
	public MyScanner (File source) throws FileNotFoundException {
		FileReader fr = new FileReader(source);
		this.br = new BufferedReader(fr);
		this.isClosed = false;
	}
	
	/**
	 * Closes this scanner
	 */
	public void close () {
		try {
            this.br.close();
            this.isClosed = true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
	}
	
	/**
	 * Method allow to return the rest of the current line, excluding any line separator at the end.
	 * The position is set to the beginning of the next line.
	 * @throws IllegalStateException - if the scanner is closed
	 * @throws NoSuchElementException - if no next line to read
	 * @return the line that was skipped
	 */
	public String nextLine() throws IllegalStateException, NoSuchElementException {
		if (isClosed) {
			throw new IllegalStateException("Scanner fermé");
		}
		String line = null;
		try{
            line = br.readLine();
            if (line == null) {
				throw new NoSuchElementException("Fin de fichier atteinte");
			}
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
        return line;
	}
	
	/**
	 * Method allow to know if there is another line in the input of this scanner
	 * @throws IllegalStateException - if the scanner is closed
	 * @return true if and only if this scanner has another line of input
	 */
	public boolean hasNextLine() throws IllegalStateException {
		if (isClosed) {
			throw new IllegalStateException("Scanner fermé");
		}
		boolean ret = true;
		int c;
		int limitCharacter = 100;
		try {
			br.mark(limitCharacter);
			c = br.read();
			br.reset();
			if (c == -1) {
				ret = false;
			}	
		}	
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return ret;
	}
}
