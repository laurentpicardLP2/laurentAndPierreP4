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
        this.idPlayer = idPlayer;
    }

    public void play(Grid grid) {
      int colNum;

      System.out.print("Choissisez une colonne: ");
      colNum = input.nextInt();
      while(grid.getLevelColumn(colNum) == -1) {
        System.out.print("Choissisez une autre colonne: ");
        colNum = input.nextInt();
      }
      grid.addToken(colNum, idPlayer);

      grid.showGrid();
    }
}
