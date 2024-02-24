import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class CompleteLinkedBinaryTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompleteLinkedBinaryTree<E>
{
    protected int size;
    protected NodeStackForHeap<E> lastNodeStack;
    protected HeapStackNode<E> root;
    
    public CompleteLinkedBinaryTree()
    {
        root = new HeapStackNode<E>(null,null,null, null);
        lastNodeStack = new NodeStackForHeap<E>();
        size = 0;
    }

    public HeapStackNode<E> add(E element)
    {
        if (size == 0)
        {
            root = new HeapStackNode<E>(element, null, null, null);
            lastNodeStack.pushNode(root);
            size++;
            lastNodeStack.incrementAdd();
            return root;
        }
        HeapStackNode<E> newNode = new HeapStackNode<E>(element, null, null, null);
        addNewNode(newNode);
        lastNodeStack.pushNode(newNode);
        size++;
        return newNode;
    }

    private void addNewNode(HeapStackNode<E> newNode)
    {
        if (size == 1)
        {
            root.setLeft(newNode);
            newNode.setParent(root);
            return;
        }
        HeapStackNode<E> node = lastNodeStack.getNextAdd();
        if (node.left() == null)
        {
            node.setLeft(newNode);
        }
        else
        {
            node.setRight(newNode);
            lastNodeStack.incrementAdd();
        }
        newNode.setParent(node);
    }

    public E remove()
    {
        if (size == 0)
        {
            throw new RootException();
        }
        if (size == 1)
        {
            E element = root.element();
            root = new HeapStackNode<E>(null, null, null, null);
            lastNodeStack = null;
            size--;
            return element;
        }
        E element = lastNodeStack.topNode().element();
        removeOldNode();
        size--;
        return element;
    }

    private void removeOldNode()
    {
        HeapStackNode<E> nodeToBeRemoved = lastNodeStack.topNode();
        if (nodeToBeRemoved.getParent().right() != null)
        {
            nodeToBeRemoved.getParent().setRight(null);
        }
        else
        {
            nodeToBeRemoved.getParent().setLeft(null);
            lastNodeStack.decrementAdd();
        }
        lastNodeStack.popNode();
        nodeToBeRemoved.setParent(null);
        return;
    }

    public int size()
    {
        return size;
    }
    
    public HeapStackNode<E> root()
    {
        return root;
    }
    
    public HeapStackNode<E> parent(PositionAT v) throws RootException
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
    
    public HeapStackNode<E> right(PositionAT<E> position)
    {
        return checkPosition(position).left();
    }
    
    public HeapStackNode<E> left(PositionAT<E> position)
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
    
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    public List iterator()
    {
        List<HeapStackNode<E>> nodes = traversal();
        List<E> elements = new ArrayList<E>();
        for (HeapStackNode<E> node : nodes)
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
        HeapStackNode<E> node = checkPosition(v);
        E oldElement = node.element();
        node.setElement(element);
        return oldElement;
    }
    
    protected HeapStackNode<E> checkPosition(PositionAT<E> p) throws InvalidPositionException {
        if (p == null)
        {
            throw new InvalidPositionException();
        }
        HeapStackNode<E> temp = (HeapStackNode<E>) p;
        return temp;
    }
    
    protected List<HeapStackNode<E>> traversal()
    {
        List<HeapStackNode<E>> nodes = new ArrayList<HeapStackNode<E>>();
        if (isEmpty())
        {
            return nodes;
        }
        return inOrder(root, nodes);
    }
    
    protected List<HeapStackNode<E>> inTraversal()
    {
        List<HeapStackNode<E>> nodes = new ArrayList<HeapStackNode<E>>();
        if (isEmpty())
        {
            return nodes;
        }
        return inOrder(root, nodes);
    }
    
    private List<HeapStackNode<E>> preOrder(HeapStackNode<E> node, List<HeapStackNode<E>> nodes)
    {
        nodes.add(node);
        for (HeapStackNode<E> childNode: node.getChildren())
        {
            preOrder(childNode, nodes);
        }
        return nodes;
    }
    
    private List<HeapStackNode<E>> postOrder(HeapStackNode<E> node, List<HeapStackNode<E>> nodes)
    {
        for (HeapStackNode<E> childNode: node.getChildren())
        {
            postOrder(childNode, nodes);
        }
        nodes.add(node);
        return nodes;
    }
    
    private List<HeapStackNode<E>> inOrder(HeapStackNode<E> node, List<HeapStackNode<E>> nodes)
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
