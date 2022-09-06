class Solution {
    public int change(int amount, int[] coins) {
        HashMap<String,Integer> map = new HashMap<>();
        return changeHelper(0, amount, coins, map);
    }
    public int changeHelper(int index, int amount, int[] coins, HashMap<String,Integer> map){
        if(amount == 0)return 1;
        if(index >= coins.length)return 0;
        String key = Integer.toString(index) + "#" + Integer.toString(amount);
        if(map.containsKey(key))return map.get(key);
        int take = 0;
        if(amount >= coins[index]){
            take = changeHelper(index, amount-coins[index], coins, map);
        }
        int dontTake = changeHelper(index+1, amount, coins, map);
        map.put(key, (take+dontTake));
        return take + dontTake;
    }
}