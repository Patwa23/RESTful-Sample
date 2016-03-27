package com.navprayas.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7291980488464164074L;
	
	public DataNotFoundException(String message){
		super(message);
	}

}
