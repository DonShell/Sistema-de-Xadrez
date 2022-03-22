package chess;

import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for( int r = 0 ; r < board.getRows() ; r ++) 
		{
			for( int c = 0 ; c < board.getColumns() ; c ++) 
			{
				mat[r][c] = (ChessPiece) board.getPiece(r,c);
			}
		}
		return mat;
	}
	
	
	private void placeNewPiece(char column, int row, ChessPiece piece)
	{
		
		board.placePiece(piece, new ChessPosition(column,row).toPosition());
		
	}
	
	private void initialSetup() {
		Color color = Color.WHITE;
		
		placeNewPiece('a',1,  new Rook(board, color));
		placeNewPiece('h',1,  new Rook(board, color));
		placeNewPiece('e',1,  new King(board, color));
		
		
		color = Color.BLACK;
		placeNewPiece('a',8,  new Rook(board, color));
		placeNewPiece('h',8,  new Rook(board, color));
		placeNewPiece('e',8,  new King(board, color));
	}
}
