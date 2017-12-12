import java.util.LinkedList;
import java.util.List;

public class Solution {

    private class TrieNode {
        private int end;
        private TrieNode[] map;

        public TrieNode() {
            end = 0;
            map = new TrieNode[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new LinkedList<String>();
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

        for (String word : words) {
            char[] chword = word.toCharArray();
            if (process(root, chword, 0, chword.length - 1, 0)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean process(TrieNode root, char[] chword, int start, int end, int th) {
        int nums = 0;
        if (start > end && th > 1) {
            return true;
        } else if (start > end && th < 1) {
            return false;
        }
        TrieNode node = root;
        int index = 0;
        for (int i = start; i <= end; i++) {
            index = chword[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            if (node.map[index].end == 1) {
                if (process(root, chword, i + 1, end, th + 1)) {
                    return true;
                }
            }
            node = node.map[index];
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        String[] words1 = {"a", "b", "ab", "abc"};
        Solution solution = new Solution();
        List<String> ans = solution.findAllConcatenatedWordsInADict(words1);
        for (String word : ans) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
