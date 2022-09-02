class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
        }
        while(!pq.isEmpty()){
            int smallest = pq.poll();
            for(int i = 1; i<k; i++){
                if(!pq.contains(smallest+i))return false;
                else pq.remove(smallest+i);
            }
        }
        return true;
    }
}