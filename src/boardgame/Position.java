package boardgame;

public class Position {
	private int column; // coluna
	private int row; //linha
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public Position(int row, int column) {
		this.column = column;
		this.row = row;
	}
	@Override
	public String toString() {
		return "Position [column=" + column + ", row=" + row + "]";
	}

	public void setValues(int row, int column) {
		this.column = column;
		this.row = row;
	}
	

}
