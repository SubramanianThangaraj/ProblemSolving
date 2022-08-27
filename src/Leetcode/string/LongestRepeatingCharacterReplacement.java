/**
 * Problem Link: https://leetcode.com/problems/longest-repeating-character-replacement
 */

package Leetcode.string;

public class LongestRepeatingCharacterReplacement
{
    //Optimize the following code by storing the value of each iteration and make use of it in the next iteration.
    public int characterReplacement(String s, int k)
    {
        if (k >= s.length()) return s.length();
        char[] giveStringArray = s.toCharArray();
        int count = 0;
        int max =0;
        char firstChar = '1';
        for(int i=0; i<giveStringArray.length; i++)
        {
            if(giveStringArray[i]==firstChar)continue;
            firstChar = giveStringArray[i];
            int j;
            count = 0;

            for(j=i+1; j<giveStringArray.length; j++)
            {
                if(giveStringArray[j] == firstChar)
                {
                    continue;
                }
                else
                {
                    if (count<k)
                        count++;
                    else
                        break;
                }
            }
            int length = j - i;
            if(count<k)
                length = length + k - count;
            if(length>max)
                max = length;
            if(max>= giveStringArray.length)
                return giveStringArray.length;
        }
        return max;
    }
}
