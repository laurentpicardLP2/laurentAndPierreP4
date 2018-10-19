
import java.util.Arrays;
public class Puissance4Test {

	public static void main(String[] args) {

		testIdPlayer();
		testVictoireColonne();
		testVictoireLigne();
		testVictoireDiagonale1();
		testVictoireDiagonale2();

	}

	
    public static void testIdPlayer() {
		PlayerTest player1 = new PlayerTest();
        assertEquals("ok--> testIdplayer",1, player1.getIdPlayer());
    }

	public static void testVictoireColonne() {
		int i = 34;
		int i2 = i;
		int i22 = i2;
		int[][] gridTest = {
						{1, 1, 1, 1, 1, 1, 1}, 
						{11, 21, 31, 41, 51, 61, 71}, 
						{12, 22, 32, 42, 52, 62, 72}, 
						{13, 23, 33, 43, 53, 63, 73}, 
						{14, 24, 22, 44, 54, 64, 74}, 
						{15, 25, 35, 45, 55, 65, 75}, 
						};
		GridTest.showGridTest(gridTest);
	    assertEquals("ok--> testVictoireColonne", PlayerTest.getResultTest(gridTest, new String("Pierre"), 1), "Victoire, Bravo Pierre");
	}

	public static void testVictoireLigne() {
		int[][] gridTest = {
						{2, 11, 12, 13, 14, 15, 16}, 
						{2, 21, 31, 41, 51, 61, 71}, 
						{1, 22, 32, 42, 52, 62, 72}, 
						{1, 23, 33, 43, 53, 63, 73}, 
						{1, 24, 34, 44, 54, 64, 74}, 
						{1, 25, 35, 45, 55, 65, 75}, 
						};
		GridTest.showGridTest(gridTest);
	    assertEquals("testVictoireLigne", PlayerTest.getResultTest(gridTest, new String("Laurent"), 1), "Victoire, Bravo Laurent");
	}

    public static void testVictoireDiagonale1() {
		int[][] gridTest = {
						{2, 11, 12, 13, 14, 42, 16}, 
						{2, 21, 31, 41, 42, 61, 71}, 
						{4, 22, 32, 42, 52, 62, 72}, 
						{7, 23, 42, 43, 53, 63, 73}, 
						{1, 42, 34, 44, 54, 64, 74}, 
						{1, 25, 35, 45, 55, 65, 75}, 
						};
		GridTest.showGridTest(gridTest);
		
        assertEquals("testVictoireDiagonale1", PlayerTest.getResultTest(gridTest, new String("Pierre"), 42), "Victoire, Bravo Pierre");
	}
	
    public static void testVictoireDiagonale2() {
		int[][] gridTest = {
					{2, 11, 12, 13, 14, 15, 16}, 
					{2, 21, 31, 41, 51, 61, 71}, 
					{4, 33, 32, 42, 52, 62, 72}, 
					{1, 23, 33, 43, 53, 63, 73}, 
					{1, 24, 34, 33, 54, 64, 74}, 
					{1, 25, 35, 45, 33, 65, 75}, 						
				};
		GridTest.showGridTest(gridTest);
        assertEquals("testVictoireDiagonale2", PlayerTest.getResultTest(gridTest, new String("Laurent"), 33), "Victoire, Bravo Laurent");
	}
	
    public void testEgalite() {
		int[][] gridTest = {
					{2, 11, 12, 13, 14, 15, 16}, 
					{2, 21, 31, 41, 51, 61, 71}, 
					{4, 33, 32, 42, 52, 62, 72}, 
					{1, 23, 33, 43, 53, 63, 73}, 
					{1, 24, 34, 33, 54, 64, 74}, 
					{1, 25, 35, 45, 33, 65, 75}, 						
				};
		GridTest.showGridTest(gridTest);
        //assertEquals("egalite", PlayerTest.getResultTest(gridTest, new String("Laurent"), 33));
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
