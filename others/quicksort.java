// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] a = { 15, 16, 6, 8, 5 };
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        quicksort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");



    }

    public static void quicksort(int[] a, int lb, int ub) {
        if (lb < ub) {
            int loc = partition(a, lb, ub);
            quicksort(a, lb, loc - 1);
            quicksort(a, loc + 1, ub);
        } else
            return;
    }

    public static int partition(int[] a, int lb, int ub) {
        int pivot = a[lb];
        int count = 0;
        for (int i = lb + 1; i <= ub; i++) {
            if (a[i] <= pivot)
                count++;
        }
        int pivotindex = lb + count;
        // swap(a[pivotindex],a[lb])
        int temp = a[pivotindex];
        a[pivotindex] = a[lb];
        a[lb] = temp;

        int start = lb, end = ub;
        while (start < pivotindex && end > pivotindex) {
            while (a[start] <= pivot)
                start++;
            while (a[end] > pivot)
                end--;
            if (start < pivotindex && end > pivotindex) {
                // swap(a[start],a[end])
                temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }

        }
        return pivotindex;
    }


}
