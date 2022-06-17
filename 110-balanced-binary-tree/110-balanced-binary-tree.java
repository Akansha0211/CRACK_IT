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
        return height(root) != -1;
    }
    public int height(TreeNode node){
        if(node == null)return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(Math.abs(leftHeight - rightHeight) >1)return -1;
        if(leftHeight==-1 || rightHeight == -1)return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}