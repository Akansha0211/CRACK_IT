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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode rem = queue.poll();
                if(i== size-1){
                    ans.add(rem.val);
                }
                if(rem.left != null){
                    queue.add(rem.left);
                }
                if(rem.right != null){
                    queue.add(rem.right);
                }
            }
        }
        return ans;
    }
}