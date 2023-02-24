/*
 Rules of Recurence
1. Express everything in term of index
2. Explore possibility on that index
3. Take the best among of them
*/

// Recurence Solution -> TLE
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      
       Brute force will not hold good because 
       that have an exponatial time complexity 
       due to recursion.
      
       return lcs(text1 , text2, text1.length()-1 ,
       text2.length()-1 );
    }
    public int lcs(String text1, String text2 ,int idx1 , int idx2){
        if(idx1 < 0 || idx2 < 0)
            return 0;
        if(text1.charAt(idx1) == text2.charAt(idx2))
            return 1 + lcs(text1, text2 ,idx1-1 , idx2-1);
        return  Math.max(lcs(text1, text2,idx1-1,idx2),
        lcs(text1, text2,idx1,idx2-1));
    }
}


// Memoization
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
       
       int n = s1.length() , m = s2.length();
       int[][]dp = new int[n][m];

       for(int[]a: dp)
          Arrays.fill(a, -1);
       return lcs(s1 ,s2, n-1 ,m-1, dp);

    }
    public int lcs(String s1, String s2 ,int i, 
        int j,int[][]dp){

        if(i < 0 || j < 0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + lcs(s1, s2 ,i-1 ,j-1,dp);
        return dp[i][j] = Math.max(lcs(s1,s2,i-1,j,dp),
        lcs(s1,s2,i,j-1,dp));
    }
}


// Tabulation
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}


