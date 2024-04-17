//https://leetcode.com/problems/binary-tree-level-order-traversal/
// O(N) O(lHeight Of Tree)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){ return ans; }
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        ans.add(temp);

        while(queue.size() != 0){

            int k =0;
            int len = queue.size();
            List<Integer> l = new ArrayList<>();

            while(k < len ){

                TreeNode node = queue.poll();
                if(node.left != null){
                    l.add(node.left.val);
                    queue.add(node.left);
                }
                if(node.right != null){
                    l.add(node.right.val);
                    queue.add(node.right);
                }
                k++;
        }
            if(l.size() != 0){ ans.add(l);}
        }
        return ans;  
    }
}
