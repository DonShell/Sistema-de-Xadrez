package boardgame;

public abstract class Piece {
	protected Position position;
	protected Board borad;
	
	protected Board getBoard() {
		return borad;
	}

	protected Piece(Board borad) {
		this.borad = borad;
	}
	
	public abstract boolean[][] possibleMovies();
	
	public boolean possibleMove(Position position) {
		return possibleMovies()[position.getRow()][position.getColumn()];
	}
	public boolean isThereAnyPossibleMove()
	{
		boolean[][] possibleMoveis = this.possibleMovies();
		for(int r = 0 ; r < possibleMoveis.length ;  r++ ) {
			for(int c = 0 ; c < possibleMoveis[r].length ;  c++ ) {
				if (possibleMoveis[r][c]) 
				{
					return true;
				}
			}	
		}
		return false;
	}
	
}
