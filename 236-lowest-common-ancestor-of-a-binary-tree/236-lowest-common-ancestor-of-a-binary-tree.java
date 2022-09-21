/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        if(root == p || root == q)return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if((leftNode == p && rightNode == q) || (leftNode== q && rightNode == p))return root;
        // if(left == p && right == null)return p;
        // if(left == q && right ==  null)return q;
        if(rightNode == null)return leftNode;
        if(leftNode == null)return rightNode;
        return null;
    }
}