package Chess;

import boardGame.Position;
/*ChessPosition é uma classe só p/ receber a posição no formato xadrez pelo usuario
e usa a funçao toPosition() p/ um endereço valido na matriz*/ 
public class ChessPosition {
	private char column;
	private int row;
//-----------------------
	public ChessPosition(char column, int row) { //o tabuleiro vai da linha 1 a 8 e de 'a' ate 'h'
		if(column <'a' || column >'h' || row<1 || row>8) {
			throw new ChessException("Erro instantianting ChessPosition. valid values are from a1 to h8.");
					}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}	
	public int getRow() {
		return row;
	}
	// recebe a posição no formato xadrez e retorna a posição na MATRIZ 
	protected Position toPosition(){ 
		return new Position((8-row), (column -'a') );}
	//retorna as posiçoes da matriz no formato xadrez
	protected static ChessPosition fromPosition(Position position) {   
		return new ChessPosition ((char)('a'- position.getColumn()), 8-position.getRow()); }
	
	@Override 
	public String toString() {
		return "" +column+row;
	}
	
	
	
	
	}