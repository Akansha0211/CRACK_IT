class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // map is of element -length
        int ans = 0;
       for(int n : nums){
            if(!map.containsKey(n)){
                int startPt = n;
                int endPt = n;
                if(map.containsKey(startPt-1)){
                    startPt = n - map.get(startPt-1);
                }
                if(map.containsKey(endPt+1)){
                    endPt = n + map.get(endPt+1);
                }
                
                int newLen = endPt - startPt +1;
                map.put(startPt, newLen);
                map.put(endPt, newLen);
                
                if(startPt != n && endPt != n){
                    map.put(n,1);
                }
                ans = Math.max(ans, newLen);
            }
       }
        return ans;
    }
}