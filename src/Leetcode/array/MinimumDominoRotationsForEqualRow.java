/**
 * Problem Link: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
 */

package Leetcode.array;

import java.util.ArrayList;

public class MinimumDominoRotationsForEqualRow
{
    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        int topValue = tops[0], topCount = 1;
        int bottomValue = bottoms[0], bottomCount = 1;
        int totalLength = tops.length;
        int sameTop = 0;
        int sameBottom = 0;

        for(int i=1; i<tops.length; i++)
        {
            if(topValue != -1)
            {
                if (tops[i] == topValue)
                {
                    topCount++;
                    if(bottoms[i] == topValue)
                    {
                        sameTop++;
                    }
                }
                else if(bottoms[i] == topValue)
                {

                }
                else
                {
                    topValue = -1;
                }
            }

            if (bottomValue != -1)
            {
                if (bottoms[i] == bottomValue)
                {
                    bottomCount++;
                    if(tops[i] == bottomValue)
                    {
                        sameBottom++;
                    }
                }
                else if(tops[i] == bottomValue)
                {

                }
                else
                {
                    bottomValue = -1;
                }
            }

            if(topValue == -1 && bottomValue == -1)
            {
                return -1;
            }
        }

        if(topValue != -1 && bottomValue != -1)
        {
            if(topCount == tops.length)return 0;
            else if(topCount == bottomCount)return tops.length - topCount;
            else
            {
                int[] remainingArray = new int[4];
                remainingArray[0] = topCount; remainingArray[1] = bottomCount;
                remainingArray[2] = tops.length - topCount;
                remainingArray[3] = tops.length - bottomCount;
                int minValue= Integer.MAX_VALUE;
                for(int i=0; i<4; i++)
                {
                    if(remainingArray[i] < minValue)minValue = remainingArray[i];
                }
                return minValue;
            }
        }
        else if (bottomValue == -1)
        {
            if(topCount - sameTop > tops.length - topCount)
                return tops.length - topCount;
            else
                return topCount - sameTop;
        }
        else
        {
            if(bottomCount -sameBottom > tops.length - bottomCount)
                return tops.length - bottomCount;
            else
                return bottomCount - sameBottom;
        }

    }

}
