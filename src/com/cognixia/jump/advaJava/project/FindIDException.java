package com.cognixia.jump.advaJava.project;

public class FindIDException extends Exception {

	/**
	 *  Goes out to discover and find ID in order to update it
	 *  Only works on update Employe method
	 */
	private static final long serialVersionUID = 1822872558243209234L;

	public FindIDException(int id) {
		super("Error! No ID " + id +" exists!");
	}
}
