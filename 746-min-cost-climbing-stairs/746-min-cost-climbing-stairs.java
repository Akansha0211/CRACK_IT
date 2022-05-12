class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return Math.min(minCostHelper(0, cost, map), minCostHelper(1, cost, map));
    }
    public int minCostHelper(int index, int[] cost, HashMap<Integer,Integer> map){
        
        if(index >= cost.length)return 0;
        if(map.containsKey(index))return map.get(index);
        int choice1 = minCostHelper(index+1, cost, map);
        int choice2 = minCostHelper(index+2, cost, map);
        
        map.put(index, cost[index] + Math.min(choice1, choice2));
        return cost[index] + Math.min(choice1 , choice2);
    }
}