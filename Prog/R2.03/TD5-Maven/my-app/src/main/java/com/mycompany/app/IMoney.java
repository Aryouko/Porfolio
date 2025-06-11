package com.mycompany.app;
/**
* Interface allow to do specific certain case of Money
* @author L. CARRE
* @version 1.0
*/
public interface IMoney {
	
	/**
	 * Method allow to additionate two Money in a new instance Money
	 * @param theM - an other Money to additionate
	 * @return A new Money instance with additionate amount or a new bag with many monies
	 */
	public abstract IMoney add(Money theM);
}
