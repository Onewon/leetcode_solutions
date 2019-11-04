/**
 * 126. Invert Binary Tree
 * Invert a binary tree.
 */
class MySolution {
    public TreeNode invertTree(TreeNode root) {// 没有empty，recursion没有while
        TreeNode LT = root.left;
        TreeNode RT = root.right;
        root.left = RT;
        root.right = LT;
        while(root.left!=null) invertTree(root.left);
//        while(root.right!=null) invertTree(root.right);
        return root;
    }
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        //empty
        if(root==null) return root;
        //if((root==null)||(root.left==null &&root.right==null)) return root; //null也可以意味着没有left right child么
        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //recursion
        invertTree(root.left);
        invertTree(root.right);
        //return
        return root;
    }
}