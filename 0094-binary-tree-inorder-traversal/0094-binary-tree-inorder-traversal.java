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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderHelper(root, ans);
        return ans;
    }
    public void inorderHelper(TreeNode root, List<Integer> ans){
        if(root == null)return;
        inorderHelper(root.left, ans);
        ans.add(root.val);
        inorderHelper(root.right, ans);
    }
}