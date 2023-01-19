package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board borad, Color color) {
		super(borad, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] pM = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		int row = position.getRow();
		int column = position.getColumn();
		
		Position p = new Position(0,0);
		
		
		if(getColor() == Color.WHITE)
		{
			p.setValues(row - 1, column);
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
			{
				pM[p.getRow()][p.getColumn()] = true;
				
				p.setValues(p.getRow() - 1, p.getColumn());
				if(getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
				{
					pM[p.getRow()][p.getColumn()] = true;
				
				}
			}
			p.setValues(row - 1, column-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			{
				pM[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(row - 1, column+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			{
				pM[p.getRow()][p.getColumn()] = true;
			}
		}
		else
		{
			p.setValues(row + 1, column);
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
			{
				pM[p.getRow()][p.getColumn()] = true;
				
				p.setValues(p.getRow() + 1, p.getColumn());
				if(getMoveCount() == 0 && getBoard().positionExists(p) && !getBoard().thereIsAPiece(p))
				{
					pM[p.getRow()][p.getColumn()] = true;
				
				}
			}
			p.setValues(row + 1, column-1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			{
				pM[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(row + 1, column+1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p))
			{
				pM[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return pM;
	}

	@Override
	public String toString()
	{
		return "P";
	}
}
