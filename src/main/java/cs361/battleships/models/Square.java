package cs361.battleships.models;

@SuppressWarnings("unused")
public class Square {

	private int row;
	private char column;
	private boolean capFlag;

	public Square(){

	}
	public Square(int row, char column) {
		this(row, column, false);
	}
	public Square(int row, char column, boolean capFlag) {
		this.row = row;
		this.column = column;
		this.capFlag = capFlag;
	}
	public boolean isCaptainsQuarter() {
		return capFlag;
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
