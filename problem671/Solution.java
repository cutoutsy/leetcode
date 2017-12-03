public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        int res =  Math.min(process(root.left, min), process(root.right, min));
        return res == 0 ? -1 : res;
    }

    public int process(TreeNode root, int min) {
        if (root == null) {
            return 0;
        }
        if (root.val > min) {
            return root.val;
        }
        return Math.min(process(root.left, min), process(root.right, min));
    }
}
