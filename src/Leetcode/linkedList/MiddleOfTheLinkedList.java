/**
 * Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
 */

package Leetcode.linkedList;

public class MiddleOfTheLinkedList
{
    public ListNode middleNode(ListNode head)
    {
        if(head == null || head.next==null) return head;
        if(head.next.next == null)return head.next;
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer.next != null && fastPointer.next.next != null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (fastPointer.next != null)return slowPointer.next;

        return slowPointer;
    }
}
