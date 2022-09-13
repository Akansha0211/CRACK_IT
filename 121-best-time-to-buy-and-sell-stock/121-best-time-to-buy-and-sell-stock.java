class Solution {
    public int maxProfit(int[] prices) {
        HashMap<String,Integer> map = new HashMap<>();
        return maxProfitHelper(prices, 0, 1, 1, map);
    }
    public int maxProfitHelper(int[] prices, int index, int canBuy, int tranCount,HashMap<String,Integer> map){
        if(index >= prices.length || tranCount == 0)return 0;
        String key = index + "#" + canBuy + "#" + tranCount;
        if(map.containsKey(key))return map.get(key);
        if(canBuy == 1){
            int idle = maxProfitHelper(prices, index+1, canBuy, tranCount, map);
            int buy = - prices[index] +  maxProfitHelper(prices, index+1, 0, tranCount, map);
            map.put(key, Math.max(idle, buy));
            return Math.max(idle,buy);
        }else{
            int idle = maxProfitHelper(prices, index+1, canBuy, tranCount, map);
            int sell = + prices[index] + maxProfitHelper(prices, index+1, 1, tranCount -1, map);
            map.put(key, Math.max(idle,sell));
            return Math.max(idle, sell);
        }        
    }
}
