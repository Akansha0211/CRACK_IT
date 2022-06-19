class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        int ansPtr = 0; // ans iterator
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i< nums.length; i++){
            if(!q.isEmpty() && q.peek() == (i-k)){
                // out of bounds element
                q.poll(); // remove from start
            }
            // now before adding at last to the deque , maintain decreasing order so that first element is maximum
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }
            q.offer(i);
            
            // Now check that lenth of window shpuld be k ( first window chcek rest will maintain)
            if(i>= k-1){
                ans[ansPtr++] = nums[q.peek()];
            }
        }
        return ans;
    }
}