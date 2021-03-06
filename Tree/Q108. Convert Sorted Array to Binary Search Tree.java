import javax.swing.tree.TreeNode;

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
        if(nums == null) return null;
        int stIndex = nums.length/2;
        TreeNode root = new TreeNode(nums[stIndex]);
        root.left = addNode(root.left,nums,stIndex-1); //需要传引用
        // root.right = addNode(root.right,nums,stIndex+1);
        return root;
    }
    public TreeNode addNode(TreeNode node,int[] nums, int index){
        if (node == null) return node;

        if(index >0 && index<nums.length/2-1)
            node.left = new TreeNode(nums[index]);
            return addNode(node.left,nums,index-1);

        // if(index >=nums.length/2+1 && index<nums.length-1)
        //     node.right = new TreeNode(nums[index]);
        //     return addNode(node.right,nums,index+1);
    }
}
class Solution{
    public TreeNode sortedArrayToBST(int[] nums) {
    if(nums.length==0) return null;
    int mid = (nums.length-1)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = sortedArrayToBST(cutArray(nums,0,mid));
    root.right = sortedArrayToBST(cutArray(nums,mid+1,nums.length));
    return root;
}
public int[] cutArray(int[] nums,int l,int r){
    return Arrays.copyOfRange(nums,l,r);
}
}
class Python_Solution{ //didn't pass
public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums,0,nums.length-1);
}
public TreeNode helper(int[] nums,int start,int end){
    if(start>end) return null;
    int mid = (start+end)/2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(nums,start,end-1);
    node.right = helper(nums,start+1,end);
    return node;
}
}