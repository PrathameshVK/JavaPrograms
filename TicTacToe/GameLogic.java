package game;

import java.util.Scanner;//pack

class play{
	
	static String winner="Nobody"; //stores name of winner, if any.
	static String [] playerNames; //stores names of players
	static String [][] ticTacToeTable; //Imitation of tic tac toe table
	
	void gamePlay(String[] playerNames) {
		this.setNewGame();
		boolean winner=false;
		for(int i=0;i<5;i++) {
			if(winner==false) {
				for(int j=0;j<2;j++) {
					if(this.checkIfWinner()==true) {
						break;
					}
					if(this.isEmpty()==false) {
						break;
					}
					System.out.println("*".repeat(47));
					Graphics.graphics(ticTacToeTable);
					System.out.println("*".repeat(47));
					System.out.println(playerNames[j]+"'s turn>>");
					this.takeInput(j==0?"x":"o");
					winner=this.checkIfWinner();
				}
			}else {
				break;
			}
		}
		System.out.println("*".repeat(47));
		Graphics.graphics(ticTacToeTable);
		System.out.println("*".repeat(47));
		System.out.println(play.winner+" won this match !");
		System.out.println("*".repeat(50));
		this.playAgain();
	}
	
	/**
	 * check if there is empty space available in the table
	 * @return true or false
	 */
	boolean isEmpty() {
		boolean emptySpaceAvailable=false;
		for(String space[]: play.ticTacToeTable) {
			for(int i=0;i<3;i++) {
				if(space[i]==" ") {
					emptySpaceAvailable=true;
					break;
				}
			}
		}
		return emptySpaceAvailable;
	}
	
	/**
	 * play again with current players or quit
	 */
	void playAgain() {
		String choice;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		try {
			System.out.print("Play again ? (y/n)>>");
			choice=in.next();
			if(choice.equals("y") || choice.equals("Y")) {
				System.out.println("Setting new board...");
				this.gamePlay(playerNames);
			}else if(choice.equals("n") || choice.equals("N")){
				System.out.println("Returning to main menu...");
				System.out.println("*".repeat(50));
				MainMenu.mainMenu();
			}else {
				System.out.println("-".repeat(50));
				System.out.println("Enter correct option !");
				System.out.println("-".repeat(50));
				this.playAgain();
			}
		}catch(Exception e){
			System.out.println("That's not a valid input");
			this.playAgain();
		}
	}
	
	/**
	 * set and initialize new board with empty spaces
	 */
	void setNewGame() {
		ticTacToeTable=new String [3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticTacToeTable[i][j]=" ";
			}
		}
	}
	
	/**
	 * method to take inputs for row and column
	 * @param symbol (x or o)
	 */
	void takeInput(String symbol) {
		int row=0,column=0;
		try {
			row=this.takeRow();
			column=this.takeColumn();
		}catch(Exception e) {
			this.takeInput(symbol);
		}
		this.setInput(row-1, column-1, symbol);
	}
	
	/**
	 * method to take input for row
	 * @return row number
	 */
	int takeRow() {
		int row=0;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("-".repeat(50));
		System.out.print("Enter row number>>");
		try {
			row=in.nextInt();
		}catch(Exception e) {
			System.out.println("-".repeat(50));
			System.out.println("That's not a valid input row");
			this.takeRow();
		}
		return row;
	}
	
	/**
	 * method to take input for column
	 * @return column number
	 */
	int takeColumn() {
		int column=0;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("-".repeat(50));
		System.out.print("Enter column number>>");
		try {
			column=in.nextInt();
		}catch(Exception e) {
			System.out.println("-".repeat(50));
			System.out.println("That's not a valid input column");
			this.takeColumn();
		}
		return column;
	}
	
	/**
	 * upon successfully taking row and column values, set the current symbol at that position in the table array.
	 * @param row
	 * @param column
	 * @param symbol (x or o)
	 */
	void setInput(int row, int column, String symbol) {
		try {
			if(ticTacToeTable[row][column]==" ") {
				ticTacToeTable[row][column]=symbol;
			}else {
				System.out.println("-".repeat(50));
				System.out.println("That position is already filled !");
				this.takeInput(symbol);
			}
		}catch(Exception e) {
			System.out.println("-".repeat(50));
			System.out.println("That's not a valid position");
			this.takeInput(symbol);
		}
	}
	
	/**
	 * if there is a winner, set the player name with current symbol as winnerName
	 * @param symbol (x or o)
	 */
	static void setWinnerName(String symbol) {
		if(symbol=="x") {
			winner=playerNames[0];
		}else {
			winner=playerNames[1];
		}
	}
	
	/**
	 * the winning conditions of the game.
	 * this method is called after each move to check if there is any winning condition satisfied
	 * calls setWinnerName method if the winning condition is satisfied to set the current player name as winnerName
	 * @return true or false
	 */
	boolean checkIfWinner() {
		boolean winner=false;
		//check for rows
		if(ticTacToeTable[0][0]!=" " && ticTacToeTable[0][0]==ticTacToeTable[0][1] && ticTacToeTable[0][0]==ticTacToeTable[0][2]) {
			play.setWinnerName(ticTacToeTable[0][0]);
			winner=true;
		}else if(ticTacToeTable[1][0]!=" " && ticTacToeTable[1][0]==ticTacToeTable[1][1] && ticTacToeTable[1][0]==ticTacToeTable[1][2]) {
			play.setWinnerName(ticTacToeTable[1][0]);
			winner=true;
		}else if(ticTacToeTable[2][0]!=" " && ticTacToeTable[2][0]==ticTacToeTable[2][1] && ticTacToeTable[2][0]==ticTacToeTable[2][2]) {
			play.setWinnerName(ticTacToeTable[2][0]);
			winner=true;
		}
		//check for diagonal positions
		else if(ticTacToeTable[0][0]!=" " && ticTacToeTable[0][0]==ticTacToeTable[1][1] && ticTacToeTable[0][0]==ticTacToeTable[2][2]) {
			play.setWinnerName(ticTacToeTable[0][0]);
			winner=true;
		}else if(ticTacToeTable[0][2]!=" " && ticTacToeTable[0][2]==ticTacToeTable[1][1] && ticTacToeTable[0][2]==ticTacToeTable[2][0]) {
			play.setWinnerName(ticTacToeTable[0][2]);
			winner=true;
		}
		//check for columns
		else if(ticTacToeTable[0][0]!=" " && ticTacToeTable[0][0]==ticTacToeTable[1][0] && ticTacToeTable[0][0]==ticTacToeTable[2][0]) {
			play.setWinnerName(ticTacToeTable[0][0]);
			winner=true;
		}else if(ticTacToeTable[0][1]!=" " && ticTacToeTable[0][1]==ticTacToeTable[1][1] && ticTacToeTable[0][1]==ticTacToeTable[2][1]) {
			play.setWinnerName(ticTacToeTable[0][1]);
			winner=true;
		}else if(ticTacToeTable[0][2]!=" " && ticTacToeTable[0][2]==ticTacToeTable[1][2] && ticTacToeTable[0][2]==ticTacToeTable[2][2]) {
			play.setWinnerName(ticTacToeTable[0][2]);
			winner=true;
		}
		return winner;
	}
}

public class GameLogic {
	public static void gameLogic(String[] playerNames) {
		play.playerNames=new String[2];
		for(int i=0;i<2;i++) {
			play.playerNames[i]=playerNames[i];
		}
		play play=new play();
		play.gamePlay(playerNames);
	}
}
