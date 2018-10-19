import static org.junit.Assert.*;

import org.junit.Test;

public class Puissance4Test {

	@Test
    public void testIdPlayer() {
		Player player1 = new Player();
        assertEquals(1, player1.getIdPlayer());
    }

	

	@Test
	public void testVictoireColonne() {
		int[][] gridTest = {
						{1, 1, 1, 1, 1, 1, 1}, 
						{11, 21, 31, 41, 51, 61, 71}, 
						{12, 22, 32, 42, 52, 62, 72}, 
						{13, 23, 33, 43, 53, 63, 73}, 
						{14, 24, 34, 44, 54, 64, 74}, 
						{15, 25, 35, 45, 55, 65, 75}, 
						};
		Grid.showGridTest(gridTest);
	    assertEquals("Victoire, Bravo Pierre", Player.getResultTest(gridTest, new String("Pierre"), 1));
	}

	@Test
	public void testVictoireLigne() {
		int[][] gridTest = {
						{2, 11, 12, 13, 14, 15, 16}, 
						{2, 21, 31, 41, 51, 61, 71}, 
						{1, 22, 32, 42, 52, 62, 72}, 
						{1, 23, 33, 43, 53, 63, 73}, 
						{1, 24, 34, 44, 54, 64, 74}, 
						{1, 25, 35, 45, 55, 65, 75}, 
						};
		Grid.showGridTest(gridTest);
	    assertEquals("Victoire, Bravo Laurent", Player.getResultTest(gridTest, new String("Laurent"), 1));
	}


	@Test
    public void testVictoireDiagonale1() {
		int[][] gridTest = {
						{2, 11, 12, 13, 14, 42, 16}, 
						{2, 21, 31, 41, 42, 61, 71}, 
						{4, 22, 32, 42, 52, 62, 72}, 
						{7, 23, 42, 43, 53, 63, 73}, 
						{1, 42, 34, 44, 54, 64, 74}, 
						{1, 25, 35, 45, 55, 65, 75}, 
						};
		Grid.showGridTest(gridTest);
		
        assertEquals("Victoire, Bravo Pierre", Player.getResultTest(gridTest, new String("Pierre"), 42));
    }	
	
	
	@Test
    public void testVictoireDiagonale2() {
		int[][] gridTest = {
					{2, 11, 12, 13, 14, 15, 16}, 
					{2, 21, 31, 41, 51, 61, 71}, 
					{4, 33, 32, 42, 52, 62, 72}, 
					{1, 23, 33, 43, 53, 63, 73}, 
					{1, 24, 34, 33, 54, 64, 74}, 
					{1, 25, 35, 45, 33, 65, 75}, 						
				};
		Grid.showGridTest(gridTest);
        assertEquals("Victoire, Bravo Laurent", Player.getResultTest(gridTest, new String("Laurent"), 33));
    }	

	@Test
    public void testEgalite() {
		int[][] gridTest = {
					{2, 11, 12, 13, 14, 15, 16}, 
					{2, 21, 31, 41, 51, 61, 71}, 
					{4, 33, 32, 42, 52, 62, 72}, 
					{1, 23, 33, 43, 53, 63, 73}, 
					{1, 24, 34, 33, 54, 64, 74}, 
					{1, 25, 35, 45, 33, 65, 75}, 						
				};
		Grid.showGridTest(gridTest);
        assertEquals("egalite", Player.getResultTest(gridTest, new String("Laurent"), 33));
    }	

	
	
}
