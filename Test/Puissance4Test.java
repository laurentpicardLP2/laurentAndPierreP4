
import java.util.Arrays;
public class Puissance4Test {

	public static void main(String[] args) {

		testIdPlayer();
		testVictoireColonne();
		testVictoireLigne();
		testVictoireDiagonale1();
		testVictoireDiagonale2();
		testEgalite();
	}

	
    public static void testIdPlayer() {
		PlayerTest player1 = new PlayerTest(new String("Pierre"), 1);
        assertEquals("ok--> testIdplayer",1, player1.getIdPlayer());
    }

	public static void testVictoireColonne() {
		PlayerTest player= new PlayerTest(new String("Pierre"), 1);
		int[][] grid = {
						{1, 1, 1, 1, 1, 1}, 
						{11, 21, 31, 41, 51, 61}, 
						{12, 22, 32, 42, 52, 62}, 
						{13, 23, 33, 43, 53, 63}, 
						{14, 24, 22, 44, 54, 64}, 
						{15, 25, 35, 45, 55, 65},
						{16, 26, 36, 46, 56, 66}
						};
		GridTest gridTest = new GridTest(7, 6, grid);
		assertEquals("ok--> testVictoireColonne", player.isVictoryByColumn(gridTest), true);
		player.setIdPlayer(55);
		assertEquals("ko--> pas de victoire en colonne", player.isVictoryByColumn(gridTest), false);
	}

	public static void testVictoireLigne() {
		PlayerTest player= new PlayerTest(new String("Laurent"), 1);
		int[][] grid = {
						{2, 11, 12, 13, 14, 15}, 
						{2, 21, 31, 41, 51, 61}, 
						{1, 22, 32, 42, 52, 62}, 
						{1, 23, 33, 43, 53, 63}, 
						{1, 24, 34, 44, 54, 64}, 
						{1, 25, 35, 45, 55, 65},
						{1, 26, 36, 46, 56, 66}
						};
		GridTest gridTest = new GridTest(7, 6, grid);
		//gridTest.showGrid();
		assertEquals("ok--> victoireLigne", player.isVictoryByRow(gridTest), true);
		player.setIdPlayer(55);
		assertEquals("ko--> pas de victoire en Ligne", player.isVictoryByRow(gridTest), false);
	}

    public static void testVictoireDiagonale1() {
		PlayerTest player= new PlayerTest(new String("Pierre"), 42);
		int[][] grid = {
						{2, 11, 12, 13, 14, 15}, 
						{2, 21, 31, 41, 42, 61}, 
						{4, 22, 32, 42, 52, 62}, 
						{7, 23, 42, 43, 53, 63}, 
						{1, 42, 34, 44, 54, 64}, 
						{1, 25, 35, 45, 55, 65},
						{16, 26, 36, 46, 56, 66}
						};
		GridTest gridTest = new GridTest(7, 6, grid);
		assertEquals("ok--> victoire en diagonale1", player.isVictoryByDiagonal1(gridTest), true);
		player.setIdPlayer(55);
		assertEquals("ko--> pas de victoire en diagonale1", player.isVictoryByDiagonal1(gridTest), false);
	}
	
    public static void testVictoireDiagonale2() {
		PlayerTest player= new PlayerTest(new String("Laurent"), 33);
		int[][] grid = {
					{2, 11, 12, 13, 14, 15}, 
					{46, 21, 31, 41, 51, 61}, 
					{4, 33, 32, 42, 52, 62}, 
					{13, 23, 33, 43, 53, 63}, 
					{14, 24, 34, 33, 54, 64}, 
					{15, 25, 35, 45, 33, 65},
					{16, 26, 36, 46, 36, 66}					
				};
		GridTest gridTest = new GridTest(7, 6, grid);
		assertEquals("ok--> victoire en diagonale2", player.isVictoryByDiagonal2(gridTest), true);
		player.setIdPlayer(55);
		assertEquals("ko--> pas de victoire en diagonale2", player.isVictoryByDiagonal2(gridTest), false);
	}
	
    public static void testEgalite() {
		PlayerTest player= new PlayerTest(new String("Laurent"), 46);
		int[][] grid = {
					{1, 2, 3, 4, 5, 6}, 
					{11, 21, 31, 41, 51, 61}, 
					{12, 22, 32, 42, 52, 62}, 
					{13, 23, 33, 43, 53, 63}, 
					{14, 24, 22, 44, 54, 64}, 
					{15, 25, 35, 45, 55, 65},
					{16, 26, 36, 46, 56, 66}				
				};
		GridTest gridTest = new GridTest(7, 6, grid);
		//gridTest.showGrid();
       assertEquals("ok--> testEgalite", player.play(gridTest), true);
    }

	/**
	 * Testing functions.
	 */

	public static void assertEquals(String message, double expected, double res) {
		if (Math.abs(expected - res) < 0.0001) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertEquals(String message, boolean expected, boolean res) {
		if (expected == res) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertEquals(String message, int expected, int res) {
		if (expected == res) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertEquals(String message, int[] expected, int[] res) {
		if (Arrays.equals(res, expected)) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertEquals(String message, String[] expected, String[] res) {
		if (res == expected) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertEquals(String message, char expected, char res) {
		if (expected == res) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertEquals(String message, String expected, String res) {
		if (expected.equals(res)) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertTrue(String message, boolean res) {
		if (res) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}

	public static void assertFalse(String message, boolean res) {
		if (!res) {
			System.out.println("\nOK >> " + message);
		} else {
			throw new Error("\nKO!! >> " + message);
		}
	}
	
	
}
