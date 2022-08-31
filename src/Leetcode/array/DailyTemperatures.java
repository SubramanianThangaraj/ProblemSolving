/**
 * Problem Link: https://leetcode.com/problems/daily-temperatures
 */
package Leetcode.array;

import java.util.Stack;

public class DailyTemperatures
{
    public int[] dailyTemperatures(int[] temperatures)
    {
        int currentTemp;
        int previousMaxIndex = 0;
        int startIndex;
        int noOfDaysToWait = 0;
        for(int i=0; i<temperatures.length; i++)
        {
            currentTemp = temperatures[i];
            temperatures[i] = 0;
            int j;
            if(previousMaxIndex!=0 && currentTemp > temperatures[previousMaxIndex])
            {
                startIndex = previousMaxIndex + 1;
            }
            else
                startIndex = i+1;

            for(j=startIndex; j<temperatures.length; j++)
            {
                if(temperatures[j]>currentTemp)
                {
                    noOfDaysToWait = j-i;
                    temperatures[i] = noOfDaysToWait;
                    previousMaxIndex = j;
                    break;
                }
            }
        }
        return temperatures;
    }

    public int[] dailyTemperaturesUsingStack(int[] temperatures)
    {
        int[] resultantArray = new int[temperatures.length];

        Stack<Integer> descendingStack = new Stack<>();
        int currentIndex;

        for (int i=0; i<temperatures.length;)
        {
            if(descendingStack.isEmpty() || temperatures[descendingStack.peek()] >= temperatures[i])
            {
                descendingStack.push(i++);
            }
            else
            {
                currentIndex = descendingStack.pop();
                resultantArray[currentIndex] = i - currentIndex;
            }
        }

        return resultantArray;
    }
}
