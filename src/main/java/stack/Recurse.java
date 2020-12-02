package stack;
import DS.Stack;

import static stack.StackUtils.*;
import static stack.IntUtils.*;

public class Recurse {
  public static int sum(Stack<Integer> st) {
    if (st.isEmpty()) return 0;
    
    int ret;
    int top = st.pop();
    
    if (st.isEmpty()) ret = top;
    else ret = top + sum(st);

    st.push(top);
    return ret;
  }
}
