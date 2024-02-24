public class IntComparator implements Comparator
{
    public int compare(Object key1, Object key2)
    {
        Integer value1 = (Integer) key1;
        Integer value2 = (Integer) key2;
        if (value1 < value2)
        {
            return -1;
        }
        if (value1 > value2)
        {
            return 1;
        }
        return 0;
    }
    
    public boolean equals(Object object)
    {
        return this == object;
    }
}
