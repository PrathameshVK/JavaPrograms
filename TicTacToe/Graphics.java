package game;

class draw{
	
	/**
	 * 
+---+---+---+
| x | x | x |
+---+---+---+
| x | x | x |
+---+---+---+
| x | x | x |
+---+---+---+
	 * @param ticTacToeTable
	 * **************************************************
	 */
	void displayBoard(String [][] ticTacToeTable) {
		System.out.println("**                  1   2   3                **");
		System.out.println("**                +"+"-".repeat(3)+"+"+"-".repeat(3)+"+"+"-".repeat(3)+"+"+"              **");
		for(int i=0;i<3;i++) {
			System.out.print("**              "+(i+1)+" |");
			for(int j=0;j<3;j++) {
				System.out.print(" "+ticTacToeTable[i][j]+" ");
				System.out.print("|");
			}
			System.out.println("              **");
			System.out.println("**                +"+"-".repeat(3)+"+"+"-".repeat(3)+"+"+"-".repeat(3)+"+"+"              **");
		}
	}
	
	/**
	  [====] [====] [====]   [====] [====] [====]   [====] [====] [====]
	    ||     ||   ||  	   ||   ||  || ||		  ||   ||  || ||    
	    ||     ||   ||	       ||   ||==|| ||         ||   ||  || [====]
	    ||     ||   ||         ||   ||  || ||         ||   ||  || ||
	    ||   [====] [====]     ||   ||  || [====]     ||   [====] [====]
	    
	    ******* ******* *******  ******* ******* *******   ******* ******* *******
	    ******* ******* *******  ******* ******* *******   ******* ******* *******
	      ***     ***   ***        ***   **   ** ***         ***   **   ** ***
	      ***     ***   ***        ***   ******* ***         ***   **   ** *******
	      ***     ***   ***        ***   ******* ***         ***   **   ** ***
	      ***   ******* *******    ***   **   ** *******     ***   ******* *******
	      ***   ******* *******    ***   **   ** *******     ***   ******* *******
	      *
	      *TTTTTT IIIIII CCCCCC   TTTTTT AAAAAA CCCCCC   TTTTTT OOOOOO EEEEEE
		     TT     II   CC         TT   AA  AA CC         TT   OO  OO EE    
		     TT     II   CC         TT   AAAAAA CC         TT   OO  OO EEEEEE
		     TT     II   CC         TT   AA  AA CC         TT   OO  OO EE    
		     TT   IIIIII CCCCCC     TT   AA  AA CCCCCC     TT   OOOOOO EEEEEE
	    */
	static void header() {
		System.out.println("****** ****** ******  ****** ******* ******   ****** ******* ******");
		System.out.println("  **     **   **        **   **   ** **         **   **   ** **");
		System.out.println("  **     **   **        **   ******* **         **   **   ** ******");
		System.out.println("  **     **   **        **   **   ** **         **   **   ** **");
		System.out.println("  **   ****** ******    **   **   ** ******     **   ******* ******");
	}
}

public class Graphics {
	public static void graphics(String[][] ticTacToeTable) {
		draw draw=new draw();
		draw.displayBoard(ticTacToeTable);
	}
}