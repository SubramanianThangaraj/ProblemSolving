/**
 * Problem Link: https://leetcode.com/problems/add-two-numbers/
 */

package Leetcode.linkedList;

public class AddTwoNumbersInLinkedList
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode sumNode = new ListNode();
        ListNode returnNode = sumNode;
        int sum;
        int carry = 0;
        Boolean flag = true;

        if(l1==null&l2==null)return null;
        else if(l1==null)return l2;
        else if(l2==null)return l1;
        else
        {
            sum = l1.val + l2.val;
            if(sum>=10)
            {
                carry = 1;
                sum = sum - 10;
            }
            else
            {
                carry = 0;
            }
            sumNode.val = sum;
            l1=l1.next;l2=l2.next;
        }
        while(l1!=null && l2!=null)
        {
            sum = l1.val + l2.val + carry;
            if(sum>=10)
            {
                carry = 1;
                sum = sum - 10;
            }
            else
            {
                carry = 0;
            }
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
            l1= l1.next;
            l2= l2.next;
        }
        if(l1==null)
        {
            while (l2!=null)
            {
                sum = l2.val + carry;
                if(sum>=10)
                {
                    carry = 1;
                    sum = sum - 10;
                }
                else
                {
                    carry = 0;
                }
                sumNode.next = new ListNode(sum);
                sumNode = sumNode.next;
                l2=l2.next;
            }
        }
        else
        {
            while (l1!=null)
            {
                sum = l1.val + carry;
                if(sum>=10)
                {
                    carry = 1;
                    sum = sum - 10;
                }
                else
                {
                    carry = 0;
                }
                sumNode.next = new ListNode(sum);
                sumNode = sumNode.next;
                l1=l1.next;
            }
        }
        if(carry==1)
        {
            sumNode.next = new ListNode(1);
        }
        return returnNode;
    }
}
