class Solution {
    public int change(int amount, int[] coins) {
        Map<String, Integer> map = new HashMap<>();
        return totalCombinations(coins, 0, amount, map);
    }
    public int totalCombinations(int[] coins, int index, int amount, Map<String, Integer> map){
        if(amount == 0)return 1;
        if(index>= coins.length)return 0;
        String key = Integer.toString(index) + "#" + Integer.toString(amount);
        if(map.containsKey(key))return map.get(key);
        int consider = 0;
        if(coins[index] <= amount){
            consider = totalCombinations(coins, index, amount- coins[index], map);
        }
        int notConsider = totalCombinations(coins, index+1, amount, map);
        map.put(key, consider + notConsider);
        return consider + notConsider;
    }
}