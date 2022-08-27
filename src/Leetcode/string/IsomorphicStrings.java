/**
 * Problem Link: https://leetcode.com/problems/isomorphic-strings/
 */

package Leetcode.string;

import java.util.Hashtable;

public class IsomorphicStrings
{
    public boolean isIsomorphic(String s, String t)
    {
        if(s.length() != t.length())return false;
        Hashtable<Character, Character> mappings = new Hashtable<Character, Character>();
        for(int i = 0; i< s.length(); i++)
        {
            if(s.charAt(i) == t.charAt(i))
            {
                if(mappings.containsKey(s.charAt(i)))
                {
                    if(mappings.get(s.charAt(i))== t.charAt(i))
                    {
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(mappings.contains(t.charAt(i)))
                {
                    return false;
                }
                mappings.put(s.charAt(i), t.charAt(i));
            }
            else
            {
                if(mappings.containsKey(s.charAt(i)))
                {
                    if(mappings.get(s.charAt(i))== t.charAt(i))
                    {
                        continue;
                    }
                    else
                    {
                        return false;
                    }
                }
                else if(mappings.contains(t.charAt(i)))
                {
                    return false;
                }
                else
                {
                    mappings.put(s.charAt(i), t.charAt(i));
                }
            }
        }
        return true;
    }
}
