package edu.uoc.uocleaner.model;

public enum Symbol {
	DUSTBALL ('@', "dustball.png"),
	DUMPSTER ('D', "dumpster.png"),
	VACUUM ('V', "huocver.png"),
	DIRT ('·', "dirt.png"),
	WALL ('#', ""),
	CORRIDOR (' ', "");
	
	
	public static Symbol getName(char ascii) {
		if (ascii == '@') {
			return Symbol.DUSTBALL;
		}
		if (ascii == 'D') {
			return Symbol.DUMPSTER;
		}		
		if (ascii == 'V') {
			return Symbol.VACUUM;
		}	
		if (ascii == '·') {
			return Symbol.DIRT;
		}			
		if (ascii == '#') {
			return Symbol.WALL;
		}	
		return Symbol.CORRIDOR;
	};
	
	private char ascii;
	private String image;
	
	Symbol( char ascii, String image) {
		this.ascii = ascii;
		this.image = image;
	};
	
	public  String getImage() {
		return this.image;
	};
	
	public char getAscii() {
		return this.ascii;
	}; 
	
	@Override
	public String toString() {
		return String.valueOf(this.ascii);  
	}	
	
}
