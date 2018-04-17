class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        char[] charS = S.toCharArray();
        int count = 0;
        int lines = 0;
        for(int i = 0; i < charS.length; i++) {
            count += widths[charS[i] - 'a'];
            if (count > 100) {
                lines++;
                i--;
                count = 0;
            }
        }
        count = count == 100 ? 0 : count;
        lines = count == 0 ? lines : lines + 1;
        return new int[] {lines, count};
    }
}