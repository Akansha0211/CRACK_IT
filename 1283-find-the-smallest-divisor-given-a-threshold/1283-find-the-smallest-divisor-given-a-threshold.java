class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int hi = max;
        int ans = 0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int sum = 0;
            for(int i = 0; i<nums.length; i++){
                sum+= Math.ceil((nums[i]*1.0)/mid);
            }
            if(sum <= threshold){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
}