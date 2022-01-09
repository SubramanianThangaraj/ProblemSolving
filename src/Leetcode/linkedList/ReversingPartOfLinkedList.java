package Leetcode.linkedList;

/**
 * Problem Link - https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReversingPartOfLinkedList
{
    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        if(left==right || head==null) return head;
        ListNode currentNode = head;
        ListNode maintainPrevious = head;
        ListNode prevNode = null;
        int diff = right-left;
        int count = 1;
        while (currentNode.next!=null)
        {

            if(count == left)
            {
                ListNode leftNode = currentNode;
                for(int i=1; i<=diff+1;i++)
                {
                    leftNode = leftNode.next;
                }
                prevNode = leftNode;
                for(int i=1;i<=diff+1; i++)
                {
                    ListNode nextNode = currentNode.next;
                    currentNode.next = prevNode;
                    prevNode = currentNode;
                    currentNode = nextNode;
                }
                if(left==1)return prevNode;
                maintainPrevious.next = prevNode;
                break;
            }
            maintainPrevious = currentNode;
            currentNode = currentNode.next;

            count++;
        }
        return head;

    }
}
