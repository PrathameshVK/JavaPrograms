package game;

class cmdGraphics{
	void dice1() {
		System.out.println(" "+"=".repeat(6));
		System.out.println("|      |");
		System.out.println("|  *   |");
		System.out.println("|      |");
		System.out.println(" "+"-".repeat(6));
	}
	void dice2() {
		System.out.println(" "+"=".repeat(6));
		System.out.println("| *    |");
		System.out.println("|      |");
		System.out.println("|    * |");
		System.out.println(" "+"-".repeat(6));
	}
	void dice3() {
		System.out.println(" "+"=".repeat(6));
		System.out.println("|*     |");
		System.out.println("|  *   |");
		System.out.println("|    * |");
		System.out.println(" "+"-".repeat(6));
	}
	void dice4() {
		System.out.println(" "+"=".repeat(6));
		System.out.println("| *  * |");
		System.out.println("|      |");
		System.out.println("| *  * |");
		System.out.println(" "+"-".repeat(6));
	}
	void dice5() {
		System.out.println(" "+"=".repeat(6));
		System.out.println("| *  * |");
		System.out.println("|  *   |");
		System.out.println("| *  * |");
		System.out.println(" "+"-".repeat(6));
	}
	void dice6() {
		System.out.println(" "+"=".repeat(6));
		System.out.println("| *  * |");
		System.out.println("| *  * |");
		System.out.println("| *  * |");
		System.out.println(" "+"-".repeat(6));
	}
	
	/**
	                        ((
	                         \\
	       ====      ====     ||
	 \\__//    \\__//    \\__//
	 
	 **/
	void snake() {
		System.out.println(" ".repeat(23)+"((");
		System.out.println(" ".repeat(24)+"\\\\");
		System.out.println(" ".repeat(6)+"=".repeat(4)+" ".repeat(6)+"=".repeat(4)+" ".repeat(5)+"||");
		System.out.println("\\\\__//"+" ".repeat(4)+"\\\\__//"+" ".repeat(4)+"\\\\__//");
	}
	
	
	/**
	 * ====================================
	 * | | | | | | | | | | | | | | | | | |
	 * ====================================
	 */
	void ladder() {
		System.out.println("=".repeat(50));
		System.out.println("| ".repeat(25));
		System.out.println("=".repeat(50));
	}
}

public class Graphics {
	public static void graphics(int diceResult) {
		cmdGraphics grp=new cmdGraphics();
			switch(diceResult) {
				case 1:
					grp.dice1();
					break;
				
				case 2:
					grp.dice2();
					break;
					
				case 3:
					grp.dice3();
					break;
					
				case 4:
					grp.dice4();
					break;
					
				case 5:
					grp.dice5();
					break;
					
				case 6:
					grp.dice6();
					break;
					
				case 7:
					grp.snake();
					break;
					
				case 8:
					grp.ladder();
					break;
		}
	}	
}

