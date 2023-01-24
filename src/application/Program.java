package application;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main (String[] args) {
		
		
		ChessMatch board = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!board.getCheckMate()) {
			try 
			{
				UI.clearScreen(); 
				UI.printMatch(board , captured);
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = board.possibleMoves(source);
				UI.clearScreen(); 
				UI.printBoard(board.getPieces(),possibleMoves);
				
				
				System.out.print("\nTarget: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = board.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if (board.getPromoted() != null)
				{
					System.out.println("Enter piece for promotion (B/N/R/Q):");
					String type = sc.nextLine().toUpperCase();
					while ((!type.equals("B") && !type.equals("N") &&!type.equals("R") && !type.equals("Q")))
					{
						System.out.println("invalid value!Enter piece for promotion (B/N/R/Q)");
						type = sc.nextLine().toUpperCase();
					}
					board.replatedPromotedPiece(type);
				}
				
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
		UI.clearScreen();
		UI.printMatch(board, captured);
	}
	
	
}
