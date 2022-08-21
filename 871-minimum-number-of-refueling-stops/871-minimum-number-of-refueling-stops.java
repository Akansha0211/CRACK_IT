class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i<stations.length; i++){
            int position = stations[i][0];
            int fuel = stations[i][1];
            while(startFuel < position){
                if(pq.isEmpty())return -1;
                startFuel+=pq.poll();
                ans++;
            }
            pq.add(fuel);
        }
        while(startFuel < target){
            if(pq.isEmpty())return -1;
            startFuel += pq.poll();
            ans++;
        }
        return ans;
    }
}