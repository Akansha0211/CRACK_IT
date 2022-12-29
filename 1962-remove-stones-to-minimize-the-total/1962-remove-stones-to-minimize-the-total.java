class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<piles.length; i++){
            pq.add(piles[i]);
        }
        int i = 1;
        while(!pq.isEmpty() && i<=k){
            int num = pq.remove();
            int changed = num - (int)(Math.floor(num/2));
            pq.add(changed);
            i++;
        }
        int sum = 0;
        while(!pq.isEmpty()){
            sum+=pq.remove();
        }
        
        return sum;
    }
}