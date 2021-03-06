public class Grid {
  // public static final int NB_COLUMNS = 7;
  // public static final int NB_ROWS = 6;
  private int nbCol, nbRow;
  private int[] levelColumns;
  public int[][] grid;

  public Grid(int nbCol, int nbRow) {
    this.nbCol = nbCol;
    this.nbRow = nbRow;
    levelColumns = new int[nbCol];
    grid = new int[nbCol][nbRow];
    initGrid();
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

  private void initGrid() {
	  for (int i = 0; i < levelColumns.length; i++)
	      levelColumns[i] = nbRow-1;    
	  for (int j = 0; j < nbCol; j++) {
	      for (int i = 0; i < nbRow; i++) {
	        grid[j][i] = 0;
	      }
	  }
  }

  public void showGrid() {
	boolean  bFilled = false;

	System.out.println();
    for (int j = 0; j < nbRow; j++) {
      for (int i = 0; i < nbCol; i++) {
    	  if (i==0)
    		  System.out.print(" ");
    	  System.out.print(Puissance4.dicoToken.get(Integer.valueOf(grid[i][j])) + " || ");
      }
    	  System.out.println();
    }
    System.out.println("__________________________________");
    System.out.println(" 0    1    2    3    4    5    6 ");
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
