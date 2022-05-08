package weekly_competition.W_292.LT_6059_hasValidPath;
/*提示 1
用一个变量 cc 表示括号字符串的平衡度：遇到左括号就 +1，遇到右括号就 −1。那么合法字符串等价于任意时刻c≥0 且最后 c=0。

提示 2
0≤c<m+n

提示 3
把进入格子前的 c 值当作格子的附加状态，那么一个格子至多有 m+n 种不同的状态，整个网格图至多有 mn(m+n) 个不同的状态。

提示 4
在这些状态上 DFS：

起点为 (0,0,0)，表示从左上角 (0,0) 出发，初始 c=0；
终点为 (m−1,n−1,1)，表示到右下角 (m−1,n−1) 结束，且进入前 c=1（因为右下角必须为右括号）；
根据当前格子的字符计算 c 值，然后往下或往右移动，继续 DFS。
为了不重复访问同一个状态，需要用一个 vis 数组标记访问过的状态。

时间复杂度：O(mn(m+n))，每个状态至多访问一次。
空间复杂度：O(mn(m+n))，需要记录每个状态是否被访问过。
*/
public class Solution {
    int m, n;
    char[][] grid;
    boolean[][][] vis;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false; // 剪枝
        this.grid = grid;
        vis = new boolean[m][n][m + n];
        return dfs(0, 0, 0);
    }

    boolean dfs(int x, int y, int c) {
        if (c > m - x + n - y - 1) return false; // 剪枝：即使后面都是 ')' 也不能将 c 减为 0
        if (x == m - 1 && y == n - 1) return c == 1; // 终点一定是 ')'
        if (vis[x][y][c]) return false; // 重复访问
        vis[x][y][c] = true;
        c += grid[x][y] == '(' ? 1 : -1;
        return c >= 0 && (x < m - 1 && dfs(x + 1, y, c) || y < n - 1 && dfs(x, y + 1, c)); // 往下或者往右
    }
}
