import java.util.EmptyStackException;

/**
 * Write a description of class NodeStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeStack<E> implements StackAT<E>
{
    private int size;
    private NodeATInter<E> top;
    
    public NodeStack()
    {
        size = 0;
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public E top() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return top.getElement();
    }
    
    public E pop() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        E element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }
    
    public void push(E element)
    {
        NodeATInter<E> newNode = new NodeAT<E>(element, top);
        top = newNode;
        size++;
    }
    
    public NodeATInter<E> topNode() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return top;
    }
    
    public NodeATInter<E> popNode() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        NodeATInter<E> node = top;
        top = top.getNext();
        size--;
        return node;
    }
    
    public void pushNode(NodeATInter<E> node)
    {
        node.setNext(top);
        top = node;
        size++;
    }
}
