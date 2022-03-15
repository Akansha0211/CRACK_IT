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
        Map<String, Integer> map = new HashMap<>();
        return maxProfitHelper(price, 0, n, map);
    }
    public int maxProfitHelper(int[] price , int index, int length, Map<String, Integer> map){
        if(length == 0)return 0;
        if(index+1 > price.length)return 0;
        String key = Integer.toString(index) + "#" + Integer.toString(length);
        if(map.containsKey(key))return map.get(key);
        int consider = 0;
        if(index+1 <= length){
            consider = price[index] + maxProfitHelper(price, index, length - (index+1), map);
        }
        int notConsider = maxProfitHelper(price, index+1, length, map);
        map.put(key , Math.max(consider, notConsider));
        return Math.max(consider, notConsider);
    }
}