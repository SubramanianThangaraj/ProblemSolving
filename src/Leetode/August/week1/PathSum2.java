package Leetode.August.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * PROBLEM
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * A leaf is a node with no children.
 *
 * EXAMPLE
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 */



public class PathSum2
{
    public int totalSum = 0;
    public int targetSum;
    public Stack<Integer> path = new Stack<Integer>();
    public List returnList = new ArrayList<>();


     // This is the structure of TreeNode
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        this.targetSum = targetSum;
        doTheMath(root);
        return returnList;

    }


    public Boolean doTheMath(TreeNode root)
    {

        if(root == null)
        {
            return true;
        }
        totalSum = totalSum + root.val;
        path.push(root.val);

        Boolean left = doTheMath(root.left);
        Boolean right = doTheMath(root.right);

        if (left && right)
        {
            if(totalSum == targetSum)
            {
                returnList.add(path.clone());
            }
        }

        totalSum = totalSum - path.pop();

        return false;
    }
}
