/**
 * Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

package Leetcode.BinaryTree;


import java.util.ArrayList;
import java.util.List;
import Leetcode.TreeNode;

public class BinaryTreeLevelOrderTraversal
{
    List<List<Integer>> levelOrder;

    public List<List<Integer>> levelOrder(TreeNode root)
    {
        levelOrder = new ArrayList<>();
        if(root==null)return levelOrder;

        doLevelOrderTraversal(root, 0);

        return levelOrder;
    }

    public void doLevelOrderTraversal(TreeNode node, int level)
    {
        if(level >= levelOrder.size())levelOrder.add(new ArrayList<Integer>());
        levelOrder.get(level).add(node.val);

        level++;

        if(node.left!=null)doLevelOrderTraversal(node.left, level);
        if(node.right!=null)doLevelOrderTraversal(node.right, level);

    }
}
