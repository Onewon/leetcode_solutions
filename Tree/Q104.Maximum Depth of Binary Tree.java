/**
 * 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        // DFS
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left =  minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0 ||right==0) return left+right+1;
        else return Math.min(left,right)+1;
    }
}