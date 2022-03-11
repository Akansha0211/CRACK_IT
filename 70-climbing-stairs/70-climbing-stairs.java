class Solution {
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return climbStairsHelper(n, map);
    }
    public int climbStairsHelper(int n , HashMap<Integer,Integer> map){
        if(n== 0|| n==1)return 1;
        if(map.containsKey(n))return map.get(n);
        int choice1 = climbStairsHelper(n-1, map);
        int choice2 = climbStairsHelper(n-2, map);
        map.put(n, choice1+choice2);
        return choice1 + choice2;
    }
}