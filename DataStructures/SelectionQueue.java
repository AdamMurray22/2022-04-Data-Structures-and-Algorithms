
/**
 * Write a description of class SelectionQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SelectionQueue<K,V> implements PriorityQueueAT<K,V>
{
    private NodePositionListAT<Entry<K,V>> list;
    
    public SelectionQueue()
    {
        list = new NodePositionListAT<>();
    }
    
    public Entry<K,V> insert(K key, V value) throws InvalidKeyException
    {
        if (key == null)
        {
            throw new InvalidKeyException();
        }
        Entry<K,V> entry = new PriorityQueueEntry<K,V>(key, value);
        list.addLast(entry);
        return entry;
    }
    
    public Entry<K,V> removeMin() throws EmptyPriorityQueueException
    {
        return list.remove(findSmallest());
    }
    
    public Entry<K,V> min()throws EmptyPriorityQueueException
    {
        return findSmallest().element();
    }
    
    private DNodeAT<Entry<K,V>> findSmallest()
    {
        if (list.isEmpty())
        {
            throw new EmptyPriorityQueueException();
        }
        Comparator comparator = new IntComparator();
        DNodeAT<Entry<K,V>> node = list.first();
        DNodeAT<Entry<K,V>> smallestNode = node;
        while (node.getNext().element() != null)
        {
            node = node.getNext();
            if (comparator.compare(smallestNode.element().getKey(), node.element().getKey()) > 0)
            {
                smallestNode = node;
            }
        }
        return smallestNode;
    }
    
    public int size()
    {
        return list.size();
    }
    
    public boolean isEmpty()
    {
        return list.size() == 0;
    }
}
