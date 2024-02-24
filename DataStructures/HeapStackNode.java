import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class HeapStackNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HeapStackNode<E>
{
    private HeapStackNode<E> next;
    private HeapStackNode<E> prev;
    
    protected E element;
    private HeapStackNode<E> parent;
    private HeapStackNode<E> left;
    private HeapStackNode<E> right;
    
    public HeapStackNode(E newElement, HeapStackNode<E> newParent, HeapStackNode<E> leftChild, HeapStackNode<E> rightChild, HeapStackNode<E> n)
    {
        element = newElement;
        parent = newParent;
        left = leftChild;
        right = rightChild;
        next = n;
    }
    
    public HeapStackNode(E newElement, HeapStackNode<E> newParent, HeapStackNode<E> leftChild, HeapStackNode<E> rightChild)
    {
        this(newElement, newParent, leftChild, rightChild, null);
    }
    
    public E getElement()
    {
        return element;
    }
    
    public HeapStackNode<E> getNext()
    {
        return next;
    }
    
    public HeapStackNode<E> getPrev()
    {
        return prev;
    }
    
    public void setPrev(HeapStackNode<E> prev)
    {
        this.prev = prev;
    }
    
    public void setElement(E newElem)
    {
        element = newElem;
    }
    
    public void setNext(HeapStackNode<E> newNext)
    {
        next = newNext;
    }
    
    public E element()
    {
        return element;
    }
    
    public HeapStackNode<E> left()
    {
        return left;
    }
    
    public HeapStackNode<E> right()
    {
        return right;
    }
    
    public HeapStackNode<E> getParent()
    {
        return parent;
    }
    
    public void setLeft(HeapStackNode<E> leftNode)
    {
        left = leftNode;
    }
    
    public void setRight(HeapStackNode<E> rightNode)
    {
        right = rightNode;
    }
    
    public List<HeapStackNode<E>> getChildren()
    {
        List<HeapStackNode<E>> children = new ArrayList<HeapStackNode<E>>();
        if (left != null)
        {
            children.add(left);
        }
        if (right != null)
        {
            children.add(right);
        }
        return children;
    }
    
    public void setParent(HeapStackNode<E> parentNode)
    {
        parent = parentNode;
    }
}
