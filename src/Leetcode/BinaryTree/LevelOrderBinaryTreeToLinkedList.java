/**
 * Problem Link: https://binarysearch.com/problems/Level-Order-Binary-Tree-to-Linked-List
 */

package Leetcode.BinaryTree;

import java.util.ArrayList;

public class LevelOrderBinaryTreeToLinkedList
{

    ArrayList<ArrayList<Integer>> levelList;
    public LLNode solve(Tree root)
    {

        levelList = new ArrayList<>();
        LLNode returnNode = new LLNode();
        if(root==null)return returnNode;

        doInOrderTraversal(root, 0);


        LLNode currentNode;
        LLNode prevNode;

        returnNode.val = levelList.get(0).get(0);
        prevNode = returnNode;
        ArrayList<Integer> al;
        for(int i=1; i<levelList.size(); i++)
        {
            al = levelList.get(i);
            for(int value : al)
            {
                currentNode = new LLNode();
                currentNode.val = value;
                prevNode.next = currentNode;
                prevNode = currentNode;
            }
        }

        return returnNode;

    }

    public void doInOrderTraversal(Tree node, int level)
    {
        if(node==null)
        {
            return;
        }
        doInOrderTraversal(node.left, level+1);
        while(levelList.size()<=level)
        {
            levelList.add(new ArrayList<>());
        }
        levelList.get(level).add(node.val);
        doInOrderTraversal(node.right, level+1);
    }


    class LLNode
    {
        int val;
        LLNode next;
    }
    class Tree
    {
        int val;
        Tree left;
        Tree right;
    }

}
