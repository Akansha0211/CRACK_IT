class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i<nums1.length; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i<nums2.length; i++){
            set2.add(nums2[i]);
        }
        if(set1.size()< set2.size()){
            return setIntersection(set1, set2);
        }
        return setIntersection(set2, set1);
    }
    public int[] setIntersection(HashSet<Integer> set1 , HashSet<Integer> set2){
        
        int[] output = new int[set1.size()];
        int index = 0; // for maintaining size
        for(int el : set1){
            if(set2.contains(el))output[index++] = el;
        }
        return Arrays.copyOf(output, index);  // chnages the size of the array
    }
}