class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int minCuts = wall.size();
        int crackDist = 0;
        int maxCount = 0;
        for(List<Integer> row : wall){
            crackDist = 0;
            for(int i = 0; i<row.size()-1; i++){
                crackDist += row.get(i);
                map.put(crackDist, map.getOrDefault(crackDist,0)+1);
                // maxCount = Math.max(maxCount, map.get(crackDist));
                minCuts = Math.min(minCuts, wall.size()- map.get(crackDist));
            }
            // minCuts = Math.min(minCuts, wall.size()- maxCount);
        }
        return minCuts;
    }
}