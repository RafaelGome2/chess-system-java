package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

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
		Position p = new Position(0, 0);
		//above
		p.setValue(p.getRow()-1, p.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
		p.setRow(p.getRow()-1);}//dimunui 1 linha da linha atual
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		//below 
		p.setValue(p.getRow()+1, p.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;//marca de true este elemento
			p.setRow(p.getRow()+1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca de true este elemento
		}
		//left
		p.setValue(p.getRow(), p.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
		p.setColumn(p.getColumn()-1);}//diminui 1 linha da coluna atual
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//right 
		p.setValue(p.getRow(), p.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
		p.setColumn(p.getColumn()+1);}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca de true este elemento da matriz
		}
		
		
		return mat;
	}
	

}
