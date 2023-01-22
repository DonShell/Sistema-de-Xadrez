package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	private ChessMatch chessMatch;
	public Pawn(Board borad, Color color, ChessMatch chessMatch) {
		super(borad, color);
		this.chessMatch = chessMatch;
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
			
			
			//specialMove en passant white
			if(row == 3)
			{
				Position left = new Position(row, column - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().getPiece(left) == chessMatch.getEnPassantVulnerable())
				{
					pM[left.getRow()-1][left.getColumn()] = true;
				}
				Position right = new Position(row, column + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().getPiece(right) == chessMatch.getEnPassantVulnerable())
				{
					pM[right.getRow()-1][right.getColumn()] = true;
				}
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
			//specialMove en passant black
			if(row == 4)
			{
				Position left = new Position(row, column - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().getPiece(left) == chessMatch.getEnPassantVulnerable())
				{
					pM[left.getRow()+1][left.getColumn()] = true;
				}
				Position right = new Position(row, column + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().getPiece(right) == chessMatch.getEnPassantVulnerable())
				{
					pM[right.getRow()+1][right.getColumn()] = true;
				}
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
