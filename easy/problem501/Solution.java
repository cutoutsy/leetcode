import java.util.*;

public class Solution {
    Map<Integer, Integer> res = new HashMap<Integer, Integer>();
    public int[] findMode(TreeNode root) {
        process(root);
        List<Integer> ans = new LinkedList<Integer>();
        int max = 0;
        for (int key : res.keySet()) {
            System.out.println(key + ":" + res.get(key));
            if (res.get(key) > max) {
                ans.clear();
                ans.add(key);
                max = res.get(key);
            } else if (res.get(key) == max) {
                ans.add(key);
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return  answer;
    }

    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode1(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        res.put(root.val, res.getOrDefault(root.val, 0) + 1);
        process(root.left);
        process(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(1);
        Solution solution = new Solution();
        int[] ans = solution.findMode(root);
        System.out.println(Arrays.toString(ans));
    }
}
