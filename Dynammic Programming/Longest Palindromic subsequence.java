
class Solution {
    public int longestPalindromeSubseq(String s) {
        
        return helper(s, 0 , s.length()-1);
    }
    public int helper(String s, int start , int end){

        if(start == end) 
            return 1;
        if(start > end)
            return 0;
        return s.charAt(start) == s.charAt(end)? 2 + helper(s,start+1,end-1)
          : Math.max(helper(s,start+1,end),helper(s,start,end-1));
    }
}


// Memoization

class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();
        int[][]dp = new int[n][n];
        for(int[]a : dp)
           Arrays.fill(a, -1);
        return helper(s, 0 , n-1, dp);
    }
    public int helper(String s, int start , int end, int[][]dp){

        if(start == end) 
            return 1;
        if(start > end)
            return 0;
        if(dp[start][end] != -1)
            return dp[start][end];
        return dp[start][end] = s.charAt(start) == s.charAt(end)? 
          2 + helper(s,start+1,end-1,dp)
          : Math.max(helper(s,start+1,end,dp),helper(s,start,end-1,dp));
    }
}
