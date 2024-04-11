//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/


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

    public int getPos(int [] inorder, int elm){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == elm){ return i; }

        }

        return -1;
    }

    public TreeNode util(int [] inorder, int [] postorder, int is, int ie, int ps, int pe){
        if(ps > pe){return null;}            // edge case imp

        TreeNode newNode = new TreeNode(postorder[pe]);
        int headPos = getPos(inorder, postorder[pe]);
        int leftLen = headPos - is;
        newNode.left = util(inorder, postorder, is,headPos-1, ps,ps+leftLen-1 );    // write these two functions
                                                                                    // carefully
        newNode.right = util(inorder, postorder, headPos+1, ie, ps+leftLen, pe-1);

        return newNode;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return util(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        
    }
}
