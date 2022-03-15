class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<String,Integer> map = new HashMap<>();
        long ans = minCoins(coins, 0, amount, map);
        if(ans >= Integer.MAX_VALUE)return -1;
        return (int)ans;
    }
    public long minCoins(int[] coins, int index, int amount, Map<String,Integer> map){
        if(amount ==0)return 0;
        if(index >= coins.length)return Integer.MAX_VALUE;
        String key = Integer.toString(index) + "#" + Integer.toString(amount);
        if(map.containsKey(key))return map.get(key);
        long consider = Integer.MAX_VALUE;
        if(coins[index] <= amount){
            consider = 1 + minCoins(coins, index, amount - coins[index], map);
        }
        long notConsider = minCoins(coins, index+1, amount, map);
        map.put(key, (int)Math.min(consider, notConsider));
        return Math.min(consider, notConsider);
    }
}