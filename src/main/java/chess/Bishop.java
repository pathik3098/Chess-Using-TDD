package chess;

public class Bishop extends Piece {

	int current_cordX = 0;
	int current_cordY = 0;
	Boolean isWhite;
	Boolean DestinationPieceWhite;

	public Bishop(int current_cordX, int current_cordY, Boolean isWhite, Boolean DestinationPieceWhite) {
		super(current_cordX, current_cordY);
		this.isWhite = isWhite;
		this.DestinationPieceWhite = DestinationPieceWhite;
	}

	public Boolean checkAllyMove() {
		if (this.DestinationPieceWhite != null) {
			if (this.DestinationPieceWhite == true && this.isWhite) {
				return false;
			}
			if (this.DestinationPieceWhite == true && !this.isWhite) {
				return false;
			}
		}
		return true;
	}

	public Boolean checkDirectionMovement(int final_cordX, int final_cordY) {
		int diffX = Math.abs(final_cordX - current_cordX);
		int diffY = Math.abs(final_cordY - current_cordY);

		if (diffX != diffY) {
			return false;
		}
		String Direction = null;
		if (diffX > 0 && diffY > 0) {
			Direction = "NE";
		}
		if (diffX < 0 && diffY > 0) {
			Direction = "NW";
		}
		if (diffX < 0 && diffY < 0) {
			Direction = "SW";
		}
		if (diffX > 0 && diffY < 0) {
			Direction = "SE";
		}
		if (Direction == "NE") {
			int spaces_in_between = Math.abs(final_cordX - this.current_cordX);
//			for (int i = 0; i < spaces_in_between; i++) {
//				Piece p = Board.getPiece(final_cordX, final_cordY);
//				if (p != null) {
//					return false;
//				}
//			}
		}

		return true;
	}

	public Boolean checkMove(int final_cordX, int final_cordY) {
		Boolean temp = checkAllyMove();
		if (!temp) {
			return false;
		}

		Boolean temporary = checkDirectionMovement(final_cordX, final_cordY);
		if (!temporary) {
			return false;
		}

		return true;

	}
}
