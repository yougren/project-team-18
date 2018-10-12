package cs361.battleships.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	@JsonProperty private List<Square> occupiedSquares;
	private int length;
	
	public Ship(String kind) {
		kind = kind.toUpperCase();
		switch(kind){
			case("BATTLESHIP"):
				this.occupiedSquares = new ArrayList<>(4);
				this.length = 4;
				break;
			case("CRUISER"):
				this.occupiedSquares = new ArrayList<>(3);
				this.length = 3;
				break;
			case("DESTROYER"):
				this.occupiedSquares = new ArrayList<>(2);
				this.length = 2;
				break;
		}
	}

	public List<Square> getOccupiedSquares() {
		return this.occupiedSquares;
		
	}

	public void setOccupiedSquares(List<Square> squares){
		this.occupiedSquares = squares;
	}

	public int getLength() {
		return this.length;
	}
}
