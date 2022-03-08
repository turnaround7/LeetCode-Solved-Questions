/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode temp=head;
        ListNode forward=head.next;
        while(temp!=null&&forward!=null&&forward.next!=null&&temp!=forward)
        {
            temp=temp.next;
            forward=forward.next.next;
        }
        if(temp==forward)
            return true;
        return false;
    }
}