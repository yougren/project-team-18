package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
  	@JsonProperty private int length;

  	public Ship() {this.occupiedSquares = new ArrayList<>();}
	public Ship(int length) { this.occupiedSquares = new ArrayList<>(length); this.length = length;}

	public final List<Square> getOccupiedSquares() {
		return this.occupiedSquares;
	}

	public final void setOccupiedSquares(List<Square> squares){
		this.occupiedSquares = squares;
    	this.length = squares.size();
	}

	public final int getLength() {
		return this.length;
	}
}



