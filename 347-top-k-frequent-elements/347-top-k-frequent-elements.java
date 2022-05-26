class Solution {
    class Pair implements Comparable<Pair>{
        int element;
        int freq;
        
        public Pair(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            return o.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        ArrayList<Pair> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(new Pair(key, map.get(key)));
        }
        Collections.sort(list);
        
        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] = list.get(i).element;
        }
        return res;
    }
}