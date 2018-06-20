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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nLast = null;
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            temp.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
                nLast = root.left;
            }
            if (root.right != null) {
                queue.offer(root.right);
                nLast = root.right;
            }
            if (root == last && !queue.isEmpty()) {
                last = nLast;
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        ans.add(temp);
        return ans;
    }
}