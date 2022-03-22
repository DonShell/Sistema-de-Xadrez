package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main (String[] args) {
		ChessMatch board = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			UI.printBoard(board.getPieces());
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			System.out.print("\nTarget: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = board.performChessMove(source, target);
			
			System.out.println(capturedPiece);
		}
	}
}
