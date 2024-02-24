import java.util.List;

/**
 * Write a description of interface TreeNode here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface TreeNode<E> extends TreeNodeCombine<E>
{   
    public void addChild(TreeNode<E> newChild);
    
    public boolean removeChild(TreeNode<E> child);
    
    public List<TreeNode<E>> getChildren();
    
    public void setElement(E element);
    
    public TreeNode<E> getParent();
}
