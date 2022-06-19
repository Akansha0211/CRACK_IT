class Solution {
    public String minWindow(String s, String t) {
        //if(t.length() > s.length())return "";
        HashMap<Character,Integer> mapT = new HashMap<>();
        HashMap<Character,Integer> mapS = new HashMap<>();
        
        // The easiest way to for-each every char in a String is to use toCharArray():
        // for (char ch: "xyz".toCharArray()) {
        // }        
        for(char ch : t.toCharArray()){
            mapT.put(ch, mapT.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int right = -1;
        int matchedCount = 0;
        int start = 0;
        int overalMin = Integer.MAX_VALUE;
        while(right<s.length()){
            // acquire
            right++;
            // System.out.println(right);
            if(right < s.length()){
                char chAcquire = s.charAt(right);
                mapS.put(chAcquire, mapS.getOrDefault(chAcquire,0)+1);
                if(mapS.getOrDefault(chAcquire,0) <= mapT.getOrDefault(chAcquire,0)){
                    matchedCount++; // kaam ki occurrence hain yeh
                }
            }
            
            if(matchedCount == t.length()){
                while(matchedCount == t.length()){
                    //overalMin = Math.min(overalMin, right-left+1);
                    if(right-left+1 < overalMin){
                        overalMin = right-left +1;
                        start = left;
                    }
                    //release
                    char chRelease = s.charAt(left);
                    mapS.put(chRelease, mapS.getOrDefault(chRelease,0)-1);
                    left++;
                    if(mapS.getOrDefault(chRelease,0) < mapT.getOrDefault(chRelease,0)){
                        // strictly less
                        matchedCount--;
                    }
                }
            }
        }
        // return s.substring(start, start+ overallMin);
         return overalMin == Integer.MAX_VALUE ? "" : s.substring(start, start+ overalMin);
        
    }
}