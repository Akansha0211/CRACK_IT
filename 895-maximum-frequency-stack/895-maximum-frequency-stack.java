class FreqStack {
    
    HashMap<Integer, Stack<Integer>> stmap = new HashMap<>();
    HashMap<Integer,Integer> fmap = new HashMap<>();
    int maxFreq = 0;
    
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int freq = fmap.getOrDefault(val,0);
        freq++;
        fmap.put(val, freq);
        
        if(!stmap.containsKey(freq)){
            stmap.put(freq, new Stack<Integer>());
        }
        stmap.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        int ans = stmap.get(maxFreq).pop();
        
        int freq = fmap.get(ans);
        freq--;
        fmap.put(ans, freq);
        
        if(stmap.get(maxFreq).size() == 0){
            stmap.remove(maxFreq);
            maxFreq--;
        }
        
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */