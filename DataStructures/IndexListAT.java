
public interface IndexListAT<E>
{
    int size();
    
    boolean isEmpty();
    
    void add(int index, E element) throws IndexOutOfBoundsException;
    
    E get(int index) throws IndexOutOfBoundsException;
    
    E remove(int index) throws IndexOutOfBoundsException;
    
    E set(int index, E element) throws IndexOutOfBoundsException; // replaces element at index with the element given, then returns the old element
}
