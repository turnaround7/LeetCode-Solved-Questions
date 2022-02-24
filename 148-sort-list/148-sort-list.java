/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; 
      
        ListNode slow = head, fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
       
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        ListNode headHolder = new ListNode();
        ListNode curNode = headHolder;
        
        while(left != null && right != null){
            if(left.val < right.val){
                curNode.next = new ListNode(left.val);
                left = left.next;
            } else{
                curNode.next = new ListNode(right.val);
                right = right.next;
            }
            curNode = curNode.next;
        }
        
        if(left != null) curNode.next = left;
        if(right != null) curNode.next = right;
        
        return headHolder.next;
    }
}