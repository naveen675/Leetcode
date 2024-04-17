//https://leetcode.com/problems/smallest-string-starting-from-leaf/?envType=daily-question&envId=2024-04-17
//O(N) O(height Of Tree)

class Solution {

    private String smaller = null;
    void util(TreeNode root, StringBuilder s){

        if(root == null){ return ; }
        s.insert(0,(char)('a' + (root.val)));

        if(root.left == null && root.right == null){
            String s1 = s.toString();
            if(smaller == null || s1.compareTo(smaller) < 0){
                smaller = s1;       
            }       
        }
        else{
            util(root.left, s);
            util(root.right, s);
        }
        s.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {

        StringBuilder s = new StringBuilder();
        util(root, s);
        return smaller;   
    }
}
