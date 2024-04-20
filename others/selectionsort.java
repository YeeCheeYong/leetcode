public class Main {
    public static void main(String[] args) {
        int[] a = { 15, 16, 6, 8, 5 };
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        selectionsort(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");


    }
    public static void selectionsort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j])
                    min = j;
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

}
