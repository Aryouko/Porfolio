/**
 * The <code>Student</code> class allows you to simulate the behavior of a student whose name,
 * a table of school subjects, a table of coefficients and the number of grades are stored in private variables.
 *
 * <p>This class offers the following operations:</p>
 * <ul>
 * <li>Construction of a student from a name, a table of school subjects, a table of coefficients and the number of grades.</li>
 * <li>Modification of the name via a setter.</li>
 * <li>Access to the name via a getter.</li>
 * <li>Access to the number of school subjects via a getter.</li>
 * <li>Access to a desired grade via a getter.</li>
 * <li>Make a class display</li>
 * <li>Make the average of a school subject</li>
 * <li>Make the overall average</li>
 * <li>Return the school subject where the best grade is</li>
 * </ul>
 *
 * @author L. CARRÉ
 * @version 1.0
 */
public class Etudiant {
    
    /**
     * Variable containing the name of the student
     */
    private String nom;
    
    /**
     * Table of table containing the different grades.
     */
    private double[][] bulletin;
    
    /**
     * Table containing the different school subjects.
     */
    private final String[] MATIERES;
    
    /**
     * Table containing the different doefficients for subjects.
     */
    private final double[] COEFFICIENTS;
    
    /**
     * Constructor that initializes the student with the provided variables.
     * 
     * @param nom Name of the school student
     * @param matieres Table of school subjects
     * @param coeff Table of coefficients for school subjects
     * @param nbNotes Number of grades per school subjects
     */
    public Etudiant(String nom, String[] matieres, double[] coeff, int nbNotes) {
		
		if ((nom == null) || (nom == "")) {
			System.out.println("Le nom n'a pas été renseigné.");
			this.nom = "Pas de nom";
		} else {
			this.nom = nom;
		}
		
		if ((matieres == null) 
				|| (matieres.length == 0)
				|| (coeff == null) 
				|| (coeff.length == 0)
				|| (coeff.length != matieres.length)) {
			System.out.println("Le tableau des matières ou des coefficients est vide ou non renseigné ou les tableaux ne sont pas de la même tailles");
			this.MATIERES = new String[0];
			this.COEFFICIENTS = new double[0];
		} else {
			this.MATIERES = matieres.clone();
			this.COEFFICIENTS = coeff.clone();
		}
		
		if (nbNotes == 0) {
			System.out.println("Le nombre de notes n'a pas été renseigné.");
			this.bulletin = new double[this.MATIERES.length][0];
		} else if (nbNotes < 0) {
			System.out.println("Le nombre de notes est négatif");
			this.bulletin = new double[this.MATIERES.length][0];
		} else {
			this.bulletin = new double[this.MATIERES.length][nbNotes];
		}		
		this.initialisation();
	}
	
	/**
     * Setter that changes the name of the student.
     * 
     * @param nom The new name of the student
     */
	public void setNom(String nom) {
		if ((nom == null) || (nom == "")) {
			System.out.println("Le nom n'a pas été renseigné.");
			this.nom = "Pas de nom";
		} else {
			this.nom = nom;
		}
	}
	
	/**
     * Getter which returns the name of the student.
     * 
     * @return The name of the student
     */
	public String getNom() {
		return this.nom;
	}
	
	/**
     * Getter which returns the number of grades.
     * 
     * @return The number of grades
     */
	public int getNbMatieres() {
		return this.MATIERES.length;
	}
	
	/**
     * Getter which returns a grade located at the specified index of a school subject and at the specified index of a grade.
     * 
     * @param iMatiere Index of the desired school subject
     * @param i Index of the desired grade
     * @return The desired grade
     */
	public double getUneNote(int iMatiere, int i) {
		double ret = -1;
		
		if ((iMatiere < 0) || (iMatiere >= this.bulletin.length)) {
			System.out.println("L'indice de la matière est incorrecte ou vide");
		} else if ((i < 0) || (i > this.bulletin[iMatiere].length)) {
			System.out.println("L'indice de la note est incorrecte ou vide");
		} else {
			ret = this.bulletin[iMatiere][i];
		}
		return ret;
	}
	
	/**
     * Initializes the report card with random grades.
     */
	private void initialisation() {
		for (int i = 0; i < this.bulletin.length; i++) {
			for (int j = 0; j < this.bulletin[i].length; j++) {
				this.bulletin[i][j] = (int) (21 * Math.random());
			}
		}
	}
	
	/**
     * Method which calculates the average of a school subject.
     * 
     * @param iMatiere Index of the desired school subject
     * @return The average of the desired school subject
     */
	public double moyenneMatiere(int iMatiere) {
		double somme = 0;
		double ret = -1;
		
		if ((iMatiere < 0) || (iMatiere >= this.MATIERES.length)) {
			System.out.println("L'indice de la matière est incorrecte ou vide");
		} else {		
			for (int i = 0; i < this.bulletin[iMatiere].length; i++) {
				somme += this.bulletin[iMatiere][i];
			}
			ret = somme / this.bulletin[iMatiere].length;
		}
		return ret;
	}
	
	/**
     * Method which calculates the overall average.
     * 
     * @return The average of the desired school subject
     */
	public double moyenneGenerale() {
		double sommeGenerale = 0;
		double sommeCoeff = 0;
		double ret = -1;
		
		if (this.bulletin.length > 0) {
			for (int i = 0; i < this.bulletin.length; i++) {
				sommeGenerale += this.moyenneMatiere(i) * this.COEFFICIENTS[i];
				sommeCoeff += this.COEFFICIENTS[i];
			}
			ret = (double) sommeGenerale / sommeCoeff;
		}
		return ret;
	}
		
	
	/**
     * Method which searches the school subject where the best grade is find.
     * 
     * @return The school subject
     */
	public String meilleureNote() {
		double maxNote = 0;
		int iMatiere = 0;
		String ret = null;
		
		if (this.bulletin.length > 0) {
			for (int i = 0; i < this.bulletin.length; i++) {
				for (int j = 0; j < this.bulletin[i].length; j++) {
					if (bulletin[i][j] > maxNote) {
						maxNote = bulletin[i][j];
						iMatiere = i;
					}
				}
			}
			ret = this.MATIERES[iMatiere];
		}
		return ret;
	}
	
	/**
     * Method which displays the student.
     * 
     * @return The character string
     */
	public String toString() {
		String ret = "\n";
		ret += "Nom de l'étudiant : " + this.getNom() + "\n";
		for (int i = 0; i < this.bulletin.length; i++) {
			ret += "Matière " + (i + 1) + " : " + this.MATIERES[i] + "\n";
			ret += "Notes : " + "\n";
			for (int j = 0; j < this.bulletin[i].length; j++) {
				ret += this.bulletin[i][j] + "\n";
			}
		}
		return ret;
	}
}
