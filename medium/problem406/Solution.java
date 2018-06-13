class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[] order = {0, 1};
        Arrays.sort(people, new Comparator<Object>(){
            public int compare(Object o1, Object o2) {    
                  int[] one = (int[]) o1;    
                  int[] two = (int[]) o2;    
                  for (int i = 0; i < order.length; i++) {    
                      int k = order[i];    
                      if (one[k] > two[k]) {    
                          return (i == 0 ? -1 : 1);    
                      } else if (one[k] < two[k]) {    
                          return (i == 0 ? 1 : -1);    
                      } else {    
                          continue; 
                      }    
                  }    
                  return 0;    
              }
        });
        List<int[]> list = new LinkedList<>();
        for(int[] ele : people) {
            list.add(ele[1], ele);
        }
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}