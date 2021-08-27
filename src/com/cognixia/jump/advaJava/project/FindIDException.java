package com.cognixia.jump.advaJava.project;

public class FindIDException extends Exception {

	/**
	 *  Goes out to discover and find ID in order to update it
	 */
	private static final long serialVersionUID = 1822872558243209234L;

	public FindIDException() {
		super("Error! No ID exists!");
	}
}
