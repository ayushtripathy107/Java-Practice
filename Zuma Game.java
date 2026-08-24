import java.util.*;

class Solution {
    public int findMinStep(String board, String hand) {
        // Sort hand to normalize the state for memoization
        char[] handChars = hand.toCharArray();
        Arrays.sort(handChars);
        String sortedHand = new String(handChars);
        
        // Queue stores states as an array: [current_board, current_hand]
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{board, sortedHand});
        
        // Track visited states to prevent cycles and duplicate work
        Set<String> visited = new HashSet<>();
        visited.add(board + "#" + sortedHand);
        
        int steps = 0;
        int originalHandLength = hand.length();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String[] curr = queue.poll();
                String currBoard = curr[0];
                String currHand = curr[1];
                
                // If the board is successfully cleared, return steps used
                if (currBoard.isEmpty()) {
                    return steps;
                }
                
                // Try inserting every available ball from hand into every position on the board
                for (int j = 0; j < currHand.length(); j++) {
                    // Skip duplicate consecutive balls in hand to prune search branch
                    if (j > 0 && currHand.charAt(j) == currHand.charAt(j - 1)) {
                        continue;
                    }
                    
                    char ball = currHand.charAt(j);
                    String nextHand = currHand.substring(0, j) + currHand.substring(j + 1);
                    
                    for (int k = 0; k <= currBoard.length(); k++) {
                        // Optimization: Only insert if it matches the neighbor to form a potential group
                        // or at the boundaries if necessary
                        if (k < currBoard.length() && currBoard.charAt(k) == ball) {
                            // Valid insertion placement optimization
                        } else if (k > 0 && currBoard.charAt(k - 1) == ball) {
                            // Valid insertion placement optimization
                        } else if (k > 0 && k < currBoard.length() && currBoard.charAt(k - 1) == currBoard.charAt(k)) {
                            // Inserting between two identical balls to potentially trigger a chain reaction later
                        } else {
                            continue;
                        }
                        
                        String newBoard = currBoard.substring(0, k) + ball + currBoard.substring(k);
                        newBoard = removeConsecutive(newBoard);
                        
                        String stateKey = newBoard + "#" + nextHand;
                        if (!visited.contains(stateKey)) {
                            visited.add(stateKey);
                            queue.offer(new String[]{newBoard, nextHand});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    // Helper method to eliminate groups of 3 or more consecutive identical balls
    private String removeConsecutive(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }
            // If group size is 3 or more, remove it and re-evaluate from the beginning
            if (j - i >= 3) {
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            }
            i = j;
        }
        return board;
    }
}
