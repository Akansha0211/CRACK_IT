class Solution {
    public int minCost(String colors, int[] neededTime) {
        int left = 0;
        int right = 0;
        int totalTime = 0;
        while(left < neededTime.length && right < neededTime.length){
            int currTotal = 0;
            int currMax = 0;
            while(right<neededTime.length && colors.charAt(left) == colors.charAt(right)){
                currTotal+=neededTime[right];
                currMax = Math.max(currMax, neededTime[right]);
                right++;
            }
            left = right;
            totalTime += currTotal-currMax;
        }
        return totalTime;
    }
}