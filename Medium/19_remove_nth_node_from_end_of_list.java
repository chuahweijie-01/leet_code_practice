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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return head.next;
        
        ListNode walk = head;
        ListNode result = head;
        
        int length = 0;
        
        while (walk.next != null)
        {
            walk = walk.next;
            length = length + 1;
        }
        
        int target = length - n + 1;
        
        if (target == 0)
            return head.next;
        
        while (target > 1)
        {
            result = result.next;
            target = target - 1;
        }
        
        result.next = result.next.next;
        
        return head;
        
    }
}