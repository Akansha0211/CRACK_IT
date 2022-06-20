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
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        int ans = traversal(root);
        if(ans == 1){
            // no parent i.e root == 1(dummy leaf)
            camera++;
        }
        return camera;
    }
    public int traversal(TreeNode root){
        if(root == null)return 3;
        int left = traversal(root.left);
        int right = traversal(root.right);
        if(left == 1 || right == 1){
             camera++;
            return 2;           
        }
        if(left == 2 || right == 2)return 3;
        return 1;
    }
}