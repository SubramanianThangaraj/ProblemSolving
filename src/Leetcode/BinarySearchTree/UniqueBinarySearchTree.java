/**
 * Problem Link: https://leetcode.com/problems/unique-binary-search-trees
 *
 * NOTE - The below code will calculate the combinations for n-1,n-2...1 before finding the number of combinations for n.
 * i.e, In order to find the combination for a tree of length n, The combination for n-1 should be known,
 * and to find the combination of n-1, combination of n-2 should be known and So on.
 */

package Leetcode.BinarySearchTree;

import java.util.HashMap;

public class UniqueBinarySearchTree
{
    public int numTrees(int n)
    {
        int[] combinations = new int[n+1];
        combinations[0] = 1;
        int totalCombination = 0;
        for(int i=1; i<=n; i++)
        {
            int left = 0;
            int right = i-1;
            for(left=0; left<i; left++,right--)
                totalCombination = totalCombination + (combinations[left]*combinations[right]);
            combinations[i] = totalCombination;
            totalCombination = 0;
        }
        return combinations[n];
    }
}
