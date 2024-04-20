// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] a = { 15, 16, 6, 8, 5 };
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        insertionsort(a, a.length);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }

    public static void insertionsort(int[] a, int n) {

        for (int i = 1; i < n; i++) {
            for (int j = i; j >0; j--) {
                if(a[j]<a[j-1])//swap
                {
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                }
            }
        }

    }



}
