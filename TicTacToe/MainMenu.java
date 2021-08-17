package game;

import java.util.Scanner;

class menu{
	
	static String[] playerNames=new String[2];
	
	void display() {
		int choice=0;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		while(choice!=3) {
			System.out.println("*".repeat(67));
			game.draw.header();
			System.out.println("*".repeat(67));
			System.out.println("1.Play\n2.Help\n3.About\n4.Exit");
			try {
				System.out.print("-".repeat(67)+"\n>>");
				choice=in.nextInt();
			}catch(Exception e) {
				System.out.println("*".repeat(67));
				System.out.println("Enter correct option !");
				this.display();
			}
			
			switch(choice) {

				case 1:
					
					this.playGame();
					break;
					
				case 2:
					
					System.out.println();
					System.out.println("+".repeat(67));
					System.out.println("This is a CLI TicTacToe game.\n"
							+ "In case you don't know what a TicTacToe game is, go search on google.\n"
							+ "I am not wasting my time here typing the game description.\n"
							+ "-".repeat(67)
							+ "\nSome general commands : \n"
							+ "+ Whenever you are required to give an input,\n"
							+ "all the valid inputs will be displayed at that point.\n"
							+ "+ Hope you enjoy this simple boring CLI TicTacToe game at this era"
							+ " of games with high end graphics.\n"
							+ "-".repeat(67)
							+ "\nIMPORTANT\n"
							+ "Don't go on typing anything like you are out of this world\n"
							+ "It may crash the game.\n"
							+ "Remember, this is a super simple CLI TicTacToe game.\n"
							+ "not some super smart AI that would interpret your gibbrish."
							);
					System.out.println("+".repeat(67));
					this.display();
				
				case 3:
					System.out.println(">>".repeat(25));
					System.out.println("Prathamesh Vijay Kulkarni\n"
							+ "Yeah, that's me"
							+ "\nwho invested too much time to program this\n"
							+ "boring CLI TicTacToe game\n"
							+ "to include in his resume and show off to recruiters !\n"
							+ "you can contact me on twitter at @_devPK");
					System.out.println(">>".repeat(25));
					this.display();
					break;
	
				case 4:
					this.confirm();
					break;
	
				default:
					System.out.println("*".repeat(67));
					System.out.println("Please enter correct choice !\nReturning to main menu...");
					System.out.println("*".repeat(67));
					this.display();
					break;
			}
		}
	}
	
	/**
	 * method for play
	 */
	void playGame() {
		try {
			this.registerPlayers();
		}catch(Exception e) {
			System.out.println("-".repeat(67));
			System.out.println(e);
			this.playGame();
		}
		GameLogic.gameLogic(playerNames);
	}
	
	/**
	 * method to take player names
	 */
	void registerPlayers() {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("*".repeat(67));
		System.out.println("Enter names of players>>");
		for(int i=0;i<2;i++) {
			System.out.println("-".repeat(67));
			System.out.print("Player "+(i+1)+">>");
			playerNames[i]=in.next();
		}
		System.out.println("*".repeat(67));
	}
	
	/**
	 * method to confirm exit
	 */
	void confirm() {
		String confirm;
		Scanner in=new Scanner(System.in);
		System.out.print("Confirm exit ? (y/n)>>");
		confirm=in.next();
		if(confirm.equals("y")||confirm.equals("Y")) {
			System.out.println("Exiting game...");
			System.out.println("*".repeat(67));
			in.close();
			System.exit(0);
		}else {
			System.out.println("Returning to main menu...");
			this.display();
		}
	}
	
}

public class MainMenu {
	public static void mainMenu() {
		menu menu=new menu();
		menu.display();
	}
}
