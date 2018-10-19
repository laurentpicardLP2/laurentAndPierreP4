import java.util.Scanner;

/**
 * Player
 */
public class Player {
    static private int nbJoueurs;
    private String name;
    private int idPlayer;
    Scanner input;
    private String token;

    public Player(int idPlayer) {
        input = new Scanner(System.in);
        System.out.print("entrez votre nom : [id num : " + idPlayer + "] : ");
        name = input.nextLine();
        this.idPlayer = idPlayer;
        token = initToken();
        Puissance4.dicoToken.put(idPlayer, token);
    }
    
    private String initToken() {
    	Scanner input1 = new Scanner(System.in);
        System.out.print("choisissez un symbole pour votre jeton : ");
        input1.close();
    	return input1.nextLine();
    }

    public static int askNbPlayer() {
        Scanner input1 = new Scanner(System.in);
        System.out.print("entrez le nombre de joueurs : ");
        nbJoueurs = input1.nextInt();
        input1.close();
        return nbJoueurs;
    }

    public String getName() {
        return name;
    }

    public boolean play(Grid grid) {
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

    private int askColumn(String msg) throws NumberFormatException {
        String saisie;
        System.out.print(msg);
        saisie = input.nextLine();
        return Integer.parseInt(saisie);
    }

    public boolean isVictory(Grid grid) {
        /* verif victory ligne */
        for (int i = 0; i < grid.getNbCol() - 3; i++)
        	for (int j = 0; j < grid.getNbRow(); j++) {
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

        /* verif victory diagonnale 1 */
           for (int i = 0; i < grid.getNbCol() - 3; i++) {
               for (int j = grid.getNbRow() - 1; j > 3; j--) {
                if (grid.grid[i][j] == idPlayer && grid.grid[i + 1][j - 1] == idPlayer
                        && grid.grid[i + 2][j - 2] == idPlayer && grid.grid[i + 3][j - 3] == idPlayer) {
                    return true;
                }
            }
        }

        /* verif victory daigonnale 2 */
        for (int i = grid.getNbCol() - 1; i > 3; i--) {
        	for (int j = grid.getNbRow() - 1; j > 3; j--) {
            
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
