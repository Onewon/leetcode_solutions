/**
 * 107. Binary Tree Level Order Traversal II and 102. Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class MySolution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        if(root==null) return container;
        List<Integer> top = new ArrayList<>();
        top.add(root.val);
        container.add(top);
        container = helper(container,root);
        Collections.reverse(container);
        return container;
    }
    public List<List<Integer>> helper(List<List<Integer>> con, TreeNode node){
        if(node ==null) return con;
        if(node.left==null&&node.right==null)
            return con;
        List<Integer> level = new ArrayList<>();
        if(node.left!=null) level.add(node.left.val); //wrong
        if(node.right!=null) level.add(node.right.val); //wrong
        con.add(level);
        helper(con,node.left);
        helper(con,node.right);
        return con;
    }
}


class Solution_BFS {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        if(root==null) return container;
        Stack <List<Integer>> st = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null) queue.offer(node.left); //next loop init
                if (node.right!=null) queue.offer(node.right);
            }
            st.add(level);
        }
        while (!st.isEmpty()) container.add(st.pop());
        return container;
    }
}
class Solution_DFS{
    //Recursion
}