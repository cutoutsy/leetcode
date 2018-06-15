/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderRecur(root, ans);
        return ans;
    }
    
    private void inorderRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderRecur(root.left, res);
        res.add(root.val);
        inorderRecur(root.right, res);
    }
}