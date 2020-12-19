package edu.uoc.uocleaner.model;

import java.util.ArrayList;

public class Vacuum extends Sprite {
	private int MAX_CAPACITY;
	private int capacity;
	private Sprite under;
	
	public Vacuum (int MAX_CAPACITY, int capacity, Sprite under) throws VacuumException, SpriteException {
		super(under.getRow(), under.getColumn(), under.getSymbol());
		
		if (MAX_CAPACITY <= 0) {
			throw new  VacuumException(VacuumException.ERROR_MAX_CAPACITY_VALUE);
		} else {
			this.MAX_CAPACITY = MAX_CAPACITY;
		}
		
		this.setCapacity(capacity);
		this.setUnder(under);
		
	}
	
	public Vacuum (int row, int column, int maxCapacity) throws SpriteException, VacuumException{
		super(row, column,Symbol.VACUUM);
		if (maxCapacity <= 0) {
			throw new  VacuumException(VacuumException.ERROR_MAX_CAPACITY_VALUE);
		} 
		this.MAX_CAPACITY = maxCapacity;
		
		Corridor corridor = new Corridor(row,column);
		
		this.setUnder(corridor);
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void incCapacity(int inc) throws VacuumException {
		
		if (this.capacity + inc > this.MAX_CAPACITY) {
			throw new VacuumException(VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
		}
		
		if (inc < 0) {
			throw new VacuumException(VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE);
		}
		
		this.capacity = this.capacity + inc;
	}

	private void setCapacity(int capacity) throws VacuumException {
		
		if(capacity <0) {
			throw new VacuumException(VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE);
		}
		
		if (capacity > this.MAX_CAPACITY) {
			throw new VacuumException(VacuumException.ERROR_OVERFLOW_MAX_CAPACITY);
		}
		this.capacity = capacity;
	}
	
	public void empty() throws VacuumException {
		this.setCapacity(0);
	}
	
	public int getMaxCapacity() {
		return this.MAX_CAPACITY;
	}
	
	public void moveTo(int row, int column) throws SpriteException {
		this.setRow(row);
		this.setColumn(column);
	}
	
	public Sprite getUnder() {
		return this.under;
	}
	
	public void setUnder(Sprite under) {

		this.under = under;
		
	}

	
}
