class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer,Integer> cntMap = new HashMap<>();
        Map<Integer,Long> sumMap = new HashMap<>();
        
        long[] ans = new long[arr.length];
        for(int i = 0; i<arr.length; i++){
            ans[i]+= (((long)cntMap.getOrDefault(arr[i], 0))* i) - sumMap.getOrDefault(arr[i],0l);
            cntMap.put(arr[i], cntMap.getOrDefault(arr[i],0)+1);
            sumMap.put(arr[i], sumMap.getOrDefault(arr[i],0l)+i);
        }
        cntMap = new HashMap<>();
        sumMap = new HashMap<>();
        for(int i = arr.length-1; i>=0; i--){
            ans[i]+= sumMap.getOrDefault(arr[i],0l) - (((long)cntMap.getOrDefault(arr[i], 0))* i);
            cntMap.put(arr[i], cntMap.getOrDefault(arr[i],0)+1);
            sumMap.put(arr[i], sumMap.getOrDefault(arr[i],0l)+i);
        }
        return ans;
    }
}