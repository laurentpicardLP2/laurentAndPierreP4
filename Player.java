import java.util.Scanner;
/**
 * Player
 */
public class Player {

    private String name;
    private int idPlayer;
    private boolean isVictory;
    Scanner input;

    public Player(int idPlayer) {
        input = new Scanner(System.in);
        System.out.print("entrez votre nom : [id num : " + idPlayer + "] : ");
        name = input.nextLine();
        this.idPlayer = idPlayer;
    }

    public String getName() {
      return name;
    }

    public boolean play(Grid grid) {
      int colNum;

      System.out.print(name + "[" + idPlayer + "]" + ", Choissisez une colonne: ");
      colNum = input.nextInt();
      while(grid.getLevelColumn(colNum) == -1) {
        System.out.print(name + "[" + idPlayer + "]" + ", Choissisez une autre colonne: ");
        colNum = input.nextInt();
      }
      grid.addToken(colNum, idPlayer);
      grid.showGrid();
      if(isVictory(grid)){
        System.out.println("Victoire, Bravo " + name);
        return true;
      }
      else if(grid.isFull()) {
        System.out.println("egalite");
        return true;
      }
      else return false;
    }

    public boolean isVictory(Grid grid){
      /* verif victory ligne */
      for(int j=0; j<grid.getNbRow(); j++){
        for(int i=0; i< grid.getNbCol()-3;i++)
          if(grid.grid[i][j] == idPlayer && grid.grid[i+1][j] == idPlayer && grid.grid[i+2][j] == idPlayer && grid.grid[i+3][j] == idPlayer) {
            return true;
          }
      }

      /* verif victory colonne */
      for(int i=0; i<grid.getNbCol(); i++){
        for(int j=0; j< grid.getNbRow()-3;j++)
          if(grid.grid[i][j] == idPlayer && grid.grid[i][j+1] == idPlayer && grid.grid[i][j+2] == idPlayer && grid.grid[i][j+3] == idPlayer) {
            return true;
          }

        }

        /* verif victory daigonnale 1 */
        for(int j=grid.getNbRow()-1; j> 3; j--){
          for (int i=0; i< grid.getNbCol()-3; i++){
            if(grid.grid[i][j] == idPlayer && grid.grid[i+1][j-1] == idPlayer && grid.grid[i+2][j-2] == idPlayer && grid.grid[i+3][j-3] == idPlayer) {
              return true;
            }
          }
        }


        /* verif victory daigonnale 2 */
        for(int j=grid.getNbRow()-1; j> 3; j--){
          for (int i=grid.getNbCol()-1; i> 3; i--){
            if(grid.grid[i][j] == idPlayer && grid.grid[i-1][j-1] == idPlayer && grid.grid[i-2][j-2] == idPlayer && grid.grid[i-3][j-3] == idPlayer) {
              return true;
            }
          }
        }


      return false;
    }

    //for(int i=0;i<grid.length; i++)
    //if (grid[i]>=0) return false;

}
