
public class PositionListQueue<E> implements QueueAT<E>
{
    private int size;
    private PositionListAT<E> elements;
    
    public PositionListQueue()
    {
        elements = new NodePositionListAT();
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public E front() throws EmptyQueueException
    {
        try
        {
            try
            {
                return elements.first().element();
            }
            catch (EmptyListException ele)
            {
                throw new EmptyQueueException();
            }
        }
        catch (InvalidPositionException ipe)
        {
            throw new EmptyQueueException();
        }
    }
    
    public void enqueue(E element)
    {
        elements.addLast(element);
        size++;
    }
    
    public E dequeue() throws EmptyQueueException
    {
        try
        {
            try
            {
                E element = elements.remove(elements.first());
                size--;
                return element;
            }
            catch (EmptyListException ele)
            {
                throw new EmptyQueueException();
            }
        }
        catch (InvalidPositionException ipe)
        {
            throw new EmptyQueueException();
        }
    }
}
