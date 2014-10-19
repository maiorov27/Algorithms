
public class PercolationStats {

    private Percolation percolation;
    private double[] thresholds;
    private int numberOfExperiments;
    private int dimension;

    public PercolationStats(int N, int T) {
        checkArguments(N, T);
        numberOfExperiments = T;
        dimension = N;
        thresholds = new double[T];
        percolation = new Percolation(N);
        int n = 0;

        for (int t = 0; t < T; t++) {
            while (n < N * N) {

                int i = StdRandom.uniform(dimension)+1;
                int j = StdRandom.uniform(dimension)+1;

                if (percolation.isOpen(i, j))
                    continue;

                percolation.open(i, j);

                n++;

                if (percolation.percolates()) {
                    thresholds[t] = n / (double) (N * N);
                    break;
                }
            }
        }
    }

    private void checkArguments(int size, int experimentsAmount) {
        if (size <= 0 || experimentsAmount <= 0)
            throw new IllegalArgumentException();
    }


    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo() {
        double d = (1.96 * stddev()) / Math.sqrt(numberOfExperiments);
        return (mean() - d);
    }

    public double confidenceHi() {
        double d = (1.96 * stddev()) / Math.sqrt(numberOfExperiments);
        return (mean() + d);
    }


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(N, T);

        double mean = stats.mean();
        double stddev = stats.stddev();
        double[] interval = new double[2];

        interval[0] = mean - ((1.96 * stddev) / Math.sqrt(T));
        interval[1] = mean + ((1.96 * stddev) / Math.sqrt(T));

        System.out.println("mean                    = " + mean);
        System.out.println("stddev                  = " + stddev);
        System.out.println("95% confidence interval = " + interval[0] + ", " + interval[1]);
    }
}