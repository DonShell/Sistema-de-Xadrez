package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	private ChessMatch chessMatch;
	
	public King(Board borad, Color color, ChessMatch chessMatch) {
		super(borad, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString()
	{
		return "K";
	}

	private boolean testRoockCastling(Position position)
	{
		ChessPiece p = (ChessPiece)getBoard().getPiece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	private boolean canMove(Position pos)
	{
		ChessPiece p = (ChessPiece)getBoard().getPiece(pos);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] pM = new boolean[getBoard().getRows()][getBoard().getColumns()];
	
		int row = position.getRow();
		int column = position.getColumn();
		
			
	
		Position p = new Position(row + 1,column);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row - 1,column);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row,column + 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row ,column - 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		
		p.setValues(row - 1,column -1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row - 1,column + 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row + 1,column + 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row + 1 ,column - 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		

		//specialMove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck())
		{
			//castling kingside rook
			Position positionRook = new Position(row, column + 3);
			if(testRoockCastling(positionRook)) {
				
				Position p1 = new Position(row, column + 1);
				Position p2 = new Position(row, column + 2);
				if(getBoard().getPiece(p1) == null && getBoard().getPiece(p2) == null )
				{

					pM[row][column + 2] = true;
				}
			}
			//castling queenside rook
			positionRook = new Position(row, column - 4);
			if(testRoockCastling(positionRook)) {
				Position p1 = new Position(row, column - 1);
				Position p2 = new Position(row, column - 2);
				Position p3 = new Position(row, column - 3);
				if(getBoard().getPiece(p1) == null && getBoard().getPiece(p2) == null && getBoard().getPiece(p3) == null  )
				{
					pM[row][column - 2] = true;
				}
			
			}
		}
		
		
		return pM;
	}
	
	
	
	
}
