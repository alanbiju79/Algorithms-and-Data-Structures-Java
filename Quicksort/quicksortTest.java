public class quicksortTest {
    public static void main(String[]args){
        quicksort qs = new quicksort();
        int array[] = {2, 3, 5, 1, 4, 9, 7};
        qs.quicksort(array);

        for(int i=0; i<array.length; i++)
            System.out.print(array[i] + " ");
    }
}
