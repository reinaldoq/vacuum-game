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
	
	void setNumRows(int numRows) {
		this.numRows = numRows;
	}
	
	void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}
	
	void setImageBackground(String imageBackground) {
		this.imageBackground =imageBackground;
	}
	
	void setTurns(int turns) {
		this.turns = turns;
	}
	
	void setTime(int time) {
		this.time = time;
	}
	
	void decTime(){
		this.time = this.time - 1;
	}
	
	void decTurns() {
		this.turns = this.turns - 1;
	}
	
	java.util.List<Sprite> get1DBoard(){
		
		List<Sprite> fila_acumulada = new List<Sprite> {};
		
		for (int i = 0; i < this.board.length; ++i) {
			fila_acumulada = this.board[i];
		}
		return fila_acumulada;
	}
	
	Sprite getCell(int row, int col) {
		this.board
	}

	String getImageBackground() {
		return this.imageBackground;
	}
	
	int getNumColumns() {
		return this.numColumns;
	}
	
	int getNumRows() {
		return this.numColumns;
	}
	
	int getTime() {
		return this.time;
	}
	
	int getTurns() {
		return this.turns;
	}
	
	private int	putColumnInRange​(int column) {
		
	}
	
	private int	putRowInRange​(int row) {
		
	}
	
}