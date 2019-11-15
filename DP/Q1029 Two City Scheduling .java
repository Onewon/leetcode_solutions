// 1029. Two City Scheduling
// There are 2N people a company is planning to interview.
// The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
//
// Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
//

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]); //快速选择算法
            }
        });
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0]; //一指针实现i和j靠近写法
        }
        return cost;
    }
}
//上边=下边
class Solution {
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