
public interface PositionListAT<E>
{
    int size();
    
    boolean isEmpty();
    
    PositionAT<E> first() throws EmptyListException;
    
    PositionAT<E> last() throws EmptyListException;
    
    PositionAT<E> next(PositionAT<E> position) throws InvalidPositionException, BoundaryViolationException;
    
    PositionAT<E> prev(PositionAT<E> position) throws InvalidPositionException, BoundaryViolationException;

    void addFirst(E element);
    
    void addLast(E element);
    
    void addAfter(PositionAT<E> position, E element) throws InvalidPositionException;
    
    void addBefore(PositionAT<E> position, E element) throws InvalidPositionException;
    
    E remove(PositionAT<E> position) throws InvalidPositionException;
    
    E set(PositionAT<E> position, E element) throws InvalidPositionException;
}
