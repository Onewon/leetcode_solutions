/**
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Stack;

class MySolution {
    int temp=0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Stack<TreeNode> st = new Stack<>();
        return addRecursion(root,st,sum);
    }
    public boolean addRecursion(TreeNode root,Stack<TreeNode> st,int sum){
        if(root==null) return false;
        st.add(root);
        temp = temp + st.pop().val;
        addRecursion(root.left,st,sum);
        addRecursion(root.right,st,sum);
        if(temp ==sum) return true;
        else return false;
    }
}
class Solution {
public boolean hasPathSum(TreeNode root, int sum) {
    if(root==null) return false;
    if(root.left==null && root.right == null) return root.val==sum;
    else return hasPathSum(root.left, sum - root.val)
    || hasPathSum(root.right, sum - root.val); // key = sum - root.val
}
}