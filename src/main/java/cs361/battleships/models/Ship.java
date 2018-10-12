package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	
	public Ship(String kind) {
		kind = kind.toUpperCase();
		switch(kind){
			case("BATTLESHIP"):
				this.occupiedSquares = new ArrayList<>(4);
				break;
			case("CRUISER"):
				this.occupiedSquares = new ArrayList<>(3);
				break;
			case("DESTROYER"):
				this.occupiedSquares = new ArrayList<>(2);
				break;
		}
	}

	public List<Square> getOccupiedSquares() {
		//TODO implement
		return null;
	}
}
