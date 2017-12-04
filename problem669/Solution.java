public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
       if (R < root.val) {
           return trimBST(root.left, L, R);
       }
       if (L > root.val) {
           return trimBST(root.right, L, R);
       }
       root.left = trimBST(root.left, L, R);
       root.right = trimBST(root.right, L, R);
       return root;
    }

}
