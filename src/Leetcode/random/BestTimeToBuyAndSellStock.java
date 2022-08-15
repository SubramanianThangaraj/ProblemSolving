/**
 * Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

package Leetcode.random;

public class BestTimeToBuyAndSellStock
{
    public int maxProfit(int[] prices)
    {
        int currentPrice = prices[0];
        int highestProfit = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]<currentPrice)
            {
                currentPrice = prices[i];
            }
            else if(prices[i]>currentPrice)
            {
                if((prices[i]-currentPrice) > highestProfit)
                {
                    highestProfit = prices[i]-currentPrice;
                }
            }
        }
        return highestProfit;
    }
}
