// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair implements Comparable<Pair>{
        int element;
        int freq;
        public Pair(int element, int freq){
            this.element = element;
            this.freq = freq;
        }
        public int compareTo(Pair o){
            if(o.freq ==this.freq){
                return o.element - this.element;
            }
            return o.freq - this.freq;
        }
    }
    public int[] topK(int[] nums, int k) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i] , map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add( new Pair(key, map.get(key)));
        }
        
        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = pq.poll().element;
        }
        return ans;
    }
}