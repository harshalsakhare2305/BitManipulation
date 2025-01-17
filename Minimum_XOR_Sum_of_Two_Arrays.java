//https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/
import java.util.*;
class Solution {
   int[][]dp;
    public int helper(int idx,int mask,int[] nums1,int[]nums2){
       if(idx==nums1.length)return 0;
       int ans=Integer.MAX_VALUE/2;
       if(dp[idx][mask]!=-1)return dp[idx][mask];
       
       for(int i=0;i<nums2.length;i++){
         if( ( mask & (1<<i))==0){
                ans=Math.min(ans,(nums1[idx]^nums2[i])+helper(idx+1,(mask | (1<<i)),nums1,nums2));
         }
       }

       return dp[idx][mask]=ans;
    }
    public int minimumXORSum(int[] nums1, int[] nums2) {
        
        dp=new int[15][20000];
        for(int i=0;i<=14;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(0,0,nums1,nums2);
    }
}
