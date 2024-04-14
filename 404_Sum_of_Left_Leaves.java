//https://leetcode.com/problems/sum-of-left-leaves/?envType=daily-question&envId=2024-04-14
// O(N) O(Height)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)){ return 0;}

        int leftLeafsum =0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
      
        while(queue.size() != 0){
            TreeNode node = queue.poll();
            if(node.left != null){
                if(node.left.left == null && node.left.right == null){ leftLeafsum = leftLeafsum + node.left.val; }
                queue.add(node.left);
            }
            if(node.right != null){ queue.add(node.right) ;}
        }
        return leftLeafsum;   
    }
}
