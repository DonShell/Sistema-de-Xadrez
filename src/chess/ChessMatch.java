package chess;

import boardgame.Board;
import boardgame.Piece;
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
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
		
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();	
		
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		
		Piece capturedPiece = makeMove(source,target);
		
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target){
	
		
		Piece movedPiece = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(movedPiece,target);
		
		return capturedPiece;
	}
	
	private	void validateSourcePosition(Position position)
	{
		if(!board.thereIsAPiece(position))
		{
			throw new ChessException("Position source invalid.");
		}
		if(! board.getPiece(position).isThereAnyPossibleMove())
		{
			throw new ChessException("There is not possible movies for the chosen piece.");
		}
	}
	
	private	void validateTargetPosition(Position source, Position target)
	{
		if(!board.positionExists(target))
		{
			throw new ChessException("Position target invalid.");
		}
		if(!board.getPiece(source).possibleMove(target)){
			throw new ChessException("The chosen piece can't move to target position.");
		}
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
