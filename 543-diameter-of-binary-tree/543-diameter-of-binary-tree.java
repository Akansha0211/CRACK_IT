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
        int dia;
        Pair(int height, int dia){
            this.height = height;
            this.dia = dia;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {

        Pair ans = helper(root);
        return ans.dia;
    }
    public Pair helper(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int apniHeight = Math.max(left.height, right.height)+1;
        int apnaDia = left.height + right.height;
        int treeDia = Math.max(apnaDia, Math.max(left.dia, right.dia));
        return new Pair(apniHeight, treeDia);
    }
}