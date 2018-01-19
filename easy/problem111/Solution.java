public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root){
        if (root == null) return 0;
        if (root.left != null){
            if (root.right != null){
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            }else{
                return minDepth(root.left) + 1;
            }
        }else if(root.right != null){
            return minDepth(root.right) + 1;
        }else{
            return 1;
        }
    }
}
