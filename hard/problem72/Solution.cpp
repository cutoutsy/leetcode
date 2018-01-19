class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.length(), n = word2.length();
        vector<int> dp(n+1);
        for (int i = 0; i <= m; ++i) {
            int last;
            for (int j = 0; j <= n; ++j) {
                if(i == 0){
                    dp[j] = j;
                }else if(j == 0){
                    last = dp[j];
                    dp[j] = i;
                }else{
                    int temp = dp[j];
                    dp[j] = min(last + ((word1[i-1] == word2[j-1])?0:1), min(dp[j-1]+1, dp[j]+1));
                    last = temp;
                }
            }
        }
        return dp[n];
    }
};