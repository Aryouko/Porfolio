package com.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleClass {

	private static final Logger logger = LogManager.getLogger ( ExampleClass.class ) ;

	public void doSomething ( ) {
		logger.info ( " Ceci est un message d’information. " );
		logger.error ( " Ceci est un message d’erreur. " );
		logger.debug ( " Ceci est un message de debug. " );
	}

	public static void main ( String[] args ) {
		ExampleClass example = new ExampleClass( );
		example.doSomething( );
	}
}
