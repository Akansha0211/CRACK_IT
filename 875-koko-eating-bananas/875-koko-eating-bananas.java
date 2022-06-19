class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int val :piles){
            max = Math.max(max, val);
        }
        int lo = 1; // when no.of hrs > sum
        int hi = max;
        int ans = 0;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int reqHrs = 0;
            for(int val : piles){
                reqHrs+= Math.ceil((val * 1.0)/mid);
            }
            if(reqHrs <= h){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        // System.out.println((int)Math.ceil((3*1.0)/2));
        // System.out.println(6/2);
        
        return ans;
    }
}