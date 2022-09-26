/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int vertLvl;
        int horiLvl;
        
        public Pair(TreeNode node, int vertLvl, int horiLvl){
           this.node = node;
            this.vertLvl = vertLvl;
            this.horiLvl = horiLvl;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)return ans;
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        while(!q.isEmpty()){
            Pair rem = q.poll();
            TreeNode node = rem.node;
            int verticalLvl = rem.vertLvl;
            int horizontalLvl = rem.horiLvl;
            
            if(!map.containsKey(verticalLvl)){
                map.put(verticalLvl, new TreeMap<>());
            }
            // contains vertLvl , now check for horizontal Level
           
            if(!map.get(verticalLvl).containsKey(horizontalLvl)){
                map.get(verticalLvl).put(horizontalLvl, new PriorityQueue<>());
            }
            // map contains vertLvl and horizontalLvl , so just add the node val(Integer) to the PriorityQueue
            map.get(verticalLvl).get(horizontalLvl).offer(node.val);
            
            if(node.left != null){
                q.offer(new Pair(node.left, verticalLvl-1, horizontalLvl+1));
            }
            if(node.right != null){
                q.offer(new Pair(node.right, verticalLvl+1, horizontalLvl+1));
            }
            
        }
        
        // generate your ans list (2D LIST)
        for(TreeMap<Integer,PriorityQueue<Integer>> innerMaps : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : innerMaps.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}