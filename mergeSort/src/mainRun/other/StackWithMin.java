package mainRun.other;

import java.util.Stack;

public class StackWithMin {
	
	  private Stack<Integer> S1;
	  private Stack<Pair> S2;
	  
	   class Pair {
	    public int a;
	    public int b;
	    
	    public Pair(int a, int b) {
	      this.a = a;
	      this.b = b;
	    }
	   }
	  
	  public StackWithMin() {
	    // write your solution here
	    this.S1 = new Stack<Integer> ();
	    this.S2 = new Stack<Pair> ();
	  }
	  
	  public int pop() {
	    if(S1.empty()) return -1;
	    
	    S2.peek().b = S2.peek().b-1;
	    if(S2.peek().b == 0) S2.pop();
	    
	    return S1.pop();
	  }
	  
	  public void push(int element) {
	    if(S1.empty()) {
	      S1.push(element);
	      S2.push(new Pair(element,1));
	      return;
	    }
	    
	    if(element >= S1.peek()){
	      S2.peek().b = S2.peek().b+1;
	      S1.push(element);
	      
	    } else {
	      S1.push(element);
	      S2.push(new Pair(element,1));
	    }
	    
	  }
	  
	  public int top() {
	    if(S1.empty()) {
	      return S1.peek();
	    } else {
	      return -1;
	    }
	  }
	  
	  public int min() {
		if(S1.empty()) return -1;
	    return S2.peek().a;
	  }

}
