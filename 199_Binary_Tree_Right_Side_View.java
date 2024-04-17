// https://leetcode.com/problems/binary-tree-right-side-view/description/
// O(N) O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){ return ans; }
        queue.add(root);

        while(queue.size() != 0){

            int k=0;
            int len = queue.size();

            while(k < len){

                TreeNode node = queue.poll();
                if(k == len-1){

                    ans.add(node.val);
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){

                    queue.add(node.right);
                }

                k++;
            } 
        }

        return ans;
        
    }
}
