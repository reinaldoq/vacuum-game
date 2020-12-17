package edu.uoc.uocleaner.model;

public class DustBall extends Dirt implements Movable{

	DustBall (int row, int column){
		super(row, column);
	}

	@Override
	public void moveTo(int row, int column) throws Exception {
		super.setRow(row);
		super.setColunm(column);
	}
}
