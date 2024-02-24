import java.util.EmptyStackException;

/**
 * Write a description of class ArrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListStack<E> implements StackAT<E>
{
    private int top;
    private ArrayIndexListAT<E> elements;
    
    public ArrayListStack()
    {
        top = -1;
        elements = new ArrayIndexListAT();
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
            return elements.remove(top + 1);
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
            return elements.get(top);
        }
    }
    
    public void push(E element)
    {
        top++;
        elements.add(top, element);
    }
}
