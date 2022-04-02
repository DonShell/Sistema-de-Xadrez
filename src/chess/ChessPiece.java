package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	private Color color;

	public ChessPiece(Board borad, Color color) {
		super(borad);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position)
	{
		ChessPiece p = (ChessPiece) getBoard().getPiece(position);
		return p != null && p.getColor() != color;
	}
	
}
