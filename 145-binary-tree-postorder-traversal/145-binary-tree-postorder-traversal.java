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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postHelper(root, list);
        return list;
    }
    public static void postHelper(TreeNode root, ArrayList<Integer> list){
        if(root== null)return;
        postHelper(root.left, list);
        postHelper(root.right, list);
        list.add(root.val);
    }
}