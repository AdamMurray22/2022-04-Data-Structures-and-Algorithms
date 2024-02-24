import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class ArrayListBinaryTreeNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListBinaryTreeNode<E> implements BinaryTreeNode<E>
{
    protected E element;
    private BinaryTreeNode<E> parent;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;
    
    public ArrayListBinaryTreeNode(E newElement, BinaryTreeNode<E> newParent, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild)
    {
        element = newElement;
        parent = newParent;
        left = leftChild;
        right = rightChild;
    }
    
    public E element()
    {
        return element;
    }
    
    public void setElement(E element)
    {
        this.element = element;
    }
    
    public BinaryTreeNode<E> left()
    {
        return left;
    }
    
    public BinaryTreeNode<E> right()
    {
        return right;
    }
    
    public BinaryTreeNode<E> getParent()
    {
        return parent;
    }
    
    public void setLeft(BinaryTreeNode<E> leftNode)
    {
        left = leftNode;
    }
    
    public void setRight(BinaryTreeNode<E> rightNode)
    {
        right = rightNode;
    }
    
    public List<BinaryTreeNode<E>> getChildren()
    {
        List<BinaryTreeNode<E>> children = new ArrayList<BinaryTreeNode<E>>();
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
    
    public void setParent(BinaryTreeNode<E> parentNode)
    {
        parent = parentNode;
    }
}
