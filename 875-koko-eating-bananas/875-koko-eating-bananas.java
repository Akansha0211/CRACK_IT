class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int max = Integer.MIN_VALUE;
        for(int i : piles){
            max = Math.max(max, i);
        }
        int hi = max;
        int ans = 0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int req_hours = 0;
            for(int i : piles){
                req_hours += Math.ceil((i*1.0)/mid);
            }
            if(req_hours<=h){
                ans = mid;
                hi=mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
}