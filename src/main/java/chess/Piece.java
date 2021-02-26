package chess;

public class Piece {

	Piece(int cx, int cy) {
		this.setCurrent_cordX(cx);
		this.setCurrent_cordY(cy);
	}

	int current_cordX = 0;
	int current_cordY = 0;

	public int getCurrent_cordX() {
		return current_cordX;
	}

	public void setCurrent_cordX(int current_cordX) {
		this.current_cordX = current_cordX;
	}

	public int getCurrent_cordY() {
		return current_cordY;
	}

	public void setCurrent_cordY(int current_cordY) {
		this.current_cordY = current_cordY;
	}

}
