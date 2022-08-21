class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // int ans = 0;
        // for(int i = 0; i<stations.length; i++){
        //     int position = stations[i][0];
        //     int fuel = stations[i][1];
        //     // startFuel == max position you can reach
        //     if(startFuel < position){
        //         if(pq.isEmpty())return -1;
        //         startFuel+=pq.poll();
        //         ans++;
        //     }
        //     pq.add(fuel); // when psoition can be reached
        // }
        // // after crossing the whole array the target is not reached 
        // // that means target = 130 and last position of array = 60
        // // [10,60],[20,30],[30,30],[60,40]
        // while(startFuel < target){
        //     if(pq.isEmpty())return -1;
        //     startFuel+=pq.poll();
        //     ans++;
        // }
        // return ans;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        for(int i = 0; i<stations.length; i++){
            int position = stations[i][0];
            int fuel = stations[i][1];
            while(startFuel < position){
                if(pq.isEmpty())return -1;
                startFuel += pq.poll();
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