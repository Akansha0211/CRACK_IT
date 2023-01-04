class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
        int minRounds = 0;
        for(int value : map.values()){
            if(value == 1)return -1;
            if(value%3 == 0){
                minRounds += value/3;
            }else{
                // value%3 = 1 value/3 -1 pairs of triplets + 2 pairs of 2
                // value%3 =2   value/3 pairs of triplets + 1 pair of 2
                minRounds+= value/3 +1;
            }
        }
        return minRounds;
    }
}