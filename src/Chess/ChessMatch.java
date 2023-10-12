package Chess;

import java.util.ArrayList;
import java.util.List;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardGame.Board;
import boardGame.BoardException;
import boardGame.Piece;
import boardGame.Position;
//				 partida de xadrez
public class ChessMatch {
	private Board board;
	private int turn;
	private Color currentyPlayer;
	private List<Piece> piecesOnTheBoard =new ArrayList<>();
	private List<Piece> capturedPieces =new ArrayList<>();
	
	//------------------ construtor padrão -------------
	public ChessMatch() {
		board = new Board(8, 8);//cria um tabuleiro 8x8
		turn =1;
		currentyPlayer = Color.WHITE;
		initialSetup();
	}
//---------------------------
	public int getTurn() {
		return turn;
	}
	public Color getCurrentyPlayer() {
		return currentyPlayer;
	}
	
// funçao getPiece(), ela retorna um result do tipo ChessPiece[][]	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows();i++) {
			for(int j=0;j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j);			}
		
		}
	return mat;//retorna uma matriz 
	}
	
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();//transforma em posição de matriz
		validateSourcePosition(position);
		return board.piece(position).possibleMoves(); 
	}
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition)
	{	Position source = sourcePosition.toPosition();//transforma posição xadrez em posiçao matriz
		Position target= targetPosition.toPosition();
		validateSourcePosition(source);//faz teste e se der erro lança exceçao
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		nextTurn();
		return (ChessPiece) capturedPiece;
		
		}//ChessPiece eh subclasse de Piece
//---------funçoes private------------------------------	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		if(capturedPiece !=null) {
			piecesOnTheBoard.remove(capturedPiece);//remove na list a peça
			capturedPieces.add(capturedPiece);//add na list a peça
		}
		return capturedPiece;
	}
//				sub funçoes privadas 	
	private void validateSourcePosition(Position position) {
//não pode mover a peça do inimigo		
		
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}		
		if(!board.piece(position).isTheAnyPossibleMove()) {
					throw new ChessException("There is no possible moves for the chosen piece");
		}
		if(currentyPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("Is Not possible move counter part");
		}
	}
	private void validateTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
//caso não houver peça na position source lança Exception	
	private void validateSourcePosition2(Position position) {
		if(board.piece(position)==null) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentyPlayer = (currentyPlayer == Color.WHITE) ? Color.BLACK: Color.WHITE;
	}
	/*funçao para add uma piece na matriz board*/
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	piecesOnTheBoard.add(piece);
		}
	
		
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));
        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
        placeNewPiece('d', 5, new King(board, Color.BLACK));
	}
	
}
