/**
 * Problem Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * Note :- There is an algorithm named as "Floyd's cycle detection algorithm" Which suits best for detecting
 * loops within an LinkedList. AKA Tortoise-Hare Approach. The working of this approach is as follows,
 * Just let the Tortoise and hare run starting from the same point,
 * Assume that, Hare moves two steps at a time and Tortoise moves one step.
 * If the Hare finishes the race,(By reaching null, "null" marks the end of a linked list) then we can confirm that there is no loop.
 * Else if at any point of time if the tortoise meets the hare again, Then there is a loop.
 *
 *
 * References
 *
 * https://www.youtube.com/watch?v=PvrxZaH_eZ4
 * https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle/
 * https://www.codingninjas.com/blog/2020/09/09/floyds-cycle-detection-algorithm/
 *
 */
package Leetcode.linkedList;

import java.util.ArrayList;

public class LinkedListCycle
{
    public boolean hasCycle(ListNode head)
    {
        ArrayList<ListNode> givenList = new ArrayList<ListNode>();
        while (head != null) {
            //Use Hash based implementation like HashSet, which is best for Value based searching.
            //ArrayList is best for index based searching.
            if (givenList.contains(head)) {
                return true;
            }
            givenList.add(head);
            head = head.next;
        }
        return false;
    }

}
