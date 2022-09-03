/**
 * Problem Link: https://leetcode.com/problems/longest-palindromic-substring/
 */

package Leetcode.array;

import java.util.Stack;

public class MaximalRectangle
{
    public int maximalRectangle(char[][] matrix)
    {
        int sum=1;
        char one = '1';
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        int value = 0;

        // Converting the given char matrix to a integer matrix
        // Traverse column by column
        // Along with that the value of a particular index should be the summation of 1's in the previous rows, (Until '0')
        for(int column=0; column<matrix[0].length; column++)
        {
            sum = 1;
            for (int row=0; row<matrix.length; row++)
            {
                if(matrix[row][column] == one)
                {
                    intMatrix[row][column] = sum;
                    sum++;
                }
                else
                {
                    sum = 1;
                }
            }
        }

        Stack<Integer> ascendingStack = new Stack();
        int prevIndex;
        int maxArea = 0;
        int area;

        //Traverse row by row, And using histogram approach calculate the largest area.
        for(int row=0; row<matrix.length; row++)
        {
            int column;
            for(column=0; column<matrix[0].length;)
            {
                if(ascendingStack.isEmpty() || intMatrix[row][ascendingStack.peek()] <= intMatrix[row][column])
                {
                    ascendingStack.push(column++);
                }
                else
                {
                    prevIndex = ascendingStack.pop();
                    area = intMatrix[row][prevIndex] * (ascendingStack.isEmpty()? column : column - 1 - ascendingStack.peek());
                    if(area > maxArea)
                    {
                        maxArea = area;
                    }
                }
            }

            while (!ascendingStack.isEmpty())
            {
                prevIndex = ascendingStack.pop();
                area = intMatrix[row][prevIndex] * (ascendingStack.isEmpty()? column : column - 1 - ascendingStack.peek());
                if(area > maxArea)
                {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
