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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while(size-- >0){
                TreeNode rem = queue.poll();
                level.add(rem.val);
                if(rem.left != null){
                    queue.add(rem.left);
                }
                if(rem.right != null){
                    queue.add(rem.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}