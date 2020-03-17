package DP;
/**总结
dp是自底向上，是一个逆推的过程，由多个小问题组合成一个大问题，
最终根据递推公式算出最终解。
（dfs）搜索是自顶向下，由大问题分解为多个类似的小问题，依次求解出小问题，
最终回溯，从而将大问题求解出来。
**/

//动态规划思维,记忆每个最佳子结构。
//最终状态: DP(m-1,n-1)
// DP(i,j) = DP(i-1,j) + DP(i,j-i), 0<=i<m, 0<=j<n; //由客观条件得来
//           上边 + 左边
//case: 已知条件 客观的已知条件。
class Q62Solution { //??
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        // dp[0][0] = 1;
        // dp[0][*] = 1;
        // dp[*][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if(i==0 || j==0) {dp[i][j] = 1; continue;}
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    public int 等价的更清晰的逻辑_uniquePaths(int m, int n) {
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++)
			result[i][0] = 1;
		for (int j = 0; j < n; j++)
			result[0][j] = 1;

		for (int i = 1; i < m; i++) // from i=1
			for (int j = 1; j < n; j++) {// from j=1
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		return result[m - 1][n - 1];
}
public int 等价的递归_uniquePaths(int m, int n) {
    if (m == 1 || n == 1)
        return 1;
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
}

}

//递归思想，暴力从下往上推,类似DFS //计算机思维
//状态: (0,0) -> (M,N) 的路径数， 最终求 DP(0,0)
// DP(i,j) = DP(i+1,j) + DP(i,j+i), 0<=i<m, 0<=j<n; //右边 + 下边
//case: 已知条件 : 假设dp(m-1,n-1)=1倒推
class Q62Solution2 {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        // dp[m-1][*] = 1;
        // dp[*][n-1] = 1;
        for (int i = m-1; i >=0; --i) {
            for (int j = n-1; j >=0; --j) {
                if(i==m-1 || j==n-1) {dp[i][j] = 1; continue;}
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}