class Solution {
    public int minCost(String colors, int[] neededTime) {
      
        int totalTime = 0;
        int max = neededTime[0];
        for(int i = 1; i<colors.length(); i++){
            if(colors.charAt(i) != colors.charAt(i-1)){
                max = neededTime[i];
            }
            // if equal than previous one
            else{
                totalTime+= Math.min(max, neededTime[i]);
                max = Math.max(max, neededTime[i]);
            }
        }
        return totalTime;
    }
}