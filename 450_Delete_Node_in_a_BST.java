//https://leetcode.com/problems/delete-node-in-a-bst/description/
// Solution with more 
// O(H) O(H)
// 

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

    public int getRightMax(TreeNode root){   // This is to had

        while(root.right != null){ root = root.right;  }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){ return null; }  // to hadle the case if there is no key in given tree
        
        if( root.val < key){ root.right =  deleteNode(root.right,key); }
        else if(root.val > key){ root.left = deleteNode(root.left,key); }
        else{
            if(root.left == null && root.right == null){ return null;}
            else if(root.left == null && root.right != null){ return root.right; }
            else if(root.left != null && root.right == null){ return root.left; }
            else{
                                                        // This is a bit complex case 
                int rightMax = getRightMax(root.left);
                root.val = rightMax;
                root.left = deleteNode(root.left, rightMax);
            }
        }
        return root;
        
    }
}
