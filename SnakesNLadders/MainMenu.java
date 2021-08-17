package game;
import java.util.*;

class menu{
	
	static int totalPlayers;
	static String[] playerNames;
	
	void display() {
		int choice=0;
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		while(choice!=3) {
			System.out.println("\n\n"+"*".repeat(50));
			System.out.println("1.Play\n2.Help\n3.About\n4.Exit");
			try {
				System.out.print("-".repeat(50)+"\n>>");
				choice=in.nextInt();
				System.out.println("*".repeat(50));
			}catch(Exception e) {
				System.out.println("\n\n"+"*".repeat(50));
				System.out.println("Enter correct option !\nReturning to main menu...");
				System.out.println("*".repeat(50));
				this.display();
			}
			
			switch(choice) {

				case 1:
					
					int playChoice=0;
					playChoice=this.playOption();
					if(playChoice==1) {
						this.playAgainstHuman();
					}else if(playChoice==2){
						this.playAgainstComputer();
					}else if(playChoice==3){
						this.display();
					}
					break;
	
				case 2:
					System.out.println();
					System.out.println("+".repeat(50));
					System.out.println("This is a command line snake and ladder game.\n"
							+ "In case you don't know what a snake and ladder game is, go search on google.\n"
							+ "I am not wasting my time here typing the game description.\n"
							+ "-".repeat(50)
							+ "\nSome general commands : \n"
							+ "+ Whenever you are required to give an input,\n"
							+ "all the valid inputs will be displayed at that point.\n"
							+ "+ Hope you enjoy this simple boring commandline snake and ladder game at this era"
							+ " of games with high end graphics.\n"
							+ "-".repeat(50)
							+ "\nIMPORTANT\n"
							+ "Don't go on typing anything like you are out of this world\n"
							+ "It may crash the game.\n"
							+ "Remember, this is a super simple command line Snakes and ladder game.\n"
							+ "not some super smart AI that would interpret your gibbrish."
							);
					System.out.println("+".repeat(50));
					this.display();
				
				case 3:
					System.out.println(">>".repeat(25));
					System.out.println("Prathamesh Vijay Kulkarni\n"
							+ "Yeah, that's me"
							+ "\nwho invested too much time to program this\n"
							+ "boring snakes and ladder game\n"
							+ "to include in his resume and show off to recruiters !\n"
							+ "you can contact me on twitter at @_devPK");
					System.out.println(">>".repeat(25));
					this.display();
					break;
	
				case 4:
					this.confirm();
					break;
	
				default:
					System.out.println("*".repeat(50));
					System.out.println("Please enter correct choice !\nReturning to main menu...");
					System.out.println("*".repeat(50));
					this.display();
					break;
			}
		}
	}
	
	/**
	 * method to choose whether play against human(1) or computer(2)
	 * @return human(1) or computer(2) or go back (3)
	 */
	int playOption() {
		int op=1;
		System.out.println("1.Play against human\n2.play against computer\n3.Go back");
		try {
			System.out.print("-".repeat(50)+"\n>>");
			Scanner in=new Scanner(System.in);
			op=in.nextInt();
		}catch(Exception e) {
			System.out.println("Enter correct choice !\nReturning to main menu...");
			this.display();
		}
		return op;
	}
	
	/**
	 * method for play against human players
	 */
	void playAgainstHuman() {
		Scanner in=new Scanner(System.in);
		System.out.println("*".repeat(50));
		System.out.println("Enter the number of players(maximum 4)");
		try {
			System.out.print("-".repeat(50)+"\n>>");
			menu.totalPlayers=in.nextInt();
			if(menu.totalPlayers<0) {
				System.out.println("-".repeat(50));
				System.out.println("Great !\nJust great !!\nYou have invented negative number of players !!!");
				this.playAgainstHuman();
			}else if(menu.totalPlayers>4) {
				System.out.println("-".repeat(50));
				System.out.println("Maximum 4 players !\nMAXIMUM 4 PLAYERS !!");
				this.playAgainstHuman();
			}else if(menu.totalPlayers==0) {
				System.out.println("-".repeat(50));
				System.out.println("How can you play with 0 players ?\nYou must be soo smart !!");
				this.playAgainstHuman();
			}
		}catch(Exception e) {
			System.out.println("-".repeat(50));
			System.out.println("That's not a valid input !");
			this.playAgainstHuman();
		}
		menu.playerNames=new String[totalPlayers];
		System.out.println("*".repeat(50));
		System.out.println("Enter names of players>>");
		for(int i=0;i<totalPlayers;i++) {
			System.out.println("-".repeat(50));
			System.out.print("Player "+(i+1)+">>");
			playerNames[i]=in.next();
		}
		System.out.println("*".repeat(50));
		for(int i=0;i<playerNames.length;i++) {
			System.out.println("Player "+(i+1)+" : "+playerNames[i]);
		}
		GameLogic.gameLogic(playerNames,playerNames.length);
	}
	
	void playAgainstComputer() {
		Scanner in=new Scanner(System.in);
		System.out.println("*".repeat(50));
		System.out.println("Enter your name : ");
		menu.playerNames=new String[2];
		playerNames[0]=in.next();
		playerNames[1]="Computer";
		GameLogic.gameLogic(playerNames,playerNames.length);
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
			System.out.println("*".repeat(50));
			System.exit(0);
		}else {
			System.out.println("Returning to main menu...");
			this.display();
		}
	}
	
}

public class MainMenu {
	public static void mainMenu() {
		System.out.println("\n\n"+"*".repeat(50));
		System.out.println("*".repeat(17)+"Snakes N Ladders"+"*".repeat(17));
		menu menu=new menu();
		menu.display();
	}
}
