class Solution {
    public int[] countBits(int n) {
        int[] ans =new int[n+1];
        for(int i =0;i<=n;i++){
            ans[i]=ones(i);
        }
        return ans;
    }
    public int ones(int N){
        int count =0;
        while (N != 0){
            if(N%2==1) count++;
            N=N/2;
        }
        return count;
    }
}