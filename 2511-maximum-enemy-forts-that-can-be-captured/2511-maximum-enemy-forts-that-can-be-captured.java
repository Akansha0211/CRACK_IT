class Solution {
    public int captureForts(int[] forts) {
        int ans = 0;
        for(int i = 0; i<forts.length; i++){
            if(forts[i] == 1){
                // go Left
                int count = 0;
                for(int j = i-1; j>=0; j--){
                    if(forts[j] == 0){
                        count++;
                    }else if(forts[j] == -1){
                        ans = Math.max(ans, count);
                        break;
                    }else{
                        break;
                    }
                }
                // go Right
                count = 0;
                for(int j = i+1; j<forts.length; j++){
                    if(forts[j] == 0){
                        count++;
                    }else if(forts[j] ==-1){
                        ans = Math.max(ans, count);
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        return ans;
    }
}