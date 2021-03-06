package DP;
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/***
1029. Two City Scheduling
There are 2N people a company is planning to interview.
The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
***/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0];
        }
        return cost;
    }
}
class Solution2 { //Solution1 = Solution2
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++)
        {
            cost += costs[i][1] + costs[costs.length - i - 1][0];
        }
        return cost;
    }
}

public class Q1029_Two_City_Scheduling{ //test case
    public static void main(String[] args) {
    int array[][] = {{10,20},{30,200},{400,50},{30,20}};
    System.out.print(new Solution2().twoCitySchedCost(array));
    }
}