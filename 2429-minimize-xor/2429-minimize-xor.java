class Solution {
    public int minimizeXor(int num1, int num2) {
        // int count = Integer.bitCount(num2);
        // int ans = 0;
        // for(int i = 60; i>=0; i--){
        //     int currBit = (num1 >> i) &1; // num1 >> i is the current number
        //     if((currBit == 1) && count >0){
        //         ans = ans | (1<<i);
        //         count--;
        //     }
        // }
        // // eg num = 1 , num2 = 12
        // if(count>0){
        //     for(int i = 0; i<=60; i++){
        //         int currBit = (ans>>i)&1;
        //        // System.out.println(ans>>i);
        //         if(currBit !=1){
        //             ans = ans | (1<<i);
        //             count--;
        //         }
        //     }
        // }
        // return ans;
        
        int bit = Integer.bitCount(num2);
		
        int ans = 0;

        for(int i=31;i>=0;i--) {
			int currBit = (num1 >> i) & 1;
            if(currBit == 1 && bit > 0) {
				ans |= (1 << i);
                bit--;
            }
        }
        
		// if bits to set are remaining, set the `LSB`
        for(int i=0;i<32;i++) {
            if(bit == 0) break;
			int currBit = (ans >> i) & 1;
            if(currBit != 1) {
                ans |= (1 << i);
                bit--;
            }
        }
        return ans;
    }
}