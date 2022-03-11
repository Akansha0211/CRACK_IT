class Solution {
    public int fib(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return fibHelper(n, map);
    }
    public int fibHelper(int n, HashMap<Integer,Integer> map){
        if(n == 0|| n==1)return n;
        if(map.containsKey(n))return map.get(n);
        map.put(n, fibHelper(n-1, map)+fibHelper(n-2, map));
        return map.get(n);
    }
}