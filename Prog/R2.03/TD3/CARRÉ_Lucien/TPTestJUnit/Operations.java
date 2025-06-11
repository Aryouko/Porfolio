import java.lang.Math;
/**
* Class allow to do operations on values
* @author L. CARRE
* @version 1.0
*/
public class Operations {

	/**
	* Method allow to additionne two values
	* @param premier - the first value
	* @param second - the second value
	* @return addition of the two values
	*/
	public int additionne(int premier, int second) {
		int ret = premier + second ;
		return ret ;
	}
	
	/**
	* Method allow to calculate the square of a value
	* @param val - the value will calculate
	* @return the square of the value
	* @throws ArithmeticException - if the value is negative
	*/
	public double calculeRacineCarree(double val) throws ArithmeticException{
		double ret = Math.sqrt(val);
		if (Double.isNaN(ret)) {
			throw new ArithmeticException("Valeur négatif");
		}
		return Math.sqrt(val);
	}
}
