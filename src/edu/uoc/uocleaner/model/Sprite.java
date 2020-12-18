package edu.uoc.uocleaner.model;

public class Sprite {
	private int row;
	private int column;
	private Symbol symbol;
	
	public Sprite( int row, int colunm, Symbol symbol){
		this.setRow(row);
		this.setColumn(column);
		this.setSymbol(symbol);
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColunm () {
		return this.column;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	private void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public boolean equals(Object other) {
		Sprite casted = (Sprite) other;
		if (this.symbol.toString() == casted.symbol.toString() ) {
			if (this.row == casted.row) {
				if (this.column == casted.row) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.symbol.toString();
	}
}
