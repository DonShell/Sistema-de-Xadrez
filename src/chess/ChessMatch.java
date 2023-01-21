package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessMatch {

	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	private Board board;
	private int turn;
	private Color currentPlayer;

	private boolean check;
	private boolean checkMate;
	
	
	
	public Color getCurrentPlayer()
	{
		return currentPlayer;
	}

	public int getTurn()
	{
		return turn;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	public ChessMatch() {
		board = new Board(8,8);
		turn = 1;
		currentPlayer = Color.WHITE;
		
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
	public boolean[][] possibleMoves(ChessPosition sourcePosition)
	{
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.getPiece(position).possibleMoves();
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
		
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();	
		
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source,target);
		
		if (testCheck(currentPlayer))
		{
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put yourself in check");
		}
		check = (testCheck(opponent(currentPlayer))) ? true : false;
		
		if(testCheckMate(opponent(currentPlayer))) 
		{
			checkMate = true;
		}
		else
		{
			nextTurn();
		}
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target){
	
		
		ChessPiece movedPiece = (ChessPiece) board.removePiece(source);
		movedPiece.incraseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(movedPiece,target);
		
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}

	private void undoMove(Position source, Position target, Piece capturedPiece) {
		
		Piece p = board.removePiece(target);
		((ChessPiece) p).decreseMoveCount();
		board.placePiece(p, source);
		
		if(capturedPiece != null)
		{
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPieces);
			piecesOnTheBoard.add(capturedPiece);
		}
	}
	
	
	private	void validateSourcePosition(Position position)
	{
		if(!board.thereIsAPiece(position))
		{
			throw new ChessException("Position source invalid.");
		}
		if(currentPlayer != ((ChessPiece) board.getPiece(position)).getColor())
		{
			throw new ChessException("The chosen piece is not yours.");
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
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		Color color = Color.WHITE;

		placeNewPiece('a',2,  new Pawn(board, color));
		placeNewPiece('b',2,  new Pawn(board, color));
		placeNewPiece('c',2,  new Pawn(board, color));
		placeNewPiece('d',2,  new Pawn(board, color));
		placeNewPiece('e',2,  new Pawn(board, color));
		placeNewPiece('f',2,  new Pawn(board, color));
		placeNewPiece('g',2,  new Pawn(board, color));

		
		placeNewPiece('a',1,  new Rook(board, color));
		placeNewPiece('b',1,  new Knight(board, color));
		placeNewPiece('c',1,  new Bishop(board, color));
		placeNewPiece('d',1,  new Queen(board, color));
		placeNewPiece('e',1,  new King(board, color));
		placeNewPiece('f',1,  new Bishop(board, color));
		placeNewPiece('g',1,  new Knight(board, color));
		placeNewPiece('h',1,  new Rook(board, color));
		
		color = Color.BLACK;

		placeNewPiece('a',7,  new Pawn(board, color));
		placeNewPiece('b',7,  new Pawn(board, color));
		placeNewPiece('c',7,  new Pawn(board, color));
		placeNewPiece('d',7,  new Pawn(board, color));
		placeNewPiece('e',7,  new Pawn(board, color));
		placeNewPiece('f',7,  new Pawn(board, color));
		placeNewPiece('g',7,  new Pawn(board, color));
		placeNewPiece('h',7,  new Pawn(board, color));
		
		placeNewPiece('a',8,  new Rook(board, color));
		placeNewPiece('b',8,  new Knight(board, color));
		placeNewPiece('c',8,  new Bishop(board, color));
		placeNewPiece('d',8,  new Queen(board, color));
		placeNewPiece('e',8,  new King(board, color));
		placeNewPiece('f',8,  new Bishop(board, color));
		placeNewPiece('g',8,  new Knight(board, color));
		placeNewPiece('h',8,  new Rook(board, color));
		
	}
	
	private Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE; 
	}
	
	private ChessPiece king(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).collect(Collectors.toList());
		for(Piece p : list)
		{
			if (p instanceof King) {
				return (ChessPiece) p;
			}
		}
		throw new IllegalStateException("There is no " + color + " king on the board!");
		
	}
	
	private boolean testCheck(Color color)
	{
		Position kingPosition = king(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter( x -> ((ChessPiece) x).getColor() == opponent(color)).collect(Collectors.toList());
		for (Piece p : opponentPieces)
		{
			boolean[][] mat = p.possibleMoves();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
			return true;
			}
		}
		return false;
	}

	private boolean testCheckMate(Color color) {
		if(!testCheck(color))
		{
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color).collect(Collectors.toList());
		for(Piece p : list)
		{
			boolean[][] mat = p.possibleMoves();
			for (int i=0; i < board.getRows() ; i++)
			{
				for (int j=0; j < board.getColumns() ; j++)
				{
					if(mat[i][j]) 
					{
						Position source = ((ChessPiece) p).getChessPosition().toPosition();
						Position target = new Position(i,j);
						Piece capturedPiece = makeMove(source,target);
						boolean testCheck = testCheck(color);
						undoMove(source,target,capturedPiece);
						if(!testCheck)
						{
							return false;
						}
						
					}
				}	
			}
		}
		return true;
	}
}
