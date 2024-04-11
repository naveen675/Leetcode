//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
// O(number of nodes) O(height Of tree)

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

    // The below Comparator built to handle below case
    //There may be multiple nodes in the 
    //same row and same column. In such a case, sort these nodes by their values.
    public class CustomComparator implements Comparator<Pair>{

        public int compare(Pair a, Pair b){

            if(a.y < b.y){ return -1;}
            if(a.y > b.y ){ return 1;}      // comparing column wise and row wise 
            if(a.x < b.x){ return -1;}      // if they are in same row then we need to sort the element
                                            // based on value 
                                            // sample input [1,2,3,4,6,5,7] Dry Run this
            if(a.x > b.x){ return 1;}
            return (a.node.val - b.node.val);                               
        }
    }

    public class Pair{

        TreeNode node;
        int x;
        int y;  // this is to sort the elements if same value exists in same row, Check comparator calss
                // for better understanding
        Pair(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        

        PriorityQueue<Pair> queue = new PriorityQueue(new CustomComparator());
        queue.add(new Pair(root,0,0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int leftMinAxis = Integer.MAX_VALUE;


        while(queue.size() != 0){
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            TreeNode node = p.node;
            if(map.containsKey(x)){
                map.get(x).add(node.val);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(x, list);
            }

            if(node.left != null ){queue.add(new Pair(node.left, x-1, y+1));}
            if(node.right != null){queue.add(new Pair(node.right, x+1, y+1));}
            leftMinAxis = Math.min(x, leftMinAxis);
          
        }

        int axis=leftMinAxis;
        for(int j=0; j<map.size(); j++){
            ans.add(map.get(axis));
            
            axis++;
        }

        return ans;   
    }  
}
