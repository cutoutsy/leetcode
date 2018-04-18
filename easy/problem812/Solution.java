class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0.0;
        int size = points.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    double area = Math.abs((points[j][0] - points[i][0])*(points[k][1] - points[i][1]) - (points[k][0] - points[i][0]) * (points[j][1] - points[i][1])) / 2.0;
                    if (area > ans) {
                        ans = area;
                    }
                }
            }
        }
        return ans;
    }
}