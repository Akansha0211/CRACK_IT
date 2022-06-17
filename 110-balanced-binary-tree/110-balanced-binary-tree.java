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
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        boolean isNodeBal = Math.abs(leftHeight - rightHeight) >1 ? false: true;
        boolean checkLeft = isBalanced(root.left);
        boolean checkRight = isBalanced(root.right);
        
        return isNodeBal && checkLeft && checkRight;
    }
    public int height(TreeNode node){
        if(node == null)return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}