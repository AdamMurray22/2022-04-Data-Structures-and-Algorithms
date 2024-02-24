import java.util.EmptyStackException;

public interface StackAT<E>
{
    void push(E element); //adds element to top of the stack
    
    E pop() throws EmptyStackException; // removes and returns the element at the top of the stack
    
    E top() throws EmptyStackException; // returns the top of the stack without removing it
    
    int size();
    
    boolean isEmpty();
}
