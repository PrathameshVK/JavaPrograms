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
	 * 
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
