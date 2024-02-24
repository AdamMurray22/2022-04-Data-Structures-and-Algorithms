
public class ArrayQueueAT<E> implements QueueAT<E>
{
    private int front;
    private int rear; //index immeadiatly past the rear
    private E[] elements;
    
    private int arraySize;
    
    public ArrayQueueAT(int maxSize)
    {
        front = 0;
        rear = 0;
        arraySize = maxSize;
        elements = (E[]) new Object[maxSize];
    }
    
    public int size()
    {
        return (rear - front + arraySize) % arraySize;
    }
    
    public boolean isEmpty()
    {
        return front == rear;
    }
    
    public E front() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return elements[front];
        }
    }
    
    public E dequeue() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            E element = elements[front];
            front = (front + 1) & arraySize;
            return element;
        }
    }
    
    public void enqueue(E element) throws FullQueueException
    {
        if (size() == arraySize - 1)
        {
            throw new FullQueueException();
        }
        else
        {
            elements[rear] = element;
            rear = (rear + 1) % arraySize;
        }
    }
}
