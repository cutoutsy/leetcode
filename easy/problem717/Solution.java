public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index < bits.length - 1) {
            index += bits[index] == 1 ? 2 : 1;
        }
        return index == bits.length - 1 ? true : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input1 = {1, 0, 0};
        int[] input2 = {1, 1, 1, 0};
        System.out.println(solution.isOneBitCharacter(input1));
        System.out.println(solution.isOneBitCharacter(input2));
    }
}
