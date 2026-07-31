class Solution {
    public String simplifyPath(String path) {
        java.util.Deque<String> stack = new java.util.ArrayDeque<>();
        String[] parts = path.split("/");
        
        for (String p : parts) {
            if (p.equals("..")) {
                stack.pollLast();
            } else if (!p.equals("") && !p.equals(".")) {
                stack.addLast(p);
            }
        }
        
        return "/" + String.join("/", stack);
    }
}
