//https://leetcode.com/problems/permutations-ii/

class Solution {
    public void util(int [] nums, List<List<Integer>> ans, List<Integer> set, int []visited){

        if(set.size() == nums.length && ! ans.contains(set)){
            ans.add(new ArrayList<>(set));
            return;
        }

        for(int i=0; i<nums.length; i++){

            if(i > 0 && nums[i] == nums[i-1]){ continue; }
            if(visited[nums[i] + 10] > 0){    // Since Array Has negative Number we have to convert them to positive intdex. 
                                                // if frequency is greater than 0 then only we will add that element to set

                set.add(nums[i]);
                visited[nums[i] + 10] = visited[nums[i] + 10] - 1;
                util(nums, ans, set, visited );
                visited[nums[i] + 10] = visited[nums[i]+10] +1;
                set.remove(set.size()-1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int [] visited = new int[21];
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            visited[nums[i] + 10]++;                    // Due tto deuplicates we need to have freq array to cout number of times the element is                                                        added to set.
        }
        util(nums, ans, set, visited);
        return ans;
    }
}