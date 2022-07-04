class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(map.containsKey(n))return map.get(n);
        if(n==0 || n==1)return 1;
        int choice1 = climbStairs(n-1);
        int choice2 = climbStairs(n-2);
        map.put(n, choice1 + choice2);
        return choice1 + choice2;
    }
}