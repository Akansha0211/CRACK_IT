class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // HashMap<String, Integer> map = new HashMap<>();
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lcsHelper(text1, text2, 0,0, dp);
    }
    public int lcsHelper(String s1, String s2, int i , int j, int[][] dp){
        if(i>=s1.length() || j>=s2.length())return 0;
        if(dp[i][j] !=-1)return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            // map.put(key, 1+ lcsHelper(s1, s2, i+1, j+1, map));
            return dp[i][j] = 1+ lcsHelper(s1, s2, i+1, j+1, dp);
            // return map.get(key);
        }
        else{
            int choice1 = lcsHelper(s1, s2, i, j+1, dp);
            int choice2 = lcsHelper(s1, s2, i+1, j, dp);
            // map.put(key, Math.max(choice1, choice2));
            // return Math.max(choice1, choice2);
            // return map.get(key);
            return dp[i][j]  =  Math.max(choice1, choice2);
            
        }
    }
}