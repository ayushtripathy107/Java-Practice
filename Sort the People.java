import java.util.Collections;
import java.util.TreeMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create a TreeMap that sorts keys in descending order
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        
        // Map each height to the corresponding name
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        
        // Populate the result array from the sorted map values
        String[] result = new String[names.length];
        int index = 0;
        for (String name : map.values()) {
            result[index++] = name;
        }
        
        return result;
    }
}
