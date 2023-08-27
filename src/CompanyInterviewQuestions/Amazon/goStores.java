package CompanyInterviewQuestions.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class goStores {

  public static void main(String[] args) {
    int rows = 5;
    int columns = 4;

    List<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0, 0));
    List<Integer> b = new ArrayList<>(Arrays.asList(0, 0, 1, 0));
    List<Integer> c = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
    List<Integer> d = new ArrayList<>(Arrays.asList(1, 0, 1, 1));
    List<Integer> e = new ArrayList<>(Arrays.asList(1, 1, 1, 1));

    goStores test = new goStores();

    System.out.println(test.numberAmazonGoStores(Arrays.asList(a, b, c, d, e), rows, columns));
  }

  public int numberAmazonGoStores(List<List<Integer>> grid, int rows, int column) {
    if (grid.size() == 0 || grid == null)
      return 0;

    int numOfAmazonGoStores = 0;  // Value to be returned.

    for (int row = 0; row < grid.size(); row++) {
      for (int col = 0; col < grid.get(row).size(); col++) {
        if (grid.get(row).get(col) == 1) {
          numOfAmazonGoStores += helperDFS(grid, row, col);
        }
      }
    }
    return numOfAmazonGoStores;
  }

  public int helperDFS(List<List<Integer>> grid, int row, int col) {

    if (row < 0 || row >= grid.size() || col < 0 || col >= grid.get(row).size() || grid.get(row).get(col) == 0)
      return 0;

    grid.get(row).set(col, 0);

    helperDFS(grid, row - 1, col);  //up
    helperDFS(grid, row + 1, col);  //down
    helperDFS(grid, row, col - 1);  //left
    helperDFS(grid, row, col + 1);  //right

    return 1;
  }

}
