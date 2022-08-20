class Solution {
    public String getPermutation(int n, int k) {
        String ans = "";
        ArrayList<Integer> numbers = new ArrayList<>();
        
        //for n = 4  (we have started with fact = 3! = 6)
         int fact = 1;
        for(int i = 1; i<n; i++){
            fact = fact*i;
            
            numbers.add(i);
        }        
        numbers.add(n); 
         k = k-1;
        while(true){
            ans += numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() ==0)break;
            k = k%fact;
            fact = fact/(numbers.size()); 
        }
        return ans;
        
    }
}