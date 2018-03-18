
/**
 * Leetcode 800: Similar RGB Color
 * @author cutoutsy@gmail.com
 */
public class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 1; i < color.length(); i = i + 2) {
            sb.append(similar(color.substring(i, i + 2)));
        }
        return sb.toString();

    }

    private String similar(String str) {
        String[] letters = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++) {
            if (Math.abs(Integer.valueOf(letters[i] + letters[i], 16) - Integer.valueOf(str, 16)) < min) {
                min = Math.abs(Integer.valueOf(letters[i] + letters[i], 16) - Integer.valueOf(str, 16));
                minIndex = i;
            }
        }
        return letters[minIndex] + letters[minIndex];
    }


    public static void main(String[] args) {
        String color = "#09f166";
        Solution solution = new Solution();
        System.out.println(solution.similarRGB(color));
    }
}

