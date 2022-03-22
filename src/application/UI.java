package application;

import chess.ChessPiece;
import chess.Color;

public class UI {
	

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	//{
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_WHITE_BOLD_BRIGHT = "\033[1;97m"; //White piece

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	//}
	
	public static void printBoard (ChessPiece[][] pieces)
	{	
		System.out.println(ANSI_BLACK_BACKGROUND + "\n\n       T A B U L E I R O :      " );
		System.out.println( "  " + ANSI_BLUE_BACKGROUND + "                            " + ANSI_BLACK_BACKGROUND);
		for( int r = 0 ; r < pieces.length ; r ++) 
		{
			System.out.print( "  " + ANSI_BLUE_BACKGROUND + ANSI_WHITE + (8 -r) + " ");
			for( int c = 0 ; c < pieces[r].length ; c ++) 
			{
				//Color position table
				System.out.print( (((r % 2) + c) % 2 == 0) ? ANSI_YELLOW_BACKGROUND : ANSI_PURPLE_BACKGROUND);
				printPiece(pieces[r][c]);
			}
			System.out.print(ANSI_BLUE_BACKGROUND + "  " + ANSI_BLACK_BACKGROUND + "\n");
		}
		System.out.println( "  " + ANSI_BLUE_BACKGROUND + ANSI_WHITE + "   a  b  c  d  e  f  g  h   " + ANSI_RESET + ANSI_BLACK_BACKGROUND + "\n");
	}
	
	
	private static void printPiece(ChessPiece piece) {

		System.out.print(" ");
		if (piece == null) {
			System.out.print(" ");
		} 
		else
		{
			if(piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE_BOLD_BRIGHT);
			} 
			else
			{
				System.out.print(ANSI_BLACK);
			}
			System.out.print(piece);
		}
		System.out.print(" " + ANSI_RESET);
	}
	
}
