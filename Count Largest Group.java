class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[40];
        int max = 0;
        int ans = 0;
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            
            count[sum]++;
            if (count[sum] > max) {
                max = count[sum];
                ans = 1;
            } else if (count[sum] == max) {
                ans++;
            }
        }
        
        return ans;
    }
}
