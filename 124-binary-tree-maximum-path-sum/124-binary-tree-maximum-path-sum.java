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
    
    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxPath);
        return maxPath[0];
    }
    public int maxPathDown(TreeNode root , int[] maxPath){
        if(root == null)return 0;
        int left = Math.max(0, maxPathDown(root.left, maxPath));
        int right = Math.max(0, maxPathDown(root.right, maxPath));
        
        maxPath[0] = Math.max(maxPath[0], root.val + left + right);
        
        return root.val + Math.max(left, right);
    }
}