import java.util.EmptyStackException;

/**
 * Write a description of class NodeStackForHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeStackForHeap<E>
{
    private int size;
    private HeapStackNode<E> top;
    private HeapStackNode<E> addPosition;
    
    public NodeStackForHeap()
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
    
    public HeapStackNode<E> topNode() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return top;
    }
    
    public HeapStackNode<E> popNode() throws EmptyStackException
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        HeapStackNode<E> node = top;
        top = top.getNext();
        size--;
        return node;
    }
    
    public void pushNode(HeapStackNode<E> node)
    {
        node.setNext(top);
        if (size != 0)
        {
            top.setPrev(node);
        }
        top = node;
        size++;
    }
    
    public HeapStackNode<E> getNextAdd()
    {
        return addPosition;
    }
    
    public void incrementAdd()
    {
        if (size == 1)
        {
            addPosition = top;
            return;
        }
        addPosition = addPosition.getPrev();
    }
    
    public void decrementAdd()
    {
        addPosition = addPosition.getNext();
    }
}
