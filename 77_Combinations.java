//https://leetcode.com/problems/combinations/
// O(2^n) O(2^n)
class Solution {

    public void util(int i, int size, List<List<Integer>> ans, List<Integer> subset, int n){

        if(size == subset.size()){
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int j=i; j<=n; j++){

            subset.add(j);
            util(j+1,size, ans, subset,n);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        util(1, k, ans, subset, n);
        return ans;
        
    }
}