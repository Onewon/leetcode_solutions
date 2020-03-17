package DP;


/**
 * 三角形路径 [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 =
 * 11）。
 *
 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
 **/
// DP: for p in tri[-1]: the sum of p(x,y) -> (0,0)
// Final: DP(0,0)
// mixSum = ms(x,y) = (x,y) + min((x+1,y),(x+1,y+1))

class Q_120_Solution{
    public int minimumTotal(int[][] triangle) { //real DP
        int r = triangle.length;
        int c = triangle[r-1].length; //c=r
        int [][] dp= new int[r][c];
        // dp[r-1][*] = self;
        for (int i = 0; i < c; i++) {
            dp[r-1][i] = triangle[r-1][i];
        } //equal to dp[r-1] = triangle[r-1]
        for (int i = r-2; i >=0; --i) {
            for (int j = 0; j <=i; j++) {
                dp[i][j] = triangle[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}

class Q_120_Solution1 { //DFS O(2^n) not Greedy and not all traverse
    public int minimumTotal(int[][] triangle) {
        if(triangle==null) return 0;
        if(triangle.length==1){
            if(triangle[0].length==1){
                return triangle[0][0];
            }
        }
        return miniTotal(triangle,0,0);
    }
    public int miniTotal(int[][] triangle,int x,int y) {
        if(x==triangle.length-2){
            int a = triangle[x+1][y];
            int b = triangle[x+1][y+1];
            return triangle[x][y]+Math.min(a,b);
        }
        return  triangle[x][y]+Math.min(miniTotal(triangle,x+1,y),miniTotal(triangle,x+1,y+1));
    }
}
public class Q120_Triangel{
    public static void main(String[] args) {
        // int[][] angel ={{2},{3,4},{6,5,7},{4,1,8,3}};
        int[][] angel ={{2},{3,2},{6,5,2},{4,1,100,101}};
        // int[][] angel ={{-10}};
        int sum = new Q_120_Solution().minimumTotal(angel);
        System.out.print(sum);
    }
}