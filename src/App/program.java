package App;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPosition;
import boardGame.BoardException;

public class program {
	
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		
		

		while(true) {
		try{//tratando as exceçoes
		UI.clearScreen();
		UI.printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.print("source: ");//se não tiver peça no source deve lançar exceção
		ChessPosition source = UI.readChessPosition(sc);
		boolean[][] possibleMoves = chessMatch.possibleMoves(source);
		UI.clearScreen();
		UI.printBoard(chessMatch.getPieces(), possibleMoves);
		System.out.println();
		System.out.print("target: ");
		ChessPosition target = UI.readChessPosition(sc);
		//aqui faz o movimento no tabuleiro, agora só falta imprimir
		chessMatch.performChessMove(source, target);
		}
	
	catch (ChessException e) {
		System.out.println(e.getMessage());
		sc.nextLine();
	}
	catch (InputMismatchException e) {
		System.out.println(e.getMessage());
	sc.nextLine();
	}
		}
		
			}
}
	


