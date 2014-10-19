
public class Percolation {
    private int dimension;
    private WeightedQuickUnionUF quickUnionUF;
    private boolean[][] grid;
    private int virtualTop = 0;
    private int virtualBottom = 1;

    public Percolation(int N) {
        isDimensionBiggerThanZero(N);
        quickUnionUF = new WeightedQuickUnionUF(N * N + 2);
        grid = new boolean[N][N];
        dimension = N;
        connectVirtualTop();
        connectVirtualBottom();
    }

    public void open(int i, int j) {
        checkIndexes(i, j);
        grid[i-1][j-1] = true;
        if (i == 1 && j == 1) {
            unionBottom(i, j);
            unionRight(i, j);
        } else if (i == 1 && j == dimension) {
            unionBottom(i, j);
            unionLeft(i, j);
        } else if (i == 1) {
            unionBottom(i, j);
            unionLeft(i, j);
            unionRight(i, j);
        } else if (i == dimension && j == 1) {
            unionTop(i, j);
            unionRight(i, j);
        } else if (i == dimension && j == dimension) {
            unionTop(i, j);
            unionLeft(i, j);
        } else if (i == dimension) {
            unionTop(i, j);
            unionLeft(i, j);
            unionRight(i, j);
        } else if (j == dimension) {
            unionTop(i, j);
            unionBottom(i, j);
            unionLeft(i, j);
        } else if (j == 1) {
            unionTop(i, j);
            unionBottom(i, j);
            unionRight(i, j);
        } else {
            unionTop(i, j);
            unionBottom(i, j);
            unionRight(i, j);
            unionLeft(i, j);
        }
    }

    private void unionTop(int i, int j) {
        if (isOpen(i - 1, j)) {
            quickUnionUF.union(convertMatrixCordsToArray(i, j), convertMatrixCordsToArray(i - 1, j));
        }
    }

    private void unionBottom(int i, int j) {
        if (isOpen(i + 1, j)) {
            quickUnionUF.union(convertMatrixCordsToArray(i, j), convertMatrixCordsToArray(i + 1, j));
        }
    }

    private void unionLeft(int i, int j) {
        if (isOpen(i, j - 1)) {
            quickUnionUF.union(convertMatrixCordsToArray(i, j), convertMatrixCordsToArray(i, j - 1));
        }
    }

    private void unionRight(int i, int j) {
        if (isOpen(i, j + 1)) {
            quickUnionUF.union(convertMatrixCordsToArray(i, j), convertMatrixCordsToArray(i, j - 1));
        }
    }

    public boolean isOpen(int i, int j) {
        checkIndexes(i, j);
        return grid[i-1][j-1];
    }

    public boolean isFull(int i, int j) {
        checkIndexes(i, j);

        if (isOpen(i,j) && quickUnionUF.connected(convertMatrixCordsToArray(i, j), virtualTop))
            return true;
        return false;
    }

    public boolean percolates() {
        return quickUnionUF.connected(virtualTop, virtualBottom);
    }

    private void checkIndexes(int i, int j) {
        if (i > dimension || j > dimension || i <= 0 || j <= 0)
            throw new IndexOutOfBoundsException();
    }

    private void isDimensionBiggerThanZero(int size) {
        if (size <= 0)
            throw new IllegalArgumentException();

    }

    private int convertMatrixCordsToArray(int i, int j) {
        return (i - 1) * dimension + (j - 1) + 2;
    }

    private void connectVirtualTop() {
        for (int j = 1; j <= dimension; j++) {
            quickUnionUF.union(convertMatrixCordsToArray(1, j),virtualTop);
        }
    }

    private void connectVirtualBottom() {
        for (int j = 1; j <= dimension; j++) {
            quickUnionUF.union(convertMatrixCordsToArray(dimension, j),virtualBottom);
        }
    }

    public static void main(String[] args) {
        Percolation stat = new Percolation(6);
        stat.open(1,6);
        System.out.println(stat.isFull(1,6));
    }
}