
/**
 * Write a description of interface PriorityQueueAT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface PriorityQueueAT<K,V>
{
    public Entry<K,V> insert(K key, V value) throws InvalidKeyException;
    public Entry<K,V> removeMin() throws EmptyPriorityQueueException;
    public Entry<K,V> min()throws EmptyPriorityQueueException;
    public int size();
    public boolean isEmpty();
}
