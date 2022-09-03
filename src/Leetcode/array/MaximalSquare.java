/**
 * Problem Link: https://leetcode.com/problems/maximal-rectangle/
 */

package Leetcode.array;

import java.util.Stack;

public class MaximalSquare
{
    public int maximalSquare(char[][] matrix)
    {
        int sum=1;
        char zero = '0';
        char one = '1';
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        int value = 0;
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
        int area = 0;
        int length;
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
                    length = ascendingStack.isEmpty()? column : column - 1 - ascendingStack.peek();
                    if(intMatrix[row][prevIndex] == length)
                    {
                        area = intMatrix[row][prevIndex] * length;
                    }
                    else if(intMatrix[row][prevIndex] > length)
                    {
                        area = length * length;
                    }
                    else if(intMatrix[row][prevIndex] < length)
                    {
                        area = intMatrix[row][prevIndex] * intMatrix[row][prevIndex];
                    }

                    if(area > maxArea)
                    {
                        maxArea = area;
                    }
                }
            }

            while (!ascendingStack.isEmpty())
            {
                prevIndex = ascendingStack.pop();
                length = ascendingStack.isEmpty()? column : column - 1 - ascendingStack.peek();
                if(intMatrix[row][prevIndex] == length)
                {
                    area = intMatrix[row][prevIndex] * length;
                }
                else if(intMatrix[row][prevIndex] > length)
                {
                    area = length * length;
                }
                else if(intMatrix[row][prevIndex] < length)
                {
                    area = intMatrix[row][prevIndex] * intMatrix[row][prevIndex];
                }

                if(area > maxArea)
                {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
