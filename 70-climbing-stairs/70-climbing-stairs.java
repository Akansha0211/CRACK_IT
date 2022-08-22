class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return climbHelper(0, n, map);
    }
    public int climbHelper(int curr, int n, HashMap<Integer,Integer> map){
        if(curr == n)return 1;
        if(curr > n)return 0;
        
        if(map.containsKey(curr))return map.get(curr);
        int left = climbHelper(curr+1, n, map);
        int right = climbHelper(curr+2, n, map);
        map.put(curr, left+right);
        return  left + right;
    }
}