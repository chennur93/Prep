package CompanyInterviewQuestions.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numberOfAmazonGoStoresClass {

  public static void main(String[] args) {
    int rows = 5;
    int columns = 4;

    List<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 0, 0));
    List<Integer> b = new ArrayList<>(Arrays.asList(0, 0, 1, 0));
    List<Integer> c = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
    List<Integer> d = new ArrayList<>(Arrays.asList(1, 0, 1, 1));
    List<Integer> e = new ArrayList<>(Arrays.asList(1, 1, 1, 1));

    numberOfAmazonGoStoresClass test = new numberOfAmazonGoStoresClass();

    System.out.println(test.numberOfAmazonGoStores(rows, columns, Arrays.asList(a, b, c, d, e)));
  }

  int numberOfAmazonGoStores(int rows, int columns, List<List<Integer>> grid) {
    int[][] matrix = new int[grid.size()][grid.get(0).size()];
    int i = 0, j = 0;
    for (List<Integer> row : grid) {
      for (int val : row) {
        matrix[i][j++] = val;
      }
      j = 0;
      i++;
    }
    return numIslands(matrix);
  }
  void dfs( int r, int c, int[][] grid) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';
    dfs(r - 1, c,grid);
    dfs(r + 1, c, grid);
    dfs(r, c - 1, grid);
    dfs(r, c + 1, grid);
  }

  public int numIslands(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          ++num_islands;
          dfs(r, c, grid);
        }
      }
    }

    return num_islands;
  }
}
