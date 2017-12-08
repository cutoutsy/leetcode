public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] chas = S.toCharArray();
        int end = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != '-') {
                end++;
            }
            if (chas[i] >= 'a' && chas[i] <= 'z') {
                chas[i] = (char) (chas[i] - 32);
            }
        }
        if (end == 0) {
            return "";
        }
        int dashes = end % K == 0 ? end / K - 1 : end / K;
        char[] res = new char[end + dashes];
        int index = res.length;
        int count = 0;
        for (int i = chas.length - 1; i > -1; i--) {
            if (chas[i] != '-') {
                res[--index] = chas[i];
                count++;
                if (count == K && index > 0) {
                    res[--index] = '-';
                    count = 0;
                }
            }
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        String s1 = "5F3Z-2e-9-w";
        String s2 = "2-5g-3-J";
        Solution solution = new Solution();
        System.out.println(solution.licenseKeyFormatting(s1, 4));
        System.out.println(solution.licenseKeyFormatting(s2, 2));

    }
}
