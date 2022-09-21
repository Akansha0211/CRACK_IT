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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSumHelper(root,targetSum, ans, new ArrayList<>());
        return ans;
    }
    public void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> ds){
        if(root == null)return;
        targetSum-=root.val;
        ds.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(ds));
        }
        pathSumHelper(root.left, targetSum, ans, ds);
        pathSumHelper(root.right, targetSum, ans, ds);
        ds.remove(ds.size()-1);
    }
}