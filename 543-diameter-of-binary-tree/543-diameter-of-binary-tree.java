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
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        int leftHt = height(root.left);
        int rightHt = height(root.right);
        int apnaDia = leftHt + rightHt;
        
        maxDia = Math.max(maxDia, apnaDia);
        
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        return Math.max(maxDia, Math.max(leftDia, rightDia));
        
    }
    public int height(TreeNode node){
        
        if(node == null)return 0;
        int leftHt = height(node.left);
        int rightHt = height(node.right);
        return 1 + Math.max(leftHt, rightHt);
    }
}