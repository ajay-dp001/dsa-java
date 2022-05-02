package stack;

public class TwoStackInArray {

    int size;
    int[] arr;
    int top1, top2;

    TwoStackInArray(int size) {
        top1 = -1;
        top2 = size;
        this.size = size;
        arr = new int[size];
    }

    public void push1(int n) {
        if (top1 < top2 - 1) {
            arr[++top1] = n;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    public int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        }else {
            System.out.println("Stack UnderFlow");
            System.exit(1);
        }
        return 0;
    }

    public void push2(int n) {
        if (top1 < top2 - 1) {
            arr[--top2] = n;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    public int pop2(){
        if(top2<size){
            return  arr[top2++];
        }else {
            System.out.println("stack Ubderflow");
            System.exit(1);
        }
        return  0;
    }


    public static void main(String[] args) {
    TwoStackInArray twoStackInArray = new TwoStackInArray(10);
    twoStackInArray.push1(10);
    twoStackInArray.push2(12);
    twoStackInArray.push1(22);
    twoStackInArray.push2(32);
        System.out.println("Popped Element form Stack-1 "+ twoStackInArray.pop1());
        System.out.println("Popped Element form Stack-2 "+ twoStackInArray.pop2());
    }
}
