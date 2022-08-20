/**
 * Problem Link: https://leetcode.com/problems/unique-binary-search-trees
 *
 * NOTE - The below code will calculate the combinations for n-1,n-2...1 before finding the number of combinations for n.
 * i.e, In order to find the combination for a tree of length n, The combination for n-1 should be known,
 * and to find the combination of n-1, combination of n-2 should be known and So on.
 *
 * Thought Process :
 *
 * Consider n=4 (The numbers will be 1,2,3,4)
 * We have to calculate the possible way of arrangements, while having each number at the base node.
 * Ex: When 1 is the base node, There will be no numbers on the left side of the node(0)
 * and on the right side there will be three numbers (2,3,4)
 * So the number of combinations that can be achieved by placing 1 at base node is,
 * number of combinations when n=0 (left) multiplied by number of combinations when n=3 (right)
 *
 * Similarly, When 2 is the base node, There will be one number on the left side (1)
 * and two numbers on the right side (3,4)
 * So the number of combinations that can be achieved by placing 2 at base node is,
 * number of combinations when n=1 (left) multiplied by number of combinations when n=2 (right)
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
