package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: The number of columns or rows, can't smaller than 1.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece getPiece(int row, int column )
	{ 
		if(!positionExists(row,column)) {
			throw new BoardException("Error at get piece: Position outside the board.");
		}
		return pieces[row][column];
	}
	public Piece getPiece(Position position)
	{ 
		return getPiece(position.getRow(), position. getColumn());
	}
	
	
	public void placePiece( Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Error when plece piece: In this position there is already a piece");
		}
		
		pieces[position.getRow()][position.getColumn()] = piece; 
		piece.position = position;
	}
	private boolean positionExists(int row, int column) 
	{
		return row >= 0 && row < rows && column >= 0 && column < columns; 
	}

	public boolean positionExists(Position position) 
	{
		return positionExists( position.getRow(), position.getColumn() ); 
	}

	public boolean thereIsAPiece(Position position) {
		
		if (!positionExists(position)) {
			throw new BoardException("Error at get piece: Position outside the board.");
		}
		
		return getPiece(position) != null;
	}
	public Piece removePiece(Position position) {

		if(thereIsAPiece(position)) {
			Piece piece = pieces[position.getRow()][position.getColumn()];
			piece.position = null;
			pieces[position.getRow()][position.getColumn()] = null;
			return piece;
		}
		else 
		{
			return null;
		}
		
		
	}
}
