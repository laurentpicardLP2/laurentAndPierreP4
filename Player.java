import java.util.Scanner;
/**
 * Player
 */
public class Player {

    private String name;
    private boolean isVictory;
    Scanner input; 

    public Player() {
        input = new Scanner(System.in);
    }

    public void play(Grid grid) {
        System.out.print("Choissisez une colonne: ");
        int colNum = input.nextInt();
        grid.addToken(colNum);

    }
}