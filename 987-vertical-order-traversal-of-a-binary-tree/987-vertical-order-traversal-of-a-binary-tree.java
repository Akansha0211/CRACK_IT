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
        int level; // horizontal
        
        public Pair(TreeNode node, int vertLvl, int level){
            this.node = node;
            this.vertLvl = vertLvl;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0,0));
        
        //Level order Traversal
        while(!q.isEmpty()){
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int vertLvl = pair.vertLvl;
            int level = pair.level;
            
            if(!map.containsKey(vertLvl)){
                map.put(vertLvl, new TreeMap<>());
            }
            if(!map.get(vertLvl).containsKey(level)){
                map.get(vertLvl).put(level, new PriorityQueue<>());
            }
            map.get(vertLvl).get(level).offer(node.val);
            
            if(node.left != null){
                q.offer(new Pair(node.left, vertLvl -1, level+1));
            }
            if(node.right != null){
                q.offer(new Pair(node.right, vertLvl+1, level +1));
            }
        }
        
        // create answer List [[], [], ....]
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> innerMaps : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : innerMaps.values()){
                while(!nodes.isEmpty()){
                    System.out.println(nodes.peek());
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}