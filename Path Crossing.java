import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        
        // Start at the origin
        int x = 0;
        int y = 0;
        visited.add(x + "," + y);
        
        // Traverse each movement in the path
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            
            // Generate a unique key for the current position
            String currentPos = x + "," + y;
            
            // If the position has been visited before, the path crosses itself
            if (visited.contains(currentPos)) {
                return true;
            }
            
            visited.add(currentPos);
        }
        
        return false;
    }
}
