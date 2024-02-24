
public class PriorityQueueEntry<K,V> implements Entry<K,V>
{
    private K key;
    private V value;
    
    public PriorityQueueEntry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    
    public K getKey()
    {
        return key;
    }
    
    public V getValue()
    {
        return value;
    }
}
