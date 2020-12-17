package edu.uoc.uocleaner.model;

public class SpriteException extends java.lang.Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String ERROR_INDEX_COLUMN_INCORRECT = "[ERROR] The index of column cannot be negative!!";
	public static String ERROR_INDEX_ROW_INCORRECT = "[ERROR] The index of row cannot be negative!!";
	
	public SpriteException () {};
	
	public SpriteException (String msg) {
		super(msg);
	};
}
