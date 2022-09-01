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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        max = Math.max(max, leftHeight + rightHeight);
        max = Math.max(max, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
        
       
        return max;
        
    }
    public int height(TreeNode root){
        if(root == null)return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
}