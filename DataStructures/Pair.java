
/**
 * Write a description of class Pair here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pair<E>
{
    private E element1;
    private E element2;
    
    public Pair(E e1, E e2)
    {
        element1 = e1;
        element2 = e2;
    }
    
    public E getE1()
    {
        return element1;
    }
    
    public E getE2()
    {
        return element2;
    }
}
