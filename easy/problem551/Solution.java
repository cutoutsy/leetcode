public class Solution {
    public boolean checkRecord(String s) {
        if (s == null) {
            return true;
        }
        char[] chas = s.toCharArray();
        int absent = 0;
        int clate = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == 'A') {
                absent++;
                if (absent == 2) {
                    return false;
                }
            }
            if (chas[i] == 'L') {
                if ((i - 1 > -1 && chas[i - 1] == 'L') && (i + 1 < chas.length && chas[i + 1] == 'L')) {
                    return false;
                }
            }
        }
        return true;
    }
}
