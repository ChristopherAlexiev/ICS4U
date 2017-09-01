package com.bayviewglen.queens;

public class Queen {

	private int row;
	private int column;

	public Queen(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void setLocation(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getColumn(){
		return column;
	}

}
