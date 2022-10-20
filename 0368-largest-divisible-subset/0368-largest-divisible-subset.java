class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];
        int max = 1;
        int lastIndex = 0;
        Arrays.fill(dp,1);
        for(int i = 0; i< nums.length; i++){
            hash[i] = i;
            for(int prev = 0; prev<i; prev++){
                if(nums[i]%nums[prev]==0 && 1+ dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list;
    }
   
}