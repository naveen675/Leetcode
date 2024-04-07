//https://leetcode.com/problems/valid-parenthesis-string/?envType=daily-question&envId=2024-04-07

// Traversing left and right by left++ and right -- in same loop 
// do leftcount++ when s[left] == "(" or "*" else leftcount--
// do rightcount++ when s[right] == ")" or "*" else rightcount--
// check if openCount < 0 || closeCount < 0 return false;
// after the end of the loop return true;
class Solution {


    public boolean checkValidString(String s) {

        int sLength = s.length();
        int open =0;
        int close =0;
        int left=0;
        int right=sLength-1;
        for(int i=0; i<sLength; i++){

            int leftChar = s.charAt(left++);                  // edge -> F -> *(  T -> *)  T -> *()
            int rightChar = s.charAt(right--);

            if(leftChar == '(' || leftChar == '*'){ open++; }
            else{ open--; }

            if(rightChar == ')' || rightChar == '*'){ close++; }
            else{ close--; }

            if(open < 0 || close < 0){ return false; }
        }
        return true;   
    }
}
