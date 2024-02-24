public class BinarySearch<K,V>
{
    public Entry search(K key, Entry[] entries, int max)
    {
        int min = 1;
        int mid;
        do
        {
            mid = (min + max) / 2;
            if (entries[mid].getKey() == key)
            {
                return entries[mid];
            }
            if (key.hashCode() > entries[mid].getKey().hashCode())
            {
                min = mid + 1;
            }
            else
            {
                max = mid - 1;
            }
        } while (min <= max);
        return null;
    }
}
