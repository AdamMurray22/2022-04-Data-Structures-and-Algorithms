
/**
 * Write a description of class NodeQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeQueue<E> implements QueueAT<E>
{
    private int size;
    private NodeATInter<E> front;
    private NodeATInter<E> back;    

    public NodeQueue()
    {
        size = 0;
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
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return front.getElement();
    }
    
    public E dequeue() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        E element = front.getElement();
        front = front.getNext();
        return element;
    }
    
    public void enqueue(E element)
    {
        NodeAT<E> newNode = new NodeAT<E>(element, null);
        if (isEmpty())
        {
            front = newNode;
        }
        else
        {
            back.setNext(newNode);
        }
        back = newNode;
        size++;
    }
}
