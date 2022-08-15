/**
 * Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
 */

package Leetcode.BinaryTree;

import Leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class ValidateBinarySearchTree
{
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    public boolean validateBST(TreeNode rootNode, Integer low, Integer high)
    {
        if(rootNode==null)
        {
            return true;
        }

        if( (low!=null && rootNode.val<=low) || (high!=null && rootNode.val >= high) )
        {
            return false;
        }
        return validateBST(rootNode.right, rootNode.val, high) && validateBST(rootNode.left, low, rootNode.val);
    }
}
