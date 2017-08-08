package baseGame;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer {
	static String difficulty;
	static String[] board;
	static ArrayList<Integer> spacestoPlay;
	static ArrayList<Integer> computerMoves = new ArrayList<>();;
	static ArrayList<Integer> playerMoves;
	static int move;
	
	public ComputerPlayer(){
		computerMoves = new ArrayList<>();
		difficulty = "";
	}
	public static void clear(){
		computerMoves.clear();
	}
	public String getDifficulty() {
		return difficulty;
	}

	public static void setDifficulty(String d) {
		difficulty = d;
	}
	
	public static void makeAMove(){
		board = GameBoard.getBoard();
		spacestoPlay = GameBoard.getSpacestoPlay();
		playerMoves = GameBoard.getPlayerMoves();
		ArrayList<Integer> moves = new ArrayList<>();
		double j = Math.random();
		if(difficulty.equals("possible")){
			if(playerMoves.size() == 1){
				if(playerMoves.contains(4)){					
					move = (j <.25) ? 1:(j< .5 && j>.25) ? 3 : (j>.5 && j<.75)?5:7;
				}
				else if(playerMoves.contains(0)){
					move = (j>.5) ? 5 : 7;
				}
				else if(playerMoves.contains(2)){
					move = (j>.5) ? 3 : 7;
				}
				else if(playerMoves.contains(6)){
					move = (j>.5) ? 5 : 1;
				}
				else if(playerMoves.contains(8)){
					move = (j>.5) ? 3 : 1;
				}
				else if(playerMoves.contains(1)){
					move = (j>.5) ? 6 : 8;
				}
				else if(playerMoves.contains(3)){
					move = (j>.5) ? 2 : 8;
				}
				else if(playerMoves.contains(5)){
					move = (j>.5) ? 6 : 0;
				}
				else if(playerMoves.contains(7)){
					move = (j>.5) ? 0 : 2;
				}
			}
			if(playerMoves.size() == 2){
				
				move = randomMove(spacestoPlay);
				for(int i=0; i<=6;i+=3){
					if(playerMoves.contains(i)&&playerMoves.contains(i+2))move = i+1;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1))move = i+2;
					else if(playerMoves.contains(i+1)&&playerMoves.contains(i+2))move = i;
				}
				for(int i=0;i<=2;i++){
					if(playerMoves.contains(i)&&playerMoves.contains(i+3))move = i+6;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+6))move=i+3;
					else if(playerMoves.contains(i+3)&&playerMoves.contains(i+6))move = i;
				}
				if(playerMoves.contains(0)&&playerMoves.contains(4)) move = 8;
				else if(playerMoves.contains(0)&&playerMoves.contains(8)) move = 4;
				else if(playerMoves.contains(8)&&playerMoves.contains(4)) move = 0;
				else if(playerMoves.contains(2)&&playerMoves.contains(4)) move = 6;
				else if(playerMoves.contains(2)&&playerMoves.contains(6)) move = 4;
				else if(playerMoves.contains(6)&&playerMoves.contains(4)) move = 2;				
			}
			if(playerMoves.size() == 3){
				move = randomMove(spacestoPlay);
				for(int i=0; i<=6;i+=3){
					if(playerMoves.contains(i)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i+1)))move = i+1;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1)&&(!computerMoves.contains(i+2)))move = i+2;
					else if(playerMoves.contains(i+1)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(playerMoves.contains(i)&&playerMoves.contains(i+3)&&(!computerMoves.contains(i+6)))move = i+6;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i+3)))move=i+3;
					else if(playerMoves.contains(i+3)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i)))move = i;
				}
				if(playerMoves.contains(0)&&playerMoves.contains(4)&&(!computerMoves.contains(8))) move = 8;
				else if(playerMoves.contains(0)&&playerMoves.contains(8)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(8)&&playerMoves.contains(4)&&(!computerMoves.contains(0))) move = 0;
				else if(playerMoves.contains(2)&&playerMoves.contains(4)&&(!computerMoves.contains(6))) move = 6;
				else if(playerMoves.contains(2)&&playerMoves.contains(6)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(6)&&playerMoves.contains(4)&&(!computerMoves.contains(2))) move = 2;

				for(int i=0; i<=6;i+=3){
					if(computerMoves.contains(i)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i+1)))move = i+1;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+1)&&(!playerMoves.contains(i+2)))move = i+2;
					else if(computerMoves.contains(i+1)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(computerMoves.contains(i)&&computerMoves.contains(i+3)&&(!playerMoves.contains(i+6)))move = i+6;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i+3)))move=i+3;
					else if(computerMoves.contains(i+3)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i)))move = i;
				}
				if(computerMoves.contains(0)&&computerMoves.contains(4)&&(!playerMoves.contains(8))) move = 8;
				else if(computerMoves.contains(0)&&computerMoves.contains(8)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(8)&&computerMoves.contains(4)&&(!playerMoves.contains(0))) move = 0;
				else if(computerMoves.contains(2)&&computerMoves.contains(4)&&(!playerMoves.contains(6))) move = 6;
				else if(computerMoves.contains(2)&&computerMoves.contains(6)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(6)&&computerMoves.contains(4)&&(!playerMoves.contains(2))) move = 2;
			}
			if(playerMoves.size() == 4){
				move = randomMove(spacestoPlay);
				for(int i=0; i<=6;i+=3){
					if(playerMoves.contains(i)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i+1)))move = i+1;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1)&&(!computerMoves.contains(i+2)))move = i+2;
					else if(playerMoves.contains(i+1)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(playerMoves.contains(i)&&playerMoves.contains(i+3)&&(!computerMoves.contains(i+6)))move = i+6;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i+3)))move=i+3;
					else if(playerMoves.contains(i+3)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i)))move = i;
				}
				if(playerMoves.contains(0)&&playerMoves.contains(4)&&(!computerMoves.contains(8))) move = 8;
				else if(playerMoves.contains(0)&&playerMoves.contains(8)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(8)&&playerMoves.contains(4)&&(!computerMoves.contains(0))) move = 0;
				else if(playerMoves.contains(2)&&playerMoves.contains(4)&&(!computerMoves.contains(6))) move = 6;
				else if(playerMoves.contains(2)&&playerMoves.contains(6)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(6)&&playerMoves.contains(4)&&(!computerMoves.contains(2))) move = 2;
				
				for(int i=0; i<=6;i+=3){
					if(computerMoves.contains(i)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i+1)))move = i+1;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+1)&&(!playerMoves.contains(i+2)))move = i+2;
					else if(computerMoves.contains(i+1)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(computerMoves.contains(i)&&computerMoves.contains(i+3)&&(!playerMoves.contains(i+6)))move = i+6;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i+3)))move=i+3;
					else if(computerMoves.contains(i+3)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i)))move = i;
				}
				if(computerMoves.contains(0)&&computerMoves.contains(4)&&(!playerMoves.contains(8))) move = 8;
				else if(computerMoves.contains(0)&&computerMoves.contains(8)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(8)&&computerMoves.contains(4)&&(!playerMoves.contains(0))) move = 0;
				else if(computerMoves.contains(2)&&computerMoves.contains(4)&&(!playerMoves.contains(6))) move = 6;
				else if(computerMoves.contains(2)&&computerMoves.contains(6)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(6)&&computerMoves.contains(4)&&(!playerMoves.contains(2))) move = 2;
			}
		}else if(difficulty.equals("random")){
			move = randomMove(spacestoPlay);
		}else if(difficulty.equals("impossible")){
			if(playerMoves.size()==1){
				if(!playerMoves.contains(4)) move = 4;
				else move = 0;
			}
			else if(playerMoves.size()==2){
				for(int i=0; i<=6;i+=3){
					if(playerMoves.contains(i)&&playerMoves.contains(i+2))move = i+1;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1))move = i+2;
					else if(playerMoves.contains(i+1)&&playerMoves.contains(i+2))move = i;
				}
				for(int i=0;i<=2;i++){
					if(playerMoves.contains(i)&&playerMoves.contains(i+3))move = i+6;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+6))move=i+3;
					else if(playerMoves.contains(i+3)&&playerMoves.contains(i+6))move = i;
				}
				if(playerMoves.contains(0)&&playerMoves.contains(4)) move = 8;
				else if(playerMoves.contains(0)&&playerMoves.contains(8)) move = 4;
				else if(playerMoves.contains(8)&&playerMoves.contains(4)&&(!computerMoves.contains(0))) move = 0;
				else if(playerMoves.contains(2)&&playerMoves.contains(4)) move = 6;
				else if(playerMoves.contains(2)&&playerMoves.contains(6)) move = 4;
				else if(playerMoves.contains(6)&&playerMoves.contains(4)) move = 2;	
				else if(move == -1){
					move = (j>.5) ? 2 : 6;
				}
			}
			else if(playerMoves.size()==3){
				for(int i=0; i<=6;i+=3){
					if(playerMoves.contains(i)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i+1)))move = i+1;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1)&&(!computerMoves.contains(i+2)))move = i+2;
					else if(playerMoves.contains(i+1)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(playerMoves.contains(i)&&playerMoves.contains(i+3)&&(!computerMoves.contains(i+6)))move = i+6;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i+3)))move=i+3;
					else if(playerMoves.contains(i+3)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i)))move = i;
				}
				if(playerMoves.contains(0)&&playerMoves.contains(4)&&(!computerMoves.contains(8))) move = 8;
				else if(playerMoves.contains(0)&&playerMoves.contains(8)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(8)&&playerMoves.contains(4)&&(!computerMoves.contains(0))) move = 0;
				else if(playerMoves.contains(2)&&playerMoves.contains(4)&&(!computerMoves.contains(6))) move = 6;
				else if(playerMoves.contains(2)&&playerMoves.contains(6)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(6)&&playerMoves.contains(4)&&(!computerMoves.contains(2))) move = 2;
				
				for(int i=0; i<=6;i+=3){
					if(computerMoves.contains(i)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i+1)))move = i+1;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+1)&&(!playerMoves.contains(i+2)))move = i+2;
					else if(computerMoves.contains(i+1)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(computerMoves.contains(i)&&computerMoves.contains(i+3)&&(!playerMoves.contains(i+6)))move = i+6;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i+3)))move=i+3;
					else if(computerMoves.contains(i+3)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i)))move = i;
				}
				if(computerMoves.contains(0)&&computerMoves.contains(4)&&(!playerMoves.contains(8))) move = 8;
				else if(computerMoves.contains(0)&&computerMoves.contains(8)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(8)&&computerMoves.contains(4)&&(!playerMoves.contains(0))) move = 0;
				else if(computerMoves.contains(2)&&computerMoves.contains(4)&&(!playerMoves.contains(6))) move = 6;
				else if(computerMoves.contains(2)&&computerMoves.contains(6)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(6)&&computerMoves.contains(4)&&(!playerMoves.contains(2))) move = 2;
				else if(move == -1){
					move = randomMove(spacestoPlay);
				}

			}
			if(playerMoves.size() == 4){
				for(int i=0; i<=6;i+=3){
					if(playerMoves.contains(i)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i+1)))move = i+1;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+1)&&(!computerMoves.contains(i+2)))move = i+2;
					else if(playerMoves.contains(i+1)&&playerMoves.contains(i+2)&&(!computerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(playerMoves.contains(i)&&playerMoves.contains(i+3)&&(!computerMoves.contains(i+6)))move = i+6;
					else if(playerMoves.contains(i)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i+3)))move=i+3;
					else if(playerMoves.contains(i+3)&&playerMoves.contains(i+6)&&(!computerMoves.contains(i)))move = i;
				}
				if(playerMoves.contains(0)&&playerMoves.contains(4)&&(!computerMoves.contains(8))) move = 8;
				else if(playerMoves.contains(0)&&playerMoves.contains(8)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(8)&&playerMoves.contains(4)&&(!computerMoves.contains(0))) move = 0;
				else if(playerMoves.contains(2)&&playerMoves.contains(4)&&(!computerMoves.contains(6))) move = 6;
				else if(playerMoves.contains(2)&&playerMoves.contains(6)&&(!computerMoves.contains(4))) move = 4;
				else if(playerMoves.contains(6)&&playerMoves.contains(4)&&(!computerMoves.contains(2))) move = 2;
				
				for(int i=0; i<=6;i+=3){
					if(computerMoves.contains(i)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i+1)))move = i+1;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+1)&&(!playerMoves.contains(i+2)))move = i+2;
					else if(computerMoves.contains(i+1)&&computerMoves.contains(i+2)&&(!playerMoves.contains(i)))move = i;
				}
				for(int i=0;i<=2;i++){
					if(computerMoves.contains(i)&&computerMoves.contains(i+3)&&(!playerMoves.contains(i+6)))move = i+6;
					else if(computerMoves.contains(i)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i+3)))move=i+3;
					else if(computerMoves.contains(i+3)&&computerMoves.contains(i+6)&&(!playerMoves.contains(i)))move = i;
				}
				if(computerMoves.contains(0)&&computerMoves.contains(4)&&(!playerMoves.contains(8))) move = 8;
				else if(computerMoves.contains(0)&&computerMoves.contains(8)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(8)&&computerMoves.contains(4)&&(!playerMoves.contains(0))) move = 0;
				else if(computerMoves.contains(2)&&computerMoves.contains(4)&&(!playerMoves.contains(6))) move = 6;
				else if(computerMoves.contains(2)&&computerMoves.contains(6)&&(!playerMoves.contains(4))) move = 4;
				else if(computerMoves.contains(6)&&computerMoves.contains(4)&&(!playerMoves.contains(2))) move = 2;
				else if(move == -1){
					move = randomMove(spacestoPlay);
				}
			}
			
		}
		computerMoves.add(move);
		GameBoard.setComputerMoves(move);
		move = -1;
	}
	private static int randomMove(ArrayList<Integer> spacestoPlay){
		ArrayList<Integer> moves = new ArrayList<>();
		int randomNum = 0;
		for(int i=0;i<9;i++){
			if(!spacestoPlay.contains(i))moves.add(i);
		}
		boolean isValid = false;
		while(!isValid){
			randomNum = ThreadLocalRandom.current().nextInt(0,9);
			isValid = moves.contains(randomNum);
		}
		return randomNum;		
	}
}
