
// # Recusive Solution -> TLE
class Solution {
    public int minDistance(String s1, String s2) {
        
        return minEdit(s1,s2,s1.length()-1,s2.length()-1);
    }

    public int minEdit(String s1, String s2, int i, int j){

        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(s1.charAt(i)== s2.charAt(j))
            return 0 + minEdit(s1,s2,i-1,j-1);
        
        int insert = 1 + minEdit(s1,s2,i,j-1);
        int delete = 1+ minEdit(s1,s2,i-1,j);
        int replace = 1+ minEdit(s1,s2,i-1,j-1);

        return Math.min(replace , Math.min(insert,delete));
    }
}


// # Memoization
class Solution {
    public int minDistance(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];

        for(int[]a : dp)
            Arrays.fill(a, -1);

        return minEdit(s1,s2,n-1,m-1,dp);
    }

    public int minEdit(String s1, String s2, int i, int j,int[][]dp){

        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i)== s2.charAt(j))
            return 0 + minEdit(s1,s2,i-1,j-1,dp);
        
        int insert = 1 + minEdit(s1,s2,i,j-1,dp);
        int delete = 1+ minEdit(s1,s2,i-1,j,dp);
        int replace = 1+ minEdit(s1,s2,i-1,j-1,dp);

        return dp[i][j] = Math.min(replace , Math.min(insert,delete));
    }
}


// # Tabulation

class Solution {
    public int minDistance(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<)

        
    }
}
