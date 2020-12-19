package edu.uoc.uocleaner.model;

import java.util.ArrayList;

public class DustBall extends Dirt implements Movable{

	public DustBall (int row, int column) throws SpriteException{
		super(row, column);
	}

	@Override
	public void moveTo(int row, int column) throws SpriteException {
		super.setRow(row);
		super.setColumn(column);
	}
	
	@Override
	public int getScore() {
		return 5;
		
	}
	
	public ArrayList<int[]> moveRandomly​(Level level){
		
		ArrayList<int[]> lista = new ArrayList<int[]>();
		
		int check_row = this.getRow() - Movable.SPEED;
		int check_col = this.getColumn();
	
		if (this.validMove​(level, check_row, check_col) == true) {
			int[] myIntArray = new int[]{check_row, check_col};
			lista.add(myIntArray);
		};
		
		int check_row_abajo = this.getRow() + Movable.SPEED;
		int check_col_abajo = this.getColumn();
	
		if (this.validMove​(level, check_row_abajo, check_col_abajo) == true) {
			int[] myIntArray = new int[]{check_row_abajo, check_col_abajo};
			lista.add(myIntArray);
		};
		
		int check_row_iz = this.getRow();
		int check_col_iz = this.getColumn() - Movable.SPEED;
	
		if (this.validMove​(level, check_row_iz, check_col_iz) == true) {
			int[] myIntArray = new int[]{check_row_iz, check_col_iz};
			lista.add(myIntArray);
		};
		
		int check_row_de = this.getRow();
		int check_col_de = this.getColumn() + Movable.SPEED;
	
		if (this.validMove​(level, check_row_de, check_col_de) == true) {
			int[] myIntArray = new int[]{check_row_de, check_col_de};
			lista.add(myIntArray);
		};
		
		return lista;
		
	}
	
	private boolean validMove​(Level level, int row, int column) {
		
		if (row >= level.getNumRows() || row < 0) {
			return false;
		}
		
		if (column >= level.getNumColumns() || column < 0) {
			return false;
		}

		Sprite cell = level.getCell(row, column);

		if (cell.getSymbol() == Symbol.CORRIDOR) {
			return true;
		} else {
			return false;
		}
		
	}
}
