
/**
 * Write a description of interface NodeATInter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface NodeATInter<E>
{
    public E getElement();
    
    public NodeATInter<E> getNext();
    
    public void setElement(E newElem);
    
    public void setNext(NodeATInter<E> newNext);
}
