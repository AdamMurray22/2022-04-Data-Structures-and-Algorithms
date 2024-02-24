import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class LinkedBinaryTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>
{
    protected BinaryTreeNode<E> root;
    
    public LinkedBinaryTree(BinaryTreeNode<E> root)
    {
        this.root = root;
    }
    
    public BinaryTreeNode<E> root()
    {
        return root;
    }
    
    public BinaryTreeNode<E> parent(PositionAT v) throws RootException
    {
        if (checkPosition(v) == root)
        {
            throw new RootException();
        }
        return checkPosition(v).getParent();
    }
    
    public List children(PositionAT v)
    {
        return checkPosition(v).getChildren();
    }
    
    public BinaryTreeNode<E> right(PositionAT<E> position)
    {
        return checkPosition(position).left();
    }
    
    public BinaryTreeNode<E> left(PositionAT<E> position)
    {
        return checkPosition(position).left();
    }
    
    public boolean hasRight(PositionAT<E> position)
    {
        return checkPosition(position).right() == null;
    }
    
    public boolean hasLeft(PositionAT<E> position)
    {
        return checkPosition(position).left() == null;
    }
    
    public boolean isExternal(PositionAT v)
    {
        return checkPosition(v).getChildren().size() == 0;
    }
    
    public boolean isInternal(PositionAT v)
    {
        return checkPosition(v).getChildren().size() != 0;
    }
    
    public boolean isRoot(PositionAT v)
    {
        return v == root;
    }
    
    public int size()
    {
        return traversal().size();
    }
    
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    public List iterator()
    {
        List<BinaryTreeNode<E>> nodes = traversal();
        List<E> elements = new ArrayList<E>();
        for (BinaryTreeNode<E> node : nodes)
        {
            elements.add(node.element());
        }
        return elements;
    }
    
    public List position()
    {
        return traversal();
    }
    
    public E replace(PositionAT v, E element)
    {
        BinaryTreeNode<E> node = checkPosition(v);
        E oldElement = node.element();
        node.setElement(element);
        return oldElement;
    }
    
    protected BinaryTreeNode<E> checkPosition(PositionAT<E> p) throws InvalidPositionException {
        if (p == null)
        {
            throw new InvalidPositionException();
        }
        BinaryTreeNode<E> temp = (BinaryTreeNode<E>) p;
        return temp;
    }
    
    protected List<BinaryTreeNode<E>> traversal()
    {
        List<BinaryTreeNode<E>> nodes = new ArrayList<BinaryTreeNode<E>>();
        if (isEmpty())
        {
            return nodes;
        }
        return inOrder(root, nodes);
    }
    
    protected List<BinaryTreeNode<E>> inTraversal()
    {
        List<BinaryTreeNode<E>> nodes = new ArrayList<BinaryTreeNode<E>>();
        if (isEmpty())
        {
            return nodes;
        }
        return inOrder(root, nodes);
    }
    
    private List<BinaryTreeNode<E>> preOrder(BinaryTreeNode<E> node, List<BinaryTreeNode<E>> nodes)
    {
        nodes.add(node);
        for (BinaryTreeNode<E> childNode: node.getChildren())
        {
            preOrder(childNode, nodes);
        }
        return nodes;
    }
    
    private List<BinaryTreeNode<E>> postOrder(BinaryTreeNode<E> node, List<BinaryTreeNode<E>> nodes)
    {
        for (BinaryTreeNode<E> childNode: node.getChildren())
        {
            postOrder(childNode, nodes);
        }
        nodes.add(node);
        return nodes;
    }
    
    private List<BinaryTreeNode<E>> inOrder(BinaryTreeNode<E> node, List<BinaryTreeNode<E>> nodes)
    {   
        if (node.left() != null)
        {
            inOrder(node.left(), nodes);
        }
        nodes.add(node);
        if (node.right() != null)
        {
            inOrder(node.right(), nodes);
        }
        return nodes;
    }
}
