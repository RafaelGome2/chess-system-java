package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;

public class King extends ChessPiece{
//-----------------------------------------------------
	public King(Board board, Color color) {
		super(board, color);
	}
	@Override 
	public String toString() {
		return "K";
	}
	@Override
	public boolean[][] possibleMoves() {//nº de linhas e colunas de mat
/*int[][] a = new int[x][y] --> matriz a de tamanho X e Y				*/		
		boolean[][] mat= new boolean[board.getRows()][board.getColumns()];
				return mat;
	}

}
