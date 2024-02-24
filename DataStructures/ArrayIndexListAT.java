
/**
 * Write a description of class ArrayIndexListAT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayIndexListAT<E> implements IndexListAT<E>
{
    private E[] elements; 
    private int capacity = 16; 
    private int size = 0; 
    public ArrayIndexListAT() 
    {
        elements = (E[ ]) new Object[capacity]; 
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void add(int index, E element) throws IndexOutOfBoundsException
    {
        if (index < 0 && index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        if (index >= capacity)
        {
            increaseCapacityDoubling();
        }
        for (int j = size - 1; j >= index; j--)
        {
            elements[j+1] = elements[j];
        }
        elements[index] = element;
        size++;
    }
    
    private void increaseCapacityDoubling()
    {
        capacity = capacity * 2;
        E[] newArray = (E[ ]) new Object[capacity];
        for (int i = 0; i < elements.length; i++)
        {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
    
    public E get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 && index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }
    
    public E remove(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 && index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        E element = elements[index];
        for (int j = index; j < size - 1; j++)
        {
            elements[j] = elements[j+1];
        }
        size--;
        return element;
    }
    
    public E set(int index, E element) throws IndexOutOfBoundsException
    {
        if (index < 0 && index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }
}
