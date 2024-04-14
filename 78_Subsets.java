//https://leetcode.com/problems/subsets/
//O(2^n) O(2^n)

class Solution {
    public void util(int [] nums, int i, int len, List<List<Integer>> ans, List<Integer> subset){

        if(i >= len){ 
            ans.add(new ArrayList<>(subset));        // Edge case dont forget to create new arraylist and add to ans
                                        // else you may end up in adding empty lists
            return; 
        }

        subset.add(nums[i]);
        util(nums,i+1, len, ans, subset);          // 
        subset.remove(subset.size()-1);             
        util(nums, i+1, len, ans, subset);

    }
    public List<List<Integer>> subsets(int[] nums) {

        int len =  nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        util(nums, 0, len, ans, subset);

        return ans;
    }
}
