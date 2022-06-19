class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : weights){
            sum+= i;
            max = Math.max(max, i);
        }
        
        int lo = max;
        int hi = sum;
        int ans = 0;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            int reqDays = 1;
            int wt = 0;
            for(int i : weights){
                if(wt+ i <= mid){
                    wt+= i;
                }else{
                    wt = i;
                    reqDays++;
                }
            }
            if(reqDays <= days){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
}