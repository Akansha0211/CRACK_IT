class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum_gas = 0;
        int sum_cost = 0;
        for(int i = 0; i<gas.length; i++){
            sum_gas+=gas[i];
            sum_cost+=cost[i];
        }
        if(sum_gas < sum_cost)return -1;
        int total = 0;
        int startIndex = 0;
        for(int i = 0; i< gas.length; i++){
            total+=gas[i] - cost[i];
            if(total < 0){
                total = 0;
                startIndex = i+1; 
            }
        }
        return startIndex;
    }
}