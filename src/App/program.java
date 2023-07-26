package App;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.pieces.Rook;
import boardGame.Board;
import boardGame.Position;
import Chess.Color;

public class program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		
	UI.printBoard(chessMatch.getPieces());
		
		
	}

}
