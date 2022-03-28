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
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	public boolean isThereAnyPossibleMove()
	{
		boolean[][] possibleMoveis = this.possibleMoves();
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
	
	@Override
	public String toString()
	{
		return " ";
	}
	
}
