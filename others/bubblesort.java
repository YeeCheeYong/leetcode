public class Main {
    public static void main(String[] args) {
        int[] a={15,16,6,8,5};

        bubblesort(a);
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");



    }
    public static void bubblesort(int[] a)
    {
        for(int i=0;i<a.length-1;i++)
        {
            for(int j=0;j<a.length-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

}
