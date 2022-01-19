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
    public ListNode detectCycle(ListNode head) {
        if(head==null)
       return null; 
        ListNode back=head;
        ListNode front=head;
        while(front!=null&&front.next!=null)
        {
            front=front.next.next;
            back=back.next;
            if(front==back)
                break;
        }
        
        if(front==null||front.next==null)
        return null;
        
        
        back=head;
       
        
         while(front!=back)
        {
            front=front.next;
            back=back.next;
        }
        return front;
    }
}
/*

   back.  front 
   3 3      3 
   2 0 
   0 2
   -4 -4
   2 0
   0 2 
   public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (!(fast != null && fast.next != null)) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
   
*/