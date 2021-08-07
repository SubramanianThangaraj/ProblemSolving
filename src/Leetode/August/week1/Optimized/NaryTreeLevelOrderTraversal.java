/**
 * PROBLEM
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 * EXAMPLE
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * LINK - https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3871/
 */
package Leetode.August.week1.Optimized;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal
{
    //Definition of Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<List<Integer>> mainList = new ArrayList();

    public List<List<Integer>> levelOrder(Node root)
    {
        doTheMath(root, 0);
        return mainList;
    }

    public void doTheMath(Node currentNode, int level)
    {
        if(currentNode != null)
        {
            if(mainList.size() <= level)
            {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(currentNode.val);
                mainList.add(level, tempList);
            }
            else
            {
                mainList.get(level).add(currentNode.val);
            }
            for(Node node : currentNode.children)
            {
                doTheMath(node, level+1);
            }
        }
    }
}
