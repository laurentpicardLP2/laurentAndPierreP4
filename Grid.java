public class Grid {
  //public static final int NB_COLUMNS = 7;
  //public static final int NB_ROWS = 6;
  private int nbCol, nbRow;
  private int[] levelColumns;
  private int[][] grid;

  public Grid(int nbCol, int nbRow){
      this.nbCol = nbCol;
      this.nbRow = nbRow;
      levelColumns = new int[nbCol];
      grid = new int[nbCol][nbRow];
      for(int i=0; i< levelColumns.length; i++)
        levelColumns[i] = 0;
      initGrid();
  }

  private void initGrid() {
    for(int j=0; j< nbCol; j++){
      for (int i=0; i< nbRow; i++){
        grid[j][i] = 0;
      }
    }
  }

  public void showGrid(){
    for(int j=0; j< nbRow; j++){
      for (int i=0; i< nbCol; i++){
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }

  }

  public void addToken(int numCol){

  }


}
