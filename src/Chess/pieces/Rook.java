package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;

public class Rook extends ChessPiece {
	
	
//----------------------------------------------------
	public Rook(Board board, Color color) {
		super(board, color);
//-----------------------------------------		
	}
	
	@Override 
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[board.getRows()][board.getColumns()];
				return mat;
	}
	

}
