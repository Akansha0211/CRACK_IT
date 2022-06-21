class Solution {
    class Pair implements Comparable<Pair>{
        int endPt;
        int pasDrop;
        
        public Pair(int endPt, int pasDrop){
            this.endPt = endPt;
            this.pasDrop = pasDrop;
        }
        public int compareTo(Pair o){
            return this.endPt - o.endPt;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        // array trips is already sorted on start(i.e from)
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        int cntPss = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int[] trip : trips){
            while(!pq.isEmpty() && pq.peek().endPt <= trip[1]){
                cntPss-=pq.poll().pasDrop;
            }
            cntPss+= trip[0];
            pq.add(new Pair(trip[2], trip[0]));
            if(cntPss > capacity)return false;
        } 
        return true;
        
    }
}