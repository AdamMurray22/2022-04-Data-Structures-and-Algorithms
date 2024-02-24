
public class DNodeAT<E> implements PositionAT<E>
{
    private E element;
    private DNodeAT<E> next;
    private DNodeAT<E> prev;
    
    public DNodeAT(DNodeAT<E> newPrev, DNodeAT<E> newNext, E element)
    {
        prev = newPrev;
        next = newNext;
        this.element = element;
    }
    
    public E element() throws InvalidPositionException
    {
        if (prev == null && next == null)
        {
            throw new InvalidPositionException();
        }
        return element;
    }
    
    public DNodeAT<E> getNext()
    {
        return next;
    }
    
    public DNodeAT<E> getPrev()
    {
        return prev;
    }
    
    public void setElement(E newElement)
    {
        element = newElement;
    }
    
    public void setNext(DNodeAT<E> node)
    {
        next = node;
    }
    
    public void setPrev(DNodeAT<E> node)
    {
        prev = node;
    }
}
