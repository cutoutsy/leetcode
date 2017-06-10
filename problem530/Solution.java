import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> list = new ArrayList<Integer>();

    public int getMinimumDifference(TreeNode root){
        middleIterator(root);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1) - list.get(i) < diff){
                diff = list.get(i+1) - list.get(i);
            }
        }
        return diff;
    }

    public void middleIterator(TreeNode root){
        if (root.left != null) middleIterator(root.left);
        list.add(root.val);
        if (root.right != null) middleIterator(root.right);
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        Solution solution = new Solution();
        System.out.println(solution.getMinimumDifference(root));
    }
}
