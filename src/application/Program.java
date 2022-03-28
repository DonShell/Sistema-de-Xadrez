package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main (String[] args) {
		ChessMatch board = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			try 
			{
				UI.clearScreen(); 
				UI.printBoard(board.getPieces());
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = board.possibleMoves(source);
				UI.clearScreen(); 
				UI.printBoard(board.getPieces(),possibleMoves);
				
				
				System.out.print("\nTarget: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = board.performChessMove(source, target);
				
				System.out.println(capturedPiece);
			}
			catch (ChessException e )
			{
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e )
			{
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
	
	
}
