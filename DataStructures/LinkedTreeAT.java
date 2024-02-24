import java.util.List;
import java.util.ArrayList;

public class LinkedTreeAT<E> implements TreeAT<E>
{
    private TreeNode<E> root;
    
    public LinkedTreeAT(TreeNode<E> root)
    {
        this.root = root;
    }
    
    public TreeNode<E> root()
    {
        return root;
    }
    
    public TreeNode<E> parent(PositionAT v) throws RootException
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
        return root == null;
    }
    
    public List iterator()
    {
        List<TreeNode<E>> nodes = traversal();
        List<E> elements = new ArrayList<E>();
        for (TreeNode<E> node : nodes)
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
        TreeNode<E> node = checkPosition(v);
        E oldElement = node.element();
        node.setElement(element);
        return oldElement;
    }
    
    protected TreeNode<E> checkPosition(PositionAT<E> p) throws InvalidPositionException {
        if (p == null)
        {
            throw new InvalidPositionException();
        }
        TreeNode<E> temp = (TreeNode<E>) p;
        return temp;
    }
    
    protected List<TreeNode<E>> traversal()
    {
        List<TreeNode<E>> nodes = new ArrayList<TreeNode<E>>();
        if (isEmpty())
        {
            return nodes;
        }
        return preOrder(root, nodes);
    }
    
    private List<TreeNode<E>> preOrder(TreeNode<E> node, List<TreeNode<E>> nodes)
    {
        nodes.add(node);
        for (TreeNode<E> childNode: node.getChildren())
        {
            preOrder(childNode, nodes);
        }
        return nodes;
    }
    
    private List<TreeNode<E>> postOrder(TreeNode<E> node, List<TreeNode<E>> nodes)
    {
        for (TreeNode<E> childNode: node.getChildren())
        {
            preOrder(childNode, nodes);
        }
        nodes.add(node);
        return nodes;
    }
}
