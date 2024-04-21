//https://leetcode.com/problems/permutations/description/
// O(2^N) O(N)

class Solution {

    public void util(int [] nums, List<List<Integer>> ans, List<Integer> set, boolean []visited){

        if(set.size() == nums.length){
            ans.add(new ArrayList<>(set));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(visited[nums[i] + 10] == false){    // Since Array Has negative Number we have to convert them to positive intdex. 

                set.add(nums[i]);
                visited[nums[i] + 10] = true;
                util(nums, ans, set, visited );
                visited[nums[i] + 10] = false;
                set.remove(set.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        boolean [] visited = new boolean[21];
        util(nums, ans, set, visited); 

        return ans; 
    }
}