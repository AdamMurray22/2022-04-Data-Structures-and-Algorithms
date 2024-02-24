
/**
 * Write a description of interface Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Map<K,V>
{
    public V get(K key);
    public V put(K key, V value);
    public V remove(K key);
}
