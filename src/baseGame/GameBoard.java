package baseGame;

import java.util.ArrayList;

public class GameBoard {
	static String[] board= new String[9];
	static ArrayList<Integer> spacestoPlay= new ArrayList<>();
	static ArrayList<Integer> computerMoves= new ArrayList<>();
	static ArrayList<Integer> playerMoves= new ArrayList<>();
	
	public GameBoard(){
		board = new String[9];
		spacestoPlay = new ArrayList<>();
		computerMoves = new ArrayList<>();
		playerMoves = new ArrayList<>();
	}
	
	public static ArrayList<Integer> getComputerMoves() {
		return computerMoves;
	}
	public static ArrayList<Integer> getPlayerMoves() {
		return playerMoves;
	}
	
	public static void setComputerMoves(int i){
		computerMoves.add(i);
		setSpacestoPlay(i);
		setPlayedSpace(i,"X");
	}
	public static void setPlayerMoves(int i){
		playerMoves.add(i);
		setSpacestoPlay(i);
		setPlayedSpace(i,"O");
	}
	
	public static ArrayList<Integer> getSpacestoPlay() {
		return spacestoPlay;
	}
	public static void setSpacestoPlay(int i) {
		spacestoPlay.add(i);
	}

	public static void setPlayedSpace(int i, String p) {
			board[i]=" "+p+" ";
	}
	public static void generateBoard(){
	board[0] = " 0 ";
	board[1] = " 1 ";
	board[2] = " 2 ";
	board[3] = " 3 ";
	board[4] = " 4 ";
	board[5] = " 5 ";
	board[6] = " 6 ";
	board[7] = " 7 ";
	board[8] = " 8 ";
	spacestoPlay.clear();
	computerMoves.clear();
	playerMoves.clear();
	}
	public static String[] getBoard(){
		return board;
	}
	
}
