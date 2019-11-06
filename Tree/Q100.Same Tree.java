/**
 * 100. Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;

class MySolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        queueA.offer(p);
        queueB.offer(q);
        while(!queueA.isEmpty()){
            int size = queueA.size();
            for (int i = 0; i < size; i++) {
                TreeNode left_node = queueA.poll();
                TreeNode right_node = queueB.poll();
                if(left_node.val != right_node.val) return false;
                if(left_node.left!=null) queueA.offer(left_node.left); //reason
                if(left_node.right!=null) queueA.offer(left_node.right);
                if(right_node.left!=null) queueB.offer(right_node.left);
                if(right_node.right!=null) queueB.offer(right_node.right);
            }
        }
        return true;
    }
// TestCase
// [1, 2]
// [1,null,2]
//  Wrong
}

class MySolution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        queueA.offer(p);
        queueB.offer(q);
        while(!queueA.isEmpty()){
            int size = queueA.size();
            for (int i = 0; i < size; i++) {
        TreeNode left_node = queueA.poll();
        TreeNode right_node = queueB.poll();
        if(left_node.val != right_node.val) return false;
        if(left_node.left!=null&&right_node.left!=null&&left_node.left.val != right_node.left.val)
            return false; //also cannot solve
        if(left_node.right!=null&&right_node.right!=null&&left_node.right.val != right_node.right.val)
            return false;
        if(left_node.left!=null) queueA.offer(left_node.left);
        if(left_node.right!=null) queueA.offer(left_node.right);
        if(right_node.left!=null) queueB.offer(right_node.left);
        if(right_node.right!=null) queueB.offer(right_node.right);
    }
}
        return true;
    }
// TestCase
// [1, 2]
// [1,null,2]
//  Wrong
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p ==null && q==null) return true; //boundary1
        else if(p ==null|| q==null) return false; //boundary2
        else {
            return (p.val == q.val &&
            isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right)); //three conditions need to met
        }
    }
}