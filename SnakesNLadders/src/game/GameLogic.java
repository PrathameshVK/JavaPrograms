package game;
import java.util.*;

class play{
	static int i;
	static int [] playerPositions;
	
	//hashmap of snake positions on the board
	private static HashMap<Integer,Integer> snakes=new HashMap<Integer,Integer>();
	{
		snakes.put(17, 7);
		snakes.put(54, 34);
		snakes.put(62, 19);
		snakes.put(64, 60);
		snakes.put(87, 36);
		snakes.put(93, 73);
		snakes.put(95, 75);
		snakes.put(98, 79);
	}
	
	//hashmap of ladder positions
	private static HashMap<Integer,Integer> ladders=new HashMap<Integer,Integer>();
	{
		ladders.put(4, 14);
		ladders.put(9, 31);
		ladders.put(20, 38);
		ladders.put(23, 42);
		ladders.put(28, 84);
		ladders.put(51, 67);
		ladders.put(80, 99);
		ladders.put(72, 91);
	}
	
	/**
	 * snakes and ladder game board
	 */
	void gameBoard(String playerNames[]) {
		boolean winner=false;
		int winnerPosition=0;
		play.i=playerNames.length;
		play.playerPositions=new int[i];
		for(int i=0;i<playerNames.length;i++) {
			play.playerPositions[i]=0;
		}
		while(winner==false) {
			for(int k=0; k<playerNames.length;k++) {
				System.out.println("-".repeat(50));
				System.out.print(playerNames[k]+" turn\nr\\R roll dice\nc\\C go back>>");
				try {
					this.diceRolling(k,playerNames[k]);
					if(play.playerPositions[k]==100) {
						winnerPosition=k;
						winner=true;
						break;
					}
				}catch(Exception e) {
					System.out.println(e);
					this.diceRolling(k,playerNames[k]);
				}
			}
		}
		System.out.println("*".repeat(50));
		System.out.println(playerNames[winnerPosition]+" won !");
		play.playerPositions=new int[4];
		System.out.println("Returning to main menu...");
		MainMenu.mainMenu();
	}
	
	/**
	 * method for setting player positions
	 * gets current position after dice roll
	 * adds dice result with current position
	 * checks if snake or ladder is present at new position
	 * returns new position accordingly
	 * @param currentPosition
	 * @param diceResult
	 * @return new player position
	 */
	int setPosition(int currentPosition,int diceResult) {
		int playerPosition=currentPosition;
		if(currentPosition+diceResult<=100) {
			if(this.isLadder(currentPosition+diceResult)) {
				Graphics.graphics(8);
				System.out.println("\nThere is a ladder here !");
				playerPosition=play.ladders.get(currentPosition+diceResult);
			}else if(this.isSnake(currentPosition+diceResult)) {
				Graphics.graphics(7);
				System.out.println("\nThere is a snake here !");
				playerPosition=play.snakes.get(currentPosition+diceResult);
			}else {
				playerPosition=currentPosition+diceResult;
			}
		}else {
			if(this.isLadder(100-((currentPosition+diceResult)-100))) {
				Graphics.graphics(8);
				System.out.println("\nThere is a ladder here !");
				playerPosition=ladders.get(100-((currentPosition+diceResult)-100));
			}else if(this.isSnake(100-((currentPosition+diceResult)-100))) {
				Graphics.graphics(7);
				System.out.println("\nThere is a snake here !");
				playerPosition=snakes.get(100-((currentPosition+diceResult)-100));
			}else {
				playerPosition=100-((currentPosition+diceResult)-100);
			}
		}
		return playerPosition;
	}
	
	/**
	 * method to check if ladder is present at current player position
	 * this method will be called after each dice roll
	 * @param playerPosition
	 */
	boolean isLadder(int playerPosition) {
		boolean ladder=false;
		if(ladders.containsKey(playerPosition)) {
			ladder=true;
		}
		return ladder;
	}
	
	/**
	 * method to check if snake is present at current player position
	 * this method will be called after each dice roll
	 * @param playerPosition
	 */
	boolean isSnake(int playerPosition) {
		boolean snake=false;
		if(snakes.containsKey(playerPosition)) {
			snake=true;
		}
		return snake;
	}
	
	/**
	 * method for rolling the dice
	 * @param i
	 * @return
	 */
	void diceRolling(int i,String playerName) {
		Scanner in=new Scanner(System.in);
		String command=in.next();
		if(command.equals("r") || command.equals("R")) {
			int diceResult=this.dice();
			Graphics.graphics(diceResult);
			play.playerPositions[i]=this.setPosition(play.playerPositions[i], diceResult);
			System.out.println(playerName+" position = "+play.playerPositions[i]);
		}else if(command.equals("c") || command.equals("C")){
			System.out.print("Are you sure ? (y/n)>>");
			String opt=in.next();
			if(opt.equals("y") || opt.equals("Y")) {
				MainMenu.mainMenu();
			}else {
				System.out.print("r\\R roll dice\nc\\C go back>>");
				this.diceRolling(i, playerName);
			}
		}else {
			System.out.print("Please enter proper command>>");
			this.diceRolling(i, playerName);
		}
	}
	
	/**
	 * method for dice simulation
	 * @return dice result (from 1 to 6)
	 */
	int dice() {
		int diceResult=1;
		Random random=new Random();
		System.out.println("Rolling dice...");
		diceResult=random.nextInt(6)+1;
		return diceResult;
	}
	
}

public class GameLogic {
	public static void gameLogic(String arr[],int num) {
		String playerNames[]=new String[num];
		for(int i=0;i<arr.length;i++) {
			playerNames[i]=arr[i];
		}
		play play=new play();
		play.gameBoard(playerNames);
	}
}
