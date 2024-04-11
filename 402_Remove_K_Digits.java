// https://leetcode.com/problems/remove-k-digits/?envType=daily-question&envId=2024-04-11
// O(N) O(N)
// Try drawing a graph or curve based on numbers in the given string from left to right
// lets take example of 1432219
// if you observe after 1 there will be increase line which is 4 instead of deleting 1 we need 
// to delete 4 because the problem say we have to delete digits which makes bigger number
// use stack and push digits from left to right when s[i] < stack.peek() then remove that element 
// repeat this until the last element in stack.peek() < s[i]
// edge case 22222
// when string.length == k hadle these 2 edge cases

class Solution {
    public String removeKdigits(String num, int k) {

        int len = num.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder s = new StringBuilder();

        if(k == len){ return "0";}  // to handle num = "10", k = 2
        
        for(int i=0; i<len; i++){

            char c = num.charAt(i);
            while(k > 0 && stack.size() != 0 && c < stack.peek()){

                    stack.pop();
                    k--;
            }
            stack.push(c);

        }
        while(k > 0){ stack.pop(); k--; }   // to handle cases like 33333

        while(stack.size() != 0){
            
            s.append(stack.pop());
        }
        s = s.reverse();
        while(s.length() > 1 && s.charAt(0) == '0'){
            s.deleteCharAt(0);
        }

        return String.valueOf(s);
        
    }
}
