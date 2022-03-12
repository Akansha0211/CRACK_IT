class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return minCostHelper(cost.length, cost, map);
    }
    public int minCostHelper(int n, int[] cost, HashMap<Integer,Integer> map){
        if(n==1 || n==0)return 0;
        if(map.containsKey(n))return map.get(n);
        int choice1 = cost[n-1] + minCostHelper(n-1, cost, map);
        int choice2 = cost[n-2] + minCostHelper(n-2, cost, map);
        map.put(n, Math.min(choice1, choice2));
        return Math.min(choice1, choice2);
    }
}