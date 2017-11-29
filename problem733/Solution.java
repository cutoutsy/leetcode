import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Integer> rQ = new LinkedList<Integer>();
        Queue<Integer> cQ = new LinkedList<Integer>();
        boolean[][] pixeled = new boolean[image.length][image[0].length];
        rQ.add(sr);
        cQ.add(sc);
        int r = 0;
        int c = 0;
        int pre = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            pre = image[r][c];
            image[r][c] = newColor;
            pixeled[r][c] = true;
            walkTo(pre, r - 1, c, image, rQ, cQ, pixeled);   //up
            walkTo(pre, r + 1, c, image, rQ, cQ, pixeled);   // down
            walkTo(pre, r, c - 1, image, rQ, cQ, pixeled);   // left
            walkTo(pre, r, c + 1, image, rQ, cQ, pixeled);   // right
        }
        return image;
    }

    private void walkTo(int pre, int toR, int toC, int[][] image, Queue<Integer> rQ, Queue<Integer> cQ, boolean[][] pixed) {
        if (toR < 0 || toR == image.length || toC < 0 || toC == image[0].length || image[toR][toC] != pre || pixed[toR][toC] == true) {
            return;
        }
        rQ.add(toR);
        cQ.add(toC);
    }
}
