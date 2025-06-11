/**
 * The <code>Polynomial</code> class allows you to simulate the behavior of a polynomial
 * of the form a<sub>0</sub> + a<sub>1</sub> x + a<sub>2</sub> x<sup>2</sup> + ... + a<sub>n</sub> x<sup>n</sup>,
 * whose coefficients are stored in an array.
 *
 * <p>
 * For example, for the table of coefficients [2.0, 3.0, 5.0], the polynomial
 * corresponding is: 2 + 3x + 5x².
 * </p>
 *
 * <p>This class offers the following operations:</p>
 * <ul>
 * <li>Construction of a polynomial from a table of coefficients.</li>
 * <li>Access and modification of coefficients via a getter and a setter.</li>
 * <li>Calculation of the sum of two polynomials (<code>add</code> method).</li>
 * <li>Comparing polynomials (<code>isIdentical</code> method).</li>
 * <li>Evaluation of the polynomial for a given value of x (<code>evaluate</code> method).</li>
 * <li>Recovery of the degree of the polynomial (<code>getDegree</code> method).</li>
 * </ul>
 *
 * @author R. Fleurquin
 * @version 1.0
 */
public class Polynome {

    /**
     * Table containing the coefficients of the polynomial.
     * The index i corresponds to the coefficient of the term x^i.
     */
    private double[] coefficients;

    /**
     * Constructor that initializes the polynomial with the provided coefficient table.
     * The coefficients are assumed to be ordered in increasing order with respect to the power of x.
     * For example, <code>coefficients[0]</code> is the coefficient of the constant term (x^0),
     * <code>coefficients[1]</code> that of the term x^1, etc.
     *
     * @param coeffs Table of polynomial coefficients (not modified by the class).
     */
    public Polynome(double[] coeffs) { //constructeur		
		if (coeffs == null) {
			System.err.println("Coefficient null : polynome initialisé à 0");
			this.coefficients = new double[1];
		} else {
			this.coefficients = coeffs.clone();
		}
    }

    /**
     * Getter which returns the coefficient located at the specified index.
     * The index corresponds to the power of x.
     *
     * @param index The array index, corresponding to the power of x.
     * @return The coefficient associated with x^index.
     */
    public double getCoefficient(int index) { //getter
    	double ret=-1;
        if (index < 0 || index >= coefficients.length) {
            System.out.println("L'indice " + index + " est hors limites.");
        }
        else{
        	ret=coefficients[index];
        }
        return ret;
    }

    /**
     * Setter that changes the coefficient to the specified index.
     * The index corresponds to the power of x.
     *
     * @param index The index in the array, corresponding to the power of x.
     * @param coefficient The new coefficient value for x^index.
     */
    public void setCoefficient(int index, double coefficient) { //setter
        if (index < 0 || index >= coefficients.length) {
            System.out.println("L'indice " + index + " est hors limites.");
        }
        else{
        	this.coefficients[index] = coefficient;
        }
    }

    /**
     * Method which calculates the sum of this polynomial with another polynomial.
     * The sum is defined by adding the coefficients of the same degree (same power of x).
     *
     * @param other The polynomial to add to this polynomial.
     * @return A new polynomial that represents the sum of the two polynomials.
     */
    public Polynome add(Polynome other) { //autres
		double[] newCoefficients;
		
		if (other == null) {
			System.err.println("Polynome entré null : polynome renvoyé égale au polynome de départ");
			newCoefficients = this.coefficients.clone();
		} else {
			int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
			newCoefficients = new double[maxLength];

			for (int i = 0; i < maxLength; i++) {
				double c1 = (i < this.coefficients.length) ? this.coefficients[i] : 0.0;
				double c2 = (i < other.coefficients.length) ? other.coefficients[i] : 0.0;
				newCoefficients[i] = c1 + c2;
			}
		}

        return new Polynome(newCoefficients);
    }

    /**
     * Method that checks if two polynomials are identical.
     * Two polynomials are considered identical if they have the same number of coefficients
     * and that their respective coefficients are equal.
     *
     * @param other The polynomial to compare.
     * @return <code>true</code> if the polynomials have the same array length and the same coefficients,
     * <code>false</code> otherwise.
     */
    public boolean isIdentical(Polynome other) { //autres
		if (other == null) {
			return false;
		}
		
		int thisLong = 0;
		for (int i = 0; i < this.coefficients.length; i++) {
			if (this.coefficients[i] != 0) {
				thisLong = i + 1;
			}
		}
		
		int otherLong = 0;
		for (int i = 0; i < other.coefficients.length; i++) {
			if (other.coefficients[i] != 0) {
				otherLong = i + 1;
			}
		}
		
		if (thisLong != otherLong) {
            return false;
        }
        for (int i = 0; i < thisLong; i++) {
            if (this.coefficients[i] != other.coefficients[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that calculates the value of the polynomial for a given real value of x.
     * For example, if the polynomial is 2 + 3x + 5x² and x = 10, the method will return 2 + 3*10 + 5*100 = 532.
     *
     * @param x The value for which we want to evaluate the polynomial.
     * @return The value of the polynomial at x.
     */
    public double evaluate(double x) { //autres
        double result = 0.0;
        double puissance = 1.0;  // correspond à x^0

        // Évaluation : a0 + a1*x + a2*x^2 + ...
        for (double coeff : coefficients) {
            result += coeff * puissance;
            puissance *= x; 
        }
        return result;
    }

    /**
     * Returns the degree of the polynomial, i.e. the greatest power of x
     * having a non-zero coefficient. If all coefficients are zero, the method
     * will return -1 to indicate that the polynomial is the zero polynomial.
     *
     * @return The degree of the polynomial, or -1 if all coefficients are zero.
     */
    public int getDegree() { //getter
        int deg = coefficients.length - 1;
        while (deg >= 0 && Double.compare(coefficients[deg], 0.0) == 0) {
            deg--;
        }
        return deg; // -1 si tous les coefficients sont nuls
    }
    
    
	/**
	 * Method for displaying polynomials
	 * 
	 * @return the Polynomial String
	 */
	public String toString() {
		String poly = this.coefficients[0] + "";
		
		for (int i = 1; i < this.coefficients.length; i++) {
			poly += " + " + this.coefficients[i] + "x^" + i;
		}
		
		return poly;
	}
	
	/**
     * Method which calculates the product of this polynomial with another polynomial.
     * The product is defined by multiplying the coefficients together.
     *
     * @param other The polynomial to add to this polynomial.
     * @return A new polynomial that represents the sum of the two polynomials.
     */
	public Polynome multiply(Polynome other) {
		double[] newCoefficients;
		double[] finalCoefficients;
		
		if (other == null) {
			System.err.println("Polynome entré null : polynome renvoyé égale au polynome de départ");
			newCoefficients = this.coefficients.clone();
		} else {
			newCoefficients = new double[(this.coefficients.length + other.coefficients.length) - 1];
			for (int i = 0; i < this.coefficients.length; i++) {
				for (int j = 0; j < other.coefficients.length; j++) {
					newCoefficients[i + j] += this.coefficients[i] * other.coefficients[j];
				}
			}
		}
		
		int coeffLong = 0;
		for (int i = 0; i < newCoefficients.length; i++) {
			if (newCoefficients[i] != 0) {
				coeffLong = i + 1;
			}
		}
		
		finalCoefficients = new double[coeffLong];
		
		for (int i = 0; i < coeffLong; i++) {
			finalCoefficients[i] = newCoefficients[i];
		}

        return new Polynome(finalCoefficients);
    }
}
