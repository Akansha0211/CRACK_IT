class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i =0; i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            }else{
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}