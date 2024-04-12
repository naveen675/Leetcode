//https://leetcode.com/problems/binary-tree-inorder-traversal/
// O(N) O(1) 

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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        while(root != null)
        {
            if(root.left == null){
                ans.add(root.val);
                root = root.right;
            }

            else{
                TreeNode temp = root.left;
                while(temp.right != null && temp.right != root){
                    temp = temp.right;
                }

                if(temp.right == null){
                    temp.right = root;
                    root = root.left;
                }

                else{
                    ans.add(root.val);
                    temp.right = null;
                    root = root.right;         // We have to move towards left
                }
            }

        }
        return ans;
    }
}
