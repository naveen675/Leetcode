//https://leetcode.com/problems/buy-two-chocolates/description/
// O(N) O(1)

class Solution {
    public int buyChoco(int[] prices, int money) {
         int [] freq = new int[101];
         int minPrice = Integer.MAX_VALUE;
         int moneyLeft = money;

         for(int i=0; i<prices.length; i++){
            freq[prices[i]]++;
            minPrice = Math.min(minPrice, prices[i]);
         }

         int choclates = 2;
         for(int price=1; price<=100; price++){
            if(freq[price] != 0){

                if(choclates == 2 ){ 

                    if(freq[price] >= 2){ 
                        moneyLeft = moneyLeft - choclates * price;
                        choclates = choclates - 2; }
                    else {
                        moneyLeft = moneyLeft -  price;
                        choclates--;
                    }
                }

                else if(choclates == 1){ 

                    moneyLeft = moneyLeft - choclates * price;
                    choclates--;
                }
                
                if(moneyLeft < 0){ return money; }
                if(price == 0){ break; }
            }
         }
         return moneyLeft;    
    }
}
