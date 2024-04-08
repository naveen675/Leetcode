// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/?envType=daily-question&envId=2024-04-08

// push students into queue and push sandwiches into stack 
// check for every first person in queue wether he can able to eat sandwitch on top of the stack
// if it is possible then remove that student and sandwich from the stack
// else move the student to end of the queue by keeping sandwich on top
// O(N) O(N) Stack and Queue

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int len = students.length;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int unServed = 0;


        for(int i=0; i<len; i++){
            queue.add(students[i]);
            stack.add(sandwiches[len-i-1]);
        }
        while(queue.size() != 0){
            if(queue.peek() == stack.peek() ){ queue.poll(); stack.pop(); unServed=0;}
            else{ 

                queue.add(queue.poll());
                unServed++;
            }
            if(queue.size() == unServed){ break; }
        }
        int noEat = queue.size();
        return noEat;
        
    }
}
