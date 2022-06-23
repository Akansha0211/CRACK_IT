// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution{
    static class Pair{
        int startPt;
        int endPt;
        int freq;
        
        public Pair(int startPt, int endPt, int freq){
            this.startPt = startPt;
            this.endPt = endPt;
            this.freq = freq;
        }
        
    }
  
    ArrayList<Integer> smallestSubsegment(int nums[], int n)
    {
        // Complete the function
        HashMap<Integer,Pair> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int finSt = -1;
        int finEnd = -1;
        
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new Pair(i, i, 1));
            }else{
                Pair p = map.get(nums[i]);
                p.endPt = i;
                p.freq+=1;
                map.put(nums[i], p);
            }
            Pair pair = map.get(nums[i]);
            if(pair.freq > maxLen){
                maxLen = pair.freq;
                finSt = pair.startPt;
                finEnd = pair.endPt;
            }
            if (pair.freq == maxLen){
                if((pair.endPt - pair.startPt) < (finEnd - finSt)){
                    finSt = pair.startPt;
                    finEnd = pair.endPt;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = finSt; i<=finEnd; i++){
            ans.add(nums[i]);
        }
        return ans;
    }
  
    
}


// { Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            

  // } Driver Code Ends