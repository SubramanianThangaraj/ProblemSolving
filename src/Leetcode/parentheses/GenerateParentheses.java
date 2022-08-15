/**
 * Problem Link: https://leetcode.com/problems/generate-parentheses
 */
package Leetcode.parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
    //My approach, not an optimized one.
    public List<String> generateParenthesis(int n)
    {
        ArrayList<String> possibilities = new ArrayList<String>();
        ArrayList<String> tempPossibilities = new ArrayList<String>();
        possibilities.add("()");
        for(int i=2; i<=n; i++)
        {

            for(int j=0;j<possibilities.size();j++)
            {
                String currentString = possibilities.get(j);
                for(int k=0; k<currentString.length(); k++)
                {
                    int index = currentString.indexOf("()",k);

                    if(index == -1)break;

                    String temp = currentString.substring(0,index) + "()" +currentString.substring(index);
                    if(!tempPossibilities.contains(temp)) {
                        tempPossibilities.add(temp);
                    }

                    temp = currentString.substring(0, index+1) + "()" +currentString.substring(index+1);
                    if(!tempPossibilities.contains(temp)) {
                        tempPossibilities.add(temp);
                    }
                    k = index + 1;
                }
            }
            possibilities = new ArrayList(tempPossibilities);
            tempPossibilities.clear();
        }
        return possibilities;

    }


    //Optimized approach
    public List<String> generateParenthesisOptimized(int n)
    {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    //Suggestion, just have open and close parameter, Other parameters need not be passed for each method call, which will significantly reduce memory overhang during a large stack of recursive method call.
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
