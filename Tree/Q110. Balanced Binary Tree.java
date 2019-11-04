/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MySolution {
    public boolean isBalanced(TreeNode root) {
        //In pure computer science, null is a valid binary tree. It is called an empty binary tree. Just like an empty set is still a valid set.
        if(root==null) return false;//这里是true.
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1) return true;
        else return false;
    }
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int l= maxDepth(root.left);
        int r= maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return (getHeight(root)!=-1);
    }
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        int l= getHeight(root.left);
        int r= getHeight(root.right);
        if(Math.abs(l-r)>1) return -1; //-1 false
        if(l ==-1 || r==-1) return -1; //-1 false
        return Math.max(l,r)+1; // !=-1 true
    }
}