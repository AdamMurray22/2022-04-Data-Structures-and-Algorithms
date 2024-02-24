
public class NodeQueueAT<E> implements QueueAT<E>
{
    private NodeATInter<E> head;
    private NodeATInter<E> tail;
    private int size;
    
    public NodeQueueAT()
    {
        head = null;
        tail = null;
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
    
    public void enqueue(E element)
    {
        NodeAT<E> newNode = new NodeAT<E>(element, null);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }
    
    public E dequeue() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        E element = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
        {
            tail = null;
        }
        return element;
    }
    
    public E front() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return head.getElement();
    }
}
