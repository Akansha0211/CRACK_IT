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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, 0, ans);
        return ans;
    }
    public void rightView(TreeNode currNode, int level , List<Integer> ans){
        if(currNode == null)return;
        if(level == ans.size())ans.add(currNode.val);
        rightView(currNode.right, level+1, ans);
        rightView(currNode.left, level+1, ans);
    }
}