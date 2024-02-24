import java.util.EmptyStackException;

/**
 * Write a description of class PositionListStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PositionListStack<E> implements StackAT<E>
{
    private int size;
    private PositionListAT<E> elements;
    
    public PositionListStack()
    {
        elements = new NodePositionListAT();
    }
    
    public void push(E element)
    {
        elements.addLast(element);
        size++;
    }
    
    public E pop() throws EmptyStackException
    {
        try
        {
            E element = elements.remove(elements.last());
            size--;
            return element;
        }
        catch (EmptyListException ele)
        {
            throw new EmptyStackException();
        }
    }
    
    public E top() throws EmptyStackException
    {
        try
        {
            try
            {
                return elements.last().element();
            }
            catch (InvalidPositionException ipe)
            {
                throw new EmptyStackException();
            }
        }
        catch (EmptyListException ele)
        {
            throw new EmptyStackException();
        }
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
}
