/**
 * Class allow to create a couple with chosen type
 * @author L. CARRE
 * @version 1.0
 */
public class CoupleG<T, U> {

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
	public CoupleG (T left, U right) {
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
	 * Method to change left value
	 * @param <V> the type of the new left value
	 * @param newLeft the new value for left value
	 * @return a new CoupleG with a new type and value for left
	 */
	public <V> CoupleG<V, U> withNewLeft(V newLeft) {
        return new CoupleG<>(newLeft, this.right);
    }
}
