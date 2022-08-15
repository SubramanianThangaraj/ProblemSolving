/**
 * Problem Link: https://leetcode.com/problems/consecutive-numbers-sum/
 */

package Leetcode.random;

public class ConsecutiveNumbersSum
{
    public int consecutiveNumbersSum(int n)
    {
        if(n<=2)return 1;
        if(n==3)return 2;
        int reminder;
        int numberOfPossibilities = 1;
        int limit = 0;
        int sum = 0;

        //Finding the limit
        for(int i=1; i<n; i++)
        {
            sum = sum + i;

            if(sum<=n)limit++;
            else
                break;
        }

        for(int i=2; i<=limit; i=i+2)
        {
            reminder = n%i;
            if(reminder*2 == i)numberOfPossibilities++;
        }
        for(int i=3; i<=limit; i=i+2)
        {
            reminder = n%i;
            if(reminder==0)numberOfPossibilities++;
        }

        return numberOfPossibilities;

    }
}
