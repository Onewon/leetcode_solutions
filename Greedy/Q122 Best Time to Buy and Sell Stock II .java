/**
 * 122 Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 **/
/*
* Input: [7,1,5,3,6,4]  Output: 5
* Input: [7,6,4,3,1]    Output: 0
*             Start
*              /   \
*            -7      0
*           /  \    /  \
*         -6  -7   -1   0
*/
class Solution_DFS { // O(2^n)
    Boolean isStock = false;
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        return Math.max(BuySellorNot(prices,-1,0,true),BuySellorNot(prices,-1,0,false));
    }
    public int BuySellorNot(int[] prices,int level,int profit,Boolean do_something) {
        level = level + 1;
        if(prices.length < level) return profit;
        if(do_something==true){
            if(isStock == false) {
                int buy = prices[level];
                profit = profit - buy;
                isStock = true;
            }
            else{
                int sell = prices[level];
                profit = profit + sell;
                isStock = false;
            }
            return Math.max(BuySellorNot(prices,level,profit,true),BuySellorNot(prices,level,profit,false));
        }else{
            return Math.max(BuySellorNot(prices,level,profit,true),BuySellorNot(prices,level,profit,false));
        }
    }
}
