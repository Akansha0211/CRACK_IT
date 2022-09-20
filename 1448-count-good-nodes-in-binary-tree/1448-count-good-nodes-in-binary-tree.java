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
    // int max_val = Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return helper(root, max);
    }
    public int helper(TreeNode root, int max){
        if(root == null)return 0;
        if(root.val >= max){
            max = root.val;
            return 1 + helper(root.left, root.val) + helper(root.right, root.val);            
        }
        return helper(root.left, max) + helper(root.right, max);
    }
}