class Solution {
    class Pair implements Comparable<Pair>{
        int index;
        int distance;
        //Pair(){}
        Pair(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
        public int compareTo(Pair o){
            return this.distance - o.distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // we need max priority Queue ( as we want k amllest elements.
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder()); // max pq
        for(int i = 0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int distance = (x*x) + (y*y);
            if(pq.size()<k){
                pq.add(new Pair(i, distance));
            }else{
                if(pq.peek().distance > distance){
                    pq.remove();
                    pq.add(new Pair(i, distance));
                }
            }
        }
        int[][] ans = new int[k][points[0].length];
        int i = 0;
        while(pq.size()>0){
            Pair rem = pq.poll();
            int index = rem.index;
            ans[i] = points[index];
            i++;
        }
        return ans;
    }
}