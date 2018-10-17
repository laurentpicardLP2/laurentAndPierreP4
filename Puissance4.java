public class Puissance4 {


  public static void main(String[] args){
    int nbCoups = 0;
    //int firstPlayer = Math.floor(Math.random()*2);
    Grid grid = new Grid(7, 6);
    grid.showGrid();

    Player player1 = new Player(1);
    Player player2 = new Player(2);

    while(true){
      if(nbCoups%2==0){
        if(player2.play(grid)) {
          System.out.println("Victoire !!!");
          break;
        }
      }
      else{
        if(player1.play(grid)) {
          System.out.println("Victoire !!!");
          break;
        }
      }
      nbCoups++;
    }


  }


}
