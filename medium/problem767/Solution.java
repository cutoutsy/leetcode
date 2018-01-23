import java.util.PriorityQueue;

public class Solution {

    public String reorganizeString(String S) {
        char[] alphabet = new char[26];
        for (char c : S.toCharArray()) {
            alphabet[c - 'a']++;
            if (alphabet[c - 'a'] > (S.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] > 0) {
                pq.add(new int[] {i + 97, alphabet[i]});
            }
        }

        StringBuffer ans = new StringBuffer();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (ans.length() == 0 || first[0] != ans.charAt(ans.length() -1)) {
                ans.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                ans.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return ans.toString();
    }



    public static void main(String[] args) {
        String S1 = "aab";
        String S2 = "aaab";
        String S3 = "a";
        String S4 = "baaba";
        String S5 = "cxmwmmm";
        Solution solution = new Solution();
        System.out.println(solution.reorganizeString(S1));
        System.out.println(solution.reorganizeString(S2));
        System.out.println(solution.reorganizeString(S3));
        System.out.println(solution.reorganizeString(S4));
        System.out.println(solution.reorganizeString(S5));
    }
}
