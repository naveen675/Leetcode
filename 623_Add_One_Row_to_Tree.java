//https://leetcode.com/problems/add-one-row-to-tree/?envType=daily-question&envId=2024-04-16
// O(N) O(N)

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        int level =0; 

        if(depth == 1){                         // If depth is one then directly 
                                                //make new node as root and append old root to the left of new node
            TreeNode head = new TreeNode(val);
            head.left = root;  
            return head; 
        }

        Queue<TreeNode> queue = new LinkedList<>();
        level =1;

        queue.add(root);

        // Continue traversal until the desired depth minus one
        while(level < depth-1){
               // we need to stop before the requiured depth to assign new node to its parent nodes
            int size=  queue.size();
            int k =0;
            while(k < size){
                TreeNode node = queue.poll();
                if(node.left != null){ queue.add(node.left) ;}
                if(node.right != null){ queue.add(node.right) ;}
                k++; 
            }
            level++;
        }

        while(queue.size() != 0){

            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            // Insert new nodes with the given value
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            // Reassign the original left and right children to the new nodes
            node.left.left = left;
            node.right.right = right;
        
        }

        return root;  
    }
}
