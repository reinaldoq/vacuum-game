package edu.uoc.uocleaner.model;

public class Dirt extends Sprite {
	private int score = 1;
	
	public Dirt(int row, int column){
		super(row, column, Symbol.DIRT);
	}
	
	protected Dirt(int row, int column, Symbol symbol, int score){
		super(row, column, symbol);
		
		this.setScore(score);
	}
	
	int getScore() {
		return this.score;
	}
	
	void setScore(int score) {
		this.score = score;
	}
}
