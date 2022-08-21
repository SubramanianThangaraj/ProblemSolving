/**
 * Problem Link: https://leetcode.com/problems/zigzag-conversion
 */

package Leetcode.string;

public class ZigZagConversion
{
    public String convert(String s, int numRows)
    {
        if(numRows==1 || numRows>= s.length())return s;
        char[] givenStringArray = s.toCharArray();
        int zig,zag;
        String convertedString = "";
        for(int row=1; row<=numRows; row++)
        {
            zig = (numRows - row) * 2;
            zag = (row-1) * 2;
            zig = zig == 0 ? zag : zig;
            zag = zag == 0 ? zig : zag;

            for(int i=row-1; i<givenStringArray.length; i=i+zag)
            {
                convertedString = convertedString + givenStringArray[i];

                i = i + zig;
                if(i<givenStringArray.length)
                    convertedString += givenStringArray[i];
            }
        }
        return convertedString;
    }
}
