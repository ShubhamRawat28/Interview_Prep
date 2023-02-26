
/*
 # Approach --
  
  Their are 2 case 
  1. character at indices are same
  2. character at indices are not same
  
  their are 3 possibilities in the 2 case
  1. i is the part of lcs but not j
  2. i is not the part of lcs but j
  3. i and j both are not the part of lcs
  
  
*/


class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
       
       return lcs(s1,s2,0,0,0);
    }
    
    int lcs(String s1, String s2, int i, int j,int cnt){
        
        if(i >=s1.length() || j >= s2.length())
           return cnt;
           
        int len = cnt;
        
        if(s1.charAt(i) == s2.charAt(j))
            len =lcs(s1,s2,i+1,j+1,cnt+1);
        
        int diff1 = lcs(s1,s2,i+1,j,0);
        int diff2 = lcs(s1,s2,i,j+1,0);
        
        return Math.max(len , Math.max(diff1,diff2));
        
    }
}



TLE
// Memoization using HashMap
class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
       
      Map<String,Integer>dp = new HashMap<>();
     
      return lcs(s1,s2,0,0,0,dp);
    }
    
    int lcs(String s1, String s2, int i, int j,
        int cnt,Map<String,Integer>dp){
        
        if(i >=s1.length() || j >= s2.length())
          return cnt;
          
        String Key = ""+ i+'#'+j+'@'+cnt;
        if(dp.containsKey(Key)) 
            return dp.get(Key);
            
        int len = cnt;
        
        if(s1.charAt(i) == s2.charAt(j))
            len =lcs(s1,s2,i+1,j+1,cnt+1,dp);
        
        int diff1 = lcs(s1,s2,i+1,j,0,dp);
        int diff2 = lcs(s1,s2,i,j+1,0,dp);
        
        int res = Math.max(len , Math.max(diff1,diff2));
        
        dp.put(Key,res);
        return res;
    }
}



// Tabulation
class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
       
        int maxLen = 0;
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return maxLen;
    }
}

