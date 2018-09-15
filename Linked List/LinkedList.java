public class LinkedList{
    Node head;

    public void append(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;

        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void insertAt(int index, int data){
        if(index == 0)
            prepend(data);

        Node current = head;
        Node newNode = new Node(data);

        for(int i=0; i<index-1; i++){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteWithValue(int data){
        if (head == null)
            return;

        if (head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void show(){
        Node current = head;

        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }
}
