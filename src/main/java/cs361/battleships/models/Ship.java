package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	
	public Ship(String kind) {
		//TODO implement
	}

	public List<Square> getOccupiedSquares() {
		//TODO implement
		return this.occupiedSquares;
		
	}

	public void setOccupiedSquares(List<Square> squares){
		this.occupiedSquares = squares;
	}
}
