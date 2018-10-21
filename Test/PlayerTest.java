import java.util.Scanner;

/**
 * Player
 */
public class PlayerTest {
    private String name;
    private int idPlayer;
    private boolean isVictory;
    Scanner input;
 
    
    public String getName(){
        return name;
    }

    public int getIdPlayer() {
    	return idPlayer;
    }

    public void setIdPlayer(int idPlayer){
        this.idPlayer = idPlayer;
    }

    public PlayerTest(String name, int idPlayer) {
        this.name = name;
        this.idPlayer = idPlayer;
        
    }
    

    public boolean play(GridTest grid) {
    
        if (isVictoryByRow(grid) || isVictoryByColumn(grid) || 
        isVictoryByDiagonal1(grid) || isVictoryByDiagonal2(grid)) {
            return true;
        } else if (grid.isFull()) {
            return true;
        } else
            return false;
    }
    

    public boolean isVictoryByRow(GridTest grid){
        /* verif victory ligne */
        for (int i = 0; i < grid.getNbCol() - 3; i++)
        	for (int j = 0; j < grid.getNbRow(); j++) {
                if (grid.grid[i][j] == idPlayer && grid.grid[i + 1][j] == idPlayer && grid.grid[i + 2][j] == idPlayer
                        && grid.grid[i + 3][j] == idPlayer) {
                    return true;
                }
        }
        return false;
    }

    public boolean isVictoryByColumn(GridTest grid){
        /* verif victory colonne */
        for (int i = 0; i < grid.getNbCol(); i++) {
            for (int j = 0; j < grid.getNbRow() - 3; j++)
                if (grid.grid[i][j] == idPlayer && grid.grid[i][j + 1] == idPlayer && grid.grid[i][j + 2] == idPlayer
                        && grid.grid[i][j + 3] == idPlayer) {
                    return true;
                }

        }
        return false;
    }

    public boolean isVictoryByDiagonal1(GridTest grid) {
        /* verif victory diagonnale 1 */
        for (int i = 0; i < grid.getNbCol() - 3; i++) {
            for (int j = grid.getNbRow() - 1; j > 3; j--) {
             if (grid.grid[i][j] == idPlayer && grid.grid[i + 1][j - 1] == idPlayer
                     && grid.grid[i + 2][j - 2] == idPlayer && grid.grid[i + 3][j - 3] == idPlayer) {
                 return true;
             }
         }
     }
     return false;
    }

    public boolean isVictoryByDiagonal2(GridTest grid) {
        /* verif victory diagonnale 2 */
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


}


