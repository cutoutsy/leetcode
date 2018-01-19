import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode last = root;
        TreeNode nlast = null;
        queue.offer(root);
        List<Integer> level = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            level.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
                nlast = root.left;
            }
            if (root.right != null) {
                queue.offer(root.right);
                nlast = root.right;
            }
            if (root == last && !queue.isEmpty()) {
                res.add(0, level);
                level = new LinkedList<Integer>();
                last = nlast;
            }
        }
        res.add(0, level);
        return res;
    }
}
