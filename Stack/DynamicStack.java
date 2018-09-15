public class DynamicStack {

    int cap = 2;
    int stack[] = new int[cap];
    int top = 0;

    public void push(int data) {
        if(size()==cap)
            expand();

        stack[top] = data;
        top++;
    }

    private void expand() {
        int length = size();
        int newStack[] = new int[cap*2];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        cap *= 2;
    }

    public int pop() {
        int data = 0;

        if(isEmpty())
            System.out.println("Stack empty");

        else {
            top--;
            data = stack[top];
            stack[top] = 0;
            shrink();
        }
        return data;
    }

    private void shrink() {
        int length = size();

        if(length < cap/2)
            cap = cap/2;

        int newStack[] = new int[cap];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
    }

    public int peek() {
        int data;
        data = stack[top - 1];
        return data;
    }

    public int size(){
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }

    public void show() {
        for(int n : stack){
            System.out.print(n + " ");
        }
    }
}
