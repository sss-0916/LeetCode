class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        int row = image.length;
        int col = image[0].length;
        int oldColor = image[sr][sc];
        int[][] book = new int[row][col];

        DFS(image, book, row, col, sr, sc, newColor, oldColor);

        return image;
    }

    private int[][] nextPos = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    private void DFS(
        int[][] image, int[][] book, int row, int col, 
        int sr, int sc, int newColor, int oldColor
    ) {
        image[sr][sc] = newColor;
        book[sr][sc] = 1;

        for (int i = 0; i < 4; ++i) {
            int newSr = sr + nextPos[i][0];
            int newSc = sc + nextPos[i][1];

            if (newSr >= row || newSr < 0 || newSc >= col || newSc < 0) {
                continue;
            }

            if (image[newSr][newSc] == oldColor && book[newSr][newSc] == 0) {
                DFS(image, book, row, col, newSr, newSc, newColor, oldColor);
            }
        }
    }
}