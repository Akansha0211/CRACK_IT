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
        
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        
        return Math.max(max, Math.max(leftDia, rightDia));
    }    
    public int height(TreeNode node){
        if(node == null)return 0;
        int left = height(node.left);
        int right = height(node.right);
        return 1 + Math.max(left, right);
    }
}