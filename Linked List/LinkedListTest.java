public class LinkedListTest {
    public static void main(String[]args){

        LinkedList list = new LinkedList();
        list.append(18);
        list.append(45);
        list.prepend(12);
        list.prepend(15);
        list.deleteWithValue(18);
        list.insertAt(2,55);

        list.show();

    }
}
