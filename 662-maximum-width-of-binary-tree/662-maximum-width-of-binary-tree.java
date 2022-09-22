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
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int minId = q.peek().num; // min Id at the current level
            int first = 0;
            int last = 0;
            for(int i = 0; i<size; i++){
                Pair rem = q.poll();
                int currId = rem.num - minId;
                if(i == 0)first = currId;
                if(i == size-1)last = currId;
                
                if(rem.node.left != null)q.add(new Pair(rem.node.left, rem.num*2+1));
                if(rem.node.right != null)q.add(new Pair(rem.node.right, rem.num*2+2));
                
            }
            ans = Math.max(ans, (last-first)+1);
            
        }
        return ans;
    }
}