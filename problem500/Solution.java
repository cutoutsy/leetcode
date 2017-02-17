public class Solution {
    public String[] findWords(String[] words){
        String[] reWords = new String[words.length];
        int num = 0;
        String[] keyboardLines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < words.length; i++){
            String oneWord = words[i];
            String alphabet = String.valueOf(oneWord.charAt(0)).toLowerCase();
            String ownLine = keyboardLines[2];
            if (keyboardLines[0].contains(alphabet)){
                ownLine = keyboardLines[0];
            }else if(keyboardLines[1].contains(alphabet)){
                ownLine = keyboardLines[1];
            }
            boolean flag = true;
            for (int j = 1; j < oneWord.length(); j++){
                String alphabetTemp = String.valueOf(oneWord.charAt(j)).toLowerCase();
                if(!ownLine.contains(alphabetTemp)){
                    flag = false;
                }
            }

            if (flag){
                reWords[num++] = oneWord;
            }
        }
        String[] reResults = new String[num];
        for (int i = 0; i < num; i++) {
            reResults[i] = reWords[i];
        }
        return reResults;
    }

    public static void main(String[] args){
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        Solution solution = new Solution();
        String[] reWords = solution.findWords(words);
        for (int i = 0; i < reWords.length; i++){
            System.out.println(reWords[i]);
        }
    }

}
