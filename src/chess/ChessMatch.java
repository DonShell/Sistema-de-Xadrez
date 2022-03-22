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
	private void initialSetup() {
		Color color = Color.WHITE;
		board.placePiece(new Rook(board, color), new Position(7,7));
		board.placePiece(new Rook(board, color), new Position(7,0));
		board.placePiece(new King(board, color), new Position(7,4));

		
		
		color = Color.BLACK;
		board.placePiece(new Rook(board, color), new Position(0,0));
		board.placePiece(new Rook(board, color), new Position(0,7));
		board.placePiece(new King(board, color), new Position(0,4));
	}
}
