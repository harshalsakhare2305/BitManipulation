class Solution {
    public void addele(int[] bits, int idx, int[] nums) {
        int ele = nums[idx];
        for (int i = 0; i < 32; i++) {
            int bit = (ele & 1);
            if (bit == 1) {
                bits[i]++;
            }
            ele >>= 1;
        }
    }

    public void deOR(int idx, int[] nums, int[] bits) {
        int ele = nums[idx];
        for (int i = 0; i < 32; i++) {
            int bit = (ele & 1);
            if (bit == 1 && bits[i] > 0) {
                bits[i]--;
            }
            ele >>= 1;
        }
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int left = 0;
        int right = 0;
        int mini = Integer.MAX_VALUE; // Minimum subarray length
        int or = 0; // Current OR value

        while (right < nums.length) {
            // Add element at 'right' to the OR calculation
            addele(bits, right, nums);
            or |= nums[right];

            // Shrink the window while OR >= k
            while (or >= k && left <= right) {
                mini = Math.min(mini, right - left + 1);

                // Remove the left element
                deOR(left, nums, bits);
                left++;

                // Recalculate OR after removing the left element
                or = calcOR(bits);
            }

            // Expand the window
            right++;
        }

        return mini == Integer.MAX_VALUE ? -1 : mini; // Return -1 if no valid subarray found
    }

    public int calcOR(int[] bits) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }
}
