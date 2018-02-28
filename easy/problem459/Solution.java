public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] charS = s.toCharArray();
        int n = charS.length;
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                boolean temp = false;
                for (int j = i; j < charS.length; j = j + i) {
                    for (int k = j; k < j + i; k++) {
                        if (charS[k] != charS[k - i]) {
                            temp = true;
                            break;
                        }
                    }
                    if (temp) {
                        break;
                    }
                }
                if (!temp) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int k = n / i;
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                int j;
                for (j = 1; j < k; j++) {
                    if (!sub.equals(s.substring(j * i, i + j * i))) {
                        break;
                    }
                }
                if (j == k) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern1("abab"));
        System.out.println(solution.repeatedSubstringPattern1("abac"));
        System.out.println(solution.repeatedSubstringPattern1("abcabcabcabc"));
    }
}
