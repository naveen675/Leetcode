//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/?envType=daily-question&envId=2024-04-07
class Solution {
    public String minRemoveToMakeValid(String s) {

        int len = s.length();
        StringBuilder str=  new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<len; i++){

            char c = s.charAt(i);

            if(c == '(') {stack.push(i); str.append(c); }
            else if(c == ')' ){ 

                if(stack.size() != 0){
                    stack.pop();
                    str.append(c);
                }

                else{
                    str.append('*');
                }
            }

            else{ str.append(c); }
        }

        while(stack.size() != 0){ str.deleteCharAt(stack.pop()); }
        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) != '*'){ ans.append(str.charAt(i)); }
        }

        return String.valueOf(ans);

        
    }
}
