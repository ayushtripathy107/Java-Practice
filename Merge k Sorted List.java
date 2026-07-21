import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge cases
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialize Min-Heap based on the node's value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Push the head of each non-empty list into the heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        
        // Dummy head to simplify building the final list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process nodes until the heap is empty
        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            current.next = smallestNode;
            current = current.next;
            
            // If there is a next node in the current list, add it to the heap
            if (smallestNode.next != null) {
                pq.add(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}
