class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            int[]temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int lo = 0; 
        int hi = nums1.length;
        while(lo<=hi){
            int mid1 = (lo+hi)/2;
            int mid2 = (nums1.length+nums2.length +1)/2 - mid1;
            
            int left1 = (mid1 ==0)?Integer.MIN_VALUE : nums1[mid1-1];
            int left2 = (mid2==0)?Integer.MIN_VALUE :nums2[mid2-1];
            int right1 = (mid1==nums1.length)?Integer.MAX_VALUE: nums1[mid1];
            int right2 = (mid2 == nums2.length)? Integer.MAX_VALUE : nums2[mid2];
            
            // if valid partition is found
            if(left1 <=right2 && left2 <=right1){
                if((nums1.length + nums2.length)%2 ==0){
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                }else{
                    return (Math.max(left1, left2))/1.0;
                }
            }else if(left1 > right2){
                hi = mid1-1;
            }else{
                lo = mid1+1;
            }
        }
        return 0.0;
    }
}