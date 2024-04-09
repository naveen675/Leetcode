//https://leetcode.com/problems/time-needed-to-buy-tickets/?envType=daily-question&envId=2024-04-09

// Approach 1 (One Pass) O(N) O(1)
// we will split element types in ticekts array into 2 types
// 1 -> elements before or equal k index
// 2 -> elements after k index
// iterate array from i=0; i<n do
// time = time + 
// if (i before or equal k) { then Math.min(tickets[i], tickets[k])}
// else Math.min(tickets[i], tickets[k]-1);

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int len = tickets.length;
        int time =0;
        for(int i=0; i<len; i++){

            if(i <= k){time = time + Math.min(tickets[i], tickets[k]);}
            else{ time  = time + Math.min(tickets[i], tickets[k]-1 );}
        }

        return time;
        
    }
}


// Appeoach 2 
// O(tickerts[k]*N) O(1)
//we iterate entire array from i=0 till i < n this iteration performs tickets[k] number of times
// count time inside inner for loop for every decrement of tickets[i] unless tickets[i] == 0

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int len = tickets.length;
        int time =0;
        while(tickets[k] != 0){

            for(int i=0; i<len; i++){
                if(tickets[i] != 0){ 
                    time++; 
                    tickets[i]--;
                    if(tickets[k] == 0){         // Check if tickets at kth position is zero
                                                    // because after this we no need to count time 
                                                    // after kth index
                        break;
                    }}
            }
        }
        return time;
        
    }
}
