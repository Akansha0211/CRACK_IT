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
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxHelper(max, root);
        return max[0];
    }
    public static int maxHelper(int[] max,TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0,maxHelper(max, root.left));
        int right = Math.max(0,maxHelper(max, root.right));
        max[0] = Math.max(max[0], root.val + left + right);
        return root.val + Math.max(left, right);
    }
}