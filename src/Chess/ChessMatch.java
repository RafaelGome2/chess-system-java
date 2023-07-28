package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardGame.Board;
import boardGame.Position;
//				 partida de xadrez
public class ChessMatch {
	private Board board;

	//-------------------construtor padrão
	public ChessMatch() {
		board = new Board(8, 8);//cria um tabuleiro 8x8
		initialSetup();
	}
//---------------------------
// funçao getPiece(), ela retorna um result do tipo ChessPiece[][]	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows();i++) {
			for(int j=0;j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j);			}
		
		}
	return mat;
	}
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('a', 1, new Rook(board, Color.BLACK));
		//board.placePiece(new King(board, Color.WHITE), new Position(0,0));
	}
	
}
