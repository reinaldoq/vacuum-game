package edu.uoc.uocleaner.model;

public class Vacuum extends Sprite {
	private int MAX_CAPACITY;
	private int capacity;
	private Sprite under;
	
	public Vacuum (int MAX_CAPACITY, int capacity, Sprite under){
		super(under.getRow(), under.getColunm(), under.getSymbol());
		
		if (MAX_CAPACITY <= 0) {
			// error
		} else {
			this.MAX_CAPACITY = MAX_CAPACITY;
		}
		
		this.setCapacity(capacity);
		this.setUnder(under);
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void incCapacity(int inc) {
		this.capacity = this.capacity + inc;
	}

	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void empty() {
		this.capacity = 0;
	}
	
	public int getMaxCapacity() {
		return this.MAX_CAPACITY;
	}
	
	public void moveTo(int row, int column) {
		under.setRow(row);
		under.setColunm(column);
	}
	
	public Sprite getUnder() {
		return this.under;
	}
	
	public void setUnder(Sprite under) {
		if (!(under instanceof Corridor)) {
			// erorr
		} else {
			this.under = under;
		}
	}
	
}
