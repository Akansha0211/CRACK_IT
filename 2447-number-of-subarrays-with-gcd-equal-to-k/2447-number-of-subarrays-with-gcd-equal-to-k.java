class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int total = 0;
        for(int i = 0; i<nums.length; i++){
            int gcd = nums[i];
            for(int j = i; j<nums.length; j++){
                gcd = findgcd(gcd, nums[j]);
               if(gcd== k)total++;
               else if(findgcd(nums[i], nums[j] ) < k)break;
            }
        }
        return total;
    }
    // static int findgcd(int a, int b)
    // {
    //     int result = Math.min(a, b); // Find Minimum of a nd b
    //     while (result > 0) {
    //         if (a % result == 0 && b % result == 0) {
    //             break;
    //         }
    //         result--;
    //     }
    //     return result; // return gcd of a nd b
    // }
    static int findgcd(int a, int b)
    {
      if (b == 0)
        return a;
      return findgcd(b, a % b);
    }
}