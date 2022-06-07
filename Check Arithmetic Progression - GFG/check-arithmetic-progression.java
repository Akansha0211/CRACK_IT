// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(set.contains(arr[i])){
                flag = true;
            }
            else set.add(arr[i]);
            max = Math.max(max, arr[i]);
        }
        if(flag == true && set.size()>1)return false;
        
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min){
                secondMin = min;
                min = arr[i];
            }else if(arr[i] < secondMin){
                secondMin = arr[i];
            }
        }
        int commonDiff = secondMin - min;
        int i = min;
        int j = max;
        while(i<=j){
            if(set.contains(i)){
                set.remove(i);
            }
            i+=commonDiff;
        }
        
        if(!set.isEmpty())return false;
        return true;
    
    }
}



// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}



  // } Driver Code Ends