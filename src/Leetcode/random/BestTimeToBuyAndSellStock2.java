/**
 * Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
package Leetcode.random;

public class BestTimeToBuyAndSellStock2
{
    public int maxProfit(int[] prices)
    {
        int buyPrice = prices[0];
        int totalProfit = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]<buyPrice)
            {
                buyPrice = prices[i];
            }
            else if(prices[i]>buyPrice)
            {
                totalProfit = totalProfit + prices[i] - buyPrice;
                buyPrice = prices[i];
            }
        }
        return totalProfit;
    }
}
