//https://leetcode.com/problems/subsets-ii/
// O(2^n) O(2^n)

// Approach Using Set to remove Duplicates
class Solution {

    public void util(int [] nums, Set<List<Integer>> ans, List<Integer> subset, int i){

        if(i >= nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);

        util(nums, ans, subset, i+1);
        subset.remove(subset.size()-1);
        util(nums, ans, subset, i+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> a= new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        util(nums, ans, subset, 0);
        for(List<Integer> i : ans){
            a.add(new ArrayList<>(i));
        }
        return a;
        
    }
}


// Approach 2 Without hashset
class Solution {

    public void util(int [] nums, List<List<Integer>> ans, List<Integer> subset, int i){

        if( i >= nums.length && ! ans.contains(subset)){
            ans.add(new ArrayList<>(subset));
            return;
        }
        else if(i >= nums.length){ return;}

        subset.add(nums[i]);
        util(nums, ans, subset, i+1);
        subset.remove(subset.size()-1);
        util(nums, ans, subset, i+1);

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums); // For all the arrays who are having duplicates sorteing the array is mandatory to handle duplicates
        util(nums,ans, subset, 0);
        return ans;
        
        
    }
}

