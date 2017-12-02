public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return process(nums, 0, nums.length - 1);
    }

    private TreeNode process(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = process(nums, start, mid - 1);
        head.right = process(nums, mid + 1, end);
        return head;
    }
}
