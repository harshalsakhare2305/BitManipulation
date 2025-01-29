
//https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k/
class Solution {
    public static void ORele(int[] bits, int idx, int[] nums) {
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

    public int calcOR(int[] bits) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > 0) {
                num |= (1 << i);
            }
        }
        return num;
    }

    public int minimumDifference(int[] nums, int k) {
        int or = 0;
        int left = 0, right = 0;
        int mindiff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            min = Math.min(min, i);
        }

        if (k <= min) return Math.abs(k - min);

        int[] bits = new int[32];

        while (right < nums.length) {
            ORele(bits, right, nums);
            or = calcOR(bits);

            int diff = Math.abs(k - or);
            mindiff = Math.min(mindiff, diff);

            while (or > k && diff >= mindiff && left <= right) {
                deOR(left, nums, bits);
                or = calcOR(bits);
                diff = Math.abs(k - or);
                mindiff = Math.min(mindiff, diff);
                left++;
            }

            mindiff = Math.min(mindiff, diff);
            right++;
        }

        return mindiff;
    }
}
