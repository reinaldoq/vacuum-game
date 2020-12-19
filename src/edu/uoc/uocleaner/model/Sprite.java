package edu.uoc.uocleaner.model;

public class Sprite {
	private int row;
	private int column;
	private Symbol symbol;
	
	Sprite( int row, int column, Symbol symbol) throws SpriteException{
		this.setRow(row);
		this.setColumn(column);
		this.setSymbol(symbol);
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn () {
		return this.column;
	}
	
	public void setRow(int row) throws SpriteException {
		if (row <0) {
			throw new SpriteException( SpriteException.ERROR_INDEX_ROW_INCORRECT );
		}
		
		
		this.row = row;
	}
	
	public void setColumn(int column) throws SpriteException {
		if (column <0) {
			throw new SpriteException( SpriteException.ERROR_INDEX_COLUMN_INCORRECT );
		}
		
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
		if ((int)this.symbol.toString().charAt(0) == (int)casted.symbol.toString().charAt(0) ) {
			if (this.row == casted.row) {
				if (this.column == casted.column) {
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
