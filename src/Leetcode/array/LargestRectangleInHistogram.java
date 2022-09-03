/**
 * Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */

package Leetcode.array;

import java.util.*;

public class LargestRectangleInHistogram
{

    public int largestRectangleArea(int heights[])
    {
        // Create an empty stack. The stack holds indexes of heights[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> ascendingStack = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < heights.length)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (ascendingStack.empty() || heights[ascendingStack.peek()] <= heights[i])
                ascendingStack.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = ascendingStack.pop();

                // Calculate the area with heights[tp] stack as smallest bar
                area_with_top = heights[tp] * (ascendingStack.empty() ? i : i - ascendingStack.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (ascendingStack.empty() == false)
        {
            tp = ascendingStack.pop();

            area_with_top = heights[tp] * (ascendingStack.empty() ? i : i - ascendingStack.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }
}
