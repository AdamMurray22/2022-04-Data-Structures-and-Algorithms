
/**
 * Write a description of class NodeAT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeAT<E> implements NodeATInter<E>
{
    private E element;
    private NodeATInter<E> next;
    
    public NodeAT(E e, NodeATInter<E> n)
    {
        element = e;
        next = n;
    }
    
    public NodeAT()
    {
        this(null, null);
    }
    
    public E getElement()
    {
        return element;
    }
    
    public NodeATInter<E> getNext()
    {
        return next;
    }
    
    public void setElement(E newElem)
    {
        element = newElem;
    }
    
    public void setNext(NodeATInter<E> newNext)
    {
        next = newNext;
    }
}
