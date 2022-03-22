package boardgame;

public abstract class Piece {
	protected Position position;
	protected Board borad;
	
	protected Board getBorad() {
		return borad;
	}

	protected Piece(Board borad) {
		this.borad = borad;
	}
	
}
