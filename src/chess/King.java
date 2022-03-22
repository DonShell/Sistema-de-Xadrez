package chess;

import boardgame.Board;

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

	@Override
	public boolean[][] possibleMovies() {
		boolean[][] possibleMovies = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return possibleMovies;
	}
}
