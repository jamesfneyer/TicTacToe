package baseGame;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean playAgain = true;
		boolean gameOver = false;
		String gameOutcome = "";
		int move = 0;
		String[] board;
		ArrayList<Integer> playerMoves = new ArrayList<>();
		while(playAgain){
			ComputerPlayer.setDifficulty(Validator.getValidDifficulty(sc, "Select Difficulty for computer: (possible, random, impossible)"));
			GameBoard.generateBoard();
			board = GameBoard.getBoard();
			while(!gameOver){
			for(int i = 0; i< board.length;i++){				
				System.out.print(board[i]);
				if((i+1)%3 == 0) System.out.println("\n");
			}
			move = Validator.getPlay(sc, "Enter valid move: ", GameBoard.getSpacestoPlay());
			GameBoard.setPlayerMoves(move);
			playerMoves.add(move);
			ComputerPlayer.makeAMove();
			
			if(GameBoard.getComputerMoves().size()>=3){
				System.out.println(GameBoard.getSpacestoPlay().size());
				for(int i=0;i<3;i++){
					if(GameBoard.getComputerMoves().contains(i)&&GameBoard.getComputerMoves().contains(i+3)&&GameBoard.getComputerMoves().contains(i+6)) {
						gameOver = true;
						gameOutcome = "You lose!";
					}
					else if(playerMoves.contains(i)&&playerMoves.contains(i+3)&&playerMoves.contains(i+6)){
						gameOver = true;
						gameOutcome = "You win!";
					}
				}
				for(int i=0;i<9;i+=3){
					if(GameBoard.getComputerMoves().contains(i)&&GameBoard.getComputerMoves().contains(i+1)&&GameBoard.getComputerMoves().contains(i+2)){
						gameOutcome = "You lose!";
						gameOver = true;
					}
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1)&&playerMoves.contains(i+2)){
						gameOver = true;
						gameOutcome = "You win!";
					}
				}
				
				if(GameBoard.getComputerMoves().contains(0)&&GameBoard.getComputerMoves().contains(4)&&GameBoard.getComputerMoves().contains(8)){
					gameOver = true;
					gameOutcome = "You lose!";
				}
				else if(playerMoves.contains(0)&&playerMoves.contains(4)&&playerMoves.contains(8)){
					gameOver = true;
					gameOutcome = "You win!";
				}
				if(GameBoard.getComputerMoves().contains(2)&&GameBoard.getComputerMoves().contains(4)&&GameBoard.getComputerMoves().contains(6)){
					gameOutcome = "You lose!";
					gameOver = true;
				}
				else if(playerMoves.contains(2)&&playerMoves.contains(4)&&playerMoves.contains(6)){
					gameOver = true;
					gameOutcome = "You win!";
				}
				if(GameBoard.getSpacestoPlay().size()==10){
					gameOver= true;
					gameOutcome = "You tie!";
				}
			}
			}
			System.out.println(gameOutcome);
			for(int i = 0; i< board.length;i++){				
				System.out.print(board[i]);
				if((i+1)%3 == 0) System.out.println("\n");
			}
			playAgain = Validator.getPlayAgain(sc, "Would you like to play again?");
			playerMoves.clear();
			ComputerPlayer.clear();
			gameOver = false;
		}

	}

}
