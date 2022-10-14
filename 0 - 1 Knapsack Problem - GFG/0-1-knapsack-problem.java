//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n][W+1];
         for(int[] row : dp){
              Arrays.fill(row, -1);
         }
         return knapsackHelper(n-1, W, wt, val, dp);
    } 
    static int knapsackHelper(int index, int capacity, int[] wt, int[] val, int[][] dp){
        
        if(index == 0){
            if(wt[0] <= capacity){
                return val[0];
            }
            return 0;
        }
        if(dp[index][capacity] != -1)return dp[index][capacity];
        int notTake = knapsackHelper(index-1, capacity, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if(wt[index] <= capacity){
            take = val[index]  + knapsackHelper(index-1, capacity - wt[index], wt, val, dp);
        }
        return dp[index][capacity] =  Math.max(take, notTake);
    }
}


