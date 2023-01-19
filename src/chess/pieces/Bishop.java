package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

	public Bishop(Board borad, Color color) {
		super(borad, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] pM = new boolean[getBoard().getRows()][getBoard().getColumns()];
	
		int row = position.getRow();
		int column = position.getColumn();
		
			
	
		Position p = new Position(row,column);
		
		//'nw
		p.setValues(row - 1, column-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[p.getRow()][ p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() -1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[p.getRow()][p.getColumn()] = true;
		}

		//sl.
		p.setValues(row + 1, column+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[p.getRow()][ p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[p.getRow()][ p.getColumn()] = true;
		}

		//'sw
		p.setValues(row + 1, column-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[p.getRow()][ p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[p.getRow()][ p.getColumn()] = true;
		}
		
		//nl'
		p.setValues(row - 1, column+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[p.getRow()][ p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[p.getRow()][ p.getColumn()] = true;
		}
		

		
		
		
		return pM;
	}
}
