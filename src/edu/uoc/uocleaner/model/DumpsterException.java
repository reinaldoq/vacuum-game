package edu.uoc.uocleaner.model;

public class DumpsterException extends java.lang.Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String ERROR_LOAD_NEGATIVE_VALUE = "[ERROR] Load cannot be negative!!";
	
	public DumpsterException() {
		
	};
			
	public DumpsterException(String msg) {
		super(msg); 
	}
}
