/**
 * Problem Link: https://leetcode.com/problems/sliding-window-maximum/submissions/
 */
package Leetcode.random;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        Deque<Integer> Qi = new LinkedList<Integer>();
        int[] returnArray = new int[nums.length-k+1] ;
        int i;
        for (i = 0; i < k; ++i)
        {
            while (!Qi.isEmpty() && nums[i] >= nums[Qi.peekLast()])
            {
                Qi.removeLast();
            }
            Qi.addLast(i);
        }
        int count = 0;
        for (; i < nums.length; ++i)
        {
            returnArray[count] = nums[Qi.peek()];
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
            {
                Qi.removeFirst();
            }
            while ((!Qi.isEmpty()) && nums[i] >= nums[Qi.peekLast()])
            {
                Qi.removeLast();
            }
            Qi.addLast(i);
            count++;
        }
        returnArray[count] = nums[Qi.peek()];
        return returnArray;
    }
}
