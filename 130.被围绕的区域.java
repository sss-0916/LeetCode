class Solution {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || !(o instanceof Pair)) return false;

            Pair pair = (Pair)o;
            return this.x == pair.x && this.y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;

        HashSet<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < col; ++i) {
            if (board[0][i] == 'O') {
                Pair newPair = new Pair(0, i);
                visited.add(newPair);
                queue.offer(newPair);
            }
            if (board[row - 1][i] == 'O') {
                Pair newPair = new Pair(row - 1, i);
                visited.add(newPair);
                queue.offer(newPair);
            }
        }
        for (int i = 0; i < row; ++i) {
            if (board[i][0] == 'O') {
                Pair newPair = new Pair(i, 0);
                visited.add(newPair);
                queue.offer(newPair);
            }
            if (board[i][col - 1] == 'O') {
                Pair newPair = new Pair(i, col - 1);
                visited.add(newPair);
                queue.offer(newPair);
            }
        }

        int[][] nextPos = {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };

        while (!queue.isEmpty()) {
            Pair curPair = queue.poll();
            board[curPair.x][curPair.y] = '#';

            for (int i = 0; i < 4; ++i) {
                int newX = curPair.x + nextPos[i][0];
                int newY = curPair.y + nextPos[i][1];

                if (newX >= row || newX < 0 || newY >= col || newY < 0) {
                    continue;
                }

                Pair newPair = new Pair(newX, newY);
                if (board[newX][newY] == 'O' && !visited.contains(newPair)) {
                    queue.offer(newPair);
                    visited.add(newPair);
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}