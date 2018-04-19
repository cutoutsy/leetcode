class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        char[] charGraph = paragraph.toCharArray();
        Map<String, Integer> words = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charGraph.length; i++) {
            if ((charGraph[i] >= 'a' && charGraph[i] <= 'z') || (charGraph[i] >= 'A' && charGraph[i] <= 'Z')) {
                sb.append(charGraph[i]);
            } else {
                if (sb.length() != 0) {
                    String temp = sb.toString().toLowerCase();
                    words.put(temp, words.getOrDefault(temp, 0) + 1);
                    sb = new StringBuffer();
                }
            }
        }
        if(sb.length() != 0) {
            String temp = sb.toString().toLowerCase();
            words.put(temp, words.getOrDefault(temp, 0) + 1);
        }
        for (String ele : banned) {
            words.remove(ele);
        }
        int max = -1;
        String word = "";
        for (String ele : words.keySet()) {
            if (words.get(ele) > max) {
                max = words.get(ele);
                word = ele;
            }
        }
        return word;
    }
}