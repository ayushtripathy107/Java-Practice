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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if there are at least k nodes available to reverse
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        // If the number of nodes is less than k, leave them as they are
        if (count < k) {
            return head;
        }
        
        // Step 2: Reverse k nodes
        curr = head;
        ListNode prev = null;
        ListNode nextNode = null;
        for (int i = 0; i < k; i++) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        // Step 3: 'head' is now the tail of the reversed group.
        // Connect it recursively to the next reversed segments.
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }
        
        // 'prev' is the new head of this reversed k-group
        return prev;
    }
}
