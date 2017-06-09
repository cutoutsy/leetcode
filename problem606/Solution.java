public class Solution {
    String result = "";
    public String tree2str(TreeNode t){
        if (t != null){
            result += t.val;
            if(t.left != null || t.right != null){
                result += "(";
            }
            tree2str(t.left);
            if(t.left != null || t.right != null){
                result += ")";
            }
            if(t.right != null){
                result += "(";
                tree2str(t.right);
                result += ")";
            }
        }
        return result;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        Solution solution = new Solution();
        System.out.println(solution.tree2str(root));
    }
}
