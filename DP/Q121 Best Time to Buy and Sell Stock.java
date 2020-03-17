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

class Solution {
    public int maxProfit(int[] prices) {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int n = prices.length;
            if(n==0) return profit;
            int[][] DP =new int[n][3];
            DP[0][0] = 0; //not and never have
            DP[0][1] = -prices[0]; //buy one
            DP[0][2] = 0;  // not but bought
            for (int i = 1; i <n; i++) { 
                DP[i][0] = DP[i-1][0];
                DP[i][1] = Math.max(DP[i-1][0]-prices[i],DP[i-1][1]);
                DP[i][2] = Math.max(DP[i-1][1]+prices[i], DP[i-1][2]);
            }
            profit = MaxinThree(DP[n-1][0], DP[n-1][1], DP[n-1][2]);
            return profit;
        }
        public int MaxinThree(int a,int b,int c){
            int max = Math.max(a,b);
            max = Math.max(max,c);
            return max;
        }
    }
}




