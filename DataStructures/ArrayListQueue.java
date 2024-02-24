
/**
 * Write a description of class ArrayListQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListQueue<E> implements QueueAT<E>
{
    private int rear; //index immeadiatly past the rear
    private ArrayIndexListAT<E> elements;

    public ArrayListQueue()
    {
        rear = 0;
        elements = new ArrayIndexListAT<>();
    }

    public int size()
    {
        return rear;
    }

    public boolean isEmpty()
    {
        return rear == 0;
    }

    public E front() throws EmptyQueueException
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        else
        {
            return elements.get(0);
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
            rear--;
            return elements.remove(0);
        }
    }

    public void enqueue(E element)
    {
        elements.add(rear, element);
        rear++;
    }
}
