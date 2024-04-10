//https://leetcode.com/problems/reveal-cards-in-increasing-order/?envType=daily-question&envId=2024-04-10
//O(n logn) O(N)
//


class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        int len = deck.length;
        int [] ans = new int[len];
        int i=0;
        Arrays.sort(deck);
        int k=0;
        Queue<Integer> queue = new LinkedList<>();

        for(int j=0; j<len; j++){

            queue.add(j);
        }
        while(queue.size() != 0){

            int index = queue.poll();
            ans[index] = deck[i++]; 
            if(queue.size() != 0){ queue.add(queue.poll());}
        }
        
        return ans;   
    }
}
