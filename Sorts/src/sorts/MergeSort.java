package sorts;

public class MergeSort extends AbstractSort{
    Comparable aux[];

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a, int lo, int high) {
        if (lo >= high)
            return;
        int mid =lo + (high - lo) / 2;
        sort(a,lo,mid);
        sort(a,mid+1,high);
        merge(a,lo,mid,high);
    }

    private void merge(Comparable[] a, int lo, int mid, int high) {
        int i = lo, j = mid+1;
        for(int x = lo; x <= high; x++) {
            aux[x] = a[x];
        }

        for(int k = lo; k <= high; k++) {
            if (i > mid ) {                    a[k] = aux[j++];
            } else if (j > high) {            a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {    a[k] = aux[i++];
            } else {                          a[k] = aux[j++];
            }
        }
    }


}
