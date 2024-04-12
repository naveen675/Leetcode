//https://leetcode.com/problems/trapping-rain-water/?envType=daily-question&envId=2024-04-12

// O(N) O(1)
// This solution is improvement of finding left max and right max and trapped rained water 
// will be Math.min(leftmax[i] , rightMax[i]) - A[i];
// if you observe we are considering the side which has Min of max height because
// if onside is lower than other side then water will be trapped until the lower one side
// so considering the above observe we will create two pointers left and right
// with left max and right max, utnil left < right
// at every iteration we will be updating leftmax and right max 
// when A[left] < A[right] then water will be at lower side so we will do 
//watertrapped = wattertrapped + leftMax - A[left] left++;
// else if A[left] >= A[right] then watertrapped = wattertrapped + rightMax - A[right] right--;


class Solution {
    public int trap(int[] height) {

        int left =0;
        int right=height.length-1;
        int waterTrapped =0;
        int leftMaxHeight =0;
        int rightMaxHeight =0;


        while(left < right){

            leftMaxHeight = height[left] > leftMaxHeight ? height[left] : leftMaxHeight;
            rightMaxHeight = height[right] > rightMaxHeight ? height[right] : rightMaxHeight;

            if(height[left] < height[right]){ 
                waterTrapped = waterTrapped + leftMaxHeight - height[left];
                left++;

        }
            else{
                waterTrapped = waterTrapped + rightMaxHeight - height[right];
                right--;
            }
        
    }
    return waterTrapped;
    }
}
