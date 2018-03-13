import java.util.*;

/**
 * Leetcode 797: All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 * @author cutoutsy@gmail.com
 */
public class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int nodes = graph.length;
        if (nodes == 0) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        dfs(graph, ans, path, 0, nodes -1);
        return ans;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> path,  int start, int end) {
        path.add(start);
        if (start == end) {
            ans.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        for (Integer item : graph[start]) {
            dfs(graph, ans, path, item, end);
        }
        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        Solution solution = new Solution();
        solution.allPathsSourceTarget(graph);
    }
}
