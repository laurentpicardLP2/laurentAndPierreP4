import java.util.Scanner;

/**
 * Player
 */
public class PlayerTest {
    static private int nbJoueurs;
    private String name;
    private int idPlayer;
    private boolean isVictory;
    Scanner input;
 
    
    public PlayerTest() {
    	idPlayer = 1;
    }
    
    public int getIdPlayer() {
    	return idPlayer;
    }

    public PlayerTest(int idPlayer) {
        input = new Scanner(System.in);
        System.out.print("entrez votre nom : [id num : " + idPlayer + "] : ");
        name = input.nextLine();
        this.idPlayer = idPlayer;
        
    }
    
    

    public static int askNbPlayer() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("entrez le nombre de joueurs : ");
        nbJoueurs = input1.nextInt();
        return nbJoueurs;
    }

    public String getName() {
        return name;
    }

    public boolean play(GridTest grid) {
        int colNum = 0;
        boolean bExitTry = false;
        do {
            try {
                colNum = askColumn(name + "[" + idPlayer + "]" + ", Choissisez une colonne: ");
                bExitTry = true;

                while ((colNum >= grid.getNbCol()) || (grid.getLevelColumn(colNum) == -1)) {
                    colNum = askColumn(name + "[" + idPlayer + "]" + ", Choissisez une autre colonne: ");
                    bExitTry = true;
                    if (colNum >= grid.getNbCol()) {
                        bExitTry = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.print("Vous devez saisir un entier, so ");
                bExitTry = false;
            }
        } while (bExitTry == false);
        System.out.println("colNum2 = " + colNum);
        System.out.println("bExitTry = " + bExitTry);

        grid.addToken(colNum, idPlayer);
        grid.showGrid();
        if (isVictory(grid)) {
            System.out.println("Victoire, Bravo " + name);
            return true;
        } else if (grid.isFull()) {
            System.out.println("egalite");
            return true;
        } else
            return false;
    }
    
    public static String getResultTest (int[][] gridTest, String nameTest, int idPlayerTest) {
    	System.out.println("x");   
	    if (isVictoryTest(gridTest, idPlayerTest)) {
	        return "Victoire, Bravo " + nameTest;
	    } /*else if (gridTest.isFull()) {
	        System.out.println("egalite");
	        return "egalite";
	    } */else
	        return"Partie en cours";
    }
    
    public static boolean isVictoryTest(int[][] gridTest, int idPlayerTest) {
    	   	

    	
        // verif victory ligne
           for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (gridTest[i][j] == idPlayerTest && gridTest[i + 1][j] == idPlayerTest && gridTest[i + 2][j] == idPlayerTest
                        && gridTest[i + 3][j] == idPlayerTest) {
                    return true;
                }
            }
        }
     

        // verif victory colonne 
       
       
       for (int i = 0; i < 6; i++) {
    	   for (int j = 0; j < 4; j++) {
            	//System.out.println("*" + gridTest[i][j] + "*" + gridTest[i][j + 1] + "*" + gridTest[i][j+2] + "*" 
                   	// + gridTest[i][j + 3]);
                if (gridTest[i][j] == idPlayerTest && gridTest[i][j + 1] == idPlayerTest && gridTest[i][j + 2] == idPlayerTest
                        && gridTest[i][j + 3] == idPlayerTest) {
                    	return true;
                }
                
            }
        }
        

        // verif victory diagonnale 1 
    	for (int i = 0; i < 4; i++) {
    		for (int j = 6; j > 3; j--) {

    	
            	
                if (gridTest[i][j] == idPlayerTest && gridTest[i + 1][j - 1] == idPlayerTest
                        && gridTest[i + 2][j - 2] == idPlayerTest && gridTest[i + 3][j - 3] == idPlayerTest) {
                    return true;
                }
            }
        }

        //verif victory diagonnale 2
       
       for (int i = 5; i > 3; i--) {
             for (int j = 6; j > 3; j--) {
            	 
            	 //System.out.println("*" + gridTest[i][j] + "*" + gridTest[i - 1][j - 1] + "*" + gridTest[i-2][j-2] + "*" 
            	// + gridTest[i - 3][j - 3]);
            	 
                if (gridTest[i][j] == idPlayerTest && gridTest[i - 1][j - 1] == idPlayerTest
                        && gridTest[i - 2][j - 2] == idPlayerTest && gridTest[i - 3][j - 3] == idPlayerTest) {
                    return true;
                }
            }
        }

        return false;
    }



    private int askColumn(String msg) throws NumberFormatException {
        String saisie;
        System.out.print(msg);
        saisie = input.nextLine();
        return Integer.parseInt(saisie);
    }

    public boolean isVictory(GridTest grid) {
        /* verif victory ligne */
        for (int j = 0; j < grid.getNbRow(); j++) {
            for (int i = 0; i < grid.getNbCol() - 3; i++)
                if (grid.grid[i][j] == idPlayer && grid.grid[i + 1][j] == idPlayer && grid.grid[i + 2][j] == idPlayer
                        && grid.grid[i + 3][j] == idPlayer) {
                    return true;
                }
        }

        /* verif victory colonne */
        for (int i = 0; i < grid.getNbCol(); i++) {
            for (int j = 0; j < grid.getNbRow() - 3; j++)
                if (grid.grid[i][j] == idPlayer && grid.grid[i][j + 1] == idPlayer && grid.grid[i][j + 2] == idPlayer
                        && grid.grid[i][j + 3] == idPlayer) {
                    return true;
                }

        }

        /* verif victory daigonnale 1 */
        for (int j = grid.getNbRow() - 1; j > 3; j--) {
            for (int i = 0; i < grid.getNbCol() - 3; i++) {
                if (grid.grid[i][j] == idPlayer && grid.grid[i + 1][j - 1] == idPlayer
                        && grid.grid[i + 2][j - 2] == idPlayer && grid.grid[i + 3][j - 3] == idPlayer) {
                    return true;
                }
            }
        }

        /* verif victory daigonnale 2 */
        for (int j = grid.getNbRow() - 1; j > 3; j--) {
            for (int i = grid.getNbCol() - 1; i > 3; i--) {
                if (grid.grid[i][j] == idPlayer && grid.grid[i - 1][j - 1] == idPlayer
                        && grid.grid[i - 2][j - 2] == idPlayer && grid.grid[i - 3][j - 3] == idPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    // for(int i=0;i<grid.length; i++)
    // if (grid[i]>=0) return false;

}


