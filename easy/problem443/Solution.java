public class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (count != 1) {
                    String num = String.valueOf(count);
                    for (int j = 0; j < num.length(); j++) {
                        chars[++index] = num.charAt(j);
                    }
                }
                chars[++index] = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 1) {
            String num = String.valueOf(count);
            for (int j = 0; j < num.length(); j++) {
                chars[++index] = num.charAt(j);
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a','a','b','b','c','c','c'};
        char[] chars2 = {'a'};
        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] chars4 = {'a','a','a','b','b','a','a'};
        Solution solution = new Solution();
        System.out.println(solution.compress(chars1));
        System.out.println(solution.compress(chars2));
        System.out.println(solution.compress(chars3));
        System.out.println(solution.compress(chars4));
    }
}
