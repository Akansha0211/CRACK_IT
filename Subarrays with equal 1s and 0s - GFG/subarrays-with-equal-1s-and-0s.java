// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int pc0 = 0;
        int pc1 = 0;
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0)pc0+=1;
            else if(arr[i] == 1)pc1+=1;
            if(map.containsKey(pc0-pc1)){
                count+= map.get(pc0-pc1);
            }
            map.put(pc0-pc1, map.getOrDefault(pc0-pc1, 0)+1);
        }
        return count;
    }
}


