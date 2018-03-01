public class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    private int getHeight(TreeNode root, int level, boolean[] res) {
        if (root == null) {
            return level;
        }
        int lH = getHeight(root.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(root.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }


}
