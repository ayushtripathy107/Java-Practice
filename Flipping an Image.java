class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        
        for (int[] row : image) {
            int left = 0;
            int right = n - 1;
            
            while (left <= right) {
                // If elements at left and right are the same, they change value upon inversion
                if (row[left] == row[right]) {
                    int temp = row[left] ^ 1; // XOR with 1 flips 0 to 1 and 1 to 0
                    row[left] = temp;
                    row[right] = temp;
                }
                // If they are different, flipping and inverting cancels out, leaving them unchanged
                
                left++;
                right--;
            }
        }
        
        return image;
    }
}
