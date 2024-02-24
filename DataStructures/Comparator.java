
/**
 * Write a description of interface Comparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Comparator
{
    public int compare(Object key1, Object key2); // <0 is key1 < key2, 0 is key1=key2, >0 is key1 > key2
    public boolean equals(Object object); // compares comparators
}
