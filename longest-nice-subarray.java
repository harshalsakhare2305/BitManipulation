//https://leetcode.com/problems/longest-nice-subarray/ 

// all the digits have unique bit set at diffrent position means if we do or then each set bit in or with represent a single number only means if we do OR & nums[right]==0 then our new number follow our condition 
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

    public int longestNiceSubarray(int[] nums) {
        int or =0;
        int n=nums.length;
        int left=0;
        int right=1;
        int maxlen =1;
        int[] bits =new int[32];
        ORele(bits,0,nums);
        while(right<n){
            or=calcOR(bits);
          while(( or & nums[right])!=0){
            deOR(left,nums,bits);
            or=calcOR(bits);
            left++;
          }
        ORele(bits,right,nums);
          maxlen=Math.max(maxlen,right-left+1);
          right++;

        }

        return maxlen;

    }
}
