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
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(7,2));
		board.placePiece(new King(board, Color.BLACK), new Position(0,2));
	}
	
}
