class Solution {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int cnt = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == '1') {
                    BFS(grid, queue, row, col, i, j);
                    ++cnt;
                }
            }
        }

        return cnt;
    }

    private int[][] nextPos = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private void BFS(
        char[][] grid, Queue<Pair> queue, 
        int row, int col, int sr, int sc
    ) {
        queue.offer(new Pair(sr, sc));
        grid[sr][sc] = '2';
        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int newX = curPair.x + nextPos[i][0];
                int newY = curPair.y + nextPos[i][1];

                if (newX >= row || newX < 0 || newY >= col || newY < 0) {
                    continue;
                }

                if (grid[newX][newY] == '1') {
                    queue.offer(new Pair(newX, newY));
                    grid[newX][newY] = '2';
                }
            }
        }
    }
}