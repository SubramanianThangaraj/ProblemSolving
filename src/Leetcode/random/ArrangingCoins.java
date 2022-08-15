/**
 * Problem Link: https://leetcode.com/problems/arranging-coins/
 */
package Leetcode.random;

public class ArrangingCoins
{
    public int arrangeCoins(int n)
    {
        long numberOfCoinsUsed = 0;
        int numberOfSteps = 0;
        while(numberOfCoinsUsed < n)
        {
            numberOfSteps++;
            numberOfCoinsUsed = numberOfCoinsUsed + numberOfSteps;
        }
        if(numberOfCoinsUsed > n)numberOfSteps--;

        return numberOfSteps;
    }
}
