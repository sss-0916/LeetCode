class Solution {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int maxArea = 0;

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    int area = BFS(grid, queue, row, col, i, j);
                    maxArea = maxArea > area ? maxArea : area;
                }
            }
        }

        return maxArea;
    }

    private int[][] nextPos = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private int BFS(
        int[][] grid, Queue<Pair> queue, 
        int row, int col, int x, int y
    ) {
        int ret = 1;
        grid[x][y] = 2;
        
        queue.offer(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int newX = curPair.x + nextPos[i][0];
                int newY = curPair.y + nextPos[i][1];

                if (newX >= row || newX < 0 || newY >= col || newY < 0) {
                    continue;
                }

                if (grid[newX][newY] == 1) {
                    queue.offer(new Pair(newX, newY));
                    grid[newX][newY] = 2;
                    ++ret;
                }
            }
        }

        return ret;
    }
}