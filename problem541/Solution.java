public class Solution {

    public String reverseStr(String s, int k) {
        char[] chas = s.toCharArray();
        boolean rotate = true;
        for (int i = 0; i < chas.length; i = i + k) {
            if (rotate) {
                reverse(chas, i, i + k - 1);
            }
            rotate = !rotate;
        }
        return String.valueOf(chas);
    }

    public void reverse(char[] chas, int start, int end) {
        char tmp = 0;
        if (end > chas.length - 1) {
            end = chas.length - 1;
        }
        while (start < end) {
            tmp = chas[start];
            chas[start] = chas[end];
            chas[end] = tmp;
            start++;
            end--;
        }
    }
}
