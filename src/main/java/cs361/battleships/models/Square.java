package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Square {

	@JsonProperty private int row;
	@JsonProperty private char column;
	@JsonProperty private boolean captainsQuarter;

	public Square(){ }
	public Square(int row, char column) {
		this(row, column, false);
	}
	public Square(int row, char column, boolean capFlag) {
		this.row = row;
		this.column = column;
		this.captainsQuarter = capFlag;
	}
	public boolean isCaptainsQuarter() {
		return captainsQuarter;
	}

	public char getColumn() {
		return column;
	}

	public void setColumn(char column) {
		this.column = column;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
}
