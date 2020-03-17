package DP;
/**
 * {10,9,2,5,3,7,101,18}

   状态: 0 ->i, lenN = dp[i]
   方程： dp(i,j) = arr[i] j+=1
    结果：max(dp[0],dp[1]....dp[N-1])
 */
class Q_300_Solution {
    public int lengthOfLIS(int[] nums) {
        return 0;
    }
}

public class Q300_subsequence{
    public static void main(String[] args) {
        int [] arr = {10,9,2,5,3,7,101,18};
        int sum = new Q_300_Solution().lengthOfLIS(arr);
        System.out.print(sum);
    }
}