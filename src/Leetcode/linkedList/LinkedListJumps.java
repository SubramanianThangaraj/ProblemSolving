/**
 * Problem Link: https://binarysearch.com/problems/Linked-List-Jumps
 */
package Leetcode.linkedList;


class LLNode {
  int val;
  LLNode next;
}

public class LinkedListJumps
{
    public LLNode solve(LLNode node)
    {
        LLNode returnNode = node;
        outerloop:
        while(node!=null)
        {
            LLNode temp = node;
            int value = node.val;

            for(int i=0; i<value; i++)
            {
                if(temp == null)
                {
                    node.next = null;
                    break outerloop;
                }
                temp = temp.next;
            }
            node.next = temp;
            node = node.next;
        }
        return returnNode;
    }
}
