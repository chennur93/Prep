package CompanyInterviewQuestions.Microsoft.OTS;

import CommonClasses.TreeNode;

public class visibleNodesOfTree {
    int count;
    public int solution(TreeNode T) {
        if (T == null)
            return 0;

        if (T.left == null && T.right == null)
            return 1;

        isVisible(T.left, T.val);
        isVisible(T.right, T.val);
        return count + 1;
    }

    private void isVisible(TreeNode T, int highest) {
        if (T == null)
            return;
        if (T.val >= highest) {
            highest = Math.max(T.val, highest);
            count++;
        }
        isVisible(T.left, highest);
        isVisible(T.right, highest);
    }
}
