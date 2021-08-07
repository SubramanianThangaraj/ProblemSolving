/**
 * PROBLEM
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 * EXAMPLE
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 */

package Leetode.August.week1;

import java.util.ArrayList;
import java.util.HashMap;
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

    public HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
    List mainList = new ArrayList();
    ArrayList<Integer> tempList = new ArrayList<Integer>();

    public List<List<Integer>> levelOrder(Node root)
    {
        doTheMath(root, 0);

        for(ArrayList<Integer> al : hm.values())
        {
            mainList.add(al);
        }

        return mainList;
    }

    /**
     * Thought Process
     *
     * Travel from top to bottom (Keep track of Level)
     * Add the value of a node to a list at the specified index of Hashmap (Index is obtained from Level)
     *
     * Don't ever go Line(Level) by Line in Nary tree, It will be a costly process.
     */
    public void doTheMath(Node currentNode, int level)
    {
        if(currentNode != null)
        {
            if(hm.get(level) != null)
            {
                hm.get(level).add(currentNode.val);
            }
            else
            {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(currentNode.val);
                hm.put(level, tempList);
            }
            for(Node node : currentNode.children)
            {
                doTheMath(node, level+1);
            }
        }
    }


}
