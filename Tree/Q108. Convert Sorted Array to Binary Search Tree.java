/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int stIndex = nums.length/2+1;
        TreeNode root = new TreeNode(nums[stIndex]);
        addNode(root.left,nums,stIndex-1);
        addNode(root.right,nums,stIndex+1);
        return root;
    }
    public TreeNode addNode(TreeNode node,int[] nums, int index){
        if (node == null) return node;
        if(index >0 &&index<nums.length/2+1)
            node.left = new TreeNode(nums[index]);
            addNode(node.left,nums,index-1);
        if(index >nums.length/2+1 &&index<nums.length-1)
            node.right = new TreeNode(nums[index]);
            addNode(node.right,nums,index+1);
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
    }
}