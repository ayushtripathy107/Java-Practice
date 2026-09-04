import java.util.*;

class Solution {
    public int[] maxvalue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // ans[i] will store the maximum reachable value from index i.
        // Initialize each position with its own value.
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        
        // Monotonic stack to find the next smaller element to the right
        // If we jump right to a smaller element, we can inherit its maximum reachable value.
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = n - 1; i >= 0; i--) {
            // Maintain a strictly increasing stack from top to bottom 
            // to find elements smaller than nums[i]
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            
            // If there is a smaller element to the right, we can jump to it
            if (!stack.isEmpty()) {
                int nextSmallerIndex = stack.peek();
                ans[i] = Math.max(ans[i], ans[nextSmallerIndex]);
            }
            
            stack.push(i);
        }
        
        // Monotonic stack to propagate values back from right to left (Left jumps)
        // Since jumping left requires nums[j] > nums[i], an index 'j' to the left 
        // can reach 'i' if nums[j] > nums[i].
        // This means ans[j] can be updated with ans[i] if nums[j] > nums[i].
        Deque<Integer> leftStack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && nums[leftStack.peek()] < nums[i]) {
                int leftIndex = leftStack.pop();
                ans[leftIndex] = Math.max(ans[leftIndex], ans[i]);
            }
            leftStack.push(i);
        }
        
        // A final pass from right to left ensures all dependent jumps are fully propagated
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = Math.max(ans[i], ans[stack.peek()]);
            }
            stack.push(i);
        }
        
        return ans;
    }
}
