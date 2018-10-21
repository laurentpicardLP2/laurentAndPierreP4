public class GridTest {
  // public static final int NB_COLUMNS = 7;
  // public static final int NB_ROWS = 6;
  private int nbCol, nbRow;
  private int[] levelColumns;
  public int[][] grid;
  

  public GridTest(int nbCol, int nbRow, int[][] grid) {
    this.nbCol = nbCol;
    this.nbRow = nbRow;
    levelColumns = new int[nbCol];
    this.grid = grid;
    
    for (int i = 0; i < levelColumns.length; i++)
    levelColumns[i] = -1; //testIsFull
      //levelColumns[i] = nbRow - 1;
    //initGrid();
  }

  public int getNbCol() {
    return nbCol;
  }

  public int getNbRow() {
    return nbRow;
  }

  public int getLevelColumn(int nbCol) {
    return levelColumns[nbCol];
  }


  public void showGrid() {
    for (int j = 0; j < nbRow; j++) {
      for (int i = 0; i < nbCol; i++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }

  }
  

  public void addToken(int numCol, int idPlayer) {
    grid[numCol][levelColumns[numCol]--] = idPlayer;
  }

  public boolean isFull() {
    for (int i = 0; i < levelColumns.length; i++)
      if (levelColumns[i] != -1)
        return false;
    return true;
  }

}
