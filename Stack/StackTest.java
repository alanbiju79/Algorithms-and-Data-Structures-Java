public class StackTest {
    public static void main(String[]args){
        DynamicStack nums = new DynamicStack();

        nums.push(10);
        nums.show();
        System.out.println();
        nums.push(15);
        nums.show();
        System.out.println();
        nums.push(12);
        nums.show();
        System.out.println();
        nums.push(2);
        nums.show();
        System.out.println();
        nums.push(5);
        nums.show();
        System.out.println();

        nums.pop();
        nums.show();
        System.out.println();
        nums.pop();
        nums.show();
        System.out.println();
    }
}
