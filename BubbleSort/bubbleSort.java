public class bubbleSort {
    public static void bubbleSort(int array[]){

        int temp = 0;
        int n = array.length;

        for(int pass=1; pass<n; pass++){
            for(int i=0; i<n-1; i++){
                if(array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
}
