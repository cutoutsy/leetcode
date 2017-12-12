
public class Solution {

    private int maxLength = 0;
    private String ans = "";

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.map[index] == null) {
                    node.map[index] = new TrieNode();
                }
                node = node.map[index];
            }
            node.end++;
        }
        dfs(root, 0, "");
        return ans;
    }

    private void dfs(TrieNode root, int len, String cur) {
        TrieNode[] temp = root.map;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null && temp[i].end != 0) {
                if (len + 1 > maxLength) {
                    maxLength = len + 1;
                    ans = cur + (char)(i + 'a');
                }
                dfs(temp[i], len + 1, cur + (char)(i + 'a'));
            }
        }
    }

    private class TrieNode {
        private int path;
        private int end;
        private TrieNode[] map;

        public TrieNode() {
            end = 0;
            map = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Solution solution = new Solution();
        System.out.println(solution.longestWord(words));
    }
}
