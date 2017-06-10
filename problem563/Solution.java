public class Solution {
    int tilt = 0;
    static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int findTilt(TreeNode root){
        if (root == null) return 0;
        laterIterator(root);
        return tilt;
    }

    public int laterIterator(TreeNode root){
        if (root == null) return 0;
        int leftSum = laterIterator(root.left);
        int rightSum = laterIterator(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum+rightSum+root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.findTilt(root));
    }
}
