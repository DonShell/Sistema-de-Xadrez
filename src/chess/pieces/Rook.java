package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board borad, Color color) {
		super(borad, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] pM = new boolean[getBoard().getRows()][getBoard().getColumns()];
	
		int row = position.getRow();
		int column = position.getColumn();
		
			
	
		Position p = new Position(row,column);
		
		
		p.setValues(row - 1, column);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[p.getRow()][column] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[p.getRow()][column] = true;
		}
		
		
		p.setValues(row + 1, column);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[p.getRow()][column] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[p.getRow()][column] = true;
		}
		
		
		p.setValues(row, column + 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[row][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[row][p.getColumn()] = true;
		}
		
		

		p.setValues(row, column - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			pM[row][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p))
		{
			pM[row][p.getColumn()] = true;
		}
		
		
		
		return pM;
	}

}
