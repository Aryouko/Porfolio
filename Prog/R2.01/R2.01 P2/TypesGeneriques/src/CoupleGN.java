/**
 * Class allow to create a couple with chosen type
 * @author L. CARRE
 * @version 1.0
 */
public class CoupleGN<T extends Number, U extends Number> {
	
	/**
	 * The left value of couple
	 */
	private T left;
	/**
	 * The right value of couple
	 */
	private U right;
	
	/**
	 * The constructor
	 * @param left the left value
	 * @param right the right value
	 */
	public CoupleGN (T left, U right) {
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Getter for the left value
	 * @return the left value
	 */
	public T getLeft() {
		return this.left;
	}
	
	/**
	 * Getter for the right value
	 * @return the right value
	 */
	public U getRight() {
		return this.right;
	}
	
	/**
	 * Setter for the left value
	 * @param l new left value
	 */
	public void setLeft(T l) {
		this.left = l;
	}
	
	/**
	 * Setter for the right value
	 * @param r new right value
	 */
	public void setRight(U r) {
		this.right = r;
	}
	
	/**
	 * Method to show properly the couple
	 * @return the String attribute
	 */
	public String toString() {
		return "(" + this.left + ", " + this.right + ")";
	}
	
	/**
	 * Method to add left and right
	 * @return result of add
	 */
	public double additionComp() {
		return this.left.doubleValue() + this.right.doubleValue();
	}
	
	/**
	 * Method to multiply left and right
	 * @return result of multiply
	 */
	public double produitComp() {
		return this.left.doubleValue() * this.right.doubleValue();
	}
	
	/**
	 * Method to compare if two couple are the same couple
	 * @param other an other couple
	 * @return true if the same, false if not
	 */
	public boolean sameNumericContent(CoupleGN<? extends Number, ? extends Number> other) {
		return (this.left.doubleValue() == other.left.doubleValue() && this.right.doubleValue() == other.right.doubleValue());
	}
	
	/**
	 * 2nd method to compare if two couple are the same couple
	 * @param <L2> the type of the left value of other couple
	 * @param <R2> the type of the left value of other couple
	 * @param other an other couple
	 * @return true if the same, false if not
	 */
	public <L2 extends Number, R2 extends Number> boolean sameNumericContent2(CoupleGN<L2, R2> other) {
    return (this.left.doubleValue() == other.left.doubleValue() && this.right.doubleValue() == other.right.doubleValue());
	}


}
