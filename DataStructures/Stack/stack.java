package DataStructures.Stack;
import java.util.Stack;

public class stack {

    public static void pushAtBottom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(top, s);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(9);
        s.push(4);
        s.push(3);
        s.push(8);
        s.push(5);

        System.out.println("Original Stack:");
        while(!s.isEmpty()){
            System.out.println(s.pop() + " ");
        }
    }
    
}
