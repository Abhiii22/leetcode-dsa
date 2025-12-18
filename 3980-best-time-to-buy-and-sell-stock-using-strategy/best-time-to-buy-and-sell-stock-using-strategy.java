class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long originalProfit = 0;

        // 1. Calculate the initial profit with the provided strategy
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }

        int halfK = k / 2;
        long currentChange = 0;

        // 2. Calculate the change for the first window [0, k-1]
        // First half (0 to halfK-1) becomes 0
        // Second half (halfK to k-1) becomes 1
        for (int i = 0; i < k; i++) {
            int targetStrategy = (i < halfK) ? 0 : 1;
            currentChange += (long) (targetStrategy - strategy[i]) * prices[i];
        }

        long maxChange = currentChange;

        // 3. Slide the window across the arrays
        for (int i = 1; i <= n - k; i++) {
            // Index that just left the window (was at the start of the '0' zone)
            int leftIdx = i - 1;
            currentChange -= (long) (0 - strategy[leftIdx]) * prices[leftIdx];

            // Index that moves from '1' zone to '0' zone
            int midIdx = i + halfK - 1;
            // Remove its old '1' modification and add its new '0' modification
            currentChange -= (long) (1 - strategy[midIdx]) * prices[midIdx];
            currentChange += (long) (0 - strategy[midIdx]) * prices[midIdx];

            // Index that just entered the window (at the end of the '1' zone)
            int rightIdx = i + k - 1;
            currentChange += (long) (1 - strategy[rightIdx]) * prices[rightIdx];

            maxChange = Math.max(maxChange, currentChange);
        }

        // Return the best profit found (original or modified)
        return originalProfit + Math.max(0, maxChange);
    }
}