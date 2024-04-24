//https://leetcode.com/problems/n-th-tribonacci-number/
// O(N) O(N)

class Solution {
    public int tribonacci(int n) {
        
        int [] dp = new int[n+1];
        if(n == 0){ return n;}
        if(n <= 2){ return 1; }
        dp[0] = 0;

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3; i<=n; i++){

            if(i == 0){ dp[i] = 0; }
            if( i <= 2){ dp[i] = 1; }

            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }
}