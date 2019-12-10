class Solution {
    private static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int[][] nextPos = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        int minutes = 0;
        while (!queue.isEmpty()) {
            ++minutes;

            int qSize = queue.size();
            for (int i = 0; i < qSize; ++i) {
                Pair curPair = queue.poll();
                for (int j = 0; j < 4; ++j) {
                    int newX = curPair.x + nextPos[j][0];
                    int newY = curPair.y + nextPos[j][1];

                    if (newX >= row || newX < 0 || newY >= col || newY < 0) {
                        continue;
                    }

                    if (grid[newX][newY] == 1) {
                        queue.offer(new Pair(newX, newY));
                        grid[newX][newY] = 2;
                    }
                }
            }
        }

        boolean flag = false;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
        }

        minutes = minutes == 0 ? minutes : --minutes;

        return flag ? -1 : minutes;
    }
}