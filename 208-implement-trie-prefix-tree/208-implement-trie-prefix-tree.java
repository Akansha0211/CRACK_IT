class Trie {
    
    class Node{
        char ch;
        boolean eow;
        Node[] arr = new Node[26];
        
        public Node(char ch){
            this.ch = ch;
            this.eow = eow;
        }
    }
    Node root;

    public Trie() {
        root = new Node(' ');
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.arr[ch-'a'] == null){
                temp.arr[ch-'a'] = new Node(ch);
            }
            temp = temp.arr[ch-'a'];
        }
        temp.eow = true;
    }
    
    public boolean search(String word) {
        
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.arr[ch-'a'] == null)return false;
            temp = temp.arr[ch-'a'];
        }
        if(temp.eow == true)return true;
        else return false;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i = 0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(temp.arr[ch-'a'] == null)return false;
            temp = temp.arr[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */