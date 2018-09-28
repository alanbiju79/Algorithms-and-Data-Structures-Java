public class bubbleSortTest {

    public static void main(String[]args){
        bubbleSort sort = new bubbleSort();
        int array[] = {2, 3, 5, 1, 4, 9, 7};
        sort.bubbleSort(array);

        for(int i=0; i<array.length; i++)
            System.out.print(array[i] + " ");
    }
}
