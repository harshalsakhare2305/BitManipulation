//https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
class Solution {
    public int minFlips(int a, int b, int c) {
        int or = (a | b);
        int xor = ( or ^ c );
        int count =0 ;
        if(xor==0)return 0;
        for(int i=0;i<32;i++){
            int bit = (xor & 1);
            if(bit==1){
                int bitC = (c & 1);
                if(bitC==1){
                    count+=1;
                }else if(bitC==0){
                    int bitA= (a & (1<<i));
                    int bitB=( b & (1<<i));
                    if(bitA!=0)count++;
                     if(bitB!=0)count++;
                }
            }

            xor>>=1;
            c>>=1;
        }

        return count;
    }
}
