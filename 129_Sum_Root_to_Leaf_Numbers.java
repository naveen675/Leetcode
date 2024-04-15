//https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=daily-question&envId=2024-04-15
// O(N) O(hiehgt)
// Do Dry RUn 
class Solution {
    public int util(TreeNode root, int sum){

        if(root == null){ return 0;}
        
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null){ 
            return sum;
        }
        int leftSum = util(root.left, sum);
        int rightSum = util(root.right, sum);

        return leftSum+rightSum;
    }
    public int sumNumbers(TreeNode root) {

        return util(root, 0); 
    }
}
