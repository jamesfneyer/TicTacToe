package baseGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Validator {
	public static String getValidDifficulty(Scanner sc, String prompt){
		String d = "";
		boolean isValid = false;
		while(!isValid){
			System.out.print(prompt);
			d = sc.next();
			isValid = d.equals("possible")||d.equals("random")||d.equals("impossible");
			if(!isValid) System.out.println("Invalid Difficulty.");
		}		
		return d;
	}
	public static int getPlay(Scanner sc, String prompt, ArrayList<Integer> ints){
		int move = -1;
		boolean isValid = false;
		while(!isValid){
			System.out.print(prompt);
			if(sc.hasNextInt()){
				move = sc.nextInt();
				if(ints.contains(move)){
					System.out.println("Error! Invalid move. Space occupied.");
				} else if(move >= 0 && move < 9) isValid = true;
				else System.out.println("Error! Invalid move. Must be between 0-8");
			}
			else{
				System.out.println("Error! Must be an integer between 0-8.");
			}
			sc.nextLine();
		}	
		return move;
	}
	public static boolean getPlayAgain(Scanner sc, String prompt) {
		String d = "";
		boolean isValid = false;
		while(!isValid){
			System.out.print(prompt);
			d = sc.next();
			isValid = d.equals("n")||d.equals("y")||d.equals("yes")||d.equals("no");
			if(!isValid) System.out.println("Invalid answer.");
		}
		return d.equals("y")||d.equals("yes");
	}
}
