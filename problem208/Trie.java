public class Trie {
    /** Initialize your data structure here. */
    boolean have;
    private class TrieNode {
        boolean have;
        TrieNode[] next = new TrieNode[26];

        public TrieNode() {
            for (int i = 0; i < next.length; i++) {
                next[i] = null;
            }
            have = false;
        }
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(now.next[c] == null){
                now.next[c] = new TrieNode();
            }
            now = now.next[c];
        }
        now.have = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(now.next[c] == null){
                return false;
            }
            now = now.next[c];
        }
        return  now.have;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(now.next[c] == null){
                return false;
            }
            now = now.next[c];
        }
        return now != null;
    }
}
