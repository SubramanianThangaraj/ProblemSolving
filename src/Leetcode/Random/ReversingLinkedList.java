package Leetcode.Random;

public class ReversingLinkedList
{
    public ListNode reverseList(ListNode head)
    {
        ListNode currentNode = head.next;
        head.next = null;
        ListNode prevNode = head;

        while(currentNode.next!=null)
        {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        currentNode.next = prevNode;
        return currentNode;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
