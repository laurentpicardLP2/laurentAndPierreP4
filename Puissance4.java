import java.util.*;

public class Puissance4 {
public static HashMap<Integer, String> dicoToken;

  public static void main(String[] args) {
    int nbCoups = 0;
    Grid grid = new Grid(7, 6);
    int nbPlayer = Player.askNbPlayer();
    Player[] players = new Player[nbPlayer];
    dicoToken = new HashMap<Integer, String>();
    dicoToken.put(0, " ");
    
    for (int i = 0; i < nbPlayer; i++) {
      players[i] = new Player(i + 1);
    }
    // int firstPlayer = Math.floor(Math.random()*2);

    int playerNum=0;
    grid.showGrid();
    while (!players[playerNum].play(grid)) {
      nbCoups++;
      playerNum=nbCoups%nbPlayer;
    }

    /*
     * while(true){ if(nbCoups%3==0){ if(player3.play(grid)) break; } else
     * if(nbCoups%3==1) { if(player2.play(grid)) break;
     * 
     * } else { if(player1.play(grid)) break; } nbCoups++;
     * 
     * }
     */
  }

}
