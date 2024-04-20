// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        mergesort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");


    }

    public static void mergesort(int[] a, int lb, int ub) {
        int mid;
        if (lb < ub) {
            mid = (lb + ub) / 2;
            mergesort(a, lb, mid);
            mergesort(a, mid + 1, ub);
            merge(a, lb, mid, ub);
        } else
            return;
    }

    public static void merge(int[] a, int lb, int mid, int ub) {
        int lsize = mid - lb + 1;
        int rsize = ub - mid;
        int[] l = new int[lsize];
        int[] r = new int[rsize];
        for (int i = 0; i < lsize; i++)
            l[i] = a[lb + i];
        for (int i = 0; i < rsize; i++)
            r[i] = a[mid + 1 + i];
        int i = 0, j = 0, k = lb;
        while (i < lsize && j < rsize) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < lsize) {
            a[k] = l[i];
            i++;
            k++;
        }
        while (j < rsize) {
            a[k] = r[j];
            j++;
            k++;
        }
    }



}
