package Theory.Trees;

import CommonClasses.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

  public static List<List<Integer>> levelOrderTraversal(TreeNode root) {

    List<List<Integer>> sol = new ArrayList<>();

    if (root == null)
      return sol;

    travel(root, sol, 0);

    return sol;
  }

  private static void travel(TreeNode curr, List<List<Integer>> sol, int level) {

    if (curr == null)
      return;

    if (sol.size() <= level){
      List<Integer> newLevel = new LinkedList<>();
      sol.add(newLevel);
    }

    List<Integer> collection = sol.get(level);

    collection.add(curr.val);

    travel(curr.left, sol, level+1);
    travel(curr.right, sol, level+1);
  }
}
