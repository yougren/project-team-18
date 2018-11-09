package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Square {

	@JsonProperty private int row;
	@JsonProperty private char column;
	@JsonProperty private boolean captainsQuarter;
	@JsonProperty private int hitCount;

	public Square(){ }
	public Square(int row, char column) {
		this(row, column, false, 1);
	}
	public Square(int row, char column, boolean capFlag, int hitCount) {
		this.row = row;
		this.column = column;
		this.captainsQuarter = capFlag;
		this.hitCount = hitCount;
	}

	public int getHitCount() { return hitCount; }

	public void setHitCount(int hitCount) { this.hitCount = hitCount; }

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
