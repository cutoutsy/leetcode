class Solution {
    
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new LinkedList<>();
        Map<String, Integer> domainNum = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            int nums = Integer.valueOf(cpdomains[i].split(" ")[0]);
            String[] domains = cpdomains[i].split(" ")[1].split("\\.");
            String temp = "";
            for(int j = domains.length - 1; j > -1; j--) {
                temp = temp == "" ? domains[j] : (domains[j] + "." + temp);
                domainNum.put(temp, domainNum.getOrDefault(temp, 0) + nums);
            }
        }
        for (String ele : domainNum.keySet()) {
            ans.add(domainNum.get(ele) + " " + ele);
        }
        return ans;
    }
}