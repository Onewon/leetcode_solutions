/**
 * 199. Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
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
import java.util.*;

class MySolution { //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> lvl =new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode s =queue.poll();
                if (s.left!=null) queue.offer(s.left);
                if (s.right!=null) queue.offer(s.right);
                lvl.add(s.val);
            }
            res.add(lvl.get(lvl.size()-1));
        }
        return res;
    }
}