package edu.uoc.uocleaner.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** 
 * Level/Room class. 
 * @author David Garc�a Sol�rzano
 * @version 1.0 
 */
public class Level{
	/**
	 * Number of rows of the board.
	 */
	private int numRows;
	/**
	 * Number of columns of the board.
	 */
	private int numColumns;
	/**
	 * Representation of the 2D board.
	 */
	private Sprite[][] board;
	/**
	 * Name of the background image for the GUI app.
	 */
	private String imageBackground;
	/**
	 * Number of turns which the player has in order to beat the level.
	 */
	private int turns;	
	/**
	 * Maximum time which the player has in order to beat the level.
	 */
	private int time;

		
	/**
	 * Constructor 
	 * @param fileName Name of the configuration file which has all the information of the level.
	 * @throws FileNotFoundException When it is impossible to open the configuration file.
	 * @throws LevelException When the number of rows or columns are zero or negative; 
	 * when the number of turns or time is negative; when there is not only one vacuum cleaner; when there are not dumpsters; 
	 * when there are not dirts or dustballs.
	 * @throws VacuumException When the value for the vacuum cleaner's capacity is zero or negative.
	 * @throws SpriteException When the index of either the row or the column is incorrect.
	 */
	public Level(String fileName) throws FileNotFoundException, LevelException, VacuumException, SpriteException {
		char[] line = null;
		boolean isDumpster = false, isDirt = false;
		int numVacuums = 0;		
		
		Scanner sc = new Scanner(new File(fileName));

		// find the number of rows and columns       
        setNumRows(Integer.parseInt(sc.nextLine()));
        setNumColumns(Integer.parseInt(sc.nextLine()));
        setImageBackground(sc.nextLine());
        setTurns(Integer.parseInt(sc.nextLine()));
        setTime(Integer.parseInt(sc.nextLine()));
        
        board = new Sprite[numRows][numColumns];           
        for (int row = 0; row < numRows; row++) {
        	line = sc.nextLine().toCharArray();        	
			for (int column = 0; column < numColumns; column++) {				
				board[row][column] = SpriteFactory.getSprite(row,column,Symbol.getName(line[column]));				
				if(board[row][column] instanceof Dirt) isDirt = true;
				if(board[row][column] instanceof Vacuum) numVacuums++;
				if(board[row][column] instanceof Dumpster) isDumpster = true;								
			}			
        }        
        
        sc.close();       
                
        if(numVacuums!=1) {
        	throw new LevelException(LevelException.ERROR_NUM_VACUUMS);
        }
        
        if(!isDumpster) {
        	throw new LevelException(LevelException.ERROR_NO_DUMPSTERS);
        }
        
        if(!isDirt) {
        	throw new LevelException(LevelException.ERROR_NO_DIRT);
        }        
	}	
	
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}
	
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}
	
	public void setImageBackground(String imageBackground) {
		this.imageBackground =imageBackground;
	}
	
	public void setTurns(int turns) {
		this.turns = turns;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public void decTime(){
		this.time = this.time - 1;
	}
	
	public void decTurns() {
		this.turns = this.turns - 1;
	}
	
	public List<Sprite> get1DBoard(){
		
		List<Sprite> fila_acumulada = new ArrayList<Sprite>();
		
        for (int row = 0; row < numRows; row++) {
			for (int column = 0; column < numColumns; column++) {	
				fila_acumulada.add(this.board[row][column]);
			}			
        }        
		return fila_acumulada;
	}
	
	public Sprite getCell(int row, int col) {
		return this.board[row][col];
	}

	public String getImageBackground() {
		return this.imageBackground;
	}
	
	public int getNumColumns() {
		return this.numColumns;
	}
	
	public int getNumRows() {
		return this.numRows;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getTurns() {
		return this.turns;
	}
	
	private int	putColumnInRange​(int column) {
		if (column > this.numColumns -1 ) {
			return this.numColumns - 1;
		}
		
		return column;
	}
	
	private int	putRowInRange​(int row) {
		if (row > this.numRows -1 ) {
			return this.numRows - 1;
		}
		return row;
	}
	
	public void setCell​(int row, int column, Sprite sprite) {
		sprite.setColunm(column);
		sprite.setRow(row);
		
		this.board[row][column] = sprite;
	}
	
	public void setCell​(Sprite sprite) {
		this.board[sprite.getRow()][sprite.getColunm()] = sprite;
	}
	
	@Override
	public String toString() {
				
		StringBuilder str = new StringBuilder();
	    
	    this.get1DBoard().stream().forEach(c -> {
	    	str.append(c.toString());
	    });
		
		return str.toString(); 
	}


	
	
	
	
	
}