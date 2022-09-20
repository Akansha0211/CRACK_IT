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
    public boolean isValidBST(TreeNode root) {
        // if(root == null)return true;
        // if(root.left != null && root.left.val >=root.val){
        //     return false;
        // }
        // if(root.right != null && root.right.val <= root.val){
        //     return false;
        // }
        // return isValidBST(root.left) && isValidBST(root.right);
        return checkValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean checkValid(TreeNode root, long min, long max){
        if(root == null)return true;
        if(root.val >= max || root.val <=min)return false;
        return checkValid(root.left, min, root.val) && checkValid(root.right, root.val, max);
    }
}