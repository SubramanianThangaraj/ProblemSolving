/**
 * Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * This can also be done using "Floyd's cycle detection algorithm"
 * which is the best approach when compared to the below logic.
 */
package Leetcode.linkedList;

import java.util.ArrayList;

public class LinkedListCycle2
{
    public ListNode hasCycle(ListNode head)
    {
        ArrayList<ListNode> givenList = new ArrayList<ListNode>();
        while (head != null)
        {
            if (givenList.contains(head))
            {
                return givenList.get(givenList.indexOf(head));
            }
            givenList.add(head);
            head = head.next;
        }
        return null;
    }
}
