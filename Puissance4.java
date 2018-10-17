public class Puissance4 {


  public static void main(String[] args){
    int nbCoups = 0;
    //int firstPlayer = Math.floor(Math.random()*2);
    Grid grid = new Grid(7, 6);

    Player player1 = new Player();
    Player player2 = new Player();
    player1.play(grid);
  }


}
