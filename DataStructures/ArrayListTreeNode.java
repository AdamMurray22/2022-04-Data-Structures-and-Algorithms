import java.util.List;
import java.util.ArrayList;

public class ArrayListTreeNode<E> implements TreeNode<E>
{
    private List<TreeNode<E>> children;
    private E element;
    private TreeNode<E> parent;
    
    public ArrayListTreeNode(E newElement, TreeNode<E> newParent, List<TreeNode<E>> newChildren)
    {
        element = newElement;
        parent = newParent;
        if (newChildren == null)
        {
            children = new ArrayList<TreeNode<E>>();
        }
        else
        {
            children = newChildren;
        }
    }
    
    public TreeNode<E> getParent()
    {
        return parent;
    }
    
    public E element()
    {
        return element;
    }
    
    public void setElement(E element)
    {
        this.element = element;
    }
    
    public List<TreeNode<E>> getChildren()
    {
        return children;
    }
    
    public void addChild(TreeNode<E> newChild)
    {
        children.add(children.size(), newChild);
    }
    
    public boolean removeChild(TreeNode<E> child)
    {
        return children.remove(child);
    }
}
