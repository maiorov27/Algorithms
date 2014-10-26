package sorts;

public abstract class AbstractSort {

    public static boolean less(Comparable first, Comparable second) {
        return first.compareTo(second) < 0;
    }

    public static void exch(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j]  = temp;
    }

    public abstract void sort(Comparable a[]);

    public void showArray(Comparable a[]) {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }


}
