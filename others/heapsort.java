// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int a[] = { 10, 5, 3, 2, 4  };
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        heapsort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");




    }
    public static void heapify(int[] arr, int n, int i) {
        int leftchild = (i + 1) * 2 - 1;
        if (leftchild >= n)//if no child
            return;
        int childindex;
        if (leftchild + 1 >= n) {//if only leftchild
            childindex = leftchild;
            if (childindex < n && i < n) {
                if (arr[i] < arr[childindex]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[childindex];
                    arr[childindex] = temp;

                    i = childindex;
                    // Recursively heapify the affected sub-tree
                    heapify(arr, n, i);
                }
            }
        }//if i have both left n rightchild
        int rightchild = leftchild + 1;
        childindex = (arr[leftchild] > arr[rightchild]) ? leftchild : rightchild;
        if (childindex < n && i < n) {
            if (arr[i] < arr[childindex]) {
                // swap
                int temp = arr[i];
                arr[i] = arr[childindex];
                arr[childindex] = temp;

                i = childindex;
                // Recursively heapify the affected sub-tree
                heapify(arr, n, i);
            }
        } else
            return;
    }

    public static void heapsort(int arr[])
    {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }


}
