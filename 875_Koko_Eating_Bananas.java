//https://leetcode.com/problems/koko-eating-bananas/
//O(nlogk) O(1)
class Solution {

    public long getHoursPerKBananas(int [] piles, long k ){
        long hours =0;

        for(int i=0; i<piles.length; i++){

            long pile = (long)piles[i];
            hours = hours + pile/k;
            if(pile%k != 0){ hours = hours+1; }
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        long mink = 1;
        long maxk = 1000000000;  // as per the contraints given piles.length <= h <= 1000000000
        int len = piles.length;
        long reqHours = (long)h;
        long ans =0;

        while(mink <= maxk){

            long k = mink + (maxk - mink)/2;
            long hoursToComplete = getHoursPerKBananas(piles, k);  // Cause overflow at  [805306368,805306368,805306368] h=1000000000
            if(hoursToComplete <= reqHours){
                ans = k;
                maxk = k-1;
            }
            else{
                mink = k+1;
            }
        }
        return (int)ans;
    }
}
