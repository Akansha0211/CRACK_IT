class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer,Integer> map = new HashMap<>();
        return minCostHelper(days, costs, 0, map);
    }
    public int minCostHelper(int[] days, int[] costs, int index, Map<Integer,Integer> map){
        if(index>= days.length)return 0;
        
        if(map.containsKey(index))return map.get(index);
        
        int option1 =costs[0] + minCostHelper(days, costs, index+1, map);
        
        int k = index;
        for(; k<days.length; k++){
            if(days[k] >= days[index] + 7){
                break;
            }
        }
        int option2 = costs[1] + minCostHelper(days, costs,k, map);
        
        k = index;
        for(; k<days.length; k++){
            if(days[k] >= days[index] + 30){
                break;
            }
        }
        int option3 = costs[2] + minCostHelper(days, costs, k, map);
        
        map.put(index, Math.min(option1, Math.min(option2, option3)));
        
        return Math.min(option1, Math.min(option2, option3));
    }
}