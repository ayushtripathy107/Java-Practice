import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        // If the endWord is not in the dictionary, no valid sequence exists
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        // Tracks the number of words in the sequence
        int level = 1; 
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                // If destination reached, return current path length
                if (currentWord.equals(endWord)) {
                    return level;
                }
                
                // Find all valid next words by changing one character at a time
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        wordChars[j] = c;
                        String newWord = String.valueOf(wordChars);
                        
                        // If it's a valid unvisited word, add to queue and remove from set
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Prevents re-visiting
                        }
                    }
                    // Restore character for the next position loop
                    wordChars[j] = originalChar;
                }
            }
            level++;
        }
        
        return 0;
    }
}
