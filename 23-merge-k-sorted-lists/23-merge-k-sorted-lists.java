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
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge=null;
        ListNode follow=merge;
       while(l1!=null&&l2!=null)
       {
          if(l1.val<=l2.val)
          {
              if(merge==null)
              {
                  merge=l1;
                  follow=merge;
                 
              }
              else
              {
                  follow.next=l1;
                  follow=follow.next;
              }
               l1=l1.next;
          }
          else
          {
              if(merge==null)
              {
                  merge=l2;
                  follow=merge;
                 
              }
              else
              {
                  follow.next=l2;
                  follow=follow.next;
              }
               l2=l2.next;  
          
       }
       }
       if(l1==null&&l2==null)
       return merge;
       if(l1==null)
       {
           if(merge==null)
           merge=l2;
           else
           follow.next=l2;
       }
       if(l2==null)
       {
           if(merge==null)
           merge=l1;
           else
           follow.next=l1;
       }
       return merge;
        
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
       return null;
       if(lists.length==1)
       return lists[0];
       
       ListNode first=lists[0];
       for(int i=1;i<lists.length;i++)
       {
           ListNode second=lists[i];
           first=mergeTwoLists(first,second);
       }
       return first;
        
    }
}