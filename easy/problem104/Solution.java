/**
 * Definition for a binary tree node.
 * public class TreeNode{
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        root.left = left;
        TreeNode leftTwo = new TreeNode(7);
        left.left = leftTwo;
        Solution solution = new Solution();
        int result = solution.maxDepth(root);
        System.out.println(result);
    }
}
