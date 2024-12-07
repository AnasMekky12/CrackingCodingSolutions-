package StacksAndQueues;

import java.util.Stack;

public class Q5 {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        
        s1.push(7);
        s1.push(10);
        s1.push(8);
        s1.push(12);
        s1.push(5);

        System.out.println("Stack قبل الفرز: " + s1);
        
        sortStack(s1);
        
        System.out.println("Stack بعد الفرز: " + s1);
    }

    public static void sortStack(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>(); 
        while (!s1.isEmpty()) {
            int tmp = s1.pop();
            
            while (!s2.isEmpty() && s2.peek() > tmp) {
                s1.push(s2.pop());
            }
            
            s2.push(tmp);
        }
        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
