package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board borad, Color color) {
		super(borad, color);
	}
	
	
	
	@Override
	public String toString()
	{
		return "N";
	}


	private boolean canMove(Position position)
	{
		ChessPiece p = (ChessPiece)getBoard().getPiece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] pM = new boolean[getBoard().getRows()][getBoard().getColumns()];
	
		int row = position.getRow();
		int column = position.getColumn();
		
			
	
		Position p = new Position(row - 1,column - 2);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row - 2,column -1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row-2,column + 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row -1 ,column + 2);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		
		p.setValues(row + 1,column + 2);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row - 2,column + 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row + 2,column + 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		p.setValues(row + 2 ,column - 1);
		if (getBoard().positionExists(p) && canMove(p)) pM[p.getRow()][p.getColumn()] = true;
		
		
		
		
		return pM;
	}
}
