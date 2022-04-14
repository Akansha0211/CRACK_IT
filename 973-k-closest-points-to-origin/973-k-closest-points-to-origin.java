class Solution {
    class Pair implements Comparable<Pair>{
        int index;
        int distance;
        Pair(){
            
        }
        Pair(int index,int distance){
            this.index = index;
            this.distance = distance;
        }
        public int compareTo(Pair o){
            return this.distance - o.distance;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<points.length; i++){
            int xCord = points[i][0];
            int yCord = points[i][1];
            int distance = (xCord * xCord) + (yCord* yCord);
            if(pq.size() <k){
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
            Pair rem = pq.remove();
            int index = rem.index;
            ans[i] = points[index];
            i++;
        }
        return ans;
    }
}