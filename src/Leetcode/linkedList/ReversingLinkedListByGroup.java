/**
 * Problem Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
package Leetcode.linkedList;

public class ReversingLinkedListByGroup
{
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode toReverse = head;
        ListNode toFindDepth = head;
        ListNode reversedNode = null;
        ListNode preserveNode = null;

        int i=0;
        while (toFindDepth!=null)
        {
            toFindDepth = toFindDepth.next;
            i++;
            if(i==k)
            {
                i=0;
                ListNode prevNode = null;
                ListNode nextNode;
                for(int j=0; j<k; j++)
                {
                    nextNode = toReverse.next;
                    toReverse.next = prevNode;
                    prevNode = toReverse;
                    toReverse = nextNode;
                }

                if(reversedNode==null)
                {
                    reversedNode = prevNode;
                    preserveNode = reversedNode;
                }
                else
                    reversedNode.next = prevNode;
            }
            while(reversedNode!=null && reversedNode.next!=null)
            {
                reversedNode = reversedNode.next;
            }
        }


        //To attach the end Uneven part with the final reversed part
        if(reversedNode.next!=null)
        {
            reversedNode = reversedNode.next;
        }

        if(i==0)
            return preserveNode;
        else
        {
            reversedNode.next = toReverse;
            return preserveNode;
        }


    }

}
