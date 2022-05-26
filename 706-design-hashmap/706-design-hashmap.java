class MyHashMap {
    
    class Node{
        int key;
        int value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    LinkedList<Node> [] buckets;
    int size;
    
    public MyHashMap() {
        initBuckets(4);
        size = 0;
    }
    
    public void initBuckets(int N){
        buckets = new LinkedList[N];
        for(int i = 0; i<buckets.length; i++){
            buckets[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int bi = hashFunction(key);
        int di = getIndexWithinBucket(key, bi);
        
        if(di !=-1){
            // update
            
            Node node = buckets[bi].get(di);
            node.value = value;
        }else{
            //insert
            
            Node node = new Node(key, value);
            buckets[bi].add(node);
            size++;
        }
        
        double lambda = size * 1.0 / buckets.length;
        if(lambda > 2.0){
            rehash();
        }
    }
    
    public int hashFunction(int key){
        int hashCode = Integer.hashCode(key);
        return Math.abs(hashCode) % buckets.length;
    }
    
    public int getIndexWithinBucket(int key, int bi){
        int di = 0;
        for(Node node : buckets[bi]){
            if(node.key == key){
                return di;
            }
            di++;
        }
        return -1;
    }
    public void rehash(){
        LinkedList<Node> [] old = buckets;
        initBuckets(old.length*2);
        size = 0;
        
        for(int i = 0; i<old.length; i++){
            for(Node node : old[i]){
                put(node.key, node.value);
            }
        }
        
    }
    
    public int get(int key) {
        int bi = hashFunction(key);
        int di = getIndexWithinBucket(key, bi);
        if(di != -1){
            Node node = buckets[bi].get(di);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void remove(int key) {
        int bi = hashFunction(key);
        int di = getIndexWithinBucket(key, bi);
        if(di != -1){
            Node node = buckets[bi].remove(di);
            size--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */