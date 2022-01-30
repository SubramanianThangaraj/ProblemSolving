/**
 * Problem Link: https://leetcode.com/problems/permutation-in-string/
 */
package Leetcode.random;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation
{
    public boolean checkInclusion(String s1, String s2)
    {

        if(s2.length() < s1.length()) return false;

        HashMap<Character,Integer> s1CharMap = new HashMap();
        HashMap<Character,Integer> s2CharMap = new HashMap();
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        char s1char;
        //Store each character of s1 and their count in s1CharMap
        for(int i=0; i<s1.length(); i++)
        {
            s1char = s1CharArray[i];
            if(s1CharMap.containsKey(s1char))
            {
                s1CharMap.replace(s1char, s1CharMap.get(s1char)+1);
            }
            else
            {
                s1CharMap.put(s1char, 1);
            }
        }
        //Store each character of s2 and their count in s2CharMap
        for(int i=0; i<s2.length(); i++)
        {
            s1char = s2CharArray[i];
            if(s2CharMap.containsKey(s1char))
            {
                s2CharMap.replace(s1char, s2CharMap.get(s1char)+1);
            }
            else
            {
                s2CharMap.put(s1char, 1);
            }
        }
        //If s2 has fewer characters than s1 then substring is not possible
        if(s2CharMap.size()<s1CharMap.size())return false;
        //Check for substring possibility.
        //If either the character present in s1 is not present in s2 or if it is present but the count of character in s2 is less than s1 than substring is not possible.
        for(Map.Entry<Character, Integer> s1Entry : s1CharMap.entrySet())
        {
            char s1Key = s1Entry.getKey();
            int s1Value = s1Entry.getValue();
            if(s2CharMap.containsKey(s1Key))
            {
                int s2Value = s2CharMap.get(s1Key);
                if(s2Value<s1Value)return false;
            }
            else return false;
        }
        HashMap<Character, Integer> compareMap = new HashMap<>();
        char compareChar;
        int starting =0;
        int count = 0;
        int numberOfCharacters;
        for(int i=0; i<s2.length(); i++)
        {
            compareChar = s2CharArray[i];

            if(compareMap.containsKey(compareChar))
            {
                count++;
                numberOfCharacters = compareMap.get(compareChar);
                if(numberOfCharacters==s1CharMap.get(compareChar))
                {
                    if(s2CharArray[starting]==compareChar)
                    {
                        count--;
                        starting = starting+1;
                        continue;
                    }
                    else
                    {
                        for(int j=starting; j<i; j++)
                        {
                            if(s2CharArray[j] == compareChar)
                            {
                                if((s2.length()-1-j)<s1.length())return false;

                                count = 0;
                                starting = j+1;
                                i = j;
                                compareMap.clear();
                                continue;
                            }
                        }
                    }
                }
                compareMap.replace(compareChar, numberOfCharacters+1);
            }
            else
            {
                if(!s1CharMap.containsKey(compareChar))
                {
                    if((s2.length()-1-i)<s1.length())return false;

                    compareMap.clear();
                    count = 0;
                    starting = i+1;
                    continue;
                }
                count++;
                compareMap.put(compareChar, 1);
            }
            if(count == s1.length()) return true;
        }
        return false;
    }
}
