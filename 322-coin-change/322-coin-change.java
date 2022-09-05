class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<String,Integer> map = new HashMap<>();
       long ans = coinChangeHelper(0, amount, coins, map);
        if(ans>=Integer.MAX_VALUE)return -1;
        return (int)ans;
        
    }
    public long coinChangeHelper(int index, int amount, int[] coins, HashMap<String,Integer> map){
        if(amount == 0)return 0;
        if(index>=coins.length)return Integer.MAX_VALUE;
        String key = Integer.toString(index) + "#" + Integer.toString(amount); 
        if(map.containsKey(key))return map.get(key);
        long take = Integer.MAX_VALUE;
        if(amount>= coins[index]){
            take = 1+ coinChangeHelper(index, amount-coins[index], coins, map);
        }
        long dontTake = coinChangeHelper(index+1, amount, coins, map);
        map.put(key, (int)Math.min(take, dontTake));
        return Math.min(take, dontTake);
    }
}