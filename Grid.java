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
    for (int i = 0; i < levelColumns.length; i++)
      levelColumns[i] = nbRow - 1;
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
    for (int j = 0; j < nbCol; j++) {
      for (int i = 0; i < nbRow; i++) {
        grid[j][i] = 0;
      }
    }
  }

  public void showGrid() {
	boolean  bFilled = false;
    for (int j = 0; j < nbRow; j++) {
      for (int i = 0; i < nbCol; i++) {
    	  
    	  for(Integer key: Puissance4.dicoToken.keySet()) {
    		  if(key.intValue() == grid[i][j]) {
    			  System.out.print(Puissance4.dicoToken.get(key) + " ");
    			  bFilled = true;
    			  break;
    		  }
    	  }
    	  if(bFilled == false) {
    		  System.out.print("  ");
    	  }
    	  bFilled = false;
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
