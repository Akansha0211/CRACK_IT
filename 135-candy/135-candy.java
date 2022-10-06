class Solution {
    public int candy(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 1;
        right[A.length-1] = 1;
        for(int i = 1; i<A.length; i++){
            if(A[i] > A[i-1]){
                left[i] = left[i-1] +1;
            }
            else{
                left[i] = 1;
            }
        }
        
        for(int j = right.length-2; j>=0; j--){
            if(A[j]>A[j+1]){
                right[j] = right[j+1] + 1;
            }else right[j] = 1;
        }
        int ans = 0;
        for(int i = 0; i<A.length; i++){
            ans+=Math.max(left[i], right[i]);
        }
        return ans;
    }
}