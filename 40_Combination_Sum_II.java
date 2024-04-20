//https://leetcode.com/problems/combination-sum-ii/description/

class Solution {

    public void util(int [] candidates, int i, List<Integer> subset, List<List<Integer>> ans, int target){

        if(target == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int j=i; j<candidates.length; j++){

            if(j > i && candidates[j] == candidates[j-1]){ continue;}  // j > i is an import case to handle . So that there wont            be                                                                         any     duplicates
            if(candidates[j] > target){ break; }
            subset.add(candidates[j]);
            util(candidates, j+1, subset, ans, target - candidates[j]);
            subset.remove(subset.size()-1);

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        util(candidates, 0, subset,ans, target );
        return ans;
    }
}