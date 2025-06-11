/**
 * Class allow to create a couple with Object type
 * @author L. CARRE
 * @version 1.0
 */
public class Couple {

	/**
	 * The left value of couple
	 */
	private Object left;
	/**
	 * The right value of couple
	 */
	private Object right;
	
	/**
	 * The constructor
	 * @param left the left value
	 * @param right the right value
	 */
	public Couple (Object left, Object right) {
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Getter for the left value
	 * @return the left value
	 */
	public Object getLeft() {
		return this.left;
	}
	
	/**
	 * Getter for the right value
	 * @return the right value
	 */
	public Object getRight() {
		return this.right;
	}
	
	/**
	 * Setter for the left value
	 * @param l new left value
	 */
	public void setLeft(Object l) {
		this.left = l;
	}
	
	/**
	 * Setter for the right value
	 * @param r new right value
	 */
	public void setRight(Object r) {
		this.right = r;
	}
	
	/**
	 * Method to show properly the couple
	 * @return the String attribute
	 */
	public String toString() {
		return "(" + this.left + ", " + this.right + ")";
	}

}
