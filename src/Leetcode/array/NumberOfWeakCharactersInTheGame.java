/**
 * Problem Link: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
 */

package Leetcode.array;

import java.util.Arrays;
import java.util.Stack;

public class NumberOfWeakCharactersInTheGame
{
    public int numberOfWeakCharacters(int[][] properties)
    {
        return inbuiltSort(properties);

//        return bruteForce(properties);
//        return monotonicStack(properties);
//        return bubbleSort(properties);
    }

    //Working model
    public int inbuiltSort(int[][] properties)
    {
        //'a' corresponds to one record and 'b' corresponds to another record (row)
        // ex: a[0] = first row, first column.
        //a[1] = first row, second column.
        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);

        // Now the given array got sorted with Descending order of attack
        // And for characters with same attack, It will be sorted in ascending order of Defence

        int highDefence = properties[0][1];
        int noOfWeakCharacters = 0;
        for(int i=1; i<properties.length; i++)
        {
            if(properties[i][1] < highDefence)
                noOfWeakCharacters++;
            else highDefence = properties[i][1];
        }

        return noOfWeakCharacters;

    }

    //Time limit exceeded
    public int bubbleSort(int[][] properties)
    {
        //Bubble sort the given array based on its attack, And in Descending order.

        int tempStorage;
        int noOfCharacters = properties.length;
        boolean isSwapped;
        while (noOfCharacters!=1)
        {
            isSwapped = false;
            for (int i = 0; i < noOfCharacters - 1; i++)
            {
                if (properties[i][0] <= properties[i + 1][0])
                {
                    //If both the characters have same attack, then check the Defence strength.
                    // And sort it in ascending order of defence.
                    if (properties[i][0] == properties[i + 1][0])
                    {
                        if (properties[i][1] > properties[i + 1][1])
                        {
                            //Swap "Attack"
                            tempStorage = properties[i][0];
                            properties[i][0] = properties[i + 1][0];
                            properties[i + 1][0] = tempStorage;

                            //Swap "Defence"
                            tempStorage = properties[i][1];
                            properties[i][1] = properties[i + 1][1];
                            properties[i + 1][1] = tempStorage;
                            isSwapped = true;
                        }
                    }
                    else
                    {
                        //Swap "Attack"
                        tempStorage = properties[i][0];
                        properties[i][0] = properties[i + 1][0];
                        properties[i + 1][0] = tempStorage;

                        //Swap "Defence"
                        tempStorage = properties[i][1];
                        properties[i][1] = properties[i + 1][1];
                        properties[i + 1][1] = tempStorage;
                        isSwapped = true;
                    }
                }
            }
            if(!isSwapped)break;
            noOfCharacters--;
        }


        // Now the given array got sorted with Descending order of attack

        int highAttack = properties[0][0];
        int highDefence = properties[0][1];
        int noOfWeakCharacters = 0;
        for(int i=1; i<properties.length; i++)
        {
            if(properties[i][1] < highDefence)
                noOfWeakCharacters++;
            else highDefence = properties[i][1];
        }

        return noOfWeakCharacters;
    }







    //Time limit exceeded
    // Time complexity = O(n*n)
    public int bruteForce(int[][] properties)
    {
        int noOfWeakCharacters = 0;
        int currentAttack, currentDefence;
        boolean thisIsNotWeak;
        for (int i=0; i<properties.length; i++)
        {
            currentAttack = properties[i][0];
            if (currentAttack == -1) continue;
            currentDefence = properties[i][1];
            thisIsNotWeak = true;

            for (int j=i+1; j< properties.length; j++)
            {
                if(properties[j][0] != -1) {
                    if (properties[j][0] < currentAttack && properties[j][1] < currentDefence) {
                        noOfWeakCharacters++;
                        // -1 is used as a flag, So we don't need to check this character again, Since this is already weak
                        properties[j][0] = -1;
                    } else if (thisIsNotWeak && currentAttack < properties[j][0] && currentDefence < properties[j][1]) {
                        noOfWeakCharacters++;
                        thisIsNotWeak = false;
                    }
                }
            }
        }

        return noOfWeakCharacters;
    }
}
