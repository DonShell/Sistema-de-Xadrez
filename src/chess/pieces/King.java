package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board borad, Color color) {
		super(borad, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return "K";
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
		
		
		
		
		return pM;
	}
}
