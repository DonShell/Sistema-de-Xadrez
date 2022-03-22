package application;

import boardgame.Board;
import chess.ChessMatch;

public class Program {
	public static void main (String[] args) {
		ChessMatch board = new ChessMatch();
		UI.printBoard(board.getPieces());
	}
}
