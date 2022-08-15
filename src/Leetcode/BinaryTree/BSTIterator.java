/**
 * Problem Link: https://binarysearch.com/problems/Binary-Search-Tree-Iterator/
 */

package Leetcode.BinaryTree;


import java.util.TreeSet;

public class BSTIterator
{

    TreeSet<Integer> converted;
    public BSTIterator(Tree root)
    {
        converted =  new TreeSet<Integer>();
        convertGivenTreeToTreeSet(root);

    }

    public int next() {
        return converted.pollFirst();
    }

    public boolean hasnext() {
        return !converted.isEmpty();
    }

    public void convertGivenTreeToTreeSet(Tree node)
    {
        if(node==null)return;
        convertGivenTreeToTreeSet(node.left);
        converted.add(node.val);
        convertGivenTreeToTreeSet(node.right);

    }

    public class Tree
    {
        int val;
        Tree left;
        Tree right;
    }
}
