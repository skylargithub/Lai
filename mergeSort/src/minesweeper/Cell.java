package minesweeper;

public class Cell {
	
	public int number;
	//true is exposed, otherwise false
	// 0 means blank
	// 1-9 surronded bomb
	// -1 bomb
	public boolean exposed;
	//true is flagged, otherwise false
	public boolean flag;
	//screen value;
	//public String displayedValue;

	public boolean isBomb() {
		return true;
	}
	public Cell(int number) {
		this.number = number;
	}
	
	public String screenValue() {
		return null;
	}
}
