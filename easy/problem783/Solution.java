public class Solution {
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        process(root);
        return ans;
    }

    private void process(TreeNode root) {
        if (root.left != null) {
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            ans = Math.min(root.val - left.val, ans);
            process(root.left);
        }
        if (root.right != null) {
            TreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            ans = Math.min(right.val - root.val, ans);
            process(root.right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);
        System.out.println(solution.minDiffInBST(root));
    }
}
