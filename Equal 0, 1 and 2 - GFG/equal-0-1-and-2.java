// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        HashMap<String,Integer> map = new HashMap<>();
        int pc0 = 0;
        int pc1 = 0;
        int pc2 = 0;
        String key = (pc0-pc1) + "#" + (pc0 - pc2);
        map.put(key, 1);
        
        long count = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '0')pc0 += 1;
            else if(str.charAt(i) == '1') pc1 += 1;
            else if(str.charAt(i) == '2') pc2 +=1;
            
            key = (pc0 - pc1) + "#" + (pc0 - pc2);
            
            if(map.containsKey(key))count+=map.get(key);
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        return count;
    }
} 