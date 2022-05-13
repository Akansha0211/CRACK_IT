// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        HashMap<String,Integer> map = new HashMap<>();
        return maxProfitHelper(price, 0, n, map);
    }
    
    public int maxProfitHelper(int[] price, int index, int target, HashMap<String, Integer> map){
        if(target == 0)return 0;
        if(index+1 > price.length)return 0;
        String key = index + "#" + target;
        if(map.containsKey(key))return map.get(key);
        int consider = 0;
        if(index + 1 <= target){
            consider = price[index] +  maxProfitHelper(price, index, target - (index+1), map);
        }
        int notConsider = maxProfitHelper(price, index+1, target, map);
        map.put(key, Math.max(consider, notConsider));
        return Math.max(consider, notConsider);
    }
    
}