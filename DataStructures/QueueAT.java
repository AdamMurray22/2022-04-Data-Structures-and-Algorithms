
public interface QueueAT<E>
{
    int size();
    
    boolean isEmpty();
    
    E front() throws EmptyQueueException; // returns element front front of the queue
    
    void enqueue(E element) throws FullQueueException; // Adds element to back of the queue
    
    E dequeue() throws EmptyQueueException; // removes element from front of queue and returns it
}
