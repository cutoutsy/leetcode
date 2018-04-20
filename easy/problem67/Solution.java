class Solution {
    public String addBinary(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int cur = 0;
        StringBuffer sb = new StringBuffer();
        int i = charA.length - 1;
        int j = charB.length - 1;
        while (i > -1 || j > -1) {
            int temp = 0;
            if (i == -1) {
                temp = (charB[j--] - '0') + cur;
            } else if (j == -1) {
                temp = (charA[i--] - '0') + cur;
            } else {
                temp = (charA[i--] - '0') + (charB[j--] - '0') + cur;
            }
            if (3 == temp) {
                cur = 1;
                sb.append(1);
            } else if (2 == temp) {
                cur = 1;
                sb.append(0);
            } else if (1 == temp) {
                cur = 0;
                sb.append(1);
            } else if (0 == temp) {
                cur = 0;
                sb.append(0);
            }
        }
        if (cur == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}