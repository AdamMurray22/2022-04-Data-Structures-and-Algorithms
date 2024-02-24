import java.util.EmptyStackException;


public class ArrayStackAT<E> implements StackAT<E>
{
    private int top;
    private E elements[];
    
    public ArrayStackAT(int maxSize)
    {
        top = -1;
        elements = (E[]) new Object[maxSize];
    }
    
    public int size()
    {
        return top + 1;
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public E pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            top--;
            return elements[top + 1];
        }
    }
    
    public E top()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return elements[top];
        }
    }
    
    public void push(E element) throws FullStackException
    {
        if (top == elements.length - 1)
        {
            throw new FullStackException();
        }
        else
        {
            top++;
            elements[top] = element;
        }
    }
}
