public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String t1Str = serialByPre(s);
        String t2Str = serialByPre(t);
        int index = getIndexOf(t1Str, t2Str);
        return index != -1 && (index == 0 || t1Str.charAt(index-1) == '!');
    }

    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    public int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if(cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);
        s.left.right.left = new TreeNode(0);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        TreeNode s1 = new TreeNode(12);
        TreeNode t1 = new TreeNode(2);
        Solution solution = new Solution();
        System.out.println(solution.isSubtree(s, t));
        System.out.println(solution.isSubtree(s1, t1));
    }

}
