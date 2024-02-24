
/**
 * Write a description of class SLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SLinkedListAT<E>
{
    private NodeATInter<E> head;
    private NodeATInter<E> tail;
    private long size;
    
    public SLinkedListAT()
    {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void insertAtHead(E element)
    {
        NodeAT<E> newNode = new NodeAT<E>(element, head);
        if (size == 0)
        {
            tail = newNode;
        }
        head = newNode;
        size++;
    }
    
    public E removeHead() throws EmptyListException
    {
        if (size == 0)
        {
            throw new EmptyListException();
        }
        E element = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
        {
            tail = null;
        }
        return element;
    }
    
    public void insertAtTail(E element)
    {
        NodeAT<E> newNode = new NodeAT<E>(element, null);
        tail.setNext(newNode);
        tail = newNode;
        if (size == 0)
        {
            head = newNode;
        }
        size++;
    }
    
    public E removeTail()
    {
        NodeATInter<E> node = head.getNext();
        for (int i = 0; i < size - 2; i++)
        {
            node = node.getNext();
        }
        E element = node.getNext().getElement();
        node.setNext(null);
        tail = node;
        return element;
    }
}
