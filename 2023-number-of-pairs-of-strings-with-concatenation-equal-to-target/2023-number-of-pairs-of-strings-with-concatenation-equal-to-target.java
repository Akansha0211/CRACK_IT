class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int m = nums[i].length();
            if(target.startsWith(nums[i])){
                String suffix = target.substring(m); // startIndex
                if(map.containsKey(suffix)){
                    count+=map.get(suffix);
                }
            }
            
            if(target.endsWith(nums[i])){
                String prefix = target.substring(0, target.length()-m);
                if(map.containsKey(prefix)){
                    count+=map.get(prefix);
                }
            }
            
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return count;
    }
}