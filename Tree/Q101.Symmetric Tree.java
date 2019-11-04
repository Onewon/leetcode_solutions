/**
 *
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class MySolution {
    public boolean isSymmetric(TreeNode root) { //return True or False
        Stack<TreeNode> st = new Stack<>();
        TreeNode left_tree = root.left;
        TreeNode right_tree = root.right;
        st.add(getnode(left_tree));
        while(!st.empty()){
            st.pop();
        }
    }
    public TreeNode getnode(TreeNode node){
        if(node==null) return node;
        getnode(node.left);
        getnode(node.right);
        return node;
    }
}

class Solution { //#1 Recursion写法
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymRecursion(root.left,root.right);
    }
    public boolean isSymRecursion(TreeNode left,TreeNode right){
        //empty
        if(left==null && right ==null) return true;
        //boundary
        if(left==null || right==null||(left.val!=right.val)) return false;
        //Recursion
        return (left.val==right.val)&&isSymRecursion(left.left,right.right)&&isSymRecursion(left.right,right.left);
    }
}