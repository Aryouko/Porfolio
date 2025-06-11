package com.mycompany.app;
/**
* Class allow to do specific exception
* @author L. CARRE
* @version 1.0
*/
public class BadCurrencyException extends Exception{
	
	/**
	 * Constructor of the class
	 * @param s - the error message
	 */
	public BadCurrencyException (String s) {
		super(s);
	}
}
