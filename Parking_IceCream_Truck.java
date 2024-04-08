public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {

        int ALength = A.length;
        int [] ans = new int[ALength - B +1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left =0;
        int right =0;
        int k=0;


        while(right < B){

            int elm = A[right];
            while(deque.size() != 0 && deque.getLast() < elm){
                deque.removeLast();
            }

            deque.addLast(elm);
            right++;

        }
        ans[k] = deque.getFirst();
        k = k+1;

        while(right < ALength){

            int elm = A[right];
            while(deque.size() != 0 && deque.getLast() < elm){

                deque.removeLast();
            }
            if(deque.size() != 0 && deque.getFirst() == A[left]){ deque.removeFirst(); }
            deque.addLast(elm);
            ans[k++] = deque.getFirst();
            left++;
            right++;

        }

        return ans;
    }
}
