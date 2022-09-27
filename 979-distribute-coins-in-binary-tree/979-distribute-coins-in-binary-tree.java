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
    int cost = 0;
    public int distributeCoins(TreeNode root) {
        distributeHelper(root);
        return cost;
    }
    public int distributeHelper(TreeNode root){
        if(root == null)return 0;
        int left = distributeHelper(root.left);
        int right = distributeHelper(root.right);
        cost += Math.abs(left) + Math.abs(right);
        return left+right+root.val -1;
    }
}