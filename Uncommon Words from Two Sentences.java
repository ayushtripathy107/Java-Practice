import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> countMap = new HashMap<>();
        
        // Split and count words from the first sentence
        for (String word : s1.split(" ")) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        
        // Split and count words from the second sentence
        for (String word : s2.split(" ")) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        
        // Collect words that appear exactly once
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Convert the dynamic list to a String array
        return result.toArray(new String[0]);
    }
}
