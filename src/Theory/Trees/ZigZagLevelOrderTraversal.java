package Theory.Trees;


import CommonClasses.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigZagLevelOrderTraversal {

  public List<List<Integer>> zigzagLevelOrderTrversal(TreeNode root) {

    List<List<Integer>> sol = new ArrayList<>();

    travel(root, sol, 0);

    return sol;
  }

  private static void travel(TreeNode curr, List<List<Integer>> sol, int level) {

    if (curr == null)
      return;

    if (sol.size() <= level) {
      List<Integer> newLevel = new LinkedList<>();
      sol.add(newLevel);
    }

    List<Integer> collection = sol.get(level);

    if (level % 2 == 0)
      collection.add(curr.val);
    else
      collection.add(0, curr.val);

    travel(curr.left, sol, level+1);
    travel(curr.right, sol, level+1);
  }
}
