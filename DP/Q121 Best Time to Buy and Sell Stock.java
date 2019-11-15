/**
*121. Best Time to Buy and Sell Stock
*
*Say you have an array for which the ith element is the price of a given stock on day i.
*
*If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*
*Note that you cannot sell a stock before you buy one.
*
*
* Input: [7,1,5,3,6,4]
* Output: 5
**/

class Solution_fail {
    public int maxProfit(int[] prices) {
        if(prices.length==0||prices.length==1) return 0;
        int low_index = -1;
        int high_index = -1;
        int max=0;
        int min=0;
        for (int i = 0; i < prices.length; i++) {
            if (i==0 && prices[i]<=prices[i+1] ) {
                max = prices[i+1];
                min = prices[i];
                high_index = i+1;
                low_index =i;
                continue;
            } //first step get max and min
            else if (i==0 && prices[i]>prices[i+1] ) {
                min = prices[i+1];
                max = prices[i];
                low_index =i+1;
                high_index = i;
                continue;
            }
            if(high_index<low_index) {max = 0; high_index=-1;}
            if(min>prices[i]) {min = prices[i]; low_index = i;}
            if(max<prices[i]) {max = prices[i]; high_index = i;}
        }
        return max-min;
    }
}
// O(n ~ n^n)

class Solution {
    public int maxProfit(int[] prices) {
        
    }
}




