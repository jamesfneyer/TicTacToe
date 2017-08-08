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
		setPlayedSpace(i,"x");
	}
	public static void setPlayerMoves(int i){
		playerMoves.add(i);
		setSpacestoPlay(i);
		setPlayedSpace(i,"o");
	}
	
	public static ArrayList<Integer> getSpacestoPlay() {
		return spacestoPlay;
	}
	public static void setSpacestoPlay(int i) {
		spacestoPlay.add(i);
	}

	public static void setPlayedSpace(int i, String p) {
		switch(i){
		case 0:
		case 3:
			board[i]="_"+p+"_";
			break;
		case 1:
		case 2:
		case 4:
		case 5:
			board[i]="|_"+p+"_";
			break;
		case 6:
			board[i]=" "+p+" ";
			break;
		case 7:
		case 8:
			board[i]="| "+p+" ";
			break;
		default:
			break;
		}
	}
	public static void generateBoard(){
	board[0] = "_0_";
	board[1] = "|_1_";
	board[2] = "|_2_";
	board[3] = "_3_";
	board[4] = "|_4_";
	board[5] = "|_5_";
	board[6] = " 6 ";
	board[7] = "| 7 ";
	board[8] = "| 8 ";
	spacestoPlay.clear();
	computerMoves.clear();
	playerMoves.clear();
	}
	public static String[] getBoard(){
		return board;
	}
	
}
