import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    // A simple key-value pair node for separate chaining
    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Using a prime size to distribute hash codes evenly
    private final int BUCKET_SIZE = 10007;
    private List<Node>[] buckets;

    public MyHashMap() {
        buckets = new ArrayList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }
    
    // Hash function to map key to an index
    private int getHash(int key) {
        return key % BUCKET_SIZE;
    }

    public void put(int key, int value) {
        int index = getHash(key);
        List<Node> bucket = buckets[index];
        
        // If key already exists, update its value
        for (Node node : bucket) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        // If key does not exist, add a new node
        bucket.add(new Node(key, value));
    }

    public int get(int key) {
        int index = getHash(key);
        List<Node> bucket = buckets[index];
        
        // Search through the bucket for the key
        for (Node node : bucket) {
            if (node.key == key) {
                return node.value;
            }
        }
        // Return -1 if the key mapping does not exist
        return -1;
    }

    public void remove(int key) {
        int index = getHash(key);
        List<Node> bucket = buckets[index];
        
        // Find and remove the node if it matches the key
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).key == key) {
                bucket.remove(i);
                return;
            }
        }
    }
}
