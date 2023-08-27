package OtherProblems;

public class InorderSuccessorOfBST {

    static class Node {
        Node left;
        Node right;
        Node parent;
        int val;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    Node root;

    public Node findInorderSuccessor(Node inputNode) {
        if ((inputNode.right == null)) {
            if (inputNode.parent.left == inputNode) {
                return inputNode.parent;
            }else {
                Node currentNodeParent = inputNode.parent;
                while (currentNodeParent.val <= inputNode.val) {
                    if (currentNodeParent == root) {
                        return null;
                    }
                    currentNodeParent = currentNodeParent.parent;
                }
                return currentNodeParent;
            }
        }else {
            return getLeftMost(inputNode.right);
        }
    }

     Node getLeftMost(Node input) {
        if (input.left != null)
            getLeftMost(input.left);

         return input;
     }
}
