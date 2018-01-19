class Solution {
public:
    void help(int n, int x, int y, string now, vector<string> &answer){
        if(y == n){
            answer.push_back(now);
            return;
        }
        if(x < n){
            help(n, x + 1, y, now + "(", answer);
        }
        if(x > y){
            help(n, x, y + 1, now + ")", answer);
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        help(n, 0, 0, "", answer);
        return answer;
    }
};