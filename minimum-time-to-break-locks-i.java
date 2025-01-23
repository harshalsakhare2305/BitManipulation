//https://leetcode.com/problems/minimum-time-to-break-locks-i/?envType=problem-list-v2&envId=bit-manipulation

// Here state idx => number of locked we have broken 
   // mask => which postion lock has previouly broken 
     // x => by what factor sword strength increses every minute 


class Solution {
    int[][][] dp;

    public int helper(int idx, int mask, int x, int k, List<Integer> strength) {
        if (idx == strength.size()) return 0;

        if (dp[idx][mask][x] != -1) return dp[idx][mask][x];
        int mintime = Integer.MAX_VALUE;
        for (int j = 0; j < strength.size(); j++) {
            boolean flag = (mask & (1 << j)) != 0; //Checking if jth lock is broken or not
            int temp = Integer.MAX_VALUE;
            if (!flag) {  //if lock is not broken then break it
                int time = (int) Math.ceil((double) strength.get(j) / x);  //Time needed to break the jth lock 
                  //Recursion call and setting the jth bit means jth lock has broken
                temp = time + helper(idx + 1, (mask | (1 << j)), x + k,k, strength);  
               
            }

            mintime = Math.min(mintime, temp);
        }

        return dp[idx][mask][x] = mintime;
    }
   // why maximum value of  x is 80  => our x increses after locked broken then maximum values of x will be at time of lock lock was left means n-1 locked were broken so (n-1)*k+1 

   // (8-1)*10 ==70+1 ==71 
    public int findMinimumTime(List<Integer> strength, int k) {
        dp = new int[9][(1 << 8) + 1][80];
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return helper(0, 0, 1, k, strength);
    }
}


// ---------------------------------------STATE OPTIMIZATION---------------------------------------------------


//Since the mask is keeping track of bit set at perticular positin  i (0 to n) .If the number of set bit equaal to number of locks  then we will acheive our base condition . we there is not need to have extraa state named as index

class Solution {
    int[][] dp;

    public int helper(int mask, int x, int k, List<Integer> strength) {
        if (Integer.bitCount(mask) == strength.size()) return 0;

        if (dp[mask][x] != -1) return dp[mask][x];
        int mintime = Integer.MAX_VALUE;
        for (int j = 0; j < strength.size(); j++) {
            boolean flag = (mask & (1 << j)) != 0;
            int temp = Integer.MAX_VALUE;
            if (!flag) {
                int time = (int) Math.ceil((double) strength.get(j) / x);
                temp = time + helper((mask | (1 << j)), x + k,k, strength);
            }

            mintime = Math.min(mintime, temp);
        }

        return dp[mask][x] = mintime;
    }

    public int findMinimumTime(List<Integer> strength, int k) {
        dp = new int[(1 << 8) + 1][80];
       
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
        

        return helper(0, 1, k, strength);
    }
}
