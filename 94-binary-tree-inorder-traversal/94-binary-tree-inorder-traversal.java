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
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode currP1 = curr.left;
                while(currP1.right != null && currP1.right != curr){
                    currP1 = currP1.right;
                }
                if(currP1.right == null){
                    currP1.right = curr;
                    curr = curr.left;
                }else{
                    ans.add(curr.val);
                    currP1.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}