class Solution {
    class Pair implements Comparable<Pair>{
        int element;
        int freq;
        
        public Pair(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            // return o.freq - this.freq;
            return this.freq - o.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
        }
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = pq.poll().element;
        }
        return res;
    }
}