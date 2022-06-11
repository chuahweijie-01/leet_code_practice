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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        
        ListNode current = head;
        while (current != null)
        {
            stack.push(current);
            current = current.next;
        }
        
        if (head == null || head.next == null || head.next.next == null)
        {
            return;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        
        for(int i = 0; i < stack.size() - 1; i++)
        {
            if (second != null)
            {
                if (second.next == null) break;
                
                ListNode last = stack.pop();
                first.next = last;
                last.next = second;
                stack.peek().next = null;
                first = second;
                second = second.next;
            }
        }
            
    }
}