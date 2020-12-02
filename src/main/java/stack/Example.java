package stack;

import DS.Stack;

public class Example {
  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    st.push(10);
    st.push(20);
    st.push(30);
    System.out.println(st);
    
    int val = st.pop();
    System.out.println(st);
    
    val = st.top();
    System.out.println("After top: " + st);
    
    val = st.pop();
    System.out.println(st);
  
    st.push(10);
    st.push(20);
    st.push(30);
    System.out.println(st);
    
  }
}
