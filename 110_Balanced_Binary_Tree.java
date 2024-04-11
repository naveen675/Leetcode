//https://leetcode.com/problems/balanced-binary-tree/

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
    private boolean balanced = true;
    public int util(TreeNode head){

        if(head == null || balanced== false){ return 0;}

        int left = util(head.left);
        int right = util(head.right);

        if(Math.abs(left-right) > 1){ balanced = false;}

        return Math.max(left, right)+1;
    }
    public boolean isBalanced(TreeNode root) {

        if(root == null){return true; }
        util(root);

        return balanced;

        
    }
}
