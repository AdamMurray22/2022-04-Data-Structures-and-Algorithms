
public class InsertionQueue<K,V> implements PriorityQueueAT<K,V>
{
    private NodePositionListAT<Entry<K,V>> list;

    public InsertionQueue()
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
        Comparator comparator = new IntComparator();
        if (list.isEmpty() || comparator.compare(key, list.first().element().getKey()) < 0)
        {
            list.addFirst(entry);
            return entry;
        }
        list.addAfter(findPosition(entry.getKey()), entry);
        return entry;
    }

    public Entry<K,V> removeMin() throws EmptyPriorityQueueException
    {
        if (list.isEmpty())
        {
            throw new EmptyPriorityQueueException();
        }
        return list.remove(list.first());
    }

    public Entry<K,V> min()throws EmptyPriorityQueueException
    {
        if (list.isEmpty())
        {
            throw new EmptyPriorityQueueException();
        }
        return list.first().element();
    }

    private DNodeAT<Entry<K,V>> findPosition(K key)
    {
        Comparator comparator = new IntComparator();
        DNodeAT<Entry<K,V>> node = list.first();
        if (comparator.compare(key, node.element().getKey()) < 0)
        {
            return node; 
        }
        while (node.getNext().element() != null)
        {
            node = node.getNext();
            if (comparator.compare(key, node.element().getKey()) < 0)
            {
                return node.getPrev(); 
            }
        }
        return node;
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

