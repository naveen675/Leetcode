//https://leetcode.com/problems/combination-sum/

//O()
// Approach 1
// BackTracking
// faster than below solution

class Solution {

    public void util(int [] candidates, int target, List<List<Integer>> ans , int i, int sum, List<Integer> subset ){

        if(sum == target){
            ans.add(new ArrayList<>(subset));
            return; 
        }
        if(sum > target){ return; }

        for(int j=i; j<candidates.length; j++){

            sum = sum + candidates[j];
            subset.add(candidates[j]);
            util(candidates, target, ans, j, sum, subset);
            sum = sum - candidates[j];
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        util(candidates, target, ans, 0, 0, subset);
        return ans;
    }
}

// Approach With Recursion

// class Solution {

//     ArrayList<Integer> subset = new ArrayList<>();
//     public void util(int [] candidates, int target, List<List<Integer>> ans , int i, int sum, ArrayList<Integer> subset ){
        
//         if(i == candidates.length){
//             if(sum == target){ ans.add(new ArrayList<>(subset)); return; }
//             else { return; }
//         }
        
//         if(sum < target){

//             subset.add(candidates[i]);
//             sum = sum + candidates[i];
//             util(candidates, target, ans, i, sum, subset);
//             sum = sum - candidates[i];
//             subset.remove(subset.size()-1);
//         }

//         util(candidates, target, ans, i+1, sum, subset);

//     }
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {

//         List<List<Integer>> ans = new ArrayList<>();
//         ArrayList<Integer> subset = new ArrayList<>();
//         util(candidates, target, ans, 0, 0, subset);

//         return ans;
//     }
// }
