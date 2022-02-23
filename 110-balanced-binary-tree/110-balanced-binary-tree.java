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
    class Pair{
        int height;
        boolean isBal;
        Pair(int height, boolean isBal){
            this.height = height;
            this.isBal = isBal;
        }
    }
    public boolean isBalanced(TreeNode root) {
        Pair pair = getPair(root);
        return pair.isBal;
    }
    public Pair getPair(TreeNode root){
        if(root == null){
            return new Pair(0,true);
        }
        Pair left = getPair(root.left);
        Pair right = getPair(root.right);
        int apniHeight = Math.max(left.height, right.height)+1;
        int diff = Math.abs(left.height - right.height);
        boolean kyaMainBalancedHu = diff<=1 && left.isBal && right.isBal;
        return new Pair(apniHeight, kyaMainBalancedHu);
    }
}